package com.example.terrariafx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AI {

    private Monde world;
    private Robot Rb;
    private Batiment batiment;
    private int[][] RbMiOrpluproche;
    private int[][] RbMiNipluproche;

    public AI(Monde w){
        this.world=w;
        distanceBatiment();
        resolution();
    }
    public void distanceBatiment() {
        int[][] listeOr = new int[2][world.getNbrRobot()];
        int[][] listeNi = new int[2][world.getNbrRobot()];
        for (int i = 0; i < world.getMineList().length; i++) {
            if (world.getMineList()[i].getStock() > 0) {
                batiment = world.getMineList()[i];
                for (int j = 0; j < world.getRoboList().length; j++) {
                    if (world.getMineList()[i].getTypeMateriau() == world.getRoboList()[i].getTypeMateriau()) {
                        Rb = world.getRoboList()[i];
                        int newdistance = distance()[world.getRoboList()[i].getPos()[0]][world.getRoboList()[i].getPos()[1]];
                        if (world.getMineList()[i].getTypeMateriau() == "Or") {
                            listeOr[0][i] = newdistance;
                        } else {
                            listeOr[1][i] = newdistance;
                        }
                    }
                }
            }
        }
        this.RbMiNipluproche = listeNi;
        this.RbMiOrpluproche = listeOr;

        int minOr = listeOr[0][0];
        int minNi = listeNi[0][0];

        int[] indiceOr = new int[]{0, 0};
        int[] indiceNi = new int[]{0, 0};

        for (int k = 0; k < listeOr.length; k++) {
            for (int l = 0; l < listeOr[k].length; l++) {
                int tmp = listeOr[k][l];
                if (minOr > tmp && world.getMineList()[0].getStock() > 0 || world.getMineList()[1].getStock() > 0) {
                    minOr = tmp;
                    indiceOr = new int[]{k, l};
                }
            }
        }
        for (int k = 0; k < listeNi.length; k++) {
            for (int l = 0; l < listeNi[k].length; l++) {
                int tmp = listeNi[k][l];
                if (minNi > tmp && world.getMineList()[2].getStock() > 0 || world.getMineList()[3].getStock() > 0) {
                    minNi = tmp;
                    indiceNi = new int[]{k, l};
                }
            }
        }
        if (minNi > minOr) {
            for (int i = 0; i < world.getNbrRobot(); i++) {
                if (world.getRoboList()[i].getPos()[0] == indiceNi[0] && world.getRoboList()[i].getPos()[1] == indiceNi[1]) {
                    this.Rb = world.getRoboList()[i];
                    this.batiment=world.getMineList()[indiceNi[0]];

                }
            }
        } else {
            for (int i = 0; i < world.getNbrRobot(); i++) {
                if (world.getRoboList()[i].getPos()[0] == indiceOr[0] && world.getRoboList()[i].getPos()[1] == indiceOr[1]) {
                    this.Rb = world.getRoboList()[i];
                    this.batiment=world.getMineList()[indiceOr[0]];
                }
            }
        }
    }

    public int[][] attenantes(int[] coord) {
        int[][] res = new int[4][2];
        if ( coord[0]-1>=0 && coord[0]-1 <=9 && coord[1]>=0 && coord[1]<=9 && world.getMonde()[coord[0]-1][coord[1]] instanceof Terre) {
            res[0][0]= coord[0]-1 ;
            res[0][1] = coord[1];
        }
        if ( coord[0]+1>=0 && coord[0]+1<=9 && coord[1]>=0 && coord[1]<=9 && world.getMonde()[coord[0]+1][coord[1]] instanceof Terre) {
            res[1][0]= coord[0]+1;
            res[1][1] = coord[1];
        }
        if ( coord[1]-1>=0 && coord[1]-1<=9 && coord[0]>=0 && coord[0]<=9 && world.getMonde()[coord[0]][coord[1]-1] instanceof Terre) {
            res[2][0]= coord[0];
            res[2][1] = coord[1]-1;
        }
        if ( coord[1]+1>=0 && coord[1]+1<=9 &&  coord[0]>=0 && coord[0]<=9 &&world.getMonde()[coord[0]][coord[1]+1] instanceof Terre) {
            res[3][0]= coord[0];
            res[3][1] = coord[1]+1;
        }
        return res;
    }

    public int[][] matricedistance() {
        int[][] matriceadj = new int[10][10];
        for (int i=0 ; i < 9 ; i++){
            for (int j=0 ; j < 9 ; j++){
                matriceadj[i][j]=2;
            }
        }
        return matriceadj;
    }

    public int[][] distance(){
        ArrayList<int[]> file = new ArrayList<>();
        int[][] dis = matricedistance();
        dis[batiment.getPos()[0]][batiment.getPos()[1]]=0;
        int[] coordB = new int[2];
        coordB[0]=batiment.getPos()[0];
        coordB[1]= batiment.getPos()[1];
        file.add(coordB);
        while (file.isEmpty() == false){
            int[] ele = file.get(0);
            int[][] voisin = attenantes(ele);
            for(int[] v : voisin ){
                if (dis[v[0]][v[1]] == 2){
                    file.add(v);
                    dis[v[0]][v[1]] = dis[ele[0]][ele[1]] + 1 ;
                }
                file.remove(0);
            }
        }
        return dis;
    }

    public void resolution() { // fonctionne comme une pile
        int[][] dis = distance();
        ArrayList<int[]> chemin = new ArrayList<>();
        int[] tmp = new int[2]; // par de coordoner du robot
        tmp[0] = Rb.getPosition()[0];
        tmp[1] = Rb.getPosition()[1];
        boolean notin = false;
        while (notin == false) {
            for (int i = 0; i < chemin.size(); i++) {
                if (chemin.indexOf(i) == tmp[0] && chemin.indexOf(i) == tmp[1]) {
                    notin = true;
                }
            }
            if (tmp[0]+1 < 9 && dis[tmp[0]+1][tmp[1]] == dis[tmp[0]][tmp[1]] -1  && world.getMonde()[tmp[0]+1][tmp[1]] instanceof Terre){ // deplacement vers le SUD
                if (world.veriflocal1(tmp[0]+1,tmp[1])==true){
                    // deplacer un robot quand sur un entrepot
                }
                tmp = new int[]{tmp[0] + 1, tmp[1]};
                chemin.add(tmp);
            }
            else if (tmp[0]-1 >=0 && dis[tmp[0]-1][tmp[1]] == dis[tmp[0]][tmp[1]] -1  && world.getMonde()[tmp[0]-1][tmp[1]] instanceof Terre){ // Deplacement vers le nord
                if (world.veriflocal1(tmp[0]-1,tmp[1])==true){
                    // deplacer un robot quand sur un entrepot
                }
                tmp = new int[]{tmp[0] - 1, tmp[1]};
                chemin.add(tmp);
            }
            else if (tmp[1]+1 <= 9 && dis[tmp[0]][tmp[1]+1] == dis[tmp[0]][tmp[1]] - 1  && world.getMonde()[tmp[0]][tmp[1]+1] instanceof Terre){ // Deplacement vers l'Est
                if (world.veriflocal1(tmp[0]-1,tmp[1])==true){
                    // deplacer un robot quand sur un entrepot
                }
                tmp = new int[]{tmp[0], tmp[1]+1};
                chemin.add(tmp);
            }
            else if (tmp[1]-1 >=0 && dis[tmp[0]][tmp[1]-1] == dis[tmp[0]][tmp[1]] - 1  && world.getMonde()[tmp[0]][tmp[1]-1] instanceof Terre){ // Deplacement vers l'Est
                if (world.veriflocal1(tmp[0]-1,tmp[1])==true){
                    // deplacer un robot quand sur un entrepot
                }
                tmp = new int[]{tmp[0], tmp[1]-1};
                chemin.add(tmp);
            }
        }
        Collections.reverse(Arrays.asList(dis));
        Rb.setChemin(dis);
    }

    public Robot getRb() {
        return Rb;
    }

}
