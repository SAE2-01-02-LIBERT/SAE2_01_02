package com.example.terrariafx;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MondeGUI {
    private Monde world;

    public void MondeGui(){
         world = new Monde();
         world.creerMonde();
         setGrille();
    }

    public GridPane setGrille(){
        GridPane grille = new GridPane();

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                Rectangle rec = new Rectangle(60, 60);
                if((i % 2 == 0 && j % 2 == 0) || (i % 2 !=0 && j % 2 !=0)){
                    rec.setFill(Color.GREY);
                }
                else{
                    rec.setFill(Color.BLACK);
                }
                GridPane.setRowIndex(rec, i);
                GridPane.setColumnIndex(rec, j);
                grille.getChildren().add(rec);
            }
        }
        return grille;
    }



}
