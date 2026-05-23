# C Includes Cheat Sheet — Linux / Systèmes Temps Réel

## Quick Rule
- Include the header where the **type** or **function** is formally defined.
- Never rely on indirect/implicit includes from another header.

---

## 1) Process questions (`fork`, `pid`, parent/child)
```c
#include <stdio.h>      // printf, perror
#include <sys/types.h>  // pid_t
#include <unistd.h>     // fork, getpid, getppid, sleep, pause
```
If waiting for child termination:
```c
#include <sys/wait.h>   // wait, waitpid, WIFEXITED...
```

---

## 2) Thread questions (`pthread`)
```c
#include <stdio.h>
#include <stdlib.h>     // malloc, free, exit
#include <pthread.h>    // pthread_t, pthread_create, pthread_join, mutex, cond
#include <unistd.h>     // sleep/usleep (if used)
```
Compile with:
```bash
gcc file.c -pthread
```

---

## 3) Time measurement / delays (POSIX, non-Xenomai)
```c
#include <time.h>       // clock_gettime, struct timespec, nanosleep
#include <unistd.h>     // sleep, usleep
```

---

## 4) Signals / alarms
```c
#include <signal.h>     // signal, sigaction, kill
#include <unistd.h>     // alarm, pause
#include <sys/types.h>  // pid_t
```

---

## 5) Files / low-level I/O
```c
#include <fcntl.h>      // open, O_* flags
#include <unistd.h>     // read, write, close, lseek
#include <sys/types.h>  // ssize_t, off_t
#include <sys/stat.h>   // mode_t, file permissions
```

---

## 6) Xenomai Alchemy task questions
```c
#include <alchemy/task.h>   // RT_TASK, rt_task_create, rt_task_start, rt_task_inquire, rt_task_set_periodic, rt_task_wait_period
#include <rtdk.h>           // rt_printf
```
If using timer read:
```c
#include <alchemy/timer.h>  // rt_timer_read, RTIME
```

---

## TD1 Quick Mapping

| Exercise | Topic | Headers needed |
|----------|-------|----------------|
| Ex1 Q1/Q2 | fork + getpid + getppid | `stdio.h`, `sys/types.h`, `unistd.h` |
| Ex1 Q3 | fork + wait | + `sys/wait.h` |
| Ex2 | pthread create/join | `stdio.h`, `stdlib.h`, `pthread.h` |
| Ex3/Ex4/Ex5 | Xenomai tasks | `alchemy/task.h`, `rtdk.h` |
| Ex4 Q2 | Xenomai timer | + `alchemy/timer.h` |

---

## Minimal Templates

### Process
```c
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>   // only if wait/waitpid used
```

### Pthread
```c
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
```

### Xenomai
```c
#include <alchemy/task.h>
#include <alchemy/timer.h>  // only if timer APIs used
#include <rtdk.h>
```

---

## Key Types Reference

| Type | Header | Used for |
|------|--------|----------|
| `pid_t` | `sys/types.h` | Process IDs |
| `pthread_t` | `pthread.h` | Thread IDs |
| `ssize_t` | `sys/types.h` | Signed byte counts (read/write) |
| `off_t` | `sys/types.h` | File offsets |
| `RT_TASK` | `alchemy/task.h` | Xenomai task descriptor |
| `RTIME` | `alchemy/timer.h` | Xenomai time value (nanoseconds) |
| `RT_TASK_INFO` | `alchemy/task.h` | Xenomai task info struct |
