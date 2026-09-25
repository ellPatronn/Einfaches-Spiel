/**
 * Der Controller verbindet das Model und die View nach dem MVC-Muster.
 * Er fängt Benutzeraktionen (Enter im Textfeld, Klick auf Button) ab,
 * validiert die Eingaben, steuert das Model und weist die View an,
 * sich zu aktualisieren.
 */
public class GewinnController {

    private final GewinnModel model;
    private final GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        registriereListener();
    }

    /**
     * Registriert die Ereignisbehandlung für Tastatureingaben und Button-Klicks.
     */
    private void registriereListener() {
        // Enter im Eingabefeld startet die Runde
        view.addEingabeListener(e -> spieleRunde());

        // Klick auf "Noch einmal!" bereitet die nächste Runde vor
        view.addNochEinmalListener(e -> nochEinmal());
    }

    /**
     * Liest die Eingabe, validiert diese, führt die Runde im Model aus
     * und aktualisiert die View.
     */
    private void spieleRunde() {
        // Prüfen, ob das Spiel bereits beendet ist
        if (model.hatGewonnen()) {
            view.zeigeFehler("Du hast bereits gewonnen (100 Punkte erreicht)!");
            return;
        }
        if (model.hatVerloren()) {
            view.zeigeFehler("Du hast leider verloren (0 Punkte erreicht)!");
            return;
        }

        // Eingabe auslesen und absichern
        String text = view.getEingabeZahl();
        if (text == null || text.trim().isEmpty()) {
            view.zeigeFehler("Bitte gib eine Zahl von 1 bis 9 ein!");
            return;
        }

        int spielerZahl;
        try {
            spielerZahl = Integer.parseInt(text.trim());
        } catch (NumberFormatException ex) {
            view.zeigeFehler("Ungültige Eingabe! Bitte gib eine ganze Zahl ein.");
            return;
        }

        if (spielerZahl < 1 || spielerZahl > 9) {
            view.zeigeFehler("Die Zahl muss zwischen 1 und 9 liegen!");
            return;
        }

        // Spiellogik im Model ausführen
        model.berechneRunde(spielerZahl);

        // View mit den Ergebnissen aktualisieren
        view.aktualisiereRunde(
                model.getRundenErgebnis(),
                model.getGesamtPunkte(),
                model.getComputerZahl(),
                model.hatGewonnen(),
                model.hatVerloren()
        );
    }

    /**
     * Bereitet die GUI für die nächste Runde vor.
     */
    private void nochEinmal() {
        view.resetRunde(model.getGesamtPunkte());
    }
}
