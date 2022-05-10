package CodeV1;

public class Mine extends Batiment {
    private int numero;
    private String type;
    private int capacite;
    private int stock;
    private String typeMine;
    private int[] position;


    public Mine(String typ, int num){
        this.type = "Mine";
        this.numero=num;
        this.typeMine =typ ;
        this.capacite=(int)(50+Math.random() * (double)(50-0));
        this.position = new int[2];
        this.stock=capacite;
    }

    public Mine(Mine mine, int[] pos) {
        this.type = mine.type;
        this.numero = mine.numero;
        this.typeMine = mine.typeMine;
        this.capacite = mine.capacite;
        this.position = pos;
        this.stock = mine.capacite;
    }

    public void estRecoltee(){
        if(stock > 0) {
            this.stock--;
        }
        else{
            System.out.println("Mine épuisée");
        }
    }

    @Override
    public String afficher(){
        return " M | "+ this.numero+" ";
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
        return "| " + "M" + this.numero + "   " +"[ "+ this.position[0] +", "+this.position[1]+" ]  " + this.typeMine +"  "+ this.stock + " / " + this.capacite+" |";
    }
}
