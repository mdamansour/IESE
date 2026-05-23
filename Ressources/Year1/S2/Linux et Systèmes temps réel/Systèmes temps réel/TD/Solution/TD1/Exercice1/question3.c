#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    pid_t pid = fork();

    if (pid < 0) {
        perror("Erreur lors de la création du processus");
        return 1;
    } else if (pid == 0) {
        printf("Message du FILS : Je suis le processus fils !\n");
        printf(" -> Mon PID est : %d\n", getpid());
        printf(" -> Le PID de mon père est : %d\n\n", getppid());
    } else {
        // Le père attend la fin du fils
        wait(NULL);
        printf("Message du PÈRE : Je suis le processus père !\n");
        printf(" -> Mon PID est : %d\n", getpid());
        printf(" -> Le PID de mon fils est : %d\n\n", pid);
    }

    return 0;
}
