package CodeV1;

public class Mine extends Batiment {
    private int numero;
    private String type;
    private int capacite;
    private int stock;
    private String typeMine;
    private int[] position;

    private Mine(Mine m, int[] pos) {
        this.type = m.type;
        this.stock = capacite;
        this.numero = m.numero;
        this.typeMine = m.typeMine;
        this.capacite = m.capacite;
        this.position = pos;
    }
    public Mine(String typ, int num){
        this.type = typ;
        this.stock=capacite;
        this.numero=num;
        this.typeMine = "Mine";
        this.capacite=(int)(50+Math.random() * (double)(50-0));
        this.position = new int[2];
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
