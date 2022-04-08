package CodeV1;

import java.util.*;

public class Robot extends Batiment {
    private static String type;
    private int soute;
    private int capacitee;
    private int numero;
    private int[] position;

    public Robot(String type, int[] coord, int num) {
        this.type = type;
        this.numero = num;
        this.soute = 0;
        this.capacitee = 0;
        this.position[0]=coord[0];
        this.position[1]=coord[1];
    }
    public Robot(Robot r,int[]Npos){
        this.soute=r.soute;
        this.position=Npos;
        this.capacitee=r.capacitee;
        this.numero=r.numero;
        this.type=r.type;
    }

    public void recolter() {
        // TODO implement here
    }

    public void deposer() {
        // TODO implement here
    }

    /**
     *partie des deplacements
     * Attention on doit faire gaffe a ce que deux robot ne soit pas dans
     * le meme secteur
     * Et que le robot ne sorte pas de la map sa serait problemeatique.
     */

    public void nord() {
        // TODO implement here
    }

    public void sud() {
        // TODO implement here
    }

    public void est() {
        // TODO implement here
    }

    public void ouest() {
        // TODO implement here
    }


    @Override
    public String getInfo() {
        return "" + "R" + this.numero + "\n" +"\t"+ this.type + this.soute + "/" + this.soute;
    }

    @Override
    public int getStock() {
        return this.soute;
    }
}
