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

public class CreeQcm extends JFrame {
    JPanel creeqcmfenetre;
    JLabel qcm;
    JTextField titretexte;
    JTextField filieretexte;
    JTextField niveautexte;
    JLabel titre;
    JLabel filiere;
    JLabel niveau;
    JButton creeqcmbutton;
    

    public CreeQcm(String profName) {

        this.setTitle("Espace Cree QCM");
        this.setSize(600, 800); // Adjusted the frame size
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        titre = new JLabel("titre");
        filiere = new JLabel("Filiere");
        niveau = new JLabel("Niveau");
        
        qcm = new JLabel("Cree QCM");

        titretexte = new JTextField(20); // Decreased the size of text fields
        filieretexte = new JTextField(20);
        niveautexte = new JTextField(20);

        creeqcmfenetre = new JPanel(new GridLayout(3, 2)); // Using GridLayout
        creeqcmfenetre.add(titre);
        creeqcmfenetre.add(titretexte);
        creeqcmfenetre.add(filiere);
        creeqcmfenetre.add(filieretexte);
        creeqcmfenetre.add(niveau);
        creeqcmfenetre.add(niveautexte);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout to center align
        centerPanel.add(creeqcmfenetre); // Add creeqcmfenetre panel to the center

        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout to center align
        northPanel.add(qcm); // Add creeqcmfenetre panel to the center
        
        creeqcmbutton = new JButton("Cree QCM"); // Created confirm button

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout for bottom panel
        bottomPanel.add(creeqcmbutton); // Added confirm button to bottom panel

        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER); // Add centerPanel to the center of the frame
        this.add(bottomPanel, BorderLayout.SOUTH); // Add bottomPanel to the bottom of the frame

        
        creeqcmbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titreString = titretexte.getText();
                String filiereString = filieretexte.getText();
                String niveauString = niveautexte.getText();
               

                if (!titreString.isEmpty() && !filiereString.isEmpty() && !niveauString.isEmpty()) {
                    setVisible(false); // Hide current frame

                    
					// Create and display the new frame (CreeQcm) by passing the professor's name
                    Questionnaire questionnaire = new Questionnaire(profName,titreString,filiereString,niveauString);
                    questionnaire.setVisible(true);

            }}
        });
        
        

        this.setVisible(true);
    }

    public static void main(String[] args) {

        CreeQcm ef = new CreeQcm("");
    }
}
