package dessin;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.ArrayList;

public class Dessin extends JFrame implements ActionListener {
    ArrayList<Cercle> c;
    JLabel titre;
    int a;
    JTextField size = new JTextField();
    Button b1, b2, b3, b4,b5,b6;
    Color f;

    public Dessin() {
        JPanel pane, n, centre, s,est;
        this.setTitle("Dessin de cercles");
        int x = Toolkit.getDefaultToolkit().getScreenSize().width;
        int y = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(x/2,y/2);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        c = new ArrayList<Cercle>();
        centre = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                if(a==0) {
                for (Cercle cercle : c) {
                    g.setColor(cercle.couleur);
                    g.fillOval(cercle.x - cercle.diam / 2, cercle.y - cercle.diam / 2, cercle.diam, cercle.diam);
                }
            }
                if(a==1) {
                for (Cercle cercle : c) {
                    g.setColor(cercle.couleur);
                    g.fillRect(cercle.x - cercle.diam / 2, cercle.y - cercle.diam / 2, cercle.diam, cercle.diam);
                }
            }    
            }
        };
        pane = new JPanel(new BorderLayout());
        b1 = new Button("RED");
        b2 = new Button("YELLOW");
        b3 = new Button("BLUE");
        b4 = new Button("GREEN");
        b5=new Button("SQUART");
        b6= new Button("CERCLE");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        titre = new JLabel("CLIQUER !!!!");
        n = new JPanel();
        s = new JPanel();
        est=new JPanel();
        s.add(b1);
        s.add(b2);
        s.add(b3);
        s.add(b4);
        est.add(b5);
        est.add(b6);
        est.add(size);
        pane.add(n, BorderLayout.NORTH);
        pane.add(centre, BorderLayout.CENTER);
        pane.add(s, BorderLayout.SOUTH);
        pane.add(est,BorderLayout.EAST);
        n.add(titre);
        centre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String b = size.getText().trim();
                if (!b.isEmpty()) {
                    int nombre = Integer.parseInt(b);
                    c.add(new Cercle(e.getX(), e.getY(), nombre, f));
                    repaint();
                }
            }
        });
        this.setContentPane(pane);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Dessin f = new Dessin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) f = Color.red;
        if (e.getSource() == b2) f = Color.yellow;
        if (e.getSource() == b3) f = Color.blue;
        if (e.getSource() == b4) f = Color.green;
        if (e.getSource() == b5) {a=0;repaint();}
        if (e.getSource() == b6) {a=1;repaint();}
        
    }
}

class Cercle {
    int x;
    int y;
    int diam;
    Color couleur;

    public Cercle(int x, int y, int diam, Color couleur) {
        super();
        this.x = x;
        this.y = y;
        this.diam = diam;
        this.couleur = couleur;
    }
}
