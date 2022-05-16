package CodeV1;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class Monde {
    private Secteur[][] monde;
    private Robot[] roboList;
    private Mine[] mineList;
    private Entrepot[] entrepotList;
    private int nbrRobot;

    public Monde() {
        this.entrepotList=new Entrepot[2];
        this.mineList = new Mine[4];
        this.roboList=new Robot[10];
        this.monde = new Secteur[10][10];
    }

    public void creerMonde() {
        Random valeur = new Random();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.monde[i][j] = new Terre();
            }
        }

        int eau = 0;
        int obstacle = valeur.nextInt(11);
        while (eau < obstacle) {
            int x = valeur.nextInt(10);
            int y = valeur.nextInt(10);
            if (monde[x][y].gettype()=="Terre") {
                this.monde[x][y] = new Eau();
                eau++;
            }
        }

    }


    public void generationRobot(){
        Robot R1 = new Robot("NI",1);
        Robot R2 = new Robot("OR",2);
        Robot R3 = new Robot("NI",3);
        Robot R4 = new Robot("OR",4);
        Robot R5 = new Robot("NI",5);
        roboList[0] = R1;
        roboList[1] = R2;
        roboList[2] = R3;
        roboList[3] = R4;
        roboList[4] = R5;
    }

    public void generationEntrepot(){
        Entrepot E1 = new Entrepot("NI",1);
        Entrepot E2 = new Entrepot("OR",2);
        entrepotList[0] = E1;
        entrepotList[1] = E2;
    }

    public void generationMine() {
        Mine M1 = new Mine("NI",1);
        Mine M2 = new Mine("NI",2);
        Mine M3 = new Mine("OR",3);
        Mine M4 = new Mine("OR",4);
        mineList[0] = M1;
        mineList[1] = M2;
        mineList[2] = M3;
        mineList[3] = M4;
    }

    public void ajoutElements() throws ExecutionException {
        ajoutMine();
        ajoutEntrepot();
        ajoutRobot();

    }

    public void ajoutMine () throws ExecutionException {
        for (int k = 0 ; k<mineList.length; k++) {

            Random x = new Random();
            Random y = new Random();
            int i = x.nextInt(10);
            int j = y.nextInt(10);
            while (monde[i][j].gettype().equals("Eau") || monde[i][j].gettype().equals("Mine") || monde[i][j].gettype().equals("Entrepot")) {
                i = x.nextInt(10);
                j = y.nextInt(10);
            }
            int[] pos=new int[2];
            pos[0]=i; pos[1]=j;

            mineList[k] = new Mine(mineList[k],pos);
            monde[i][j].ajoutLocalM(mineList[k]);
        }
    }

    public void ajoutRobot() throws ExecutionException {
        Random x = new Random();
        Random y = new Random();
        Random num = new Random();
        int nbr = 2 + num.nextInt(5);
        this.nbrRobot = nbr;
        for (int k = 0 ; k<nbr; k++) {
            int i = x.nextInt(10);
            int j = y.nextInt(10);
            while (monde[i][j].gettype().equals("Eau") || monde[i][j].gettype().equals("Mine")) {
                i = x.nextInt(10);
                j = y.nextInt(10);
            }
            int[] pos=new int[2];
            pos[0]=i; pos[1]=j;

            roboList[k] = new Robot(roboList[k],pos);
            monde[i][j].ajoutLocalR(roboList[k]);
        }
    }

    public void ajoutEntrepot() throws ExecutionException {
        Random x = new Random();
        Random y = new Random();
        for (int k = 0 ; k< entrepotList.length; k++) {
            int i = x.nextInt(10);
            int j = y.nextInt(10);
            while (monde[i][j].gettype().equals("Eau") ||  monde[i][j].gettype().equals("Mine")) {
                i = x.nextInt(10);
                j = y.nextInt(10);
            }
            int[] pos=new int[2];
            pos[0]=i; pos[1]=j;

            entrepotList[k] = new Entrepot(entrepotList[k],pos);
            monde[i][j].ajoutLocalE(entrepotList[k]);
        }
    }

    public void affichermonde(int cpt) {
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
        mondeAfficher.append("\n");
        mondeAfficher.append("Tour : "+cpt+"\n");
        mondeAfficher.append(" ____________________________"+"\n");
        for(Mine m: mineList){
            mondeAfficher.append(m.getInfo() + "\n");
        }
        for(Entrepot e: entrepotList){
            mondeAfficher.append(e.getInfo() + "\n");
        }
        for(int y = 0 ; y < nbrRobot ; y++){
            mondeAfficher.append(roboList[y].getInfo() + "\n");
        }
        mondeAfficher.append(" ____________________________"+"\n");
        System.out.println(mondeAfficher);
        System.out.println(" ");
    }
    public void actionRobot(Robot robot, String Da) throws ExecutionException {
        //Interaction
        if (Da.toUpperCase().equals("R")){
            if (monde[robot.getPosition()[0]][robot.getPosition()[1]] instanceof Terre ){
                if (((Terre)monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[0] instanceof Mine){
                    if(robot.getTypeMateriau() == ((Mine)((Terre) monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[0]).getTypeMateriau())
                    {
                        robot.recolter(((Mine) ((Terre) monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[0]));
                    }
                    else{
                        System.out.println("Impossible");
                        System.out.println(((Mine)((Terre) monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[0]).getTypeMateriau());
                    }
                }
            }
        }
        else if (Da.toUpperCase().equals("D")){
            if (monde[robot.getPosition()[0]][robot.getPosition()[1]] instanceof Terre ){
                if (((Terre)monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[0] instanceof Entrepot){
                    if(robot.getTypeMateriau() == ((Entrepot) ((Terre)monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[0]).getTypeMateriau())
                    {
                        ((Entrepot) ((Terre)monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[0]).depot(robot);
                    }
                    else{
                        System.out.println("Impossible, cet entrepot ne stocke pas le bon type de mine");
                    }

                }
            }
        }

        else if (Da.toUpperCase().equals("N")){
            try {
                Robot rb = robot.nord(robot);
                if ((monde[robot.getPosition()[0] - 1][robot.getPosition()[1]]) instanceof Terre) {
                    this.monde[rb.getPosition()[0]][rb.getPosition()[1]].ajoutLocalR(rb);
                    ((Terre) monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[1] = null;
                    roboList[rb.getnum() - 1] = rb;
                } else {
                    System.out.println("Vous essayez d'aller sur l'eau!");
                    this.monde[robot.getPosition()[0]][robot.getPosition()[1]].ajoutLocalR(robot);
                }
            }
            catch(Exception e){
                System.out.println("Vous ne pouvez sortir des limites de la carte!");
            }
        }

        else if (Da.toUpperCase().equals("S")){
            try {
                Robot rb = robot.sud(robot);
                if ((monde[robot.getPosition()[0] + 1][robot.getPosition()[1]]) instanceof Terre) {
                    this.monde[rb.getPosition()[0]][rb.getPosition()[1]].ajoutLocalR(rb);
                    ((Terre) monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[1] = null;
                    roboList[rb.getnum() - 1] = rb;
                } else {
                    System.out.println("Vous essayez d'aller sur l'eau!");
                    this.monde[robot.getPosition()[0]][robot.getPosition()[1]].ajoutLocalR(robot);
                }
            }
            catch(Exception e){
                System.out.println("Vous ne pouvez sortir des limites de la carte!");
            }
        }

        else if (Da.toUpperCase().equals("E")){
            try {
                Robot rb = robot.est(robot);
                if ((monde[robot.getPosition()[0]][robot.getPosition()[1] + 1]) instanceof Terre) {
                    this.monde[rb.getPosition()[0]][rb.getPosition()[1]].ajoutLocalR(rb);
                    ((Terre) monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[1] = null;
                    roboList[rb.getnum() - 1] = rb;
                } else {
                    System.out.println("Vous essayez d'aller sur l'eau!");
                    this.monde[robot.getPosition()[0]][robot.getPosition()[1]].ajoutLocalR(robot);
                }
            }
            catch(Exception e){
                System.out.println("Vous ne pouvez sortir des limites de la carte!");
            }
        }
        else if (Da.toUpperCase().equals("O")){
            try {
                Robot rb = robot.ouest(robot);
                if ((monde[robot.getPosition()[0]][robot.getPosition()[1] - 1]) instanceof Terre) {
                    this.monde[rb.getPosition()[0]][rb.getPosition()[1]].ajoutLocalR(rb);
                    ((Terre) monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[1] = null;
                    roboList[rb.getnum() - 1] = rb;
                } else {
                    System.out.println("Vous essayez d'aller sur l'eau!");
                    this.monde[robot.getPosition()[0]][robot.getPosition()[1]].ajoutLocalR(robot);
                }
            }
            catch(Exception e){
                System.out.println("Vous ne pouvez sortir des limites de la carte!");
            }
        }
        else {
            System.out.println("Entrez une commande valide!");
        }
    }

    public Mine[] getMineList() {
        return mineList;
    }
    public Entrepot[] getEntrepotList(){
        return entrepotList;
    }
    public Robot[] getRoboList() {
        return roboList;
    }
    public int getNbrRobot(){
        return nbrRobot;
    }
}
