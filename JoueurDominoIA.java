public class JoueurDominoIA extends JoueurDomino {
	JoueurDominoIA(PlateauDomino plateau, CompteurDePointsDomino compteur) {
		super(plateau, compteur);
	}

	private Position[] best_positions(TuileDomino tuile) {
		final var position_quality = new java.util.HashMap<Position, Integer>();
		plateau.iterer_tuiles((p, t) -> {
			Position neighbors[] = p.getVoisins();
			final int haut = t.haut[0] + t.haut[1] + t.haut[2];
			if (position_quality.containsKey(neighbors[0])) {
				position_quality.put(neighbors[0], position_quality.get(neighbors[0]) + haut);
			} else {
				position_quality.put(neighbors[0], haut);
			}
			final int bas = t.bas[0] + t.bas[1] + t.bas[2];
			if (position_quality.containsKey(neighbors[1])) {
				position_quality.put(neighbors[1], position_quality.get(neighbors[1]) + bas);
			} else {
				position_quality.put(neighbors[1], bas);
			}
			final int gauche = t.gauche[0] + t.gauche[1] + t.gauche[2];
			if (position_quality.containsKey(neighbors[2])) {
				position_quality.put(neighbors[2], position_quality.get(neighbors[2]) + gauche);
			} else {
				position_quality.put(neighbors[2], gauche);
			}
			final int droite = t.droite[0] + t.droite[1] + t.droite[2];
			if (position_quality.containsKey(neighbors[3])) {
				position_quality.put(neighbors[3], position_quality.get(neighbors[3]) + droite);
			} else {
				position_quality.put(neighbors[3], droite);
			}
		});
		final var sorted = new java.util.TreeSet<java.util.Map.Entry<Position, Integer>>(
			java.util.Map.Entry.<Position, Integer>comparingByValue().reversed());
		sorted.addAll(position_quality.entrySet());
		final var sorted_arr = (java.util.HashMap.Entry<Position, Integer>[]) sorted.toArray();
		final var result = new Position[sorted_arr.length];
		for (int i = 0; i < sorted_arr.length; i++) {
			result[i] = sorted_arr[i].getKey();
		}
		return result;
	}

	public void play() {
		// TODO: Obtenir la tuile voulue de la pioche du plateau (à rajouter).
		Integer haut[] = {1, 2, 3};
		Integer bas[] = {1, 2, 3};
		Integer gauche[] = {1, 2, 3};
		Integer droite[] = {1, 2, 3};
		TuileDomino t = new TuileDomino(haut, bas, gauche, droite);
		Position positions[] = best_positions(t);
		for (Position p : positions) {
			if (play(p, t)) {
				break;
			}
		}
		// Si pas de position valide, la tuile est défaussée.
	}
}

