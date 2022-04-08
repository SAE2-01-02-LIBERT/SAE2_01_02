package CodeV1;

public class Terre extends Secteur{

    protected Local[][] locals;

    public Terre(int abs , int ord ) {
        super(abs,ord);
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
public void ajouter(Robot r){}

    @Override
    public String toString() {
        return this.locals.toString();
    }


}