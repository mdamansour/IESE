package Graphique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre examentends JFrame
{
	JPanel notrePanneau;
	
	
	public Fenetre()
	{
		this.setTitle("Ma premiere fenetre Java");
		
		int x = Toolkit.getDefaultToolkit().getScreenSize().width;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height;
		//this.setBounds(x/4, y/4, x*2/3, y/2);
		this.setSize(x*2/3, y/2);
		this.setLocationRelativeTo(null); // centrer la fenetre
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//adapter par notion de classe anonyme le pannau centrale
		notrePanneau = new JPanel() {

			public void paint(Graphics g) {
				super.paint(g);
				g.setColor(Color.gray);
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 4; j++) {
						g.fillOval(100 * i, 100 * j, 100, 100);
					}
				}
			}
		};
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				Random rand = new Random();
				int r = rand.nexamentInt(0, 256);
				int g = rand.nexamentInt(0, 256);
				int b = rand.nexamentInt(0, 256);
				Color c = new Color(r, g, b);
				notrePanneau.setBackground(c);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
					super.mouseEntered(e);
					notrePanneau.setBackground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				notrePanneau.setBackground(Color.black);
			}
		});
		this.setContentPane(notrePanneau);
		notrePanneau.setBackground(Color.GRAY);
		
		this.setVisible(true);
	}
	public static void main(String[] args)
	{
		Fenetre f = new Fenetre();
		
	}

}
