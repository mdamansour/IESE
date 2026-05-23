package moyenne;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calcule extends JFrame {
    JPanel mPane, n, c, s;
    JLabel m, p, sv, mo, res, titre;
    JTextField m1, p1, sv1;
    JButton cal;
    int a, v, f, k = 0;

    public Calcule() {
        this.setTitle("Calcule de moyenne");
        int x = Toolkit.getDefaultToolkit().getScreenSize().width;
        int y = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(x / 2, y / 2);
        this.setLocationRelativeTo(null);
        m = new JLabel("MATHS");
        p = new JLabel("PHYSIQUE");
        sv = new JLabel("SVT");
        mo = new JLabel("moyenne");
        titre = new JLabel("entrer vos notes");
        m1 = new JTextField();
        p1 = new JTextField();
        sv1 = new JTextField();
        cal = new JButton("Calculer");

        res = new JLabel(); // Initialisation de res sans texte pour le moment

        cal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b = m1.getText().trim();
                if (!b.isEmpty()) {
                    a = Integer.parseInt(b);
                }
                b = p1.getText().trim();
                if (!b.isEmpty()) {
                    v = Integer.parseInt(b);
                }
                b = sv1.getText().trim();
                if (!b.isEmpty()) {
                    f = Integer.parseInt(b);
                }
                k = (a + v + f) / 3;
                res.setText(String.valueOf(k)); // Mettre à jour le texte de res avec la moyenne calculée
            }
        });

        mPane = new JPanel(new BorderLayout());
        n = new JPanel();
        c = new JPanel(new GridLayout(4, 2));
        s = new JPanel();
        n.add(titre);
        c.add(m);
        c.add(m1);
        c.add(p);
        c.add(p1);
        c.add(sv);
        c.add(sv1);
        c.add(mo);
        c.add(res); // Ajout de res au panel avant que le bouton ne soit cliqué
        s.add(cal);
        mPane.add(c, BorderLayout.CENTER);
        mPane.add(n, BorderLayout.NORTH);
        mPane.add(s, BorderLayout.SOUTH);
        setContentPane(mPane);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Calcule f = new Calcule();
    }
}

