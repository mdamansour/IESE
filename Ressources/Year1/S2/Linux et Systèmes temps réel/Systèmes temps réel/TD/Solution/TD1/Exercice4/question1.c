/*
Exercice 4, Question 1 — Tâche temps réel avec boucle d'incrémentation

Crée une tâche temps réel Xenomai qui exécute une fonction
incrémentant la variable x et affichant sa valeur dans une boucle d'ordre N.
*/
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
