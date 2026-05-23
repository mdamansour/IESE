# Aperiodic Tasks — Exam Prep (Xenomai / Real-Time Scheduling)

## 1) Core Definitions
- **Aperiodic task**: no fixed period; defined by arrival time `r`, execution time `C`, and often relative deadline `D`.
- **Periodic tasks**: fixed period `P`, computation time `C`.
- **Server**: a periodic mechanism that handles aperiodic requests while preserving periodic-task guarantees.
- **Server parameters**: capacity `C_s`, period `P_s`.

## 2) Why Aperiodic Servers Are Used
- Directly inserting aperiodic jobs can break periodic schedulability.
- A server reserves controlled bandwidth for aperiodic jobs.
- Goal: improve aperiodic response time without violating periodic constraints.

## 3) Polling Server (serveur par scrutation)
- Wakes up every period.
- At activation, serves pending aperiodic jobs until:
  - capacity is exhausted, or
  - queue becomes empty.
- If no aperiodic job is waiting at activation, **capacity is lost** for that period.

### Key limitation to memorize
- If an aperiodic task arrives just after polling instant, it may wait until the next server activation.

## 4) Deferrable Server (serveur ajournable)
- Capacity is preserved during the period and can be used later when jobs arrive.
- Better responsiveness than polling for bursty arrivals.
- Can create higher interference on periodic tasks if analysis is not enforced.

## 5) Sporadic Server
- Handles aperiodic jobs with strong responsiveness.
- Consumed capacity is replenished exactly after one period from consumption instant.
- Main exam idea: good aperiodic response while maintaining fixed-priority schedulability properties better than deferrable server.

## 6) Formulas You Must Know
- Periodic utilization:

$$
U_p = \sum_{i \in TP} \frac{C_i}{P_i}
$$

- Server utilization:

$$
U_s = \frac{C_s}{P_s}
$$

- Acceptability criterion shown in your slide set:

$$
U_p \le \ln\left(\frac{U_s + 2}{2U_s + 1}\right)
$$

## 7) Typical Exam Tasks
- Draw/read a schedule timeline and place aperiodic executions correctly.
- Identify lost capacity (polling case).
- Compute aperiodic response interval (arrival to completion).
- Compare polling vs deferrable vs sporadic in terms of responsiveness and interference.
- Verify periodic schedulability using utilization/priority analysis.

## 8) 30-Second Memory Block
- Polling: simple, but may lose budget when queue is empty at activation.
- Deferrable: keeps budget in-period, improves response, may increase interference.
- Sporadic: replenishes after actual use; strong compromise between responsiveness and schedulability.
- Always compute `U_p`, `U_s`, then validate constraints and timeline behavior.
