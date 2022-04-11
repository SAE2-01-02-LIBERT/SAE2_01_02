package CodeV1;

public class Mine extends Batiment {
    private final int numero;
    private final String type;
    private int capacite;
    private int stock;

    public Mine(String typ, int num, String type, int stk){
        this.type = typ;
        this.stock=stk;
        this.numero=num;
        this.capacite=(int)(50+Math.random() * (double)(50-0));
    }
    @Override
    public String afficher(){
        return " M | "+ this.numero+" ";
    }

    @Override
    public String getInfo() {
        return "M " + this.numero +"\n\t" +this.stock +"/" +this.capacite;
    }

    @Override
    public int getStock() {
        return this.stock;
    }

    @Override
    public String getType(){
        return this.type;
    }

}
