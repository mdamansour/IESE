package TP7GestionLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.lang.ProcessHandle.Info;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTexamentField;

public class InfoClients examentends JFrame
{
	JButton b1, b2;
	JLabel l1, l2, l3, l4, l5;
	JTexamentField f1, f2, f3;
	JPanel pn, pc, ps, main_panel;
	
	public InfoClients()
	{
		this.setTitle("Exemple de formatage de fenetre grid layout");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		int x = Toolkit.getDefaultToolkit().getScreenSize().width;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(x/3, y/3);
		this.setLocationRelativeTo(null);
		
		b1 = new JButton("Envoyer");
		b2 = new JButton("Annuler");
		
		l1 = new JLabel("Saisir Info Client", 4); // 0: centre, 2: gauche, 4: droit
		l2 = new JLabel("Nom:");
		l3 = new JLabel("Prenom:");
		l4 = new JLabel("Age:");
		l5 = new JLabel("Réalisé Par Yasser Baali");
		
		f1 = new JTexamentField();
		f2 = new JTexamentField();
		f3 = new JTexamentField();
		
		main_panel = new JPanel(new BorderLayout());
		pn = new JPanel(new FlowLayout(1, 20, 20));
		pc = new JPanel(new GridLayout(4, 2));
		ps = new JPanel(new FlowLayout(1, 20, 20));
		
		pn.add(l1);
		
		pc.add(l2);
		pc.add(f1);
		pc.add(l3);
		pc.add(f2);
		pc.add(l4);
		pc.add(f3);
		pc.add(b1);
		pc.add(b2);
		
		ps.add(l5);
		
		main_panel.add(BorderLayout.NORTH,l1);
		main_panel.add(BorderLayout.CENTER,pc);
		main_panel.add(BorderLayout.SOUTH,l5);
		
		this.setContentPane(main_panel);
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		InfoClients f = new InfoClients();
	}

}
