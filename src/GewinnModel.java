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

    /**
     * Berechnet eine zufällige Zahl von 1 bis 9 für den Computer.
     */
    public void berechneComputerZahl() {
        this.computerZahl = (int) (Math.random() * 9) + 1;
    }

    /**
     * Übernimmt die Spielerzahl, berechnet das Rundenergebnis
     * und aktualisiert den Gesamtpunktestand.
     *
     * @param spielerZahl die vom Spieler eingegebene Zahl (1-9)
     */
    public void berechneRunde(int spielerZahl) {
        this.spielerZahl = spielerZahl;
        berechneComputerZahl();

        int differenz = Math.abs(this.spielerZahl - this.computerZahl);

        if (differenz == 0) {
            this.rundenErgebnis = 20; // Gleiche Zahl getippt
        } else if (differenz == 1) {
            this.rundenErgebnis = 5;  // Zahl um 1 größer oder kleiner
        } else {
            this.rundenErgebnis = -10; // Andere Zahl getippt
        }

        this.gesamtPunkte += this.rundenErgebnis;
    }

    /**
     * Prüft, ob der Spieler mindestens 100 Punkte erreicht hat.
     *
     * @return true wenn gewonnen, sonst false
     */
    public boolean hatGewonnen() {
        return this.gesamtPunkte >= 100;
    }

    /**
     * Prüft, ob der Spieler 0 oder weniger Punkte hat.
     *
     * @return true wenn verloren, sonst false
     */
    public boolean hatVerloren() {
        return this.gesamtPunkte <= 0;
    }
}
