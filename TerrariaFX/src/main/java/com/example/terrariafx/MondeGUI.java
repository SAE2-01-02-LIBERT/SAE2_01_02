package com.example.terrariafx;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import java.util.concurrent.ExecutionException;

public class MondeGUI extends GridPane {
    private Monde world;
    private SecteurGUI[][] grille;
    public MondeGUI() throws ExecutionException {
        this.grille = new SecteurGUI[10][10]; ;
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
        Image herbe = new Image("hautesHerbes.png");
        Image eau = new Image("eaucanard.png");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                SecteurGUI sec = new SecteurGUI(world.getMonde()[i][j]);
                if (sec.getsecteurtype().equals("Terre")) {
                    sec.getRectangle().setFill(new ImagePattern(herbe));
                    for (int cptR = 0 ; cptR<world.getNbrRobot() ; cptR++ ) {
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
            }
        }
        this.grille = grille;
    }

    public void updateGrille(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

            }
        }
    }

    public SecteurGUI[][] getGrille(){
        return this.grille;
    }
    public Monde getMonde() {
        return this.world;
    }
    public Monde getWorld() {
        return world;
    }
}
