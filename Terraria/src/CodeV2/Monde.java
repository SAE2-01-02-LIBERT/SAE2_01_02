package CodeV2;
import java.util.Random;

public class Monde {
    private int idMonde;
    private Object[][][] terrain;

    public Monde(int i){
        idMonde=i;
        terrain=new Object[10][10][2];
    }

    public void AfficherMonde(){

    }
    public Objet[][][] get.terrain(){
        return terrain;
    }
    public int get.Monde(){
        return idMonde;
    }
    public boolean get.element(){
        return element;
    }
    public void Generation_Map{
        Random ran= new Random();
        int water=1;
        int entr=1;
        int rob=1;
        int m=1;
        boolean b;
        int[] tab=new int[6];
        tab[0]=ran.nextInt(11);
        tab[1]=ran.nextInt(5)+1;
        tab[2]=ran.nextInt(5)+1;
        tab[3]=ran.nextInt(2)+1;
        tab[4]=ran.nextInt(2)+1;
        tab[5]=2;
        for (int i=0; i< tab.length; i++){
            if (i=0){
                for (j=0;j<=tab[i];j++){
                    int px=ran.nextInt(11);
                    int py=ran.nextInt(11);
                    terrain[px][py][0]=new Eau(true,px,py,this);
                    terrain[px][py][1]=new Eau(true,px,py,this);
                }
            }
            else if (i=1){
                for (j=0;j<=tab[i];j++){
                    int px=ran.nextInt(11);
                    int py=ran.nextInt(11);
                    terrain[px][py][0]=new Eau(false,px,py,this);
                    terrain[px][py][1]=new Robot(true,px,py,this);
                }
            }
            else if (i=2){
                for (j=0;j<=tab[i];j++){
                    int px=ran.nextInt(11);
                    int py=ran.nextInt(11);
                    terrain[px][py][0]=new Eau(false,px,py,this);
                    terrain[px][py][1]=new Robot(false,px,py,this);
                }
            }
            else if (i=3){
                for (j=0;j<=tab[i];j++){
                    int px=ran.nextInt(11);
                    int py=ran.nextInt(11);
                    terrain[px][py][0]=new Mine(true,px,py,this);
                    terrain[px][py][1]=new Eau(false,px,py,this);
                }
            }
            else if (i=4){
                for (j=0;j<=tab[i];j++){
                    int px=ran.nextInt(11);
                    int py=ran.nextInt(11);
                    terrain[px][py][0]=new Mine(false,px,py,this);
                    terrain[px][py][1]=new Eau(false,px,py,this);
                }
            }
            else if (i=5){
                for (j=0;j<=tab[i];j++){
                    if(j=0) {
                        int px = ran.nextInt(11);
                        int py = ran.nextInt(11);
                        terrain[px][py][0] = new Entrepot(true, px, py, this);
                        terrain[px][py][1] = new Eau(false, px, py, this);
                    }
                    else{
                        int px = ran.nextInt(11);
                        int py = ran.nextInt(11);
                        terrain[px][py][0] = new Entrepot(false, px, py, this);
                        terrain[px][py][1] = new Eau(false, px, py, this);
                    }
                }
            }
        }
        for (int i=0;i<terrain.length;i++){
            for (int j=0;j<terrain.length[0];j++) {
                for (int k = 0; k < terrain[0][0].length; k++) {
                    if(terrain[i][j][k]==null){
                        terrain[i][j][k]==new Eau(false,i,j,this)
                    }
                }
            }
        }
        System.out.println("-------------------------------------------------");
        for (int i=0;i<terrain.length;i++){
            for (int k = 0; k < terrain[0][0].length; k++) {
                for (int j = 0; j < terrain.length[0]; j++) {
                    if(terrain[i][j][k] instanceof Eau){
                        Eau e = Eau.class.cast(terrain[i][j][k]);
                        if(e.getEau()==true){
                            System.out.print("X X");
                        }
                        else{
                            System.out.print("   ");
                        }
                    }
                    else if(terrain[i][j][k] instanceof Robot){
                        Robot r = Robot.class.cast(terrain[i][j][k]);
                        System.out.print("R "+r.getidRobot());
                    }
                    else if(terrain[i][j][k] instanceof Mine){
                        Mine m = Mine.class.cast(terrain[i][j][k]);
                        System.out.print("M "+m.getidMine());
                    }
                    else if(terrain[i][j][k] instanceof Entrepot){
                        Entrepot e = Entrepot.class.cast(terrain[i][j][k]);
                        System.out.print("E "+e.getidEntrepot());
                    }



                }
            }
            System.out.println("-------------------------------------------------");
        }
    }
}