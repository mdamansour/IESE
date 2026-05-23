/*
Exercice 5, Question 1 — 5 tâches temps réel de même priorité

Crée 5 tâches temps réel Xenomai de même priorité, de noms différents,
qui s'exécutent une seule fois (mode one-shot).
La fonction exécutée affiche le nom et la priorité de chaque tâche.
*/
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
