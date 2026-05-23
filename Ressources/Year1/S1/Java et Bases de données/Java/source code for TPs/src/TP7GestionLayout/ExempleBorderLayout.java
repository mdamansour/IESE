package TP7GestionLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExempleBorderLayout examentends JFrame implements ActionListener
{
	
	JButton b1, b2, b3, b4, b5, b6;
	JPanel ps, pn, pc, main_panel;
	Color couleur;
	String forme = "Carre";
	
	public ExempleBorderLayout()
	{
		this.setTitle("Exemple de formatage de fenetre border layout");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		int x = Toolkit.getDefaultToolkit().getScreenSize().width;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(x/2, y/2);
		this.setLocationRelativeTo(null);
		b1 = new JButton("Rouge");
		b1.addActionListener(this);
		b2 = new JButton("Vert");
		b2.addActionListener(this);
		b3 = new JButton("Bleu");
		b3.addActionListener(this);
		b4 = new JButton("Jaune");
		b4.addActionListener(this);
		b5 = new JButton("Carre");
		b5.addActionListener(this);
		b6 = new JButton("Cercle");
		b6.addActionListener(this);
		pn = new JPanel(new FlowLayout(1, 20, 20));
		ps = new JPanel(new FlowLayout(1, 20, 20));
		pc = new JPanel(new FlowLayout(1, 20, 20));
		// panel nord
		pn.add(b1);
		pn.add(b2);
		pn.add(b3);
		pn.add(b4);
		pn.setBackground(Color.orange);
		// panel sud
		ps.add(b5);
		ps.add(b6);
		ps.setBackground(Color.orange);
		//panel centre
		pc = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				g.setColor(couleur);
				if(forme=="Carre") g.fillRect(pc.getWidth() / 2 - 50, pc.getHeight() / 2 - 50, 100, 100);
				else g.fillOval(pc.getWidth() / 2 - 50, pc.getHeight() / 2 - 50, 100, 100);
			}
		};
		main_panel = new JPanel(new BorderLayout());
		pc.setBackground(Color.cyan);
		main_panel.add(BorderLayout.NORTH,pn);
		main_panel.add(BorderLayout.SOUTH,ps);
		main_panel.add(BorderLayout.CENTER,pc);
		this.setContentPane(main_panel);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		ExempleBorderLayout f = new ExempleBorderLayout();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) couleur = Color.red;
		if(e.getSource()==b2) couleur = Color.green;
		if(e.getSource()==b3) couleur = Color.blue;
		if(e.getSource()==b4) couleur = Color.yellow;
		if(e.getSource()==b5) forme = "Carre";
		if(e.getSource()==b6) forme = "Cercle";
		repaint();
	}

}
