package main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PremierFenetre extends JFrame {
    JPanel pfenetre;
    JLabel question;
    JButton etudiant;
    JButton professeur;

    public PremierFenetre() {

        question = new JLabel("Bienvenu! Vous etes...");
        etudiant = new JButton("Etudiant");
        professeur = new JButton("Professeur");

        this.setTitle("ApplicationQCM");
        this.setBounds(400, 50, 200, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(400, 300));
        pfenetre = new JPanel();

        pfenetre.add(question);
        pfenetre.add(etudiant);
        pfenetre.add(professeur);

        this.setContentPane(pfenetre);
        this.setVisible(true);

        etudiant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide current frame
                EtudiantFenetre etudiantFenetre = new EtudiantFenetre();
                etudiantFenetre.setVisible(true);
            }
        });

        professeur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide current frame
                ProfesseurFenetre professeurFenetre = new ProfesseurFenetre();
                professeurFenetre.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        PremierFenetre pf = new PremierFenetre();
    }
}
