package CodeV1;

public class Terre extends Secteur{

    private int x;
    private int y;

    private Local[][] locals;

    public Terre(int abs , int ord ) {
        this.x = abs ;
        this.y = ord ;
        this.locals = new Local[1][1];
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    @Override
    public String toString() {
        return "T";
    }
}