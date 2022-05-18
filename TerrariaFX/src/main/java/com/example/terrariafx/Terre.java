package com.example.terrariafx;

import java.util.concurrent.ExecutionException;

public class Terre extends Secteur {
    private String type;
    private Localisable[] locals;

    public Terre() {
        this.type = "Terre";
        this.locals = new Localisable[2];
        this.locals[0] = null;
        this.locals[1] = null;
    }
    @Override
    public void ajoutLocalR(Robot r) throws ExecutionException {
        try {
            if (this.locals[1] == null) {
                r = new Robot(r, getposition());
                this.locals[1] = r;
            }
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("Déplacement impossible, un robot est déjà dans le secteur !! en  / " + this.getposition());
        }
    }
    @Override
    public void ajoutLocalM(Mine m) throws ExecutionException {
        try {
            if (this.locals[0] == null) {
                this.locals[0] = m;
            }
        }
        catch(Exception e) {
            System.out.println(e);
            System.out.println("Implémentation impossible de la mine, un élément du même type déjà présent / " + this.getposition());
        }
    }
    @Override
    public void ajoutLocalE(Entrepot emp) throws ExecutionException {
        try {
            if (this.locals[0] == null) {
                this.locals[0] = emp;
            }
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("Implémentation impossible de l'entrepôt', un élément du même type déjà présent / " + this.getposition());
        }
    }
    public Localisable[] getLocals(){
        return this.locals;
    }
    @Override
    public int[] getposition() {
        return this.coodonnee;
    }

    @Override
    public String gettype() {
        return this.type;
    }

    @Override
    public StringBuilder afficher(int k) {
        StringBuilder terrain = new StringBuilder();
        if (locals[k] == null) {
            terrain.append("   |   ");
        }
        else {
            terrain.append(locals[k].afficher());
        }
        return terrain;
    }
}