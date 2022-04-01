package CodeV1;

import java.util.*;

/**
 *
 */
public class Robot extends Local{
    private final String type;
    private int soute;
    private final int capacite;
    private int minerai;
    private int[] coord;
    private int numero;

    public Robot(String type, int[] coord, int numero){
        this.type = type;
        this.numero = numero;
        this.minerai = 0;
        this.capacite =0;
        this.coord=new int[1];
    }

    @Override
    public String getinfo(){
        return "" +
                "R" + this.numero + "\n" +
            /** sa ligne et sa colonne**/
            "\t"+ this.type + this.soute + "/" + this.capacite;
    }

    public void recolter() {
        while(this.soute<=this.capacite){
            this.soute+=1;
            /** ici il faudra decrepenter le stock de la mine qui est miner
             * */
        }
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

    public void deposer() {
        // TODO implement here
    }

}