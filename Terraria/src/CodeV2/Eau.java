package CodeV2;

public class Eau {
    private int x;
    private int y;
    private boolean eau;
    private Monde monde;

    public Eau(boolean eau, int x,int y, Monde m){
        this.eau=eau;
        this.x=x;
        this.y=y;
        this.monde=m;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Monde getMonde() {
        return monde;
    }

    public boolean getEau() {
        return eau;
    }
}
