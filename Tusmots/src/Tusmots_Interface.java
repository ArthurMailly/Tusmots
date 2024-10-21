import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tusmots_Interface extends JFrame {
    private Partie partie;
    private JTextField inputField;
    private JTextArea gridArea;
    private JTextArea stateArea;

    public Tusmots_Interface() {
        setTitle("Tusmots");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        partie = new Partie("TAMANOIR", 6);

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
                String mot = inputField.getText().toUpperCase();
                if (partie.testerMot(mot)) {
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

        add(new JScrollPane(gridArea), BorderLayout.CENTER);
        add(new JScrollPane(stateArea), BorderLayout.SOUTH);
        add(inputPanel, BorderLayout.NORTH);

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
                char c = grille.grilleMots[i].getCasePlace(j).getEtatCase() == 1
                        ? ligneMot.charAt(j)
                        : '_';               
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
