# Exercice 5, Question 2 — 5 tâches de priorités différentes, périodiques

## Énoncé
Modifier le code pour que les 5 tâches aient des priorités différentes et s'exécutent périodiquement.

## Code
```c
#include <alchemy/task.h>
#include <rtdk.h>

#define NB_TASKS 5

RT_TASK tasks[NB_TASKS];

const char *task_names[NB_TASKS] = {
    "task_1", "task_2", "task_3", "task_4", "task_5"
};

/* Priorités différentes pour chaque tâche */
const int priorities[NB_TASKS] = {10, 20, 30, 40, 50};

/* Périodes en nanosecondes (1s, 2s, 3s, 4s, 5s) */
const RTIME periods[NB_TASKS] = {
    1000000000ULL,
    2000000000ULL,
    3000000000ULL,
    4000000000ULL,
    5000000000ULL
};

void func(void *arg) {
    int idx = (int)(long)arg;
    RT_TASK_INFO curtaskinfo;

    /* Rendre la tâche périodique */
    rt_task_set_periodic(NULL, TM_NOW, periods[idx]);

    while (1) {
        rt_task_inquire(NULL, &curtaskinfo);
        rt_printf("Nom : %-10s | Priorité : %d\n",
                  curtaskinfo.name, curtaskinfo.prio);

        rt_task_wait_period(NULL);
    }
}

int main() {
    int i;
    for (i = 0; i < NB_TASKS; i++) {
        rt_task_create(&tasks[i], task_names[i], 0, priorities[i], 0);
        rt_task_start(&tasks[i], &func, (void *)(long)i);
    }
    pause();
    return 0;
}
```

## Résultat affiché (exemple — s'affiche en boucle selon les périodes)
```
Nom : task_1     | Priorité : 10
Nom : task_2     | Priorité : 20
Nom : task_3     | Priorité : 30
Nom : task_4     | Priorité : 40
Nom : task_5     | Priorité : 50
Nom : task_1     | Priorité : 10   ← réactivation après 1s
...
```

## Différences par rapport à la question 1

| Aspect        | Question 1              | Question 2                        |
|---------------|-------------------------|-----------------------------------|
| Priorités     | Toutes identiques (20)  | Différentes : 10, 20, 30, 40, 50  |
| Mode          | One-shot                | Périodique                        |
| Boucle        | Aucune                  | `while(1)`                        |

## Explications
- **`ULL`** : Suffixe littéral C signifiant **Unsigned Long Long** (`unsigned long long`). Il force le compilateur à traiter la constante comme un entier 64 bits non signé, nécessaire ici car `RTIME` est un `unsigned long long` et les valeurs de période (ex. `1 000 000 000`) dépassent la plage d'un `int` 32 bits.
- **`priorities[]`** : Tableau de 5 priorités distinctes; la plus haute valeur = priorité la plus élevée dans Xenomai.
- **`periods[]`** : Tableau de périodes différentes par tâche, en nanosecondes (1 000 000 000 ns = 1 s).
- **`(void *)(long)i`** : Passage de l'indice `i` en argument à `func` via le pointeur void sans allocation mémoire.
- **`rt_task_set_periodic(NULL, TM_NOW, periods[idx])`** : Rend la tâche courante périodique à partir de maintenant (`TM_NOW`) avec la période correspondante.
- **`rt_task_wait_period(NULL)`** : Bloque la tâche jusqu'au prochain réveil périodique, libérant le CPU entre deux activations.
- **`while(1)`** : La tâche tourne indéfiniment, se réveillant à chaque période.
