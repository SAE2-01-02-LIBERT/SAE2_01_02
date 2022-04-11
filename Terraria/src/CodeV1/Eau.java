package CodeV1;

import jdk.jshell.spi.ExecutionControl;

import java.util.concurrent.ExecutionException;

public class Eau extends Secteur {
    private String type;

    public Eau() {
        this.type = "Eau";
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
        StringBuilder X = new StringBuilder();
        X.append( " X " +"|"+" X ");
        return X;
    }

    @Override
    public void ajoutLocalR(Robot r) throws ExecutionException {
            System.out.println("Impossible vous esseillez de faire floter votre Robot ");
    }

    @Override
    public void ajoutLocalM(Mine m) throws ExecutionException {
        System.out.println("Il vous sera impossible de trouver les minerais sous l'eau");
    }

    @Override
    public void ajoutLocalE(Entrepot e) throws ExecutionException {
        System.out.println("Votre entreprot est sous l'eau !!! ou presque ");
    }


}
