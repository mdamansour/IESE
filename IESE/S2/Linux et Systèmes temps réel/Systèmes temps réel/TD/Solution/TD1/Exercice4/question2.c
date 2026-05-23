/*
Exercice 4, Question 2 — Mesure de la durée d'exécution avec rt_timer_read()

Modifie la question 1 pour calculer et afficher la durée d'exécution
de la boucle en utilisant rt_timer_read().
*/
#include <alchemy/task.h>
#include <alchemy/timer.h>
#include <rtdk.h>

#define N 10

RT_TASK task1;
int x = 0;

void func(void *arg) {
    int i;
    RTIME start, end, duration;

    start = rt_timer_read();

    for (i = 0; i < N; i++) {
        x++;
        rt_printf("Iteration %d : x = %d\n", i + 1, x);
    }

    end = rt_timer_read();
    duration = end - start;

    rt_printf("Durée d'exécution de la boucle : %llu ns\n", (unsigned long long)duration);
}

int main() {
    rt_task_create(&task1, "increment_task", 0, 20, 0);
    rt_task_start(&task1, &func, NULL);
    pause();
    return 0;
}
