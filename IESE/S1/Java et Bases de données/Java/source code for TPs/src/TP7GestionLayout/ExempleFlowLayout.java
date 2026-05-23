package TP7GestionLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExempleFlowLayout extends JFrame {
	
	JButton br, bv, bb, bj;
	JPanel zone, main_panel;
	
	public ExempleFlowLayout()
	{
		this.setTitle("Exemple de formatage de fenetre flow layout");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		int x = Toolkit.getDefaultToolkit().getScreenSize().width;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(x/3, y/3);
		this.setLocationRelativeTo(null);
		// initialisation des bouttons
		br = new JButton("Rouge");
		br.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				zone.setBackground(Color.red);
				
			}
		});
		bv = new JButton("Vert");
		bv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				zone.setBackground(Color.green);
				
			}
		});
		bb = new JButton("Bleu");
		bb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				zone.setBackground(Color.blue);
				
			}
		});
		bj = new JButton("Jaune");
		bj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				zone.setBackground(Color.yellow);
				
			}
		});
		// creation des zones
		zone = new JPanel();
		zone.setBackground(Color.white);
		zone.setPreferredSize(new Dimension(100, 100));
		
		
		main_panel = new JPanel(new FlowLayout(1, 20, 20));// alignement, espace entre les composant horizontal, vertical
		main_panel.add(br);
		main_panel.add(bv);
		main_panel.add(bb);
		main_panel.add(bj);
		main_panel.add(zone);
		
		main_panel.setBackground(Color.black);
		
		this.setContentPane(main_panel);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		ExempleFlowLayout f = new ExempleFlowLayout();

	}

}
