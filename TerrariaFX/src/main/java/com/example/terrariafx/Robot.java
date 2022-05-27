package com.example.terrariafx;

import java.util.Random;

public class Robot implements Localisable{
    private String type;
    private String typeMine; // Or ou nickel
    private int soute;
    private int capacitee;
    private int capaciteeExtraction;
    private int numero;
    private int[] position;

    public Robot() {
        this.type = "Robot";
        this.typeMine = "OR";
        this.soute = 0;
        this.capacitee = 0;
        this.capaciteeExtraction = 0;
        this.numero = 1;
        this.position = new int[2];
        this.position[0] = 0; // par defaut
        this.position[1] = 0; // par defaut
    }

    public Robot(String typeMine, int num) {
        Random random = new Random();
        this.type = "Robot";
        this.typeMine = typeMine;
        this.numero = num;
        this.soute = 0;
        this.capacitee = 5 + random.nextInt(5);
        this.capaciteeExtraction = 1 + random.nextInt(3);
        this.position = new int[2];
        this.position[0] = 0; // par defaut
        this.position[1] = 0; // par defaut
    }

    public Robot(Robot r, int[] Npos) {
        this.soute = r.soute;
        this.position = Npos;
        this.capacitee = r.capacitee;
        this.capaciteeExtraction = r.capaciteeExtraction;
        this.numero = r.numero;
        this.type = r.type;
        this.typeMine = r.typeMine;
    }

    public void recolter(Mine m) {
        int extrait = capaciteeExtraction;
        if (m.getTypeMateriau().equals(this.getTypeMateriau())) {
            if (capacitee == soute) {
                System.out.println("Impossible, votre robot est plein");
            } else {
                if (soute + capaciteeExtraction > capacitee) {
                    extrait = capacitee - soute;
                }
                soute += extrait;
                m.estRecoltee(extrait);
            }
        }
        else{
            System.out.println("Impossible, votre robot ne peut recolter ce minerai");
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
        System.out.println(d.getnum()+" Deplacement vers le nord");
        return new Robot(d,Nwpos);
    }
    public Robot sud(Robot d) {
        int[] Nwpos = new int[2];
        Nwpos[0] = position[0]+1;
        Nwpos[1] = position[1];
        System.out.println(d.getnum()+" Deplacement vers le SUD");
        return new Robot(d,Nwpos);
    }
    public Robot est(Robot d) {
        int[] Nwpos = new int[2];
        Nwpos[0] = position[0];
        Nwpos[1] =position[1]+1;
        System.out.println(d.getnum()+" Deplacement vers l'est");
        return  new Robot(d,Nwpos);
    }
    public Robot ouest(Robot d) {
        int[] Nwpos = new int[2];
        Nwpos[0] = position[0];
        Nwpos[1] =position[1]-1;
        System.out.println(d.getnum()+" Deplacement vers l'OUEST");
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

    public int getCapaciteeExtraction() {
        return capaciteeExtraction;
    }

    @Override
    public String getTypeMateriau(){
        return typeMine;
    }

    @Override
    public int[] getPos() {
        return this.position;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getInfo() {
        return "| " + "R" + this.numero + "   " +"[ "+ this.position[0] +", "+this.position[1]+" ]  " + this.typeMine +"  "+ this.soute + " / " + this.capacitee+"\t |";
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTypeMine(String typeMine) {
        this.typeMine = typeMine;
    }

    public void setSoute(int soute) {
        this.soute = soute;
    }

    public void setCapacitee(int capacitee) {
        this.capacitee = capacitee;
    }

    public void setCapaciteeExtraction(int capaciteeExtraction) {
        this.capaciteeExtraction = capaciteeExtraction;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }
}




