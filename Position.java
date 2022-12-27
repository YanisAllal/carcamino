public class Position {
    public int x;
	public int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }


	public boolean equals(Object autre){
        Position tmp = (Position)autre;
        return (this.x == tmp.x && this.y == tmp.y);

    }
	public int hashCode(){
        return x*1000+y;
    }

    public Position[] getVoisins(){
        Position[] positions = new Position[4];
        positions[0] = new Position(x,y-1);
        positions[1] = new Position(x,y+1);
        positions[2] = new Position(x-1,y);
        positions[3] = new Position(x+1,y);
        return positions;
    }


}
