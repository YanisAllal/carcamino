public class JoueurCarcassonneHumain extends JoueurCarcassonne {
	JoueurCarcassonneHumain(PlateauCarcassonne plateau, CompteurDePointsCarcassonne compteur) {
		super(plateau, compteur);
	}

	public void play() {
		// TODO: Obtenir la tuile voulue de la pioche du plateau (à rajouter).
		TypeCaseCarcassonne haut[]   = {TypeCaseCarcassonne.HERBE, TypeCaseCarcassonne.CHEMIN, TypeCaseCarcassonne.HERBE};
		TypeCaseCarcassonne bas[]    = {TypeCaseCarcassonne.HERBE, TypeCaseCarcassonne.CHEMIN, TypeCaseCarcassonne.HERBE};
		TypeCaseCarcassonne gauche[] = {TypeCaseCarcassonne.HERBE, TypeCaseCarcassonne.CHEMIN, TypeCaseCarcassonne.HERBE};
		TypeCaseCarcassonne droite[] = {TypeCaseCarcassonne.HERBE, TypeCaseCarcassonne.CHEMIN, TypeCaseCarcassonne.HERBE};
		TuileCarcassonne t = new TuileCarcassonne(haut, bas, gauche, droite, TypeCaseCarcassonne.CARREFOUR, null);
		while (true) {
			Position p = new Position(0, 0); // TODO: Obtenir la position voulue via PlateauVue.
			if (p == null) { // Le·a joueur·euse a décidé de défausser la tuile.
				break;
			}
			// TODO: Obtenir l'information de si la·e joueur·euse veut placer un bonhomme via PlateauVue.
			boolean bonhomme = false;
			if (play(p, new TuileCarcassonne(t.haut, t.bas, t.gauche, t.droite, t.milieu, bonhomme ? this : null))) {
				break;
			}
		}
	}
}

