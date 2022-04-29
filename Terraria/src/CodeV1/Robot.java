package CodeV1;

import java.util.Random;

public class Robot extends Batiment {
    private String type;
    private String typeMine; // Or ou nickel
    private int soute;
    private int capacitee;
    private int capaciteeExtraction;
    private int numero;
    private int[] position;

    public Robot(String typeMine, int num) {
        Random random = new Random();
        this.type = "Robot";
        this.typeMine = typeMine;
        this.numero = num;
        this.soute = 0;
        this.capacitee = 5 + random.nextInt(11);
        this.capaciteeExtraction = 1 + random.nextInt(4);
        this.position = new int[2];
        this.position[0] = 0; // par defaut
        this.position[1] = 0; // par defaut
    }

    public Robot(Robot r, int[] Npos) {
        Random random = new Random();
        this.soute = r.soute;
        this.position = Npos;
        this.capacitee = r.capacitee;
        this.capaciteeExtraction = r.capaciteeExtraction;
        this.numero = r.numero;
        this.type = r.type;
    }

    public void recolter() {
        if (capacitee >= soute){
            System.out.println("Impossible");
        }
        else{
            int extrait = capaciteeExtraction;
            if(soute+capaciteeExtraction > capacitee) {
                extrait = capacitee-soute;
            }
            soute += extrait;
        }
    }

    public void deposer() {
        soute = 0;
    }

    /**
     * partie des deplacements
     * Attention on doit faire gaffe a ce que deux robot ne soient pas dans
     * le meme secteur
     * Et que le robot ne sorte pas de la map, ça serait problematique.
     * <p>
     * Utilisation du constructeur par recopie en repassant de monde a secteur... c'est pour ca que Monde a une
     * liste de Robot, Mine et Entrepot.
     * <p>
     * Bon courage  =) !
     */

    public Robot nord(Robot d) {//nouvelle coordonnee
        int[] Nwpos = new int[2];
        Nwpos[0] = position[0]-1;
        Nwpos[1] = position[1];
        System.out.println("Deplacement vers le nord");
        return new Robot(d,Nwpos);
    }
    public Robot sud(Robot d) {
        int[] Nwpos = new int[2];
        Nwpos[0] = position[0]+1;
        Nwpos[1] = position[1];
        return new Robot(d,Nwpos);
    }
    public Robot est(Robot d) {
        int[] Nwpos = new int[2];
        Nwpos[0] = position[0];
        Nwpos[1] =position[1]+1;
        return  new Robot(d,Nwpos);
    }
    public Robot ouest(Robot d) {
        int[] Nwpos = new int[2];
        Nwpos[0] = position[0];
        Nwpos[1] =position[1]-1;
        return new Robot(d,Nwpos);
    }

    public int[] getPosition() {
        return position;
    }
    public int getnum(){
        return this.numero;
    }

    @Override
    public String afficher() {
        return " R | " + this.numero + " ";
    }

    @Override
    public int getStock() {
        return this.soute;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getInfo() {
        return "| " + "R" + this.numero + "   " +"[ "+ this.position[0] +", "+this.position[1]+" ]  " + this.typeMine +"  "+ this.soute + " / " + this.capacitee+"\t |";
    }
}


