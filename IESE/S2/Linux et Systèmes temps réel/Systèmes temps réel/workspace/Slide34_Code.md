# Slide 34 — Xenomai Native API Code

```c
#include <native/task.h>
#include <native/timer.h>

void code_test(void *arg) {
    static int loop = N_LOOP;
    while (loop--) {
        rt_printf("Hello World ! nn");
    }
}

int main(int argc, char *argv[]) {
    RT_TASK task;
    int error;

    if ((error = rt_task_create(&task, "my first task", 0, 99, T_JOINABLE)) != 0) {
        fprintf(stderr, "Error: cannot create the task (%s)\n", strerror(-error));
        exit(EXIT_FAILURE);
    }

    if ((error = rt_task_start(&task, code_test, NULL)) != 0) {
        fprintf(stderr, "Error: cannot start the task (%s)\n", strerror(-error));
        exit(EXIT_FAILURE);
    }

    rt_task_join(&task);
    return EXIT_SUCCESS;
}
```