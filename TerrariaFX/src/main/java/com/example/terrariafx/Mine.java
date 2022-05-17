package com.example.terrariafx;

public class Mine extends Batiment {
    private int numero;
    private String type;
    private int capacite;
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
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
    public void estRecoltee(int r){
        if(r > 0){
            if(stock > 0 && stock-r >= 0) {
                this.stock -= r;
            }
            else{
                System.out.println("Mine épuisée");
            }
        }
        else{
            System.out.println("Capaciter d'extraction du Robot null");
        }
    }

    @Override
    public String getTypeMateriau(){
        return typeMine;
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
