import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Die View stellt die grafische Benutzeroberfläche (Swing-GUI) dar.
 * Sie enthält keine Spiellogik, sondern zeigt nur den Zustand an
 * und leitet Benutzerinteraktionen an den Controller weiter.
 */
public class GewinnView extends JFrame {

    // Labels für die Statusanzeige oben
    private JLabel lblRundenErgebnis;
    private JLabel lblGesamtPunkte;

    // Eingabefeld für den Spieler und Ausgabefeld für den Computer
    private JTextField txtDeineZahl;
    private JTextField txtComputer;

    // Button zum Starten einer neuen Runde
    private JButton btnNochEinmal;

    public GewinnView() {
        super("Zahlen-Gewinnspiel (v1.0)");
        initUI();
    }

    /**
     * Baut die Oberfläche mit allen Komponenten und Layouts auf.
     */
    private void initUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 340);
        setResizable(false);
        setLocationRelativeTo(null);

        // Haupt-Panel mit Randabstand
        JPanel mainPanel = new JPanel(new BorderLayout(0, 15));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        // --- OBERER BEREICH: Rundenergebnis und Gesamtpunkte ---
        JPanel topPanel = new JPanel(new GridLayout(2, 2, 12, 6));

        JLabel lblRundenergebnisTitel = new JLabel("Rundenergebnis:", SwingConstants.CENTER);
        lblRundenergebnisTitel.setFont(new Font("SansSerif", Font.PLAIN, 15));

        JLabel lblGesamtpunkteTitel = new JLabel("Gesamtpunkte:", SwingConstants.CENTER);
        lblGesamtpunkteTitel.setFont(new Font("SansSerif", Font.PLAIN, 15));

        lblRundenErgebnis = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
        lblRundenErgebnis.setOpaque(true);
        lblRundenErgebnis.setBackground(Color.WHITE);
        lblRundenErgebnis.setFont(new Font("SansSerif", Font.BOLD, 17));
        lblRundenErgebnis.setPreferredSize(new Dimension(200, 36));

        lblGesamtPunkte = new JLabel("Gesamtpunkte: 30", SwingConstants.CENTER);
        lblGesamtPunkte.setOpaque(true);
        lblGesamtPunkte.setBackground(Color.WHITE);
        lblGesamtPunkte.setFont(new Font("SansSerif", Font.BOLD, 17));
        lblGesamtPunkte.setPreferredSize(new Dimension(200, 36));

        topPanel.add(lblRundenergebnisTitel);
        topPanel.add(lblGesamtpunkteTitel);
        topPanel.add(lblRundenErgebnis);
        topPanel.add(lblGesamtPunkte);

        // --- MITTLERER BEREICH: Eingabe & Computerzahl ---
        JPanel centerPanel = new JPanel(new BorderLayout(0, 6));

        JPanel labelPanel = new JPanel(new GridLayout(1, 2, 12, 0));
        JLabel lblDeineZahlTitel = new JLabel("Deine Zahl:", SwingConstants.CENTER);
        lblDeineZahlTitel.setFont(new Font("SansSerif", Font.PLAIN, 15));
        JLabel lblComputerTitel = new JLabel("Computer:", SwingConstants.CENTER);
        lblComputerTitel.setFont(new Font("SansSerif", Font.PLAIN, 15));
        labelPanel.add(lblDeineZahlTitel);
        labelPanel.add(lblComputerTitel);

        JPanel boxesPanel = new JPanel(new GridLayout(1, 2, 12, 0));
        Font grosserFont = new Font("SansSerif", Font.BOLD, 46);

        txtDeineZahl = new JTextField();
        txtDeineZahl.setHorizontalAlignment(JTextField.CENTER);
        txtDeineZahl.setFont(grosserFont);
        txtDeineZahl.setPreferredSize(new Dimension(180, 100));

        txtComputer = new JTextField();
        txtComputer.setHorizontalAlignment(JTextField.CENTER);
        txtComputer.setFont(grosserFont);
        txtComputer.setEditable(false);
        txtComputer.setBackground(Color.WHITE);
        txtComputer.setPreferredSize(new Dimension(180, 100));

        boxesPanel.add(txtDeineZahl);
        boxesPanel.add(txtComputer);

        centerPanel.add(labelPanel, BorderLayout.NORTH);
        centerPanel.add(boxesPanel, BorderLayout.CENTER);

        // --- UNTERER BEREICH: Button "Noch einmal!" ---
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnNochEinmal = new JButton("Noch einmal!");
        btnNochEinmal.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnNochEinmal.setPreferredSize(new Dimension(140, 32));
        bottomPanel.add(btnNochEinmal);

        // Zusammenfügen im Haupt-Panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    /**
     * Aktualisiert die GUI nach dem Spielen einer Runde (Version 1.0).
     */
    public void aktualisiereRunde(int ergebnis, int gesamt, int computer, boolean gewonnen, boolean verloren) {
        txtComputer.setText(String.valueOf(computer));

        if (gewonnen) {
            lblRundenErgebnis.setText("Gewonnen");
            lblGesamtPunkte.setText(String.valueOf(gesamt));
        } else if (verloren) {
            lblRundenErgebnis.setText("Verloren");
            lblGesamtPunkte.setText(String.valueOf(gesamt));
        } else {
            if (ergebnis > 0) {
                lblRundenErgebnis.setText("+" + ergebnis);
            } else {
                lblRundenErgebnis.setText(String.valueOf(ergebnis));
            }
            lblGesamtPunkte.setText(String.valueOf(gesamt));
        }
        // Farbliche Rückmeldung der Labels
        if (ergebnis > 0 || gewonnen) {
            lblRundenErgebnis.setBackground(Color.GREEN);
            lblGesamtPunkte.setBackground(Color.GREEN);
        } else if (ergebnis < 0 || verloren) {
            lblRundenErgebnis.setBackground(Color.RED);
            lblGesamtPunkte.setBackground(Color.RED);
        } else {
            lblRundenErgebnis.setBackground(Color.WHITE);
            lblGesamtPunkte.setBackground(Color.WHITE);
        }
    }

    /**
     * Setzt die Anzeige für die nächste Runde zurück.
     * Der Gesamtpunktestand bleibt erhalten.
     */
    public void resetRunde(int gesamtPunkte) {
        txtDeineZahl.setText("");
        txtComputer.setText("");
        lblRundenErgebnis.setText("Tippe eine Zahl von 1 bis 9");
        lblGesamtPunkte.setText("Gesamtpunkte: " + gesamtPunkte);
        txtDeineZahl.requestFocus();
        // Hintergrundfarben wieder auf Weiß zurücksetzen
        lblRundenErgebnis.setBackground(Color.WHITE);
        lblGesamtPunkte.setBackground(Color.WHITE);
    }

    public String getEingabeZahl() {
        return txtDeineZahl.getText();
    }

    public void addEingabeListener(ActionListener listener) {
        txtDeineZahl.addActionListener(listener);
    }

    public void addNochEinmalListener(ActionListener listener) {
        btnNochEinmal.addActionListener(listener);
    }

    public void zeigeFehler(String nachricht) {
        JOptionPane.showMessageDialog(this, nachricht, "Hinweis", JOptionPane.WARNING_MESSAGE);
    }
}
