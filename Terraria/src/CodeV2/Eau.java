package CodeV2;

public class Eau {
    private final Monde monde;
    private final int x;
    private final int y;
    private final boolean eau;


    public Eau(Monde m, int i, int j, boolean b) {
        this.monde = m;
        this.x = i;
        this.y = j;
        this.eau = b;
    }


    public Monde get_monde() {
        return this.monde;
    }

    public int get_x() {
        return this.x;
    }

    public int get_y() {
        return this.y;
    }

    public boolean get_eau() {
        return this.eau;
    }
}
