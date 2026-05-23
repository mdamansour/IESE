package tp9_layoutManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExGridLayout extends JFrame implements ActionListener
{
	boolean s;
	JPanel pc,pn,ps,mainPanel;
	JButton bSauv,bAnnul;
	JLabel haut,bas,nom,prenom,age;
	JTextField NomArea;
	JTextField PrenomArea;
	JTextField AgeArea;
public ExGridLayout() {
	this.setTitle("jeux");
	int x=Toolkit.getDefaultToolkit().getScreenSize().width;
	int y=Toolkit.getDefaultToolkit().getScreenSize().height;
	this.setSize(x/2,y/2);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.getContentPane().setBackground(Color.DARK_GRAY);
	this.setMinimumSize(new Dimension(500,300));
	nom=new JLabel("Nom");
	prenom=new JLabel("Prénom");
	age=new JLabel("Age");
	NomArea=new JTextField();
	PrenomArea=new JTextField();
	AgeArea=new JTextField();
	bSauv=new JButton("SAUVEGARDER");
	bSauv.addActionListener(this);
	bAnnul=new JButton("ANNULER");
	bAnnul.addActionListener(this);
	pc=new JPanel(new GridLayout(4,2));
	pc.add(nom);
	pc.add(NomArea);
	pc.add(prenom);
	pc.add(PrenomArea);
	pc.add(age);
	pc.add(AgeArea);
	pc.add(bSauv);
	pc.add(bAnnul);
	pn=new JPanel();
	ps=new JPanel();
	mainPanel=new JPanel(new BorderLayout());
	mainPanel.add(pn,BorderLayout.NORTH);
	mainPanel.add(pc,BorderLayout.CENTER);
	mainPanel.add(ps,BorderLayout.SOUTH);
	this.setContentPane(mainPanel);
	this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		ExGridLayout f=new ExGridLayout();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bSauv) s=true;
		if(e.getSource()==bAnnul) s=false;
	}

}
