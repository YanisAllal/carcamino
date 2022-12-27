import java.awt.*;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public abstract class PlateauVue<T> extends JFrame {
    public Plateau<T> modele;
    public LinkedList<Joueur<T>> joueurs;
    public JButton pivoterButton, defausserButton, abandonenrButton, sauvegardeEtQuitter;
    public LinkedList<JPanel> tuiles;
    public JPanel tuiPanel, joueurPanel, menuPanel,scorePanel;
    public Tuile<T> actuel;

    PlateauVue(Plateau<T> modele, LinkedList<Joueur<T>> joueurs){

        this.modele = modele;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
        this.setLayout(new BorderLayout());
        this.tuiPanel = new JPanel();
        this.tuiPanel.setLayout(new GridBagLayout());
        this.add(tuiPanel, BorderLayout.CENTER);
        this.tuiles = new LinkedList<JPanel>();
        this.joueurs = joueurs;
        this.pivoterButton = new JButton("Pivoter");
        this.defausserButton = new JButton("Defausser");
        this.abandonenrButton = new JButton("Abandonner");
        this.sauvegardeEtQuitter = new JButton("Sauvegarder et quitter");

        this.joueurPanel = new JPanel();
        this.joueurPanel.setLayout(new GridLayout(1,5));
        scorePanel = new JPanel(new GridLayout(joueurs.size(),1));
        int x = 1;
        for(Joueur<T> j : this.joueurs){
            System.out.println("Joueur "+x);
            
            this.joueurPanel.add(new JLabel("Joueur "+x++));
            
        }
        this.add(joueurPanel, BorderLayout.NORTH);
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        this.add(menuPanel, BorderLayout.SOUTH);


        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        menuPanel.add(pivoterButton, c);
        c.gridx = 1;
        c.gridy = 0;
        menuPanel.add(defausserButton, c);
        c.gridx = 2;
        c.gridy = 0;
        menuPanel.add(abandonenrButton, c);
        c.gridx = 3;
        c.gridy = 0;
        menuPanel.add(sauvegardeEtQuitter, c);
        this.setVisible(true);
    }
}

