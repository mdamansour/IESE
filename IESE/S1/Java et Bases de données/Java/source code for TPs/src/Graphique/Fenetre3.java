package Graphique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre3 examentends JFrame{
	
	JPanel monPane;// ctrl + space!!
	int x = 0;
	int y = 0;
	
	public Fenetre3()
	{
		this.setTitle("Cercle qui bouge");
		int tx = Toolkit.getDefaultToolkit().getScreenSize().width;
		int ty = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(tx / 2, ty / 2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//heritage anonyme\
		monPane = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				g.setColor(Color.green);
				g.fillOval(x, y, 50, 50);
			}
		};
		
		//this.getContentPane().setBackground(Color.red);
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) x += 10;
				if (e.getKeyCode() == KeyEvent.VK_LEFT) x -= 10;
				if (e.getKeyCode() == KeyEvent.VK_DOWN) y += 10;
				if (e.getKeyCode() == KeyEvent.VK_UP) y -= 10;
				
				repaint();
			}
		});
		
		this.setContentPane(monPane);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		Fenetre3 maFenetre = new Fenetre3();
		
	}

}
