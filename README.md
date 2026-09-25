# Zahlen-Gewinnspiel (Java Swing & MVC)

Ein einfaches Zahlen-Gewinnspiel als Java-Swing-Anwendung, strukturiert nach dem **Model-View-Controller (MVC)** Prinzip.

## Spielregeln
- Jede Runde startet mit **30 Punkten**.
- Der Spieler tippt eine Zahl von **1 bis 9**.
- Der Computer ermittelt zufällig eine Zahl zwischen 1 und 9:
  - **Gleiche Zahl getippt:** +20 Punkte
  - **Differenz von 1:** +5 Punkte
  - **Andere Zahl:** -10 Punkte
- **Gewonnen:** ab 100 Punkten
- **Verloren:** bei 0 oder weniger Punkten
