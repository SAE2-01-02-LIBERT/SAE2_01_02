package CodeS2_02;

public class Entrepot extends Batiment {
    private int stock;
    private String type;
    private int numero;
    private String typeEntrepot;
    private int[] position;

    public Entrepot(String typeEntr, int n) {
        this.stock = 0;
        this.type = "Entrepot";
        this.numero = n;
        this.typeEntrepot = typeEntr;
        this.position = new int[2];
    }
    public Entrepot(Entrepot e1, int[] pos) {
        this.position = pos;
        this.stock=e1.stock;
        this.numero=e1.numero;
        this.type=e1.type;
        this.typeEntrepot=e1.typeEntrepot;
    }

    public void depot(Robot r){
        this.stock += r.getStock();
        r.deposer();
    }

    public int getstock() {
        return this.stock;
    }

    @Override
    public String getTypeMateriau(){
        return typeEntrepot;
    }
    @Override
    public String afficher(){
        return " E | "+ this.numero+" ";
    }

    @Override
    public int getStock() {
        return this.stock;
    }

    @Override
    public String getType(){
        return this.type;
    }

    @Override
    public String getInfo() {
        return "| "+ "E" + this.numero + "  " + " [ "+this.position[0]+", "+this.position[1]+" ]  "+this.typeEntrepot +"  "+ this.stock +"\t     |" ;
    }
}



