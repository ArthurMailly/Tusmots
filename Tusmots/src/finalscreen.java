import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class finalscreen extends JFrame {

    public finalscreen(int win) {
        setTitle("Écran de fin");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel(win == 1 ? "Félicitations, vous avez gagné !" : "Dommage, vous avez perdu.", JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 18));
        messageLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JButton menuButton = new JButton("Menu");
        JButton quitButton = new JButton("Quitter");

        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        menuButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        menuButton.setBackground(new Color(70, 130, 180));  
        quitButton.setBackground(new Color(220, 20, 60));
        menuButton.setForeground(Color.WHITE);
        quitButton.setForeground(Color.WHITE);

        menuButton.setFocusPainted(false);
        quitButton.setFocusPainted(false);
        
        menuButton.setPreferredSize(new Dimension(100, 40));
        quitButton.setPreferredSize(new Dimension(100, 40));


        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu test = new menu();
                test.setVisible(true);
                dispose();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(menuButton);
        buttonPanel.add(quitButton);
        buttonPanel.setOpaque(false);

        getContentPane().setBackground(new Color(240, 248, 255));

        add(messageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}