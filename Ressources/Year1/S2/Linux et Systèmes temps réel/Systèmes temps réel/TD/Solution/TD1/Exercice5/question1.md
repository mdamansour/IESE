# Exercice 5, Question 1 — 5 tâches temps réel de même priorité

## Énoncé
Écrire un code C qui permet de créer 5 tâches temps réel de même priorité, de noms différents et qui s'exécutent une seule fois. La fonction exécutée par les tâches affiche leurs noms et leurs priorités.

## Code
```c
#include <alchemy/task.h>
#include <rtdk.h>

#define NB_TASKS 5
#define PRIORITY  20

RT_TASK tasks[NB_TASKS];

const char *task_names[NB_TASKS] = {
    "task_1", "task_2", "task_3", "task_4", "task_5"
};

void func(void *arg) {
    RT_TASK_INFO curtaskinfo;
    rt_task_inquire(NULL, &curtaskinfo);
    rt_printf("Nom : %-10s | Priorité : %d\n",
              curtaskinfo.name, curtaskinfo.prio);
}

int main() {
    int i;
    for (i = 0; i < NB_TASKS; i++) {
        rt_task_create(&tasks[i], task_names[i], 0, PRIORITY, 0);
        rt_task_start(&tasks[i], &func, NULL);
    }
    pause();
    return 0;
}
```

## Résultat affiché (exemple)
```
Nom : task_1     | Priorité : 20
Nom : task_2     | Priorité : 20
Nom : task_3     | Priorité : 20
Nom : task_4     | Priorité : 20
Nom : task_5     | Priorité : 20
```
> L'ordre d'affichage peut varier selon l'ordonnancement des tâches.

## Explications
- **`RT_TASK tasks[NB_TASKS]`** : Tableau de 5 descripteurs de tâches temps réel.
- **`task_names[]`** : Tableau des noms distincts pour chaque tâche.
- **`rt_task_create(..., PRIORITY, ...)`** : Toutes les tâches sont créées avec la même priorité (20).
- **`rt_task_start`** : Lance chaque tâche en mode one-shot (exécution unique).
- **`RT_TASK_INFO curtaskinfo`** : Structure locale qui reçoit les infos de la tâche courante.
- **`rt_task_inquire(NULL, &curtaskinfo)`** : Remplit `curtaskinfo` avec les informations de la tâche en cours d'exécution (`NULL` = tâche appelante).
- **`curtaskinfo.name`** : Nom de la tâche.
- **`curtaskinfo.prio`** : Priorité actuelle de la tâche.
- **`pause()`** : Maintient le processus principal en vie pendant que les tâches s'exécutent.
