package com.example.terrariafx;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import java.util.concurrent.ExecutionException;

public class MondeGUI {
    private Monde world;
    private SecteurGUI[][] grille;
    private VBox grilleVb;
    public MondeGUI() throws ExecutionException {
        this.grille = new SecteurGUI[10][10]; ;
        grilleVb = new VBox();
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
    public Node setGrille() {
        grilleVb.getChildren().clear();
        Image herbe = new Image("hautesHerbes.png");
        Image eau = new Image("eaucanard.png");
        for (int i = 0; i < 10; i++) {
            HBox hBox = new HBox();
            hBox.setSpacing(1);
            for (int j = 0; j < 10; j++) {

                SecteurGUI sec = new SecteurGUI(world.getMonde()[i][j]);
                grille[i][j] = sec;

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
                }
                else {sec.getRectangle().setFill(new ImagePattern(eau));}
                hBox.getChildren().add(sec.getBufferbutton());
            }
            grilleVb.getChildren().add(hBox);
        }
        grilleVb.setSpacing(1);
        return grilleVb;
    }

    public VBox getGrilleVb(){
        return this.grilleVb;
    }

    public SecteurGUI getSecteurGui(int i, int j){
        return this.grille[i][j];
    }
    public Monde getMonde() {
        return this.world;
    }
    public Monde getWorld() {
        return world;
    }

    public int stockinRobot(String type){
        int stock = 0;
        for(Robot r : world.getRoboList()){
            if (r.getType().equals(type)) {
                stock += r.getStock();
            }
        }
        return stock;
    }

    public int stockinEntrepot(String type){
        int stock = 0;
        for(Entrepot e : world.getEntrepotList()){
            if (e.getType().equals(type)) {
                stock += e.getStock();
            }
        }
        return stock;
    }

    public int stockRestantinmine(){
        int stock = 0;
        for(Mine mine : world.getMineList()){
            stock+= mine.getStock();
        }
        return stock;
    }
    public int mineraisinRobot(){
        int stock = 0;
        for(int i = 0; i < world.getNbrRobot(); i++){
            Robot Rb = world.getRoboList()[i];
            stock+=Rb.getStock();
        }
        return stock;
    }

    public int Orestant(){
        int stock= 0;
        for(Mine mine : world.getMineList()){
            if (mine.getType().equals("OR")){
                stock += mine.getStock();
            }
        }
        return stock;
    }
    public int Niestant(){
        int stock= 0;
        for(Mine mine : world.getMineList()){
            if (mine.getType().equals("NI")){
                stock += mine.getStock();
            }
        }
        return stock;
    }

}
