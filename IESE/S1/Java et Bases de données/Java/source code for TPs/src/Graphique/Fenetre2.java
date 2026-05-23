package Graphique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre2 examentends JFrame {
	
	JPanel pan;
	
	public Fenetre2()
	{
		this.setTitle("Carré controllé par le clavier");
		int x = Toolkit.getDefaultToolkit().getScreenSize().width;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(x/2, y/2);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pan = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				g.setColor(Color.red);
				g.fillRect(100, 100, 50, 50);
			}
		};
		
		pan.setBackground(Color.blue);
		this.setContentPane(pan);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Fenetre2 f = new Fenetre2(); 

	}

}
