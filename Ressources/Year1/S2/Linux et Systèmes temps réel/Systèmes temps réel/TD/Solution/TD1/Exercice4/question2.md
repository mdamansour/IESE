# Exercice 4, Question 2 — Mesure de la durée d'exécution avec `rt_timer_read()`

## Énoncé
Modifier le code de la question 1 pour calculer et afficher la durée d'exécution de la boucle, en utilisant la commande `rt_timer_read()`.

## Code
```c
#include <alchemy/task.h>
#include <alchemy/timer.h>
#include <rtdk.h>

#define N 10

RT_TASK task1;
int x = 0;

void func(void *arg) {
    int i;
    RTIME start, end, duration;

    start = rt_timer_read();

    for (i = 0; i < N; i++) {
        x++;
        rt_printf("Iteration %d : x = %d\n", i + 1, x);
    }

    end = rt_timer_read();
    duration = end - start;

    rt_printf("Durée d'exécution de la boucle : %llu ns\n", (unsigned long long)duration);
}

int main() {
    rt_task_create(&task1, "increment_task", 0, 20, 0);
    rt_task_start(&task1, &func, NULL);
    pause();
    return 0;
}
```

## Résultat affiché (exemple)
```
Iteration 1 : x = 1
Iteration 2 : x = 2
...
Iteration 10 : x = 10
Durée d'exécution de la boucle : 52400 ns
```

## Explications
- **`alchemy/timer.h`** : En-tête Xenomai pour les fonctions de temporisation, dont `rt_timer_read()`.
- **`RTIME`** : Type Xenomai pour les valeurs de temps (équivalent à `long long`, exprimé en nanosecondes).
- **`rt_timer_read()`** : Lit l'horloge temps réel du système Xenomai au moment de l'appel. Retourne le temps écoulé depuis le démarrage du système en nanosecondes.
- **`start = rt_timer_read()`** : Capture l'horodatage avant la boucle.
- **`end = rt_timer_read()`** : Capture l'horodatage après la boucle.
- **`duration = end - start`** : Calcule la durée d'exécution de la boucle en nanosecondes.
- **`%llu`** : Format pour afficher un `unsigned long long` (correspondant au cast de `RTIME`).
