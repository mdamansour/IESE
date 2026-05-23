package tp9_layoutManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExFlowLayout extends JFrame
{
	JButton b1,b2,b3,b4;
	JPanel pane, mainPane;

	public ExFlowLayout() {
		this.setTitle("omisFlowLayout");
		int x=Toolkit.getDefaultToolkit().getScreenSize().width;
		int y=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(x/2,y/2);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.DARK_GRAY);
		//this.setMinimumSize(new Dimension(400,200));
		b1=new JButton("ROUGE");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pane.setBackground(Color.red);	
			}
		});
		b2=new JButton("VERT");
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pane.setBackground(Color.GREEN);	
			}
		});
		b3=new JButton("BLEU");
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pane.setBackground(Color.BLUE);	
			}
		});
		b4=new JButton("JAUNE");
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pane.setBackground(Color.yellow);	
			}
		});
		pane=new JPanel();
		pane.setPreferredSize(new Dimension(300,150));
		mainPane=new JPanel(new FlowLayout(1, 10, 50));//0 a gauche 1 au centre 2 a droite
		mainPane.add(b1);
		mainPane.add(b2);		
		mainPane.add(b3);
		mainPane.add(b4);
		mainPane.add(pane);
		mainPane.setBackground(Color.gray);
		this.setContentPane(mainPane);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExFlowLayout x=new ExFlowLayout();
	}

}
