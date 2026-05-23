#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

int glob = 0;

void* thd1_function(void* arg) {
    glob = glob + 2;
    printf("thd1 : glob = %d, adresse = %p\n", glob, (void*)&glob);
    return NULL;
}

void* thd2_function(void* arg) {
    glob = glob - 1;
    printf("thd2 : glob = %d, adresse = %p\n", glob, (void*)&glob);
    return NULL;
}

int main() {
    pthread_t thd1, thd2;

    if (pthread_create(&thd1, NULL, thd1_function, NULL) != 0) {
        perror("Erreur pthread_create pour thd1");
        return 1;
    }

    if (pthread_create(&thd2, NULL, thd2_function, NULL) != 0) {
        perror("Erreur pthread_create pour thd2");
        return 1;
    }

    pthread_join(thd1, NULL);
    pthread_join(thd2, NULL);

    printf("Valeur finale de glob = %d\n", glob);
    return 0;
}
