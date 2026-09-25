import javax.swing.SwingUtilities;

/**
 * Startklasse der Anwendung Zahlen-Gewinnspiel.
 * Initialisiert die MVC-Komponenten und startet die Oberfläche.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GewinnModel model = new GewinnModel();
            GewinnView view = new GewinnView();
            new GewinnController(model, view);
            view.setVisible(true);
        });
    }
}
