#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    // Création du processus fils
    pid_t child_pid = fork(); // PID du processus fils

    // Vérification en cas d'erreur lors du fork
    if (child_pid < 0) {
        perror("Erreur lors de la création du processus");
        return 1;
    } 
    // Si child_pid == 0, nous sommes dans le processus fils
    else if (child_pid == 0) {
        printf("Message du FILS : Je suis le processus fils !\n");
        printf(" -> Mon PID est : %d\n", getpid());
        printf(" -> Le PID de mon père est : %d\n\n", getppid());
    } 
    // Si child_pid > 0, nous sommes dans le processus père
    else {
        printf("Message du PÈRE : Je suis le processus père !\n");
        printf(" -> Mon PID est : %d\n", getpid());
        printf(" -> Le PID de mon fils est : %d\n\n", child_pid);
    }

    return 0;
}