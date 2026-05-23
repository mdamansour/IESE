package tp7_initiation_graphique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre1 extends JFrame
{
	int posX,posY;
	JPanel notrePanneau;
	public Fenetre1() {
		this.setTitle("omis");
		int x=Toolkit.getDefaultToolkit().getScreenSize().width;
		int y=Toolkit.getDefaultToolkit().getScreenSize().height;
		posX=x/4;
		posY=y/4;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(posX, posY , x/2, y/2);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				Random r=new Random();
				//e.getX()
				getContentPane().setBackground(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				getContentPane().setBackground(Color.gray);
			}
		});
        this.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		// TODO Auto-generated method stub
        		super.keyPressed(e);
        		if(e.getKeyCode()==KeyEvent.VK_RIGHT) posX +=10;
        		if(e.getKeyCode()==KeyEvent.VK_LEFT) posX -=10;
        		if(e.getKeyCode()==KeyEvent.VK_UP) posY -=10;
        		if(e.getKeyCode()==KeyEvent.VK_DOWN) posY +=10;
        		setBounds(posX, posY , x/2, y/2);
        	}
        	@Override
        	public void keyTyped(KeyEvent e) {
        		// TODO Auto-generated method stub
        		super.keyTyped(e);
        	}
		});
		this.getContentPane().setBackground(Color.YELLOW);
		notrePanneau=new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				g.setColor(Color.red);
				g.drawRect(0, 0, 100, 100);
				g.setColor(Color.gray);
				g.fillRect(10, 10, 50, 50);
				g.setColor(Color.black);
				g.drawOval(10, 10, 50, 50);
				g.setColor(Color.cyan);
				g.fillOval(0, 0, getWidth(), getHeight());
			}
		};
		this.setContentPane(notrePanneau);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fenetre1 f=new Fenetre1();

	}

}
