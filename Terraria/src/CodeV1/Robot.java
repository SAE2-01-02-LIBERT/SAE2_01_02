package CodeV1;

import java.util.*;

/**
 *
 */
public class Robot {
    private final String type;
    private int minerai;
    private final int capacite;
    private int[] coord;
    private int numero;

    public Robot(String type, int[] coord, int numero){
        this.numero = numero;
        this.minerai = 0;
        this.capacite =0;
    }
    private String info();
        return "" +
                "R" + this.numero + "\n" +
            /** sa ligne et sa colonne**/
            "\t"+ this.type + this.soute + "/" + this.capacite;

    private int soute;
        return this

    private int capacitee;
        return this.capacite;

    public void recolter() {
        while(this.soute<=this.capacite){
            this.soute+=1;
        }
    }

    /**
     *
     */
    public void nord() {
        // TODO implement here
    }

    /**
     *
     */
    public void sud() {
        // TODO implement here
    }

    /**
     *
     */
    public void est() {
        // TODO implement here
    }

    /**
     *
     */
    public void ouest() {
        // TODO implement here
    }

    /**
     *
     */
    public void deposer() {
        // TODO implement here
    }

}