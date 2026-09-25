package model;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

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

    public void berechneComputerZahl() {
        this.computerZahl = (int) (Math.random() * 9) + 1;
    }

    public void berechneRunde(int spielerZahl) {
        this.spielerZahl = spielerZahl;
        berechneComputerZahl();

        int differenz = Math.abs(this.spielerZahl - this.computerZahl);

        if (differenz == 0) {
            this.rundenErgebnis = 20;
        } else if (differenz == 1) {
            this.rundenErgebnis = 5;
        } else {
            this.rundenErgebnis = -10;
        }

        this.gesamtPunkte += this.rundenErgebnis;
    }
}
