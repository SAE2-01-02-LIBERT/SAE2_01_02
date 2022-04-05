package CodeV2;

public class Eau {
    private int x;
    private int y;
    private boolean eau;
    private Monde monde;

    public Eau(boolean eau, int x,int y, Monde){
        this.eau=eau;
        this.x=x;
        this.y=y;
        this.monde=Monde;
    }
}
