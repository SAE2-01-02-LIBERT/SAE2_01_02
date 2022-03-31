package CodeV1;

import java.util.*;

/**
 *
 */
public class Monde {
    private Secteur[][] secteurs;



    /** on verra plus tard le plus important c'est de generer le monde
     * apres on verra.....

    private final int taille = 10;
    private Robot[] robots;
    private int r;
    private int mineraiNickel = 0;
    private int mineraiOr = 0;
    private int mineraiMap = 0;
    private int mineraiNickel = 0;
    private int mineraiOr = 0;
     */

    public Monde() {
        this.secteurs=new Secteur[9][9];

    }

    public void Generation_Map(){
        int eau = 0;
        for (int i =0 ; i < 9 ;i++){
            for (int j= 0 ; j < 9 ; j++){
                int valeur = (int)Math.random();
                if (valeur==1 || eau == 10){
                    this.secteurs[i][j]=new Terre(i,j);
                }
                else{
                    this.secteurs[i][j]=new Eau(i,j);
                    eau += 1;
                }
            }
        }

    }

    public void AfficherMonde(){
       /*Ca vas commencer a étre dure enfaite*/
    }

}