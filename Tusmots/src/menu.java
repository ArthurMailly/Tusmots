import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class menu extends JFrame {

    public menu() {
        setTitle("Menu principal");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel("<html><center>Bienvenue sur la première <br> version de Tusmots !</center></html>", JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 18));
        messageLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JButton menuButton = new JButton("Jouer");
        JButton regleButton = new JButton("Règles");
        JButton quitButton = new JButton("Quitter");

        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        menuButton.setFont(buttonFont);
        regleButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        menuButton.setBackground(new Color(70, 130, 180)); 
        regleButton.setBackground(new Color(34, 139, 34)); 
        quitButton.setBackground(new Color(220, 20, 60));

        menuButton.setForeground(Color.WHITE);
        regleButton.setForeground(Color.WHITE);
        quitButton.setForeground(Color.WHITE);

        menuButton.setFocusPainted(false);
        regleButton.setFocusPainted(false);
        quitButton.setFocusPainted(false);
        
        menuButton.setPreferredSize(new Dimension(100, 40));
        regleButton.setPreferredSize(new Dimension(100, 40));
        quitButton.setPreferredSize(new Dimension(100, 40));



        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tusmots_Interface fenetre = new Tusmots_Interface();
                fenetre.setVisible(true);
                dispose();
            }
        });


        regleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rules = "Règles du jeu Tusmots :\n" +
                       "1. Vous devez deviner un mot.\n" +
                       "2. Chaque essai vous donnera un retour sur vos lettres.\n" +
                       "3. 'B' signifie que la lettre est bien placée.\n" +
                       "4. 'M' signifie que la lettre est mal placée.\n" +
                       "5. 'X' signifie que la lettre n'est pas dans le mot.\n" +
                       "6. Continuez à essayer jusqu'à ce que vous deviniez le mot ou que vous ayez épuisé vos essais.\n" +
                       "Bonne chance !";
        
                JOptionPane.showMessageDialog(null, rules, "Règles du jeu", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));
        buttonPanel.add(menuButton);
        buttonPanel.add(regleButton);
        buttonPanel.add(quitButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); 
        buttonPanel.setOpaque(false);

        getContentPane().setBackground(new Color(240, 248, 255));

        add(messageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}