
public abstract class Joueur<T> {
	protected final Plateau<T> plateau;
	private final CompteurDePoints<T> compteur;
	public final int num;
	private static int num_players;

	Joueur(Plateau<T> plateau, CompteurDePoints<T> compteur) {
		this.plateau = plateau;
		this.compteur = compteur;
		this.num = num_players;
		num_players++;
	}
	protected boolean play(Position p, Tuile<T> t) {
		if (plateau.poser(p, t)) {
			compteur.compter(this, p, t, plateau);
			return true;
		}
		return false;
	}
	abstract public void play();
	public static int getNumJoueur() {
		return num_players;
	}
	public int get_points(){
		return this.compteur.get_points(this);
	}
}
