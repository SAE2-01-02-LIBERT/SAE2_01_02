package CodeV1;

import java.time.Year;

public class Eau extends Secteur {
    private int x;
    private int y;
    private String type ;

    public Eau(int abs , int ord ) {
        this.type = "X";
        this.x =abs ;
        this.y = ord ;
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
}