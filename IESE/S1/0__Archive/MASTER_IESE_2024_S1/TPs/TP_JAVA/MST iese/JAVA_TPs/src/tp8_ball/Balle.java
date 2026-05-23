package tp8_ball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Balle extends JFrame{
	JPanel notrePane;
	Cercle c;
	Timer horloge;
	public Balle() {
		this.setTitle("balle qui se balade!");
		this.setSize(800,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		notrePane=new JPanel() {
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
				if(c!=null) {
				g.setColor(c.couleur);
				g.fillOval(c.x, c.y, c.diam, c.diam);}
			}
		};
		notrePane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				
				Random r =new Random();
				int diam =10+r.nextInt(50);
				int dx = r.nextInt(10)+3;
				int dy = r.nextInt(10)+3;
				Color col =new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
				c= new Cercle(e.getX()-diam/2,e.getY()-diam/2,diam,dx,dy,col);
				repaint();
			}
		});
		horloge=new Timer(30,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(c!=null) {
				if((c.x+c.dx+c.diam)>notrePane.getWidth()||(c.x+c.dx)<=0)c.dx=-c.dx;
					c.x+=c.dx;
				if((c.y+c.dy+c.diam)>notrePane.getHeight()||(c.y+c.dy)<=0)c.dy=-c.dy;
				c.y+=c.dy;
				repaint();
				}
			}
		});
		horloge.start();
		this.setContentPane(notrePane);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Balle x=new Balle();

	}

}
class Cercle {
	int x;
	int y;
	int diam;
	int dx;
	int dy;
	Color couleur;
	public Cercle(int x, int y, int diam, int dx, int dy, Color couleur) {
		super();
		this.x = x;
		this.y = y;
		this.diam = diam;
		this.dx = dx;
		this.dy = dy;
		this.couleur = couleur;
	}
	
}