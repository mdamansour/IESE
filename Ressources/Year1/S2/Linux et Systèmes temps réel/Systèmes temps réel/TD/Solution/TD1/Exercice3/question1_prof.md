# Exercice 3 — Version Professeur

## Code
```c
#include <alchemy/task.h>
#include <stdio.h>

RT_TASK task1;

void func(void) {
    RT_TASK_INFO this_task;
    rt_task_inquire(NULL, &this_task);
    rt_printf("Le nom de la tâche : %s\n", this_task.name);
    rt_printf("Le PID de la tâche : %d\n", this_task.pid);
}

int main() {
    rt_task_create(&task1, "first_task", 0, 20, 0);
    rt_task_start(&task1, &func, 0);
    return 0;
}
```

## Explications
- **alchemy/task.h** : En-tête Xenomai pour la gestion des tâches temps réel.
- **RT_TASK** : Structure représentant une tâche temps réel Xenomai.
- **rt_task_create** : Crée une tâche temps réel avec nom, priorité, etc.
- **rt_task_start** : Démarre la tâche et exécute la fonction `func`.
- **RT_TASK_INFO** : Structure contenant les infos sur la tâche courante (nom, PID, etc.).
- **rt_task_inquire** : Remplit la structure RT_TASK_INFO avec les infos de la tâche courante.
- **rt_printf** : Affiche en temps réel (préféré à printf dans Xenomai).
- **Pas de pause()** : Le programme se termine juste après le lancement de la tâche, comme sur le tableau du prof.
