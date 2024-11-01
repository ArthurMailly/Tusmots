import javax.swing.*;
import java.awt.*;
public class InvalidAction extends JFrame { //J'ai rajouté une classe pour afficher un message d'erreur si l'utilisateur entre un mot invalide, c'est plus joli que juste le JOptionPane selon moi
    
    public InvalidAction(Tusmots_Interface mainFrame) {
        super.setLocationRelativeTo(mainFrame);
        setTitle("Action invalide");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel panelMessage= new JPanel();
        JPanel panelButton= new JPanel();

        JLabel messageLabel = new JLabel("<html><center>Vous avez entré un mot invalide.<br> Veuillez entrer un mot valide.</center></html>", JLabel.CENTER);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        panelMessage.add(messageLabel, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.setBackground(new Color(70, 130, 180));
        okButton.setForeground(Color.WHITE);
        okButton.setFocusPainted(false);
        okButton.setPreferredSize(new Dimension(100, 40));

        okButton.addActionListener(e -> dispose());
        panelButton.add(okButton, BorderLayout.CENTER);

        add(panelMessage);
        add(panelButton);

        
    }
    public void display() {
        setVisible(true);
    }
}
