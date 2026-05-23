package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EtudiantFenetre extends JFrame implements ActionListener {

    JPanel etufenetre;
    JLabel Espetudiant;
    JTextField nomtexte;
    JTextField filieretexte;
    JTextField niveautexte;
    JLabel nom;
    JLabel filiere;
    JLabel niveau;
    JButton confirmButton;

    public EtudiantFenetre() {
        this.setTitle("Espace Etudiant");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400, 50, 400, 400);

        nom = new JLabel("Nom");
        filiere = new JLabel("Filiere");
        niveau = new JLabel("Niveau");

        Espetudiant = new JLabel("Espace Etudiant");

        nomtexte = new JTextField(20);
        filieretexte = new JTextField(20);
        niveautexte = new JTextField(20);

        etufenetre = new JPanel(new GridLayout(3, 2));
        etufenetre.add(nom);
        etufenetre.add(nomtexte);
        etufenetre.add(filiere);
        etufenetre.add(filieretexte);
        etufenetre.add(niveau);
        etufenetre.add(niveautexte);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(etufenetre);

        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this); // Link button action to actionPerformed method

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(confirmButton);

        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomString = nomtexte.getText();
        String filiereString = filieretexte.getText();
        String niveauString = niveautexte.getText();

        if (!nomString.isEmpty() && !filiereString.isEmpty() && !niveauString.isEmpty()) {
            this.setVisible(false); // Hide current frame

            // Create and display the new frame (ListeQcm) with arguments
            ListeQcm listeQcm = new ListeQcm(nomString, filiereString, niveauString);
            listeQcm.setVisible(true);
        } else {
            // Show an error message or handle empty fields
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
        }
    }

    public static void main(String[] args) {
        EtudiantFenetre etudiantFenetre = new EtudiantFenetre();
    }
}
