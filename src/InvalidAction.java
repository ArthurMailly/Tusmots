import javax.swing.*;
import java.awt.*;
public class InvalidAction extends JFrame { //J'ai rajouté une classe pour afficher un message d'erreur si l'utilisateur entre un mot invalide, c'est plus joli que juste le JOptionPane selon moi
    public InvalidAction() {
        setTitle("Action invalide");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel messageLabel = new JLabel("<html><center>Vous avez entré un mot invalide.<br> Veuillez entrer un mot valide.</center></html>", JLabel.CENTER);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JButton okButton = new JButton("OK");
        okButton.setBackground(new Color(70, 130, 180));
        okButton.setForeground(Color.WHITE);
        okButton.setFocusPainted(false);
        okButton.setPreferredSize(new Dimension(100, 40));

        okButton.addActionListener(e -> dispose());

        add(messageLabel);
        add(okButton);

        
    }
    public void display() {
        setVisible(true);
    }
}
