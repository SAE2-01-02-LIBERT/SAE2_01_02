package com.example.terrariafx;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.Collator;
import java.util.Stack;
import java.util.concurrent.ExecutionException;

public class Jeu extends Stage{
    private Menu menu;
    private Information info;
    private GestionEvent gestionEvent;
    private MondeGUI mondeGUI;
    private Robot rbch;
    private VBox infogame;
    private int tour;
    public Jeu() throws ExecutionException {
        super();
        this.setTitle("Robot Mineur");
        Button end = new Button("Fin");
        Stage temp = this;
        Group root = new Group();
        ImageView font = new ImageView(new Image("partie.png"));
        root.getChildren().add(font);
        end.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FenetreScore score = new FenetreScore(menu,mondeGUI.getMonde().getEntrepotList()[0].getStock(), mondeGUI.getMonde().getEntrepotList()[0].getStock(), getTour());
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
        // ajouter des label || bouton pour les numero de secteur


        Text info  = new Text(mondeGUI.getMonde().GetInfo(tour));
        this.infogame = new VBox(info);

        infogame.setLayoutX(800);
        infogame.setLayoutY(300);

        root.getChildren().addAll(hbox,infogame);

        Scene scene = new Scene(root);
        this.rbch = mondeGUI.getWorld().getRoboList()[0];
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

    public VBox actualiserinfop(){
        this.infogame.getChildren().clear();
        Text info = new Text();
        info.setText(mondeGUI.getMonde().GetInfo(tour));
        infogame.getChildren().add(info);
        return infogame;
    }
    public void score() {
        if (mondeGUI.stockRestantinmine() == 0 && mondeGUI.mineraisinRobot() == 0) {
            new FenetreScore(menu, mondeGUI.stockinEntrepot("OR"), 0, mondeGUI.stockinEntrepot("NI"), 0, tour);
        }
        else{
            new FenetreScore(menu, mondeGUI.stockinEntrepot("OR") + mondeGUI.stockinRobot("OR"), mondeGUI.Orestant(), mondeGUI.stockinEntrepot("NI") + mondeGUI.stockinRobot("NI"), mondeGUI.Orestant(), tour);
        }
    }
}

