# Exercice 3 — Tâche temps réel

## Énoncé
Créer et lancer une tâche temps réel nommée « first_task » avec priorité 20. La tâche exécute la fonction `funct`, qui affiche le nom et le PID de la tâche créée.

## Exemple de code (Xenomai)
```c
#include <stdio.h>
#include <native/task.h>
#include <unistd.h>

void funct(void *arg) {
    printf("Nom de la tâche : %s\n", (char *)arg);
    printf("PID de la tâche : %d\n", getpid());
}

int main() {
    RT_TASK task;
    char *nom = "first_task";
    // Créer la tâche temps réel
    rt_task_create(&task, nom, 0, 20, 0);
    // Lancer la tâche
    rt_task_start(&task, &funct, nom);
    pause(); // Attendre indéfiniment
    return 0;
}
```

## Explication
- On utilise Xenomai : `rt_task_create` crée la tâche, `rt_task_start` la lance.
- La fonction `funct` affiche le nom et le PID de la tâche.
- La priorité est fixée à 20.
- `pause()` permet de garder le programme actif pour observer la tâche.
