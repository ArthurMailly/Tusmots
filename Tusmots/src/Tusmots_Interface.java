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
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(240, 248, 255));

        partie = new Partie("TAMANOIR", 6);
        ListeMotEntre = new ArrayList<>();


        gridArea = new JTextArea(10, 30);
        gridArea.setEditable(false);
        gridArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        gridArea.setBackground(new Color(240, 248, 255));
        
        stateArea = new JTextArea(7, 30);
        stateArea.setEditable(false);
        stateArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        stateArea.setBackground(new Color(240, 248, 255));


        updateDisplay();

        inputField = new JTextField(10);
        JButton tryButton = new JButton("Valider");
        tryButton.setFont(new Font("Arial", Font.PLAIN, 14));
        tryButton.setBackground(new Color(70, 130, 180));
        tryButton.setForeground(Color.WHITE);
        tryButton.setFocusPainted(false);

        tryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mot = inputField.getText().toUpperCase();
                if (partie.testerMot(mot)) {
                    ListeMotEntre.add(mot);
                    updateDisplay();
                    if (partie.estPartieTerminee()==1 || partie.estPartieTerminee()==2) {
                        finalscreen EcranFinal = new finalscreen(partie.estPartieTerminee());
                        EcranFinal.setVisible(true);
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Mot invalide ou longueur incorrecte.");
                }
                inputField.setText("");
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(240, 248, 255));
        inputPanel.add(new JLabel("Entrez un mot : "));
        inputPanel.add(inputField);
        inputPanel.add(tryButton);

        JPanel legendPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        legendPanel.setOpaque(false);
        JLabel legendLabel = new JLabel("<html>B : Lettre bien placée<br>M : Lettre mal placée<br>X : Mauvaise lettre<br>_ : Pas encore vérifiée<br>? : Erreur</html>");
        legendLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        legendPanel.add(legendLabel);


        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);
        bottomPanel.add(stateArea, BorderLayout.CENTER);
        bottomPanel.add(legendPanel, BorderLayout.EAST);

        add(gridArea, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
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
