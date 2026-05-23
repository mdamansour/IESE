package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Note extends JFrame {
    	  
      public Note(String nom) {
    	  this.setTitle("Liste des QCMs passe");
          this.setBounds(400, 50, 400, 600);
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setLayout(new BorderLayout(20,20));
          JPanel northPanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
          JLabel northLabel = new JLabel("Liste des QCMs passe ");
          northPanel.add(northLabel);
          this.add(northPanel, BorderLayout.NORTH);
          this.setVisible(true);
      }
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  Note f= new Note("");
	}

}
