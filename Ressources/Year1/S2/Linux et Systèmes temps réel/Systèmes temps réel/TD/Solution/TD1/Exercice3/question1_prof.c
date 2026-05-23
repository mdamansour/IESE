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
