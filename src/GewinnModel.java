/**
 * Das Model verwaltet die Daten und den Zustand des Gewinnspiels.
 * Es enthält keinerlei GUI-Code (vollständige Entkopplung nach MVC).
 */
public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    /**
     * Startet das Spiel mit 30 Punkten.
     */
    public GewinnModel() {
        this.gesamtPunkte = 30;
        this.spielerZahl = 0;
        this.computerZahl = 0;
        this.rundenErgebnis = 0;
    }

    public int getGesamtPunkte() {
        return this.gesamtPunkte;
    }

    public int getSpielerZahl() {
        return this.spielerZahl;
    }

    public int getComputerZahl() {
        return this.computerZahl;
    }

    public int getRundenErgebnis() {
        return this.rundenErgebnis;
    }
}
