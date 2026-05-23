package TP7GestionLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTexamentField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class InfoClients2 examentends JFrame {

    // Declare components with meaningful names
    private JButton btnSend, btnCancel;
    private JLabel lblTitle, lblName, lblSurname, lblAge, lblFooter;
    private JTexamentField txtName, txtSurname, txtAge;
    private JPanel mainPanel, northPanel, centerPanel, southPanel;

    public InfoClients2() {
        initializeWindow();
        initializeComponents();
        setupLayout();
        
        // Finalize frame settings
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }

    private void initializeWindow() {
        this.setTitle("Exemple de formatage de fenetre grid layout");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Center the window and set size to 1/3 of the screen
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(screenWidth / 2, screenHeight / 2);
        this.setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        // Buttons
        btnSend = new JButton("Envoyer");
        btnCancel = new JButton("Annuler");

        // Labels
        // "SwingConstants.RIGHT" is much more readable than the magic number "4"
        lblTitle = new JLabel("Saisir Info Client", SwingConstants.CENTER);
        lblName = new JLabel("Nom:");
        lblSurname = new JLabel("Prenom:");
        lblAge = new JLabel("Age:");
        lblFooter = new JLabel("Réalisé Par Yasser Baali");

        // Texament Fields
        txtName = new JTexamentField();
        txtSurname = new JTexamentField();
        txtAge = new JTexamentField();
    }

    private void setupLayout() {
        mainPanel = new JPanel(new BorderLayout());

        // North Panel (Title)
        // FlowLayout.CENTER is clearer than "1"
        northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)); 
        northPanel.add(lblTitle);

        // Center Panel (Form Inputs)
        centerPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // Added gaps (10, 10) for better spacing
        centerPanel.add(lblName);
        centerPanel.add(txtName);
        centerPanel.add(lblSurname);
        centerPanel.add(txtSurname);
        centerPanel.add(lblAge);
        centerPanel.add(txtAge);
        centerPanel.add(btnSend);
        centerPanel.add(btnCancel);

        // South Panel (Footer)
        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        southPanel.add(lblFooter);

        // Add sub-panels to the main panel
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        // Best practice: Run Swing GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new InfoClients2();
        });
    }
}