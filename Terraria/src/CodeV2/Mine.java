package CodeV2;

public class Mine implements Comparable<Mine>{
    private final Monde monde;
    private final int x;
    private final int y;
    private final boolean nickel;
    private int quantite;
    private final int max;
    private final int numero;

    public Mine(Monde m, int i, int j, boolean b, int q, int n) {
        monde = m;
        this.x = i;
        this.y = j;
        this.nickel = b;
        this.quantite = q;
        this.max = q;
        this.numero = n;
    }

    public Monde get_monde() {
        return monde;
    }

    public int get_x() {
        return x;
    }

    public int get_y() {
        return y;
    }

    public boolean get_nickel() {
        return nickel;
    }

    public int get_quantite() {
        return quantite;
    }

    public int get_max() {
        return max;
    }

    public int get_numero() {
        return numero;
    }

    public void miner(int i) {
        if(quantite - i >=0) {
            quantite -= i;
        }else {
            quantite=0;
        }
    }

    @Override
    public int compareTo(Mine m) {
        return (numero - m.numero);
    }
}
