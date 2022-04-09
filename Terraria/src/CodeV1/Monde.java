package CodeV1;

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
        int[] coor = new int[1];
        for (int i = 0 ; i < 9 ;i++){
            coor[0]=i;
            for (int j = 0 ; j < 9 ; j++){
                coor[1]=j;
                int valeur = (int)Math.random();
                if (valeur == 1 || eau == 10){
                    this.monde[i][j] = new Terre();
                }
                else{
                    this.monde[i][j] = new Eau();
                    eau += 1;
                }
            }
        }

    }

    public StringBuilder affichermonde() {
        StringBuilder mondeAfficher = new StringBuilder();
        mondeAfficher.append("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "+"\n");
        for (int i = 0 ; i < 9 ;i++ ) {
            mondeAfficher.append("|");
                for (int j = 0; j < 9; j++) {
                    for (int k = 0 ; k < 1 ;k++){
                        mondeAfficher.append(monde[i][j].afficher(k));
                    }
                }
            mondeAfficher.append("|" + "\n");
            }
        mondeAfficher.append("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "+"\n");
        return mondeAfficher;
        }


    public void afficherObject() {
        // TODO implement here
    }
}
