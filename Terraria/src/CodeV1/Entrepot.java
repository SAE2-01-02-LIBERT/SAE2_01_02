package CodeV1;

public class Entrepot extends Batiment {
    private int stock;
    private String type;
    private int numero;

    public Entrepot(String t, int n) {
        this.stock = 0;
        this.type = t;
        this.numero = n;
    }
    public int getstock() {
        return this.stock;
    }

    @Override
    public String getInfo() {
        return "E " + this.numero + "\n\t" + this.type + this.stock + "/" ;
    }
    @Override
    public int getStock() {
        return this.stock;
    }
}
