import java.util.Random;
import java.util.function.BiConsumer;

public abstract class Plateau<T>{
    protected final java.util.Map<Position, Tuile<T>> tuiles;
    protected java.util.LinkedList<String> pioche;
    public Plateau(){
        tuiles = new java.util.HashMap<Position, Tuile<T>>();
    }
    public boolean existeTuile(Position p){
        return this.get_tuile(p) != null;
    }

    private boolean adjacente(T t1[], T t2[]){
        for(int i=0; i<t1.length; i++){
            if(!(t1[i].equals(t2[i]))){
                return false;
            }
        }
        return true;
    }
    




    public boolean poser(Position position,Tuile<T> tuile){
        if (tuiles.containsKey(position)){
            return false;
        }
        Position positions[] = position.getVoisins();
        T[] haut = tuile.haut;
        T[] bas = tuile.bas;
        T[] gauche = tuile.gauche;
        T[] droite = tuile.droite;
        Tuile<T> h = tuiles.get(positions[0]);
        Tuile<T> b = tuiles.get(positions[1]);
        Tuile<T> g = tuiles.get(positions[2]);
        Tuile<T> d = tuiles.get(positions[3]);
        if(h != null){
            if (!adjacente(h.bas, haut)){
                System.out.println("C'est le haut ");
                
                System.out.println(h.toString());
                return false;
            }
        }
        if(b!= null){
            if (!adjacente(b.haut, bas)){
                System.out.println("C'est le bas ");
                return false;
            }
        }if(g!= null){
            if (!adjacente(g.droite, gauche)){
                System.out.println("C'est la doite ");
                return false;
            }
        }if(d!= null){
            if (!adjacente(d.gauche, droite)){
                System.out.println("C'est la gauche ");
                return false;
            }
        }
        tuiles.put(position, tuile);
        return true;
    }
    public Tuile<T> get_tuile(Position p){
        return tuiles.get(p);
    }
    public void iterer_tuiles(BiConsumer<Position, Tuile<T>> f){
        
    }

    


}