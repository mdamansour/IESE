package Graphique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fenetre4 examentends JFrame{
	
	JPanel monPane;// ctrl + space!!
	int x = 0;
	int y = 0;
	Timer horloge;
	String direction = "R"; // R - L - D - U
	
	public Fenetre4()
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
				g.fillOval(x, y, 100, 100);
			}
		};
		
		//this.getContentPane().setBackground(Color.red);
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) direction = "R";
				if (e.getKeyCode() == KeyEvent.VK_LEFT) direction = "L";
				if (e.getKeyCode() == KeyEvent.VK_DOWN) direction = "D";
				if (e.getKeyCode() == KeyEvent.VK_UP) direction = "U";
				
				//repaint();
			}
		});
		
		horloge = new Timer(1, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(direction == "R") x+= 1;
				if(direction == "L") x-= 1;
				if(direction == "D") y+= 1;
				if(direction == "U") y-= 1;
				
				if((x + 100) > tx/2) direction = "L";
				if(x < 0) direction = "R";
				if((y + 100) > ty/2) direction = "U";
				if(y < 0) direction = "D";
				
				repaint();
			}
		});
		
		horloge.start();
		
		this.setContentPane(monPane);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		Fenetre4 maFenetre = new Fenetre4();
		
	}

}
