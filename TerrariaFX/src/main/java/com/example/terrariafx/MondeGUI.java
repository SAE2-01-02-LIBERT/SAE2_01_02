package com.example.terrariafx;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class MondeGUI extends GridPane {
    private Monde world;
    private GridPane grille;

    public MondeGUI() {
        this.grille =new GridPane(); ;
        this.world = new Monde();
        world.creerMonde();

    }

    public void setGrille() {
        GridPane grille = new GridPane();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                SecteurGUI sec = new SecteurGUI(world.getMonde()[i][j]);
                if (sec.getsecteurtype().equals("Terre")) {
                    sec.getRectangle().setStyle("terre.png");
                }
                else {
                    sec.getRectangle().setStyle("eau.png");
                }
                GridPane.setRowIndex(sec.getRectangle(), i);
                GridPane.setColumnIndex(sec.getRectangle(), j);
                grille.getChildren().addAll(sec.getRectangle());
            }
        }
        this.grille = grille;
    }
    public GridPane getGrille(){
        return this.grille;
    }
}
