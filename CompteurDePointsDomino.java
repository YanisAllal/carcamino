public class CompteurDePointsDomino extends CompteurDePoints<Integer>{

    public CompteurDePointsDomino(int nb_joueurs) {
        super(nb_joueurs);
    }
    @Override
    public void compter(Joueur<Integer> poseur, Position p, Tuile<Integer> t, Plateau<Integer> plateau){
        Position positions[] = p.getVoisins();
        if(plateau.existeTuile(positions[0])){
            for(int i=0; i<3; i++){
                add_points(poseur, t.haut[i]);
            }
        }if(plateau.existeTuile(positions[1])){
            for(int i=0; i<3; i++){
                add_points(poseur, t.bas[i]);
            }
        }if(plateau.existeTuile(positions[2])){
            for(int i=0; i<3; i++){
                add_points(poseur, t.droite[i]);
            }
        }if(plateau.existeTuile(positions[3])){
            for(int i=0; i<3; i++){
                add_points(poseur, t.gauche[i]);
            }
        }
    }
    
}
