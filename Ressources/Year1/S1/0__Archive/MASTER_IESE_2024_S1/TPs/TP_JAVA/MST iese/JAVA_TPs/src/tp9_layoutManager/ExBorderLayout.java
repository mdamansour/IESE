package tp9_layoutManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExBorderLayout extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5,b6;
	JPanel paneN,paneC,paneS, mainPane;
	boolean s;
	Color shapeColor=Color.black;
	public ExBorderLayout() {
		this.setTitle("jeux");
		int x=Toolkit.getDefaultToolkit().getScreenSize().width;
		int y=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(x/2,y/2);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setMinimumSize(new Dimension(500,300));
		b1=new JButton("SQUARE");
		b1.addActionListener(this);
		b2=new JButton("CERCLE");
		b2.addActionListener(this);
		b3=new JButton("RED");
		b3.addActionListener(this);
		b4=new JButton("GREEN");
		b4.addActionListener(this);
		b5=new JButton("BLUE");
		b5.addActionListener(this);
		b6=new JButton("YELLOW");
		b6.addActionListener(this);
		paneN=new JPanel();
		paneC=new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				g.setColor(shapeColor);
				if(s== true) g.fillOval(paneC.getWidth()/2-100, paneC.getHeight()/2-100, 200, 200);
				if(s== false) g.fillRect(paneC.getWidth()/2-100, paneC.getHeight()/2-100, 200, 200);
			}
		};
		paneS=new JPanel();
		mainPane=new JPanel(new BorderLayout());
		mainPane.add(paneN,BorderLayout.NORTH);
		mainPane.add(paneC,BorderLayout.CENTER);
		mainPane.add(paneS,BorderLayout.SOUTH);
		paneN.add(b1);
		paneN.add(b2);	
		paneN.setBackground(Color.orange);
		paneS.add(b3);
		paneS.add(b4);
		paneS.add(b5);
		paneS.add(b6);
		paneS.setBackground(Color.orange);
		paneC.setBackground(Color.gray);
		mainPane.setBackground(Color.gray);
		this.setContentPane(mainPane);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		ExBorderLayout f=new ExBorderLayout();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b2) s=true;
		if(e.getSource()==b1) s=false;
		if(e.getSource()==b3) shapeColor=Color.red;
		if(e.getSource()==b4) shapeColor=Color.green;
		if(e.getSource()==b5) shapeColor=Color.blue;
		if(e.getSource()==b6) shapeColor=Color.yellow;
		repaint();
	}

}
