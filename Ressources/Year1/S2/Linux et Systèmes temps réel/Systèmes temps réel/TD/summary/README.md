
# Systèmes Temps Réel — TD Summary


## Concepts Learned

- `pid_t` is a data type used to represent process IDs.

```c
pid_t pid = fork();
```

- `getpid()` returns the process ID of the calling process.

```c
pid_t self = getpid();
```

- `getppid()` returns the parent process ID of the calling process.

```c
pid_t parent = getppid();
```

- `wait(NULL)` makes the parent process wait for any child to finish, ignoring the exit status. then cleans it from the process table to avoid zombies.

```c
wait(NULL);
```

- `wait(&status)` makes the parent process wait for any child to finish and stores the child's exit status in `status`.

```c
int status;
wait(&status);
```

- In pthreads, thread functions must have the signature `void* function(void*)`; `void*` is a generic pointer type, allowing any kind of data to be passed or returned.

```c
void* fonction_thread(void* arg) {
	// arg can be used to pass data to the thread
	pthread_exit(NULL);
}
```

- `pthread_t` is a data type used to represent a thread identifier (similar to `pid_t` for processes).

```c
pthread_t tid;
pthread_create(&tid, NULL, fonction_thread, NULL);
```

- `pthread_create(&tid, attr, start_routine, arg)` creates a new thread.
	- `&tid` stores the new thread ID.
	- `attr` sets thread attributes:
		- detach state (`joinable` by default, or `detached`),
		- stack settings (size/address),
		- scheduling options (policy/priority, when allowed).
		- If `attr` is `NULL`, pthread uses default attributes.
	- `start_routine` is the first function executed by the new thread.
	- `arg` is the value passed to `start_routine`.

```c
pthread_t tid;
int rc = pthread_create(&tid, NULL, fonction_thread, NULL);
```

- `pthread_create` returns an `int`: `0` means success, and a non-zero value is an error code.

```c
int rc = pthread_create(&tid, NULL, fonction_thread, NULL);
if (rc != 0) {
	// error creating thread
}
```

- `pthread_join(thread, retval)` waits for a specific thread to finish (`thread` is the thread ID, `retval` stores the returned pointer or `NULL` to ignore it).

```c
int rc = pthread_join(tid, NULL);
if (rc != 0) {
	// error joining thread
}
```

## Useful Code Snippets

---

## Commands

---

## To Do

