/*
Exercice 5, Question 2 — 5 tâches temps réel de priorités différentes, périodiques

Modifie la question 1 :
- Chaque tâche a une priorité différente (10, 20, 30, 40, 50).
- Chaque tâche s'exécute périodiquement avec sa propre période.
*/
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
