package com.example.terrariafx;

import javafx.scene.layout.GridPane;

public class MondeGUI extends GridPane {
    private Monde world;

    public MondeGUI() {
        this.world = new Monde();
        world.creerMonde();
    }

    public GridPane setGrille() {

        GridPane grille = new GridPane();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                SecteurGUI sec = new SecteurGUI(world.getMonde()[i][j]);

                if (sec.getsecteurtype().equals("Terre")) {
                    sec.setStyle("file:Sprites/terre.png");
                    grille.getChildren().add(sec);
                } else {
                    sec.setStyle("file:Sprites/eau.png");
                    grille.getChildren().add(sec);
                }
            }
        } return grille;
    }
}
