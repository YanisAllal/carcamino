public abstract class CompteurDePoints<T> {
    private int scores[];
	protected void add_points(Joueur<T> j, int points){
        scores[j.num] += points;
    }
	
	public abstract void compter(Joueur<T> poseur, Position p, Tuile<T> t, Plateau<T> plateau);
    public CompteurDePoints(int nb_joueurs){
        scores = new int[nb_joueurs];

        
    }
    public int get_points(Joueur<T> j){
        return scores[j.num];
    }


}
