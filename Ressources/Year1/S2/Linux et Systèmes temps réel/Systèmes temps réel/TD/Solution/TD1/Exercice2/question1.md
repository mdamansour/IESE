# Exercice 2 — Question 1

## Code
```c
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

int x = 10;

void* fonction_thread(void* arg) {
    x = x + 5;
    printf("THREAD FILS : x = %d, Adresse de x = %p\n", x, &x);
    pthread_exit(NULL);
}

int main() {
    pthread_t tid;
    if (pthread_create(&tid, NULL, fonction_thread, NULL) != 0) {
        perror("Erreur pthread_create");
        return 1;
    }
    x = x - 3;
    printf("THREAD PERE : x = %d, Adresse de x = %p\n", x, &x);
    pthread_join(tid, NULL);
    printf("VALEUR FINALE DE x = %d\n", x);
    return 0;
}
```

## Résultat affiché (exemple)
```
THREAD PERE : x = 7, Adresse de x = 0x...  (x = 10 - 3)
THREAD FILS : x = 12, Adresse de x = 0x... (x = 7 + 5)
VALEUR FINALE DE x = 12
```

## Explication
- Les deux threads partagent la même variable x et la même adresse, car ils sont dans le même espace mémoire.
- L'ordre d'affichage peut varier selon l'ordonnancement des threads.

## Notes sur la fonction thread
- La signature `void* fonction_thread(void* arg)` est imposée par l'API pthread library : le type `void*` permet de passer et retourner n'importe quel type de pointeur.
- Ici, le paramètre `arg` n'est pas utilisé, mais il doit être présent pour respecter la convention de pthread.
- En mono-thread (seulement `main`), l'ordre des lignes semble strict; avec `pthread_create`, deux threads s'exécutent en parallèle et l'OS décide l'ordre, donc il peut varier.
