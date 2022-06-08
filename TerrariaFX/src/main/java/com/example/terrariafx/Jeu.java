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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ExecutionException;

public class Jeu extends Stage{

    private AI IA;
    private Menu menu;
    private GestionEvent gestionEvent;
    private MondeGUI mondeGUI;
    private Robot rbch;
    private VBox infogame;
    private int tour;
    private Text afficherRobot;
    private boolean auto;

    public Jeu() throws ExecutionException {
        super();
        auto = false;
        this.setTitle("Robot Mineur");
        Button end = new Button("Fin");
        Button stop = new Button("Stop Auto");
        Button autojeu = new Button("Auto-Jeu");
        Stage temp = this;
        Group root = new Group();
        ImageView font = new ImageView(new Image("partie.png"));
        root.getChildren().add(font);
        end.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                score();
                temp.close();
            }
        });
        autojeu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                auto = true;
            }
        });
        stop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                auto = false;
            }
        });

        VBox gauche = new VBox();
        VBox droite = new VBox();
        HBox hbox = new HBox();

        this.mondeGUI = new MondeGUI();
        gauche.getChildren().add(mondeGUI.setGrille());

        hbox.getChildren().add(gauche);
        hbox.getChildren().add(droite);
        hbox.setPadding(new Insets(30,10,0, 30));
        // ajouter des label || bouton pour les numero de secteur

        this.infogame = new VBox();
        VBox boutons = new VBox();

        boutons.setPadding(new Insets(0,20,15, 0));

        ArrayList<Text> txt = new ArrayList<Text>();
        txt.add(new Text("  Select robot"));
        txt.add(new Text("  Aller vers le Nord"));
        txt.add(new Text("  Aller vers le Sud"));
        txt.add(new Text("  Aller vers l'Ouest"));
        txt.add(new Text("  Aller vers l'Est"));
        txt.add(new Text("  Recolter"));
        txt.add(new Text("  Deposer"));
        for (int i = 0; i <= 6; i++) {
            HBox cmd = new HBox();
            cmd.getChildren().add(new ImageView(new Image("btn" + i + ".png")));
            cmd.getChildren().add(txt.get(i));
            boutons.getChildren().add(cmd);
        }

        this.rbch = mondeGUI.getWorld().getRoboList()[0];

        Text info  = new Text(mondeGUI.getMonde().GetInfo(tour));
        afficherRobot = new Text("Robot selectionne : "+this.rbch.getnum());
        info.setFont(Font.font("Arial", 11));
        afficherRobot.setFont(Font.font("Arial", 11));
        this.infogame.getChildren().add(boutons);
        this.infogame.getChildren().add(info);
        this.infogame.getChildren().add(afficherRobot);
        this.infogame.getChildren().add(end);
        if(!auto) {
            this.infogame.getChildren().add(autojeu);
        }
        else {
            this.infogame.getChildren().add(stop);
        }

        infogame.setLayoutX(820);
        infogame.setLayoutY(60);

        root.getChildren().addAll(hbox,infogame);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(new GestionEventActionRobot(mondeGUI.getMonde(),this,rbch, afficherRobot));
        this.sizeToScene();
        this.setScene(scene);
    }
    public void setGestionEvent(GestionEvent g){
        gestionEvent = g;
    }
    public void setMenu(Menu menu){
        this.menu = menu;
    }

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

    public ArrayList<Text> didacticiel() {
        ArrayList<Text> txt = new ArrayList<Text>();
        txt.add(new Text("  Select robot"));
        txt.add(new Text("  Aller vers le Nord"));
        txt.add(new Text("  Aller vers le Sud"));
        txt.add(new Text("  Aller vers l'Ouest"));
        txt.add(new Text("  Aller vers l'Est"));
        txt.add(new Text("  Recolter"));
        txt.add(new Text("  Deposer"));
        for (int i = 0; i <= 6; i++) {
            HBox cmd = new HBox();
            cmd.getChildren().add(new ImageView(new Image("btn" + i + ".png")));
            cmd.getChildren().add(txt.get(i));
            this.infogame.getChildren().add(cmd);
        }
        return txt;
    }

    public VBox actualiserinfop(){
        Button end = new Button("Fin");
        Button autojeu = new Button("Auto-Jeu");
        Button stop = new Button("Stop Auto");
        Stage temp = this;
        end.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                score();
                temp.close();
            }
        });
        autojeu.setOnMouseClicked(new GestionEventAvtionRobotAI(mondeGUI.getMonde(),this,afficherRobot));
        stop.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                auto = false;
            }
        });


        this.infogame.getChildren().clear();
        ArrayList<Text> didac = didacticiel();
        Text info = new Text();
        info.setText(mondeGUI.getMonde().GetInfo(tour));
        Text robot = new Text("Robot selectionne : "+this.rbch.getnum());
        info.setFont(Font.font("Arial", 11));
        robot.setFont(Font.font("Arial", 11));
        infogame.getChildren().add(info);
        infogame.getChildren().add(robot);
        this.infogame.getChildren().add(end);
        if(!auto) {
            this.infogame.getChildren().add(autojeu);
        }
        else {
            this.infogame.getChildren().add(stop);
        }
        return infogame;
    }
    public void score() {
        if (mondeGUI.stockRestantinmine() == 0 && mondeGUI.mineraisinRobot() == 0) {
            new FenetreScore(mondeGUI.stockinEntrepot("OR"), 0, mondeGUI.stockinEntrepot("NI"), 0, tour);
        }
        else{
            new FenetreScore((mondeGUI.stockinEntrepot("OR") + mondeGUI.stockinRobot("OR")), mondeGUI.Orestant(), (mondeGUI.stockinEntrepot("NI") + mondeGUI.stockinRobot("NI")), mondeGUI.Niestant(), tour);
        }
    }
}
