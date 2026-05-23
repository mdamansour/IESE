package main;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PassQcm extends JFrame implements ActionListener {

    public int questionNumber = 0; // Counter for the question number
 
   
    JPanel passQcmPanel;

    // Labels for displaying question and choices
    public JLabel labelQuestionNumber;
    public JLabel labelQuestion;
    public JLabel labelChoice1;
    public JLabel labelChoice2;
    public JLabel labelChoice3;

    // Buttons for choices and "Suivant" button
    public JButton buttonChoice1;
    public JButton buttonChoice2;
    public JButton buttonChoice3;
    public JButton buttonSuivant;

    // 2D array to save the question number and button clicked
    public int[][] userChoices;

    // ArrayList to store the retrieved questions
    public ArrayList<PassQuestion> questions = new ArrayList<>();

    public PassQcm(String id,String nom,String filiere,String niveau) {
    	
    	getQuestion(id,nom);
    }
   
    public void getQuestion(String id, String nom) {
        ConnexionC connexionC = new ConnexionC();
        try {
            ResultSet rs = connexionC.selectQuestion(id);

            // Process the retrieved QCMs and populate the 'questions' ArrayList
            while (rs.next()) {
                int questNum = rs.getInt("num");
                String questtexte = rs.getString("texte_descriptif");
                String questch1 = rs.getString("choix1");
                String questch2 = rs.getString("choix2");
                String questch3 = rs.getString("choix3");
                int  bnreponse = rs.getInt("bn_reponse");
                
                String nomE = nom;
                
                PassQuestion quest = new PassQuestion(id,nomE, questNum ,questtexte, questch1, questch2, questch3,bnreponse);
                questions.add(quest);
            }

            // Initialize the frame with the first question
            initializeFrame(questions.get(questionNumber), questionNumber + 1);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void initializeFrame(PassQuestion quest, int num) {
        setTitle("QCM");
        setSize(600, 800);
        setBounds(400, 50, 400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        passQcmPanel = new JPanel();
        passQcmPanel.setLayout(new GridLayout(6, 1,10,10));
        
        // Initialize 2D array to save user choices
        userChoices = new int[questions.size()][2];
  
        // Initialize question labels and choices
        labelQuestionNumber = new JLabel("Question " + num);
        labelQuestion = new JLabel(quest.quetexte);
        labelChoice1 = new JLabel(quest.choix1);
        labelChoice2 = new JLabel(quest.choix2);
        labelChoice3 = new JLabel(quest.choix3);

        // Initialize buttons for choices and "Suivant" button
        buttonChoice1 = new JButton("1");
        buttonChoice2 = new JButton("2");
        buttonChoice3 = new JButton("3");
        buttonSuivant = new JButton("Suivant");

        // Add action listeners to the choice buttons and "Suivant" button
        buttonChoice1.addActionListener(this);
        buttonChoice2.addActionListener(this);
        buttonChoice3.addActionListener(this);
        buttonSuivant.addActionListener(this);
        
        
       
        // Add labels and buttons to the frame
        passQcmPanel.add(labelQuestionNumber);
        passQcmPanel.add(labelQuestion);
        passQcmPanel.add(buttonChoice1);
        passQcmPanel.add(labelChoice1);
        passQcmPanel.add(buttonChoice2);
        passQcmPanel.add(labelChoice2);
        passQcmPanel.add(buttonChoice3);
        passQcmPanel.add(labelChoice3);
        passQcmPanel.add(buttonSuivant);
        
        this.setContentPane(passQcmPanel);

        setVisible(true); // Set the frame visible
    }
int choice =0;
int truequestnum;
 //String id;
 int m=0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonChoice1 || e.getSource() == buttonChoice2 || e.getSource() == buttonChoice3) {
            JButton clickedButton = (JButton) e.getSource();
            int choice = Integer.parseInt(clickedButton.getText());

            // Save the question number and button clicked in the 2D array
           truequestnum = questionNumber+1;
           
           PassQuestion qsnote = questions.get(questionNumber);
           
           System.out.println("khtarti "+choice);
           System.out.println("hada shih "+ qsnote.bonnereponse );
           
         if (truequestnum == questions.get(questionNumber).num && choice == questions.get(questionNumber).bonnereponse) { 
             m++;
         System.out.println("Nnnote : "+m);
	     }
           
            // Indicate the button click
            clickedButton.setText(clickedButton.getText());
            //this.getbnQuestion(questionNumber + 1)
         
          
            // Disable all choice buttons after one is clicked
            buttonChoice1.setEnabled(false);
            buttonChoice2.setEnabled(false);
            buttonChoice3.setEnabled(false);
            clickedButton.setEnabled(true); // Re-enable the clicked button
        } else if (e.getSource() == buttonSuivant) {
	       
            // Check if there are more questions to display
            if (questionNumber + 1 < questions.size())
            {     
            
                questionNumber++;
             
                
                // Get the next question and display it
                PassQuestion nextQuestion = questions.get(questionNumber);
               // System.out.println("nnnnnn __" +nextQuestion.bonnereponse);
                initializeFrame(nextQuestion, questionNumber + 1);
            } else {
                // No more questions - handle end of the quiz
                // You can put code here for actions after the last question
            	
                JOptionPane.showMessageDialog(this, "Qcm est termine llll  Note:"+m);
                
                ConnexionC con =new ConnexionC();
                try {
					con.InsertEtudiant(questions.get(0).id,questions.get(0).nomE,m);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        }
    }
    
   
	public static void main(String[] args) {
		
        SwingUtilities.invokeLater(() -> {
          PassQcm listeQcm = new PassQcm("","","","");
        });
    }
}