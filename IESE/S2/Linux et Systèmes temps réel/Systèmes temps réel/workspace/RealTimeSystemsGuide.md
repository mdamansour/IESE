# Real-Time Systems - Study Guide


---

# Xenomai Real-Time Programming — Exam Summary

## 1. Core Concepts

- **Task**: A real-time thread of execution. Use `rt_task_create`, `rt_task_start`, `rt_task_join`, `rt_task_delete`.
- **Periodic Task**: Use `rt_task_set_periodic` to define period, and `rt_task_wait_period` in the loop to block until the next period.
- **Primary vs Secondary Mode**: Primary = real-time, deterministic. Secondary = non real-time, can miss deadlines. Avoid `printf()` in RT tasks; use `rt_printf()` and call `rt_print_auto_init(1)` at program start.
- **mlockall(MCL_CURRENT | MCL_FUTURE)**: Locks memory to prevent paging, ensuring deterministic timing. Call at the start of `main()`.

## 2. Synchronization

- **Semaphore**: Use `RT_SEM` and `rt_sem_create` to declare/init. Protect shared resources with `rt_sem_p` (take/lock) and `rt_sem_v` (release/unlock). Always use around critical sections to avoid race conditions.
- **Mutex**: Similar to semaphore, but specifically for mutual exclusion.

## 3. Communication

- **FIFO/Pipe**: Use `RT_PIPE` and `rt_pipe_create` for communication between Xenomai tasks and Linux processes. Write with `rt_pipe_write`, read with `rt_pipe_read`, destroy with `rt_pipe_delete`.
- **Buffer**: Temporary memory area inside FIFO for holding data until read.

## 4. Time Management

- **Get current time**: `rt_timer_read()` returns monotonic time in ticks (usually nanoseconds).
- **Sleep**: `rt_task_sleep(duration)` suspends a task for a given time. `rt_task_sleep_until(date)` suspends until an absolute time. `rt_timer_spin(duration)` busy-waits (rarely used in exams).

## 5. Interrupts (Advanced)

- **Interrupts**: Use `rt_intr_create`, `rt_intr_enable`, `rt_intr_wait`, and `rt_intr_delete` to handle hardware/software events. Rarely required in exams unless explicitly asked.

## 6. Exam Tips

- Focus on tasks, periodicity, semaphores, and scheduling.
- Use `rt_task_wait_period()` in every periodic task loop to enforce timing.
- Protect all shared variables with a semaphore or mutex.
- Use pipes/FIFOs only if the question asks for inter-process or inter-task communication.
- Use interrupts only if the question is about reacting to hardware events.
- Always clean up: delete tasks, semaphores, pipes, and interrupts when done.

## 7. Example Code Snippets

**Periodic Task:**
```c
void task_body(void *arg) {
    rt_task_set_periodic(NULL, TM_NOW, 100000000); // 100ms
    while (1) {
        rt_printf("Periodic task\n");
        rt_task_wait_period(NULL);
    }
}
```

**Semaphore Protection:**
```c
rt_sem_p(&sem, TM_INFINITE);
shared_var++;
rt_sem_v(&sem);
```

**FIFO Communication:**
```c
rt_pipe_write(&pipe, &data, sizeof(data), 0);
rt_pipe_read(&pipe, &data, sizeof(data), TM_INFINITE);
```

**Interrupt Handling:**
```c
rt_intr_create(&intr, "INTR", IT_CLAVIER, 0);
rt_intr_enable(&intr);
rt_intr_wait(&intr, TM_INFINITE);
rt_intr_delete(&intr);
```

---

**One-line memory:**
- Use periodic tasks and `rt_task_wait_period` for timing.
- Protect shared data with semaphores.
- Use pipes for inter-task/process communication if asked.
- Use interrupts only if the question requires it.

## Module 1: Real-Time Programming with Xenomai - Native API

### Slide Overview: RT/Xenomai Programming with Native API

#### Code Executed by Different Tasks (Example)

This slide demonstrates a practical example of real-time task programming using **Xenomai's native API** on Linux.

#### Key Components:

**1. Header File**
```c
#include <linux/module.h>
```
- Includes the Linux kernel module header for real-time programming

**2. Task Declaration**
```c
RT_TASK task;  // Task identifier declarations
```
- `RT_TASK`: Data structure that holds task identifiers, semaphores, etc.
- Essential for managing real-time tasks in Xenomai

**3. Task Function**
```c
void code_test(void *arg)
```
- Entry point function executed by the real-time task
- Receives arguments via `void *arg` parameter

**4. Task Logic**
```c
static int loop = N_LOOP;
while(loop--){
    rt_printf("Hello World !\n");
}
```
- `loop`: Static variable controlling iterations
- `rt_printf()`: Real-time safe printf (not standard printf)
- Executes N_LOOP times

**5. RT_TASK Structure** (shown in blue box)
```c
struct RT_TASK {
    uintptr_t handle;   // Task handle identifier
    pthread_t thread;   // POSIX thread reference
};
```
- Contains task handle and thread reference

#### Important Concepts:
- **Xenomai**: Real-time framework layered on Linux
- **Native API**: Direct Xenomai calls without POSIX emulation
- **rt_printf()**: Real-time safe I/O function
- **RT_TASK**: Fundamental data structure for task management

---

*More details on task creation, synchronization, and scheduling coming next.*