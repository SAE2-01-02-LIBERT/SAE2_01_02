package CodeV1;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class Monde {
    private Secteur[][] monde;
    private Robot[] roboList;
    private Mine[] mineList;
    private Entrepot[] entrepotList;

    public Monde() {
        this.entrepotList=new Entrepot[2];
        this.mineList = new Mine[4];
        this.roboList=new Robot[2];
        this.monde = new Secteur[10][10];
    }

    public void creerMonde() {
        int eau = 0;
        while (eau < 10) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (monde[i][j] == null) {
                        Random valeur = new Random();
                        int x = valeur.nextInt(11);
                        if (x == 1 ) {
                            this.monde[i][j] = new Eau();
                            eau += 1;
                        }
                        else {
                            this.monde[i][j] = new Terre();
                        }
                    }
                    else{
                        Random valeur = new Random();
                        int x = valeur.nextInt(11); // faire en sorte que l'apparisiotn d'eau soit plus rare!
                        if (x == 1 && eau <10) {
                            this.monde[i][j] = new Eau();
                            eau += 1;
                        }
                    }
                }
            }
        }
    }


    public void generationRobot(){
        Robot R1 = new Robot("Nikel",1);
        Robot R2 = new Robot("Or",2);
        roboList[0] = R1;
        roboList[1] = R2;
    }

    public void generationEntrepot(){
        Entrepot E1 = new Entrepot("Nikel",1);
        Entrepot E2 = new Entrepot("Or",2);
        entrepotList[0] = E1;
        entrepotList[1] = E2;
    }

    public void generationMine() {
        Mine M1 = new Mine("Nickel",1);
        Mine M2 = new Mine("Nickel",2);
        Mine M3 = new Mine("Or",3);
        Mine M4 = new Mine("Or",4);
        mineList[0] = M1;
        mineList[1] = M2;
        mineList[2] = M3;
        mineList[3] = M4;
    }

    public void ajoutElement () throws ExecutionException {
        for (int k = 0 ; k<entrepotList.length; k++){

            Random x = new Random();
            Random y = new Random();
            int i = x.nextInt(10);
            int j = y.nextInt(10);

            if (monde[i][j].gettype() == " Eau") {
                i = x.nextInt(10);
                j = y.nextInt(10);
            }
            int[] pos=new int[2];
               pos[0]=i; pos[1]=j;

            roboList[k]=new Robot(roboList[k],pos);
            entrepotList[k]= new Entrepot(entrepotList[k],pos);
            monde[i][j].ajoutLocalE(entrepotList[k]);
            monde[i][j].ajoutLocalR(roboList[k]);
        }
    }

    public void ajoutMine () throws ExecutionException {
        for (int k = 0 ; k<mineList.length; k++) {

            Random x = new Random();
            Random y = new Random();
            int i = x.nextInt(10);
            int j = y.nextInt(10);
            while (monde[i][j].gettype() == "Eau" || monde[i][j].gettype() == "Mine" || monde[i][j].gettype() == "Entrepot") {
                i = x.nextInt(10);
                j = y.nextInt(10);
            }
            int[] pos=new int[2];
            pos[0]=i; pos[1]=j;

            mineList[k] = new Mine(mineList[k],pos);
            monde[i][j].ajoutLocalM(mineList[k]);
        }
    }

    public void affichermonde() {
        StringBuilder mondeAfficher = new StringBuilder();
        mondeAfficher.append("  --- ---  --- ---  --- ---  --- ---  --- ---  --- ---  --- ---  --- ---  --- ---  --- --- " + "\n");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                mondeAfficher.append("||");
                for (int k = 0; k < 10; k++) {
                    mondeAfficher.append(monde[i][k].afficher(j) + "||");
                }
                mondeAfficher.append("\n");
                if (Math.floorMod((j), 2) == 0) {
                    mondeAfficher.append("   -   -    -   -    -   -    -   -    -   -    -   -    -   -    -   -    -   -    -   -   " + "\n");
                }
                else {
                    mondeAfficher.append("  --- ---  --- ---  --- ---  --- ---  --- ---  --- ---  --- ---  --- ---  --- ---  --- --- " + "\n");
                }
            }
        }

        System.out.println(mondeAfficher);
    }
}
