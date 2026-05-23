# Exercice 2 — Question 2

## 2) Déduire le partage de la mémoire et des calculs

### Partage de la mémoire (threads)
- Les threads d’un même processus partagent le **même espace mémoire** (variables globales, tas/heap, segment code).
- Donc ici, la variable globale `x` est **commune** au thread père et au thread fils (même adresse affichée).
- En revanche, chaque thread possède sa **propre pile (stack)** et ses **propres registres**.

### Partage des calculs
- Les calculs s’exécutent en **parallèle/concurrence** selon l’ordonnancement de l’OS.
- Les deux threads modifient la même variable `x` (`x = x + 5` et `x = x - 3`) sans protection.
- Cela crée une **condition de course (race condition)** : l’ordre réel d’exécution peut changer d’un lancement à l’autre.

### Conséquence pratique
- Sans synchronisation (ex: `mutex`), la valeur finale de `x` peut varier (ex: `7`, `12` ou `15` selon l’interleaving).
- `pthread_join` garantit seulement que le thread fils est terminé avant l’affichage final, mais ne protège pas l’accès concurrent à `x`.
