import java.util.LinkedList;
import java.util.Random;

public class PlateauDomino extends Plateau<Integer> {
    
    public PlateauDomino(){
        super();
        pioche = new LinkedList<String>();
        for(int i = 0; i<100; i++){
            Random r = new Random();
            String s ="";
            for(int j = 0; j<12; j++){
                s+=String.valueOf(r.nextInt(5));
            }
            if(pioche.contains(s)|| pioche.contains(s.substring(3,12)+s.substring(0,3))|| pioche.contains(s.substring(6,12)+s.substring(0,6)) || pioche.contains(s.substring(9,12)+s.substring(0,9))){
                i--;
            }else{
                pioche.add(s);
            }
            
        }
    }


    @Override
    public boolean poser(Position position, Tuile<Integer> tuile){
        return super.poser(position, tuile);


    }
    public TuileDomino piocher(){
        Random r = new Random();
        int x = r.nextInt(pioche.size()+1);
        String code  = pioche.get(x);
        pioche.remove(x);
        Integer[] haut = new Integer[3];
        Integer[] bas = new Integer[3];
        Integer[] gauche = new Integer[3];
        Integer[] droite = new Integer[3];
        for(int i = 0; i<3; i++){
            haut[i] = Integer.valueOf(code.charAt(i)+"");
        }
        for(int i = 0; i<3; i++){
            bas[i] = Integer.valueOf(code.charAt(i+3)+"");
        }
        for(int i = 0; i<3; i++){
            gauche[i] = Integer.valueOf(code.charAt(i+6)+"");
        }
        for(int i = 0; i<3; i++){
            droite[i] = Integer.valueOf(code.charAt(i+9)+"");
        }
        TuileDomino t = new TuileDomino(haut, bas, gauche, droite);
        return t;
    }

}
    

