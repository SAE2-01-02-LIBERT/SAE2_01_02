package com.example.terrariafx;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.ExecutionException;

public class Jeu extends Stage{
    private Menu menu;
    private Information info;
    private GestionEvent gestionEvent;
    private MondeGUI mondeGUI;
    private Robot rbch;
    private int tour;
    public Jeu() throws ExecutionException {
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
                info.close();
            }
        });

        VBox gauche = new VBox();
        VBox droite = new VBox();
        HBox hbox = new HBox();
        this.mondeGUI = new MondeGUI();
        droite.getChildren().add(end);

        gauche.getChildren().add(mondeGUI.setGrille());

        hbox.getChildren().add(gauche);
        hbox.getChildren().add(droite);
        hbox.setPadding(new Insets(30,30,30,30));
        Scene scene = new Scene(hbox);
        this.rbch=mondeGUI.getWorld().getRoboList()[0];
        scene.setOnKeyPressed(new GestionEventActionRobot(mondeGUI.getMonde(),this,rbch));
        this.sizeToScene();
        this.setScene(scene);
    }
    public void setGestionEvent(GestionEvent g){
        gestionEvent = g;
    }
    public void setMenu(Menu menu){
        this.menu = menu;
    }
    public void setInfo(Information info) {this.info = info;}

    public void setRbD(Robot rb){
        this.rbch=rb;
    }
    public Robot getRbD(){
        return rbch;
    }
    public MondeGUI getMondeGUI(){
        return mondeGUI;
    }

    public int getTour(){
        return this.tour;
    }
    public void setTour(){
        tour+=1 ;
    }

}