# Exercice 4, Question 1 — Tâche temps réel avec boucle d'incrémentation

## Énoncé
Écrire un code C qui permet de créer une tâche temps réel qui exécute une fonction qui incrémente la valeur d'une variable `x` et affiche sa valeur dans une boucle d'ordre N.

## Code
```c
#include <alchemy/task.h>
#include <rtdk.h>

#define N 10

RT_TASK task1;
int x = 0;

void func(void *arg) {
    int i;
    for (i = 0; i < N; i++) {
        x++;
        rt_printf("Iteration %d : x = %d\n", i + 1, x);
    }
}

int main() {
    rt_task_create(&task1, "increment_task", 0, 20, 0);
    rt_task_start(&task1, &func, NULL);
    pause();
    return 0;
}
```

## Résultat affiché
```
Iteration 1 : x = 1
Iteration 2 : x = 2
Iteration 3 : x = 3
...
Iteration 10 : x = 10
```

## Explications
- **`#define N 10`** : Définit l'ordre de la boucle (nombre d'itérations).
- **`RT_TASK task1`** : Déclare une tâche temps réel Xenomai.
- **`int x = 0`** : Variable globale partagée, initialisée à 0.
- **`rt_task_create`** : Crée la tâche avec nom `"increment_task"`, priorité 20, pile par défaut (0).
- **`rt_task_start`** : Lance la tâche en mode one-shot (exécution unique de `func`).
- **`func`** : Incrémente `x` à chaque itération et affiche sa valeur avec `rt_printf`.
- **`rt_printf`** : Fonction d'affichage temps réel Xenomai (préférée à `printf`).
- **`pause()`** : Maintient le processus principal en vie le temps que la tâche se termine.
