package com.example.terrariafx;

import java.util.Random;
import java.util.concurrent.ExecutionException;

public class Monde {
    private Secteur[][] monde;
    private Robot[] roboList;
    private Mine[] mineList;
    private Entrepot[] entrepotList;
    private int nbrRobot;

    public Monde() {
        this.entrepotList = new Entrepot[2];
        this.mineList = new Mine[4];
        this.roboList = new Robot[10];
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
            if (monde[x][y].gettype().equals("Terre")) {
                this.monde[x][y] = new Eau();
                eau++;
            }
        }
    }
    public void generationRobot() {
        Random inta = new Random();
        int cpt = 2 ;
        int num = 3 ;
        roboList[0]  = new Robot("OR",1);
        roboList[1]  = new Robot("NI",2);
        int nbROr = inta.nextInt(4);
        if(nbROr!=0) {
            for (int i = 0; i < nbROr; i++) {
                roboList[cpt] = new Robot("OR", num);
                cpt++;
                num++;
            }
        }
        int nbRNi = inta.nextInt(4);
        if(nbRNi!=0){
            for (int i=0 ;i<nbRNi ;i++){
                roboList[cpt]   =   new Robot("NI",num);
                cpt++;
                num++;
            }
        }
        this.nbrRobot = 2 + nbRNi +nbROr;
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
        attenants();
    }

    public void ajoutMine () throws ExecutionException {
        for (int k = 0 ; k<mineList.length; k++) {
            Random x = new Random();
            Random y = new Random();
            int i = x.nextInt(10);
            int j = y.nextInt(10);
            while (monde[i][j].gettype().equals("Eau") || veriflocal0Mi(i,j)==true) {
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
        //Random num = new Random();
        //int nbr = 2 + num.nextInt(5);
        //this.nbrRobot = nbr;
        for (int k = 0 ; k<this.nbrRobot; k++) {
            int[] pos = new int[2];
            int i = x.nextInt(10);
            int j = y.nextInt(10);
            while (monde[i][j].gettype().equals("Eau") || veriflocal1(i,j)== true){
                i = x.nextInt(10);
                j = y.nextInt(10);
            }

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
            while (monde[i][j].gettype().equals("Eau") || veriflocal0En(i,j)==true) {
                i = x.nextInt(10);
                j = y.nextInt(10);
            }
            int[] pos=new int[2];
            pos[0]=i; pos[1]=j;
            entrepotList[k] = new Entrepot(entrepotList[k],pos);
            monde[i][j].ajoutLocalE(entrepotList[k]);
        }
    }

    public void attenants() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; i < 9; j++) {
                int[] coord = {0, 0, 0, 0};
                    if (monde[i][j] instanceof Terre) {
                        try {
                            if (monde[i - 1][j] instanceof Terre) { //Nord
                                coord[0] = 1;
                            }
                        } catch (Exception e) {
                            continue;
                        }
                        try {
                            if (monde[i + 1][j] instanceof Terre) { //Sud
                                coord[1] = 1;
                            }
                        } catch (Exception e) {
                            continue;
                        }
                        try {
                            if (monde[i][j - 1] instanceof Terre) { //Ou-Est lol c'est pour la blague
                                coord[2] = 1;
                            }
                        } catch (Exception e) {
                            continue;
                        }
                        try {
                            if (monde[i][j + 1] instanceof Terre) { //Est
                                coord[3] = 1;
                            }
                        } catch (Exception e) {
                            continue;
                        }
                        ((Terre) monde[i][j]).setAtennant(coord);

                    }
            }
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
                } else {
                    mondeAfficher.append("  --- ---  --- ---  --- ---  --- ---  --- ---  --- ---  --- ---  --- ---  --- ---  --- --- " + "\n");
                }
            }
        }
        mondeAfficher.append("\n");

    }

    public String GetInfo(int cpt){

        String Afficher = "\n Tour : "+cpt+"\n";
        Afficher+=" ____________________________"+"\n";
        Afficher+=" Les mines : \n";
        for(Mine m: mineList){
            Afficher+=m.getInfo() + "\n";
        }
        Afficher+=" ____________________________"+"\n";
        Afficher+=" Les Entrepots : \n";
        for(Entrepot e: entrepotList){
            Afficher+= e.getInfo() + "\n";
        }
        Afficher+=" ____________________________"+"\n";
        Afficher+="Les Robots : \n";
        for(int y = 0 ; y < nbrRobot ; y++){
            Afficher+=roboList[y].getInfo() + "\n";
        }
        Afficher += " ____________________________"+"\n";
        return Afficher;
    }

    public void actionRobot(Robot robot, String Da) throws ExecutionException {
        //Interaction
        if (Da.toUpperCase().equals("R")){  //recolter
            if (monde[robot.getPosition()[0]][robot.getPosition()[1]] instanceof Terre ){
                if (((Terre)monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[0] instanceof Mine){
                    if(robot.getTypeMateriau() == ((Mine)((Terre) monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[0]).getTypeMateriau())
                    {
                        robot.recolter(((Mine) ((Terre) monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[0]));
                    }
                    else{
                        System.out.println("Impossible");
                    }
                }
            }
        }
        else if (Da.toUpperCase().equals("D")){ // deposer pour vider sont stock
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
        else if (Da.toUpperCase().equals("N")){ // deplacement vers le nord
            try {
                Robot rb = robot.nord(robot);
                if ((Secteur)(monde[robot.getPosition()[0] - 1][robot.getPosition()[1]]) instanceof Terre) {
                    if (veriflocal1(robot.getPosition()[0] - 1, robot.getPosition()[1]) == false) {
                        this.monde[rb.getPosition()[0]][rb.getPosition()[1]].ajoutLocalR(rb);
                        ((Terre) monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[1] = null;
                        roboList[rb.getnum() - 1] = rb; //copy du robot
                    }
                    else {
                        System.out.println("Un Robot et deja present dans le secteur");
                    }
                } else {
                    System.out.println("Vous essayez d'aller sur l'eau!");
                }
            }catch(Exception e){
                System.out.println("Vous ne pouvez sortir des limites de la carte!");
            }
        }
        else if (Da.toUpperCase().equals("S")){// deplacement vers le sud
            try {
                Robot rb = robot.sud(robot);
                if (((Secteur)monde[robot.getPosition()[0] + 1][robot.getPosition()[1]]) instanceof Terre) {
                    if(veriflocal1(robot.getPosition()[0]+1,robot.getPosition()[1]) == false ){
                        this.monde[rb.getPosition()[0]][rb.getPosition()[1]].ajoutLocalR(rb);
                        ((Terre) monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[1] = null;
                        roboList[rb.getnum() - 1] = rb;
                    }else{
                        System.out.println("Un Robot et deja present dans le secteur");
                    }
                } else {
                    System.out.println("Vous essayez d'aller sur l'eau!");
                }
            }catch(Exception e){
                System.out.println("Vous ne pouvez sortir des limites de la carte!");
            }
        }
        else if (Da.toUpperCase().equals("E")){// deplacement vers l'est
            try {
                Robot rb = robot.est(robot);
                if ((Secteur)(monde[robot.getPosition()[0]][robot.getPosition()[1] + 1]) instanceof Terre) {
                    if(veriflocal1(robot.getPosition()[0],robot.getPosition()[1]+1) == false ) {
                        this.monde[rb.getPosition()[0]][rb.getPosition()[1]].ajoutLocalR(rb);
                        ((Terre) monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[1] = null;
                        roboList[rb.getnum() - 1] = rb;
                    }else {
                        System.out.println("Un Robot et deja present dans le secteur");
                    }
                } else {
                    System.out.println("Vous essayez d'aller sur l'eau!");
                }
            }
            catch(Exception e){
                System.out.println("Vous ne pouvez sortir des limites de la carte!");
            }
        }
        else if (Da.toUpperCase().equals("O")){// deplacement vers l'ouest
            try {
                Robot rb = robot.ouest(robot);
                if ((monde[robot.getPosition()[0]][robot.getPosition()[1] - 1]) instanceof Terre) {
                    if(veriflocal1(robot.getPosition()[0],robot.getPosition()[1]-1) == false ) {
                        this.monde[rb.getPosition()[0]][rb.getPosition()[1]].ajoutLocalR(rb);
                        ((Terre) monde[robot.getPosition()[0]][robot.getPosition()[1]]).getLocals()[1] = null;
                        roboList[rb.getnum() - 1] = rb;}
                    else{
                        System.out.println("Un Robot et deja present dans le secteur");
                    }
                } else {
                    System.out.println("Vous essayez d'aller sur l'eau!");
                }
            }
            catch(Exception e){
                System.out.println("Vous ne pouvez sortir des limites de la carte!");
            }
        }
        else {
            System.out.println("Entrez une commande valide !");
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
    public Secteur[][] getMonde() {
        return monde;
    }

    public Boolean veriflocal1(int i,int j){
        boolean pressence = false;
        for(int cptR=0;cptR<nbrRobot;cptR++){
            if (roboList[cptR].getPos()[0]==i &&  roboList[cptR].getPos()[1]==j) {
                return true;
            }
        }
        return pressence;
    }
    public Boolean veriflocal0En(int i,int j){
        boolean pressence = false;
        for(int cptE=0;cptE<2;cptE++){
            if (entrepotList[cptE].getPos()[0]==i &&  entrepotList[cptE].getPos()[1]==j && veriflocal0Mi(i,j) ==true) {
                return true;
            }
        }
        return pressence;
    }
    public Boolean veriflocal0Mi(int i,int j){
        boolean pressence = false;
        for(int cptm=0;cptm<getMineList().length;cptm++){
            if (mineList[cptm].getPos()[0]==i &&  mineList[cptm].getPos()[1]==j || veriflocal0En(i,j).equals(true)) {
                return true;
            }
        }
        return pressence;
    }

}
