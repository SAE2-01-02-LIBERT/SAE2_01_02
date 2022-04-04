package CodeV1;

import java.util.*;

public class Robot extends Local{

    private static String type;
    private int soute;
    private static int capacite;
    private int[] coord;
    private int numero;

    public Robot(int abs,int ord, String type, int num){
        super(abs,ord);
        this.type = type;
        this.numero = num;
        this.capacite =0;
        this.coord=new int[1];
        this.coord[0]=abs;
        this.coord[1]=ord;
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