package CodeV1;

import java.util.concurrent.ExecutionException;

public class Terre extends Secteur{
    private String type;
    private Localisable[] locals;

    public Terre() {
        this.type = "Terre";
        this.locals = new Localisable[2];
        this.locals[0] = null;
        this.locals[1] = null;
    }

    public void ajoutLocalR(Robot r)throws ExecutionException{
        try {
            if (this.locals[1] == null) {
                r = new Robot(r, getposition());
                this.locals[1] = r;
            }
        }
        finally {
            System.out.println("Deplacement impossible, un robot est deja dans le secteur !! en  / "+ this.getposition() );
        }
    }

    public void ajoutLocalM(Mine m) throws ExecutionException {
        try {
            if (this.locals[0] == null) {
                this.locals[0] = m;
            }
        } finally {
            System.out.println("Implementation Imposible de la Mine  un element du meme type deja present / " + this.getposition());
        }
    }

    public void ajoutLocalE(Entrepot emp) throws ExecutionException{
        try {
            if (this.locals[0] == null) {
                this.locals[0] = emp;
            }
        }
        finally{
            System.out.println("Implementation Imposible de l'entrepot  un element du meme type deja present/ " + this.getposition());
            }
        }

    @Override
    public int[] getposition() {
        return this.coodonnee;
    }

    @Override
    public String gettype(){
        return this.type;
    }
    @Override
    public StringBuilder afficher(int k) {
        StringBuilder terrain = new StringBuilder();

        /*if(locals[k].getType() == "R"){
            terrain.append(locals[k].afficher());
        }
        if (locals[k].getType() == "M"){ // probleme le monde vas afficher  ligne par ligne
            terrain.append(locals[k].afficher());                     // mais un [][][] vas etre plus chiant a gèrais
        }
        if (locals[k].getType() == "E"){ // probleme le monde vas afficher  ligne par ligne
            terrain.append(locals[k].afficher());                     // mais un [][][] vas etre plus chiant a gèrais
        }
        else{

         */
            terrain.append("   |   ");

        return terrain;


    }
}
