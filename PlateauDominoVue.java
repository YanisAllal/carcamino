import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.awt.*;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JPanel;

public class PlateauDominoVue extends PlateauVue<Integer> {

    JPanel tuilePiochee,h,b,g,d;
    JLabel h1,h2,h3,b1,b2,b3,g1,g2,g3,d1,d2,d3;
    PlateauDominoVue(PlateauDomino modele, LinkedList<Joueur<Integer>> joueurs) {
        super((Plateau<Integer>)(modele), (joueurs));
        GridBagConstraints cTuiles = new GridBagConstraints();

        
        
        for(Map.Entry mod :modele.tuiles.entrySet()){


            
            Position pos = (Position)mod.getKey();

            JPanel tuile =new JPanel();
            


            TuileDomino td = (TuileDomino)mod.getValue();
            JPanel haut = new JPanel(new GridLayout(1,3));
            JPanel bas = new JPanel(new GridLayout(1,3));
            JPanel gauche = new JPanel(new GridLayout(3,1));
            JPanel droite = new JPanel(new GridLayout(3,1));
            haut.add(new JLabel(" " ));
            for(int i = 0; i < 3; i++){
                haut.add(new JLabel(String.valueOf(td.haut[i])));
                haut.add(new JLabel(" " ));
            }
            bas.add(new JLabel(" " ));
            for(int i = 0; i < 3; i++){
                bas.add(new JLabel(String.valueOf(td.bas[i])));
                bas.add(new JLabel(" " ));
            }
            for(int i = 0; i < 3; i++){
                gauche.add(new JLabel(String.valueOf(td.gauche[i])));
            }
            for(int i = 0; i < 3; i++){
                droite.add(new JLabel(String.valueOf(td.droite[i])));
            }
            System.out.println(pos.x);
            System.out.println(pos.y);
            tuile.setLayout(new BorderLayout());
            tuile.add(haut,BorderLayout.NORTH);
            tuile.add(bas,BorderLayout.SOUTH);
            tuile.add(gauche,BorderLayout.WEST);
            tuile.add(droite,BorderLayout.EAST);
            cTuiles.fill = GridBagConstraints.VERTICAL;
            cTuiles.gridheight = 16;
            cTuiles.gridwidth = 16;

            cTuiles.gridx = pos.x+8;
            cTuiles.gridy = pos.y+8;
            this.tuiPanel.add(tuile,cTuiles);
            
        }
        TuileDomino pioche = modele.piocher();
        JPanel tuilePiochee =new JPanel(new BorderLayout());
        actuel = pioche;
        JPanel haut = new JPanel(new GridLayout(1,3));
        JPanel bas = new JPanel(new GridLayout(1,3));
        JPanel gauche = new JPanel(new GridLayout(3,1));
        JPanel droite = new JPanel(new GridLayout(3,1));
        haut.add(new JLabel(" " ));
        h = new JPanel(new GridLayout(1,3));
        b= new JPanel(new GridLayout(1,3));
        g= new JPanel(new GridLayout(3,1));
        d= new JPanel(new GridLayout(3,1));
        
        h1 = new JLabel(String.valueOf(actuel.haut[0]));h.add(new JLabel(" "));h.add(h1);h.add(new JLabel(" "));
        h2 = new JLabel(String.valueOf(actuel.haut[1]));h.add(h2);h.add(new JLabel(" "));
        h3 = new JLabel(String.valueOf(actuel.haut[2]));h.add(h3);h.add(new JLabel(" "));
        b1 = new JLabel(String.valueOf(actuel.bas[0]));b.add(new JLabel(" "));b.add(b1);b.add(new JLabel(" "));
        b2 = new JLabel(String.valueOf(actuel.bas[1]));b.add(b2);b.add(new JLabel(" "));
        b3 = new JLabel(String.valueOf(actuel.bas[2]));b.add(b3);b.add(new JLabel(" "));
        g1 = new JLabel(String.valueOf(actuel.gauche[0]));g.add(g1);
        g2 = new JLabel(String.valueOf(actuel.gauche[1]));g.add(g2);
        g3 = new JLabel(String.valueOf(actuel.gauche[2]));g.add(g3);
        d1 = new JLabel(String.valueOf(actuel.droite[0]));d.add(d1);
        d2 = new JLabel(String.valueOf(actuel.droite[1]));d.add(d2);
        d3 = new JLabel(String.valueOf(actuel.droite[2]));d.add(d3);

        tuilePiochee.add(h,BorderLayout.NORTH);
        tuilePiochee.add(b,BorderLayout.SOUTH);
        tuilePiochee.add(g,BorderLayout.WEST);
        tuilePiochee.add(d,BorderLayout.EAST);
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 3;
        menuPanel.add(tuilePiochee);

        defausserButton.addActionListener((event) ->{
            actuel = modele.piocher();
            update();
            repaint();

        });

        pivoterButton.addActionListener((event) ->{
            TuileDomino t = new TuileDomino(actuel.droite, actuel.gauche, actuel.haut, actuel.bas);
            actuel = t;
            update();
            repaint();
            
        });
    }


    public void update(){
        
        h1.setText(String.valueOf(actuel.haut[0]));
        h2.setText(String.valueOf(actuel.haut[1]));
        h3.setText(String.valueOf(actuel.haut[2]));
        b1.setText(String.valueOf(actuel.bas[0]));
        b2.setText(String.valueOf(actuel.bas[1]));
        b3.setText(String.valueOf(actuel.bas[2]));
        g1.setText(String.valueOf(actuel.gauche[0]));
        g2.setText(String.valueOf(actuel.gauche[1]));
        g3.setText(String.valueOf(actuel.gauche[2]));
        d1.setText(String.valueOf(actuel.droite[0]));
        d2.setText(String.valueOf(actuel.droite[1]));
        d3.setText(String.valueOf(actuel.droite[2]));
        repaint();
        
    }
    
}
