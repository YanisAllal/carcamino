import java.util.LinkedList;

public class Main {
    private PlateauDominoVue view;
    private PlateauDomino modele;
    private LinkedList<Joueur<Integer>> joueurs;
    public Main(){
        modele = new PlateauDomino();
        joueurs = new LinkedList<Joueur<Integer>>();
        CompteurDePointsDomino compteur = new CompteurDePointsDomino(2);
        JoueurDomino joueur1 = new JoueurDominoHumain(modele, compteur);
        JoueurDomino joueur2 = new JoueurDominoHumain(modele, compteur);
        JoueurDomino joueur3 = new JoueurDominoHumain(modele, compteur);
        JoueurDomino joueur4 = new JoueurDominoHumain(modele, compteur);
        joueurs.add(joueur1);
        joueurs.add(joueur2);
        joueurs.add(joueur3);
        joueurs.add(joueur4);
        Integer[] haut = {1,2,3};
        Integer[] bas = {1,2,3};
        Integer[] gauche = {1,2,3};
        Integer[] droite = {1,2,3};
        TuileDomino t = new TuileDomino(haut, bas, gauche, droite);
        Integer[] haut2 = {1,2,3};
        Integer[] bas2 = {0,0,0};
        Integer[] gauche2 = {1,2,3};
        Integer[] droite2 = {0,0,0};
        TuileDomino t2 = new TuileDomino(haut2, bas2, gauche2, droite2);
        modele.poser(new Position(0, 0), t);
        System.out.println(modele.poser(new Position(1, 1), t2));

        view = new PlateauDominoVue(modele, joueurs);
        view.setVisible(true);
    }
    public static void main(String [] args){
        new Main();
        
    }
}
