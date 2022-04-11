package CodeV1;

public class Mine extends Batiment {
    private int numero;
    private String type;
    private int capacite;
    private int stock;
    private String typeMine;
    private int[] position;


    public Mine(String typ, int num){
        this.type = typ;
        this.stock=capacite;
        this.numero=num;
        this.typeMine = "Mine";
        this.capacite=(int)(50+Math.random() * (double)(50-0));
        this.position = new int[2];
    }

    public Mine(Mine mine, int[] pos) {
            this.type = mine.type;
            this.stock = mine.capacite;
            this.numero = mine.numero;
            this.typeMine = mine.typeMine;
            this.capacite = mine.capacite;
            this.position = pos;
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
