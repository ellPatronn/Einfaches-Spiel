package controller;

import model.GewinnModel;
import view.GewinnView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController implements ActionListener {

    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        this.view.getTxtDeineZahl().addActionListener(this);
        this.view.getBtnNochEinmal().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getBtnNochEinmal()) {
            nochEinmal();
        } else if (e.getSource() == view.getTxtDeineZahl()) {
            spieleRunde();
        }
    }

    private void spieleRunde() {
        if (model.hatGewonnen()) {
            view.zeigeFehler("Du hast bereits gewonnen (100 Punkte erreicht)!");
            return;
        }
        if (model.hatVerloren()) {
            view.zeigeFehler("Du hast leider verloren (0 Punkte erreicht)!");
            return;
        }

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

        model.berechneRunde(spielerZahl);

        view.aktualisiereRunde(
                model.getRundenErgebnis(),
                model.getGesamtPunkte(),
                model.getComputerZahl(),
                model.hatGewonnen(),
                model.hatVerloren()
        );
    }

    private void nochEinmal() {
        view.resetRunde(model.getGesamtPunkte());
    }
}
