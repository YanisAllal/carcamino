public class TuileCarcassonne extends Tuile<TypeCaseCarcassonne> {
	public final JoueurCarcassonne poseur_de_pion;
	public final TypeCaseCarcassonne milieu;

	public TuileCarcassonne(TypeCaseCarcassonne[] haut,   TypeCaseCarcassonne[] bas,
	                        TypeCaseCarcassonne[] gauche, TypeCaseCarcassonne[] droite,
	                        TypeCaseCarcassonne milieu,   JoueurCarcassonne poseur_de_pion) {
		super(haut, bas, gauche, droite);
		this.milieu = milieu;
		this.poseur_de_pion = poseur_de_pion;
	}
}
