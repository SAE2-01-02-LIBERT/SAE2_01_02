package CodeV1;

public class Eau extends Secteur {
    private int x;
    private int y;
    private String type ;
    private String[][] pos ;

    public Eau(int abs , int ord ) {
        this.type = "X";
        this.x =abs ;
        this.y = ord ;
        this.pos = new String[1][1] ;
    }



    public String getType() {
        return this.type ;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "X";
    }
}