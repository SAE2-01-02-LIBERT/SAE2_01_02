package CodeV1;

import java.util.*;


public class Entrepot extends Local{
    private int[] coordE;
    private int stock;
    private int numero;
    private String type;
    /**
     * Default constructor
     */
    public Entrepot(int abs ,int ord,String t ,int n ) {
        super(abs,ord);
        /*super("Entrepot", "E", true); a quoi ca sert pour après?*/
        this.stock =0;
        this.type = t;
        this.coordE=new int[1];
        this.coordE[0] = abs;
        this.coordE[1] = ord;
        this.numero = n;
    }

    public Entrepot(int abs, int ord) {
        super(abs, ord);
    }

    @Override
    public String getinfo(){
        return "" +
                "R" + this.numero + "\n" +
                /** sa ligne et sa colonne**/
                "\t"+ this.type + this.stock ;
    }


}