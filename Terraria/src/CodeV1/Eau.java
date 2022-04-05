package CodeV1;

public class Eau extends Secteur {
    private int x;
    private int y;
    private String type ;
    private String[][] pos ;

    public Eau(){
        this.pos=new String[1][1];
    }

    public Eau(int abs , int ord ) {
        this.type = "X";
        this.x =abs ;
        this.y = ord ;
        this.pos[0][0] = "X";
        this.pos[0][1] = "X";
        this.pos[1][0] = "X";
        this.pos[1][1] = "X";
    }

    public String getType() {
        return this.type ;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        String affi = null;
        for (int i=0;i< pos.length; i++){
            for (int j=0;j<pos.length;i++){
                affi += pos[i][j] + "|" ;
            }
        }
        return affi;
    }
}