package CodeV1;
import java.util.Random;
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
                int x = valeur.nextInt(2); // faire en sorte que l'apparisiotn d'eau soit plus rare!
                if (x == 0 || eau == 10){
                    this.monde[i][j] = new Terre();
                }
                else{
                    this.monde[i][j] = new Eau();
                    eau += 1;
                }
            }
        }

    }

    public void affichermonde() {
        StringBuilder mondeAfficher = new StringBuilder();
        mondeAfficher.append(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- " + "\n");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 2; j++) {
                mondeAfficher.append("|");
                for (int k=0 ; k<9 ; k++){
                    mondeAfficher.append(monde[i][k].afficher(j)+"|");
                }
                mondeAfficher.append("\n");
                mondeAfficher.append("  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -  " + "\n");
            }
        }
        mondeAfficher.append(" --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- " + "\n");
        System.out.println(mondeAfficher);

    }

    public void afficherObject() {
        // TODO implement here
    }
}
