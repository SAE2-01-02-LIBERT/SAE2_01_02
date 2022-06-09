package com.example.terrariafx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AI {
    private Jeu jeu;
    private Monde world;
    private Robot Rb;
    private Batiment batiment;
    private int[][] RbMiOrpluproche;
    private int[][] RbMiNipluproche;

    public AI(Monde w){
        this.world=w;
        distancebatiment();
    }
    public void distancebatiment() {  // fonctionnel
        int[][] listeOr = new int[2][world.getNbrRobot()];
        int[][] listeNi = new int[2][world.getNbrRobot()];
        for (int i = 0; i < world.getMineList().length; i++) {
            if (world.getMineList()[i].getStock() > 0) {
                batiment = world.getMineList()[i];
                for (int j = 0; j < world.getNbrRobot(); j++) {
                    if (world.getMineList()[i].getTypeMateriau() == world.getRoboList()[j].getTypeMateriau()) {
                        Rb = world.getRoboList()[j];
                        int newdistance = distance()[world.getRoboList()[j].getPos()[0]][world.getRoboList()[j].getPos()[1]];
                        if (world.getMineList()[i].getTypeMateriau() == "Or") {
                            listeNi[0][j] = newdistance;
                        } else {
                            listeOr[1][j] = newdistance;
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
        if ((coord[0] - 1 >=0 && coord[0] - 1 < 10 && coord[1] >= 0 && coord[1] < 10 )&& world.getMonde()[coord[0]-1][coord[1]] instanceof Terre && world.veriflocal1(coord[0]-1,coord[1])==false) {
            res[0][0] = coord[0]-1 ;
            res[0][1] = coord[1];
        }
        if ((coord[0] + 1 >= 0 && coord[0] + 1 < 10 && coord[1] >= 0 && coord[1] < 10) && world.getMonde()[coord[0]+1][coord[1]] instanceof Terre && world.veriflocal1(coord[0]+1,coord[1])==false) {
            res[1][0] = coord[0]+1;
            res[1][1] = coord[1];
        }
        if ((coord[1] - 1 >= 0 && coord[1] - 1 < 10 && coord[0] >= 0 && coord[0] < 10) && world.getMonde()[coord[0]][coord[1]-1] instanceof Terre && world.veriflocal1(coord[0],coord[1]-1)==false) {
            res[2][0] = coord[0];
            res[2][1] = coord[1]-1;
        }
        if ( (coord[1] + 1 >= 0 && coord[1] + 1 < 10 &&  coord[0] >= 0 && coord[0] < 10) && world.getMonde()[coord[0]][coord[1]+1] instanceof Terre && world.veriflocal1(coord[0],coord[1]+1)==false) {
            res[3][0]= coord[0];
            res[3][1] = coord[1]+1;
        }
        return res;
    }

    public int[][] matricedistance() {
            int[][] matriceadj = new int[10][10];
            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j <= 9; j++) {
                    matriceadj[i][j] = -1;
                }
            }
            return matriceadj;
    }

    public int[][] distance(){// calcul les distance de secteur pour chaque secteur distant de l'objectif
        // probleme de zone morte dans le coin haut gauche du a la methode
        ArrayList<int[]> file = new ArrayList<int[]>();
        file.add(new int[]{this.batiment.getPos()[0],
                           this.batiment.getPos()[1]});
        int[][] dis = matricedistance();
        dis[this.batiment.getPos()[0]][this.batiment.getPos()[1]] = 0;
        while (file.size() > 0) {
            int[] ele = file.get(0);
            int[][] voisin = attenantes(ele);
            for (int i = 0; i < 4; i++) {
                if (dis[voisin[i][0]][voisin[i][1]] == -1) {
                    file.add(voisin[i]);
                    dis[voisin[i][0]][voisin[i][1]] = dis[ele[0]][ele[1]] + 1;
                }
            }
            file.remove(0);
        }
        String mondeAfficher = "";
        for (int i = 0; i < 10; i++) {
            mondeAfficher+= "\n";
            for (int j = 0; j < 10; j++) {
                mondeAfficher += "|"+ dis[i][j]+"\t";
            }
        }
        System.out.println(mondeAfficher);
        return dis;
    }
    public int resolution() { // fonctionne comme une pile generer des action de deplacement
        System.out.println("respm");
        int indice = 0;
        int[][] dis = distance();
        int[] tmp = new int[]{Rb.getPosition()[0], Rb.getPosition()[1]};
        if (tmp[0] + 1 < 10 && tmp[1] - 1 >= 0 && tmp[1] + 1 < 10) {
            System.out.println("next");
            /*
            System.out.println("\n");
            System.out.println("condition 1");
            System.out.println("x:" + tmp[0] + "; y :" + tmp[1]);
            System.out.println("Rb coord : " + Rb.getPosition()[0] + "," + Rb.getPosition()[1]);
            System.out.println("batiement coord : " + batiment.getPos()[0] + " , " + batiment.getPos()[1]);
            System.out.println("sa distance :" + dis[tmp[0]][tmp[1]]);
            System.out.println("distancenord: " + dis[tmp[0] - 1][tmp[1]]);
            System.out.println("distancesud : " + dis[tmp[0] + 1][tmp[1]]);
            System.out.println("distanceest : " + dis[tmp[0]][tmp[1] + 1]);
            System.out.println("distancewest : " + dis[tmp[0]][tmp[1] - 1]);

             */
            int[] distancesX = new int[]{tmp[0] - 1, tmp[0] + 1, tmp[0], tmp[0]};
            int[] distancesY = new int[]{tmp[1], tmp[1], tmp[1] + 1, tmp[1] - 1};
            int[] min = new int[]{distancesX[0], distancesY[0]};
            for (int i = 0; i < 3; i++) {
                if (dis[distancesX[i]][distancesY[i]] <= dis[min[0]][min[1]] && dis[distancesX[i]][distancesY[i]] != -1) {
                    min[0] = distancesX[i];
                    min[1] = distancesY[i];
                    indice = i;
                }
            }
            if (Rb.getStock() == Rb.getCapacitee()) {
                if (((Terre) world.getMonde()[Rb.getPosition()[0]][Rb.getPosition()[1]]).getLocals()[0] instanceof Entrepot) {
                    indice = 5;
                }
                else if (((Terre) world.getMonde()[Rb.getPosition()[0]][Rb.getPosition()[1]]).getLocals()[0] instanceof Mine) {
                    if (Rb.getTypeMateriau() == world.getEntrepotList()[0].getTypeMateriau()){
                        this.batiment=world.getEntrepotList()[0];
                        distancebatiment();
                    }else{
                        this.batiment=world.getEntrepotList()[1];
                        distancebatiment();
                    }
                }
            }
            else if (((Terre) world.getMonde()[Rb.getPosition()[0]][Rb.getPosition()[1]]).getLocals()[0] instanceof Mine &&
                    Rb.getStock() <= Rb.getCapacitee() &&
                    ((Terre) world.getMonde()[Rb.getPosition()[0]][Rb.getPosition()[1]]).getLocals()[0].getType().equals(Rb.getTypeMateriau())) {
                indice = 4;
            }
        }
        System.out.println("next2");
        return indice;
    }

    public Robot getRb() {
        return Rb;
    }
    public void setNwRb(Robot rb){
        this.Rb=rb;
    }

}
