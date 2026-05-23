package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ListeQcm extends JFrame {

    private String titreclicked; // String to store the clicked button text

    public ListeQcm(String nom, String filiere, String niveau) {
        setTitle("Liste des QCMs");
        setSize(600, 800);
        setBounds(400, 50, 400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(20,20));

        // Adding North Panel
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel northLabel = new JLabel("Liste des QCMs");
        northPanel.add(northLabel);
        add(northPanel, BorderLayout.NORTH);

        // Fetch and display QCMs based on nom, filiere, and niveau
        displayQCMs(nom, filiere, niveau);

        // Adding South Panel
        JPanel southPanel = new JPanel(new GridLayout(2, 1));
        JLabel southLabel = new JLabel("Liste des QCMs passe");
        southPanel.add(southLabel);
        JButton button = new JButton("Button");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use titreclicked as needed
            	Note pq = new Note(nom);
                pq.setVisible(true);
                setVisible(false);
                System.out.println(nom);
                System.out.println("Button clicked: " + titreclicked);
            }
        });
        southPanel.add(button);
        add(southPanel, BorderLayout.SOUTH);
    }

    private void displayQCMs(String nom, String filiere, String niveau) {
        // Perform database operations using ConnexionC class
        ConnexionC connexionC = new ConnexionC();
        try {
            // Retrieve QCMs based on filiere and niveau
            ResultSet rs = connexionC.selectQcm(filiere, niveau);

            // Panel to hold QCM information
            JPanel qcmPanel = new JPanel();
            qcmPanel.setLayout(new GridLayout(0, 1,40,20)); // Vertical layout

            // Process the retrieved QCMs and populate your frame with the data
            while (rs.next()) {
                String qcmTitle = rs.getString("titre");
                String idQcm = rs.getString("id_Qcm");
                System.out.println(idQcm);
                // Create buttons to represent QCMs
                JButton titleButton = new JButton("Title: " + qcmTitle);

                // Add ActionListener to each button
                titleButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
     
                        PassQcm pq = new PassQcm(idQcm,nom,filiere,niveau);
                        pq.setVisible(true);
                        setVisible(false);
                        System.out.println(qcmTitle);
                    }
                });

                // Add buttons to the qcmPanel
                qcmPanel.add(titleButton);
            }

            // Add qcmPanel to the frame
            add(new JScrollPane(qcmPanel), BorderLayout.CENTER);

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions or errors appropriately
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ListeQcm listeQcm = new ListeQcm("studentName", "studentFiliere", "studentNiveau");
            listeQcm.setVisible(true); // Display the frame
        });
    }
}