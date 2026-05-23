package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfesseurFenetre extends JFrame {

    JPanel profenetre;
    JLabel Espprofesseur;
    JTextField nomtexte;
    JTextField specialitetexte;
    JLabel nom;
    JLabel specialite;
    JButton confirmButton;

    public ProfesseurFenetre() {

        this.setTitle("Espace Professeur");
        this.setSize(600, 800); // Adjusted the frame size
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        nom = new JLabel("Nom");
        specialite = new JLabel("Spécialité");
        
        Espprofesseur = new JLabel("Espace Professeur");

        nomtexte = new JTextField(20); // Decreased the size of text fields
        specialitetexte = new JTextField(20);

        profenetre = new JPanel(new GridLayout(3, 2)); // Using GridLayout
        profenetre.add(nom);
        profenetre.add(nomtexte);
        profenetre.add(specialite);
        profenetre.add(specialitetexte);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout to center align
        centerPanel.add(profenetre); // Add profenetre panel to the center

        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout to center align
        northPanel.add(Espprofesseur); // Add profenetre panel to the center

        confirmButton = new JButton("Confirm"); // Created confirm button

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout for bottom panel
        bottomPanel.add(confirmButton); // Added confirm button to bottom panel

        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER); // Add centerPanel to the center of the frame
        this.add(bottomPanel, BorderLayout.SOUTH); // Add bottomPanel to the bottom of the frame

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomString = nomtexte.getText();
                String specialiteString = specialitetexte.getText();

                if (!nomString.isEmpty() && !specialiteString.isEmpty()) {
                    setVisible(false); // Hide current frame

                    // Create and display the new frame (CreeQcm) by passing the professor's name
                    CreeQcm cQcm = new CreeQcm(nomString);
                    cQcm.setVisible(true);
                } else {
                    // Show an error message or handle empty fields
                    // For example, display a JOptionPane message
                    // JOptionPane.showMessageDialog(ProfesseurFenetre.this, "Please fill all fields.");
                }
            }
        });

        this.setVisible(true);
    }

    public static void main(String[] args) {
        ProfesseurFenetre ef = new ProfesseurFenetre();
    }
}
