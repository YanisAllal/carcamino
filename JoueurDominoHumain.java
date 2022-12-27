public class JoueurDominoHumain extends JoueurDomino {
	JoueurDominoHumain(PlateauDomino plateau, CompteurDePointsDomino compteur) {
		super(plateau, compteur);
	}

	public void play() {
		// TODO: Obtenir la tuile voulue de la pioche du plateau (à rajouter).
		Integer haut[] = {1, 2, 3};
		Integer bas[] = {1, 2, 3};
		Integer gauche[] = {1, 2, 3};
		Integer droite[] = {1, 2, 3};
		TuileDomino t = new TuileDomino(haut, bas, gauche, droite);
		while (true) {
			Position p = new Position(0, 0); // TODO: Obtenir la position voulue via PlateauVue.
			if (p == null) { // Le·a joueur·euse a décidé de défausser la tuile.
				break;
			}
			if (play(p, t)) {
				break;
			}
		}
	}
}

