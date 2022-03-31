package CodeV1;

import java.util.*;


public class Entrepot {
    private int positionX;
    private int positionY;
    private int stock;
    private int numero;
    private String type;

    /**
     * Default constructor
     */
    public Entrepot(String t ,int n ) {
        /*super("Entrepot", "E", true); a quoi ca sert pour après?*/
        this.stock =0;
        this.type = t;
        this.positionX = 0;
        this.positionY = 0;
        this.numero = n;
    }

    public Entrepot(int PX,int PY){
        this.positionY=PY;
        this.positionX=PX;
    }
    private String info(){
        return "" +
                "R" + this.numero + "\n" +
                /** sa ligne et sa colonne**/
                "\t"+ this.type + this.stock ;
    }


}