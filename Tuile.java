public abstract class Tuile<T> {
	public final T[] haut;
	public final T[] bas;
	public final T[] gauche;
	public final T[] droite;

	public Tuile(T[] haut, T[] bas, T[] gauche, T[] droite) {
		this.haut = haut;
		this.bas = bas;
		this.gauche = gauche;
		this.droite = droite;
	}

	public String toString(){
		String s ="";
		s+= " "+haut[0]+" "+haut[1]+" "+haut[2]+'\n';
		s+= gauche[0]+"      "+droite[0]+'\n';
		s+= gauche[1]+"      "+droite[1]+'\n';
		s+= gauche[2]+"      "+droite[2]+'\n';
		s+=  " "+bas[0]+" "+bas[1]+" "+bas[2]+'\n';
		return s;

	}
}


