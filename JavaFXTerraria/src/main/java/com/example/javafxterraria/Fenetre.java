package com.example.javafxterraria;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Fenetre extends Stage {
    private Monde monde;

    public Fenetre(Monde monde){
        this.setTitle("Robot Mineur");
        Image image = new Image("Accueil.png");
        ImageView bg = new ImageView(image);
        Rectangle play = new Rectangle(315, 466, 167, 72);
        Rectangle quit = new Rectangle(315, 546, 167, 72);
        play.setFill(Color.TRANSPARENT);
        quit.setFill(Color.TRANSPARENT);
        Group root = new Group();
        root.getChildren().addAll(bg,play,quit);
        Scene scene = new Scene(root);
        this.setScene(scene);
        this.setResizable(false);
        this.show();
        play.setOnMouseClicked(new GestionEventMenu(monde, this, 1));
        quit.setOnMouseClicked(new GestionEventMenu(monde, this, 2));
    }
}