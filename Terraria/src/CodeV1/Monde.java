package CodeV1;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class Monde {
    private Secteur[][] monde;
    private Robot[] roboList;
    private Mine[] mineList;
    private Entrepot[] entrepotList;

    public Monde() {
        this.entrepotList=new Entrepot[1];
        this.mineList = new Mine[1];
        this.roboList=new Robot[1];
        this.monde = new Secteur[9][9];
    }

    public void creerMonde(){
        int eau = 0;
        for (int i = 0 ; i < 9 ;i++){
            for (int j = 0 ; j < 9 ; j++){
                Random valeur = new Random();
                int x = valeur.nextInt(11); // faire en sorte que l'apparisiotn d'eau soit plus rare!
                if (x == 1 && eau<10){
                    this.monde[i][j] = new Eau();
                    eau += 1;
                }
                else{
                    this.monde[i][j] = new Terre();
                }
            }
        }
    }

    public void ajoutElement (Entrepot e, Robot R) throws ExecutionException {

        Random x = new Random();
        Random y = new Random();
        int i = x.nextInt(10);
        int j = y.nextInt(10);

        while (monde[i][j].gettype()=="Eau") {
            i = x.nextInt(10);
            j = y.nextInt(10);
        }
        monde[i][j].ajoutLocalE(e);
        monde[i][j].ajoutLocalR(R);

        for (int k = 0;k<entrepotList.length;k++){
            if(entrepotList[k]==null){
                this.entrepotList[k]=e;
                this.roboList[k]=R;
            }
        }
    }

    public void ajoutMine (Mine mine) throws ExecutionException {
        Random x = new Random();
        Random y = new Random();
        int i = x.nextInt(10);
        int j = y.nextInt(10);
        while (monde[i][j].gettype()=="Eau"||monde[i][j].gettype()=="Robot"||monde[i][j].gettype()=="Mine") {
            i = x.nextInt(10);
            j = y.nextInt(10);
        }
        monde[i][j].ajoutLocalM(mine);
        for (int k = 0;k<entrepotList.length;k++){
            if(mineList[k]==null) {
                this.mineList[k] = mine;
            }
        }
    }

    public void affichermonde() {
        StringBuilder mondeAfficher = new StringBuilder();
        mondeAfficher.append(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- " + "\n");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 2; j++) {
                mondeAfficher.append("|");
                for (int k = 0; k < 9; k++) {
                    mondeAfficher.append(monde[i][k].afficher(j) + "|");
                }
                mondeAfficher.append("\n");
                if (i == 9) {
                    mondeAfficher.append("");
                }
                else{
                    mondeAfficher.append("  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -  " + "\n");
                }
            }
        }
        mondeAfficher.append(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- " + "\n");
        System.out.println(mondeAfficher);
    }

}
