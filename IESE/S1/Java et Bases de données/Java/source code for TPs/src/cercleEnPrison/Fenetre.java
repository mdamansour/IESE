package cercleEnPrison;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fenetre examentends JFrame
{
	ArrayList<Cercle> tabCercles;
	Timer horloge;
	JPanel monPanel;
	
	
	
	public Fenetre()
	{
		tabCercles = new ArrayList<Cercle>();
		this.setTitle("Cercles qui bouges");
		int tx = Toolkit.getDefaultToolkit().getScreenSize().width;
		int ty = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(tx / 2, ty / 2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		monPanel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				for(Cercle c : tabCercles)
				{
					g.setColor(c.couleur);
					g.fillOval(c.x, c.y, c.diametre, c.diametre);
				}
			}
		};
		
		monPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				for(int i = 0; i< 5; i++) {
					int x = e.getX();
					int y  = e.getY();
					Random rand = new Random();
					int dia = rand.nexamentInt(20, 80);
					int r = rand.nexamentInt(0, 256);
					int g = rand.nexamentInt(0, 256);
					int b = rand.nexamentInt(0, 256);
					int dx = rand.nexamentInt(-20, 20);
					int dy = rand.nexamentInt(-20, 20);
					Cercle c = new Cercle(x - dia/2, y - dia/2, dia, new Color(r, g, b), dx, dy);
					tabCercles.add(c);
				}
				repaint();
			}
		});
		
		horloge = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Cercle c : tabCercles) {
					c.x += c.dx;
					c.y += c.dy;
					if(c.x <= 0 || c.x + c.diametre >= monPanel.getWidth()) c.dx *= -1; 
					if(c.y <= 0 || c.y + c.diametre >= monPanel.getHeight()) c.dy *= -1; 
				}
				repaint();
			}
		});
		
		horloge.start();
		this.setContentPane(monPanel);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Fenetre f = new Fenetre();
	}

}


class Cercle {
	int x;
	int y;
	int diametre;
	Color couleur;
	int dx;
	int dy;
	
	public Cercle(int x, int y, int diametre, Color couleur, int dx, int dy) {
		super();
		this.x = x;
		this.y = y;
		this.diametre = diametre;
		this.couleur = couleur;
		this.dx = dx;
		this.dy = dy;
	}
	
	
	
}