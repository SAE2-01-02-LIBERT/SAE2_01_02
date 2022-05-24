package com.example.terrariafx;

import javafx.geometry.BoundingBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class MondeGUI extends GridPane {
    private Monde world;
    private GridPane grille;

    public MondeGUI() throws ExecutionException {
        this.grille =new GridPane(); ;
        this.world = new Monde();
        this.genererMonde();
    }
    public void genererMonde() throws ExecutionException {
        world.creerMonde();
        world.generationEntrepot();
        world.generationRobot();
        world.generationMine();
        world.ajoutElements();
        setGrille();
        world.affichermonde(0);

    }
    public void setGrille() {
        Image terre = new Image("terre.png");
        Image herbe = new Image("herbe.png");
        Image eau = new Image("eau.png");
        GridPane grille = new GridPane();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                SecteurGUI sec = new SecteurGUI(world.getMonde()[i][j]);
                if (sec.getsecteurtype().equals("Terre")) {
                    sec.getRectangle().setFill(new ImagePattern(terre));

                    for (int cptR=0 ; cptR<world.getNbrRobot() ; cptR++ ) {
                        if (world.getRoboList()[cptR].getPosition()[0] == i && world.getRoboList()[cptR].getPosition()[1] == j) {
                            sec.setRb(world.getRoboList()[cptR]);
                        }
                    }
                    for (Entrepot e : world.getEntrepotList()) {
                        if (e.getPos()[0] == i && e.getPos()[1] == j) {
                            sec.setBatiment(e);
                        }
                    }
                    for (Mine m : world.getMineList()) {
                        if (m.getPos()[0] == i && m.getPos()[1] == j) {
                            sec.setBatiment(m);
                        }
                    }

                } else {
                    sec.getRectangle().setFill(new ImagePattern(eau));
                }
                GridPane.setRowIndex(sec.getBufferbutton(), i);
                GridPane.setColumnIndex(sec.getBufferbutton(), j);
                grille.getChildren().addAll(sec.getBufferbutton());
            }
        }
        this.grille = grille;
    }


    public GridPane getGrille(){
        return this.grille;
    }
}
