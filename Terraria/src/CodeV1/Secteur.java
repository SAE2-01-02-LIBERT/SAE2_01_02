package CodeV1;

public abstract class Secteur {
    protected int x;
    protected int y;

    public Secteur(int abs, int ord) {
        this.x=abs;
        this.y=ord;
    }

    public abstract int getX();
    public abstract int getY();

    public abstract String toString();

}
