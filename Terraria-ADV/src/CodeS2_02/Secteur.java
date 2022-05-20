package CodeS2_02;

import CodeV1.Entrepot;

import java.util.concurrent.ExecutionException;

public abstract class Secteur{
    protected  int[] coodonnee;

    public abstract int[] getposition();
    public abstract String gettype();
    public abstract StringBuilder afficher(int k);

    public abstract void ajoutLocalR(Robot r) throws ExecutionException;
    public abstract void ajoutLocalM(Mine m)throws ExecutionException;
    public abstract void ajoutLocalE(Entrepot e)throws ExecutionException;


}