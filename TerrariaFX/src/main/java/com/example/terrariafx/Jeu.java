package com.example.terrariafx;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Jeu extends Stage{
    private Menu menu;
    private GestionEvent gestionEvent;
    public Jeu(){
        super();
        this.setTitle("Robot Mineur");
        Button end = new Button("Fin");
        Stage temp = this;
        end.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FenetreScore score = new FenetreScore(menu,3, 10, 4, 20, 5);
                score.show();
                temp.close();
            }
        });
        MondeGUI grille = new MondeGUI();
        grille.setGrille();
        VBox gauche = new VBox();
        VBox droite = new VBox();
        HBox hbox = new HBox();
        gauche.getChildren().add(grille);
        droite.getChildren().add(end);
        hbox.getChildren().add(gauche);
        hbox.getChildren().add(droite);
        Scene scene = new Scene(hbox);
        this.sizeToScene();
        this.setScene(scene);
    }
    public void setGestionEvent(GestionEvent g){
        gestionEvent = g;
    }
    public void setMenu(Menu menu){
        this.menu = menu;
    }
}
