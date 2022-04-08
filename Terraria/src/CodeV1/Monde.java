package CodeV1;

public class Monde {
    private Secteur[][] monde;
    private Robot[] roboList;
    private Mine[] mineList;
    private Entrepot[] entrepotList;

    public Monde() {
        this.entrepotList=new Entrepot[2];
        this.mineList = new Mine[2];
        this.roboList=new Robot[2];
        this.monde = new Secteur[10][10];
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
                    this.monde[i][j]= new Terre();
                }
                else{
                    this.monde[i][j]=new Eau();
                    eau += 1;
                }
            }
        }

    }


    public void affichermonde() {
        // TODO implement here
    }

    public void afficherObject() {
        // TODO implement here
    }
}
