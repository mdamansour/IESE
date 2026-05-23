package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Questionnaire extends JFrame {

    private JTextField numberField;
    private JTextField choix1;
    private JTextField choix2;
    private JTextField choix3;
    private JTextField brField;
    private JLabel choixLabel;   
    private JLabel choixLabel1;
    private JLabel choixLabel2;
    private JLabel choixLabel3;
    private int questionNumber = 1;
    Qcm qcm = new Qcm();

    public Questionnaire(String profName, String titreString, String filiereString, String niveauString) {
    	
      
        this.setTitle("Questionnaire");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(600, 800);
        this.setMinimumSize(new Dimension(600,800));
        this.setVisible(true);

        JPanel northPanel = new JPanel(new GridLayout(2, 2));
        JLabel questionLabel = new JLabel("Question");
        numberField = new JTextField(5);
        numberField.setEditable(false);
        JLabel texteDiscriptifLabel = new JLabel("Texte discriptif");
        JTextField textField = new JTextField(70);

        northPanel.add(questionLabel);
        northPanel.add(numberField);
        northPanel.add(texteDiscriptifLabel);
        northPanel.add(textField);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        choixLabel = new JLabel("Choix");
        choixLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        centerPanel.add(choixLabel);

        JPanel southPanel = new JPanel(new GridLayout(5, 2));
        JTextField choix1 = new JTextField();
        JTextField choix2 = new JTextField();
        JTextField choix3 = new JTextField();
        
        JLabel choixLabel1 = new JLabel("                                                                                                                                                                                         1");
        JLabel choixLabel2 = new JLabel("                                                                                                                                                                                         2");
        JLabel choixLabel3 = new JLabel("                                                                                                                                                                                         3");
         
        southPanel.add(choixLabel1);
        southPanel.add(choix1);
        southPanel.add(choixLabel2);
        southPanel.add(choix2);
        southPanel.add(choixLabel3);
        southPanel.add(choix3);
        
        
        JLabel bonneReponseLabel = new JLabel("Bonne Reponse");
        brField = new JTextField(5);
        JLabel nextQuestionLabel = new JLabel("You can move to next question click in");
        JButton suivreButton = new JButton("Suivre");
        
        southPanel.add(bonneReponseLabel);
        southPanel.add(brField);
        southPanel.add(nextQuestionLabel);
        southPanel.add(suivreButton);

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        
        
        Qcm qcm = new Qcm(titreString, profName, niveauString, filiereString);
        ConnexionC c =new ConnexionC();
        
        Random r = new Random();
        String id = profName +r.nextInt(9999999);
        System.out.println(id);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
       
  
     	  

         suivreButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 // Save the values and clear text fields
                 String td = textField.getText();
                 String ch1 = choix1.getText();
                 String ch2 = choix2.getText();
                 String ch3 = choix3.getText();
                 int br = Integer.parseInt(brField.getText());
                
         
				
                 // Perform actions with saved values (here just print)

                 /*System.out.println(profName);
                 System.out.println(titreString);
                 System.out.println(filiereString);
                 System.out.println(niveauString);
                 
                 System.out.println("Question " + questionNumber + ":");
                 System.out.println("Texte discriptif: " + td);
                 System.out.println(ch1);
                 System.out.println(ch2);
                 System.out.println(ch3);
                 System.out.println("Bonne Reponse: " + br);
                 
                 Question quest = new Question(td, ch1, ch2, ch3, br);
                
                 qcm.ajouterQuestion(quest, questionNumber-1);
                 
                 System.out.println("this issss qcm \n "+qcm);
                 */
                 
                 
					try {
						c.creationqcm(id, profName, filiereString, niveauString,titreString);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                try {
						c.questions(id, questionNumber, td, ch1, ch2, ch3, br);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


                 textField.setText("");
                 for (Component component : southPanel.getComponents()) {
                     if (component instanceof JTextField) {
                         ((JTextField) component).setText("");
                     }
                 }
                 numberField.setText(Integer.toString(++questionNumber));
                 
            
             }
         });
        
    }

    public static void main(String[] args) {
	
		Questionnaire ques = new Questionnaire("","","","");
    }
}
