import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Tusmots_Interface extends JFrame {
    private Partie partie;
    private JTextField inputField;
    private JTextArea gridArea;
    private JTextArea stateArea;
    private String mot;
    private List<String> ListeMotEntre;

    public Tusmots_Interface() {
        setTitle("Tusmots");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        partie = new Partie("TAMANOIR", 6);
        ListeMotEntre = new ArrayList<>();
        gridArea = new JTextArea(10, 30);
        stateArea = new JTextArea(10, 30);
        gridArea.setEditable(false);
        stateArea.setEditable(false);
        updateDisplay();

        inputField = new JTextField(10);
        JButton tryButton = new JButton("Valider");

        tryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mot = inputField.getText().toUpperCase();
                if (partie.testerMot(mot)) {
                    ListeMotEntre.add(mot);
                    updateDisplay();
                    if (partie.estPartieTerminee()) {
                        JOptionPane.showMessageDialog(null, "Partie terminée !");
                        tryButton.setEnabled(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Mot invalide ou longueur incorrecte.");
                }
                inputField.setText("");
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Entrez un mot : "));
        inputPanel.add(inputField);
        inputPanel.add(tryButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(stateArea, BorderLayout.CENTER);

        JPanel legendPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel legendLabel = new JLabel("<html>B : Lettre bien placée<br>M : Lettre mal placée<br>X : Mauvaise lettre<br>_ : Pas encore vérifiée<br>? : Erreur</html>");
        legendPanel.add(legendLabel);

        bottomPanel.add(legendPanel, BorderLayout.EAST);

        add(new JScrollPane(gridArea), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void updateDisplay() {
        StringBuilder gridText = new StringBuilder();
        StringBuilder stateText = new StringBuilder();

        Grille grille = partie.getGrille();
        int numeroDeLEssai = partie.getNumeroDeLEssai();

        for (int i = 0; i < partie.getNbrEssai(); i++) {
            String ligneMot = grille.grilleMots[i].getMot();
            for (int j = 0; j < ligneMot.length(); j++) {
                char c;
                if (i <= partie.getNumeroDeLEssai()-1){
                    c = ListeMotEntre.get(i).charAt(j);
                }
                else {
                    c = '_';
                }              
                gridText.append(c).append(" ");
            }
            gridText.append("\n");
        }

        gridArea.setText(gridText.toString());
        stateArea.setText(""); 

        for (int i = 0; i < numeroDeLEssai; i++) {
            String ligneMot = grille.grilleMots[i].getMot();
            for (int j = 0; j < ligneMot.length(); j++) {
                int etatCase = grille.grilleMots[i].getCasePlace(j).getEtatCase();
                switch (etatCase) {
                    case 1:
                        stateText.append("B "); // Bien placée
                        break;
                    case 2:
                        stateText.append("M "); // Mal placée
                        break;
                    case 3:
                        stateText.append("X "); // Mauvaise lettre
                        break;
                    case 4:
                        stateText.append("_ "); // Pas encore vérifiée
                        break;
                    default:
                        stateText.append("? "); // Erreur
                }
            }
            stateText.append("\n");
        }

        stateArea.setText(stateText.toString());
    }
}
