package com.example.terrariafx;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Menu extends Stage{
    private Jeu jeu;
    public Menu() {
        super();
        this.setTitle("Robot Mineur");
        Image image = new Image("menu.png");
        ImageView bg = new ImageView(image);
        Rectangle play = new Rectangle(315, 466, 167, 72);
        Rectangle quit = new Rectangle(315, 546, 167, 72);
        play.setFill(Color.TRANSPARENT);
        quit.setFill(Color.TRANSPARENT);

        Group root = new Group();
        root.getChildren().add(bg);
        root.getChildren().add(play);
        root.getChildren().add(quit);
        Stage temp = this;
        play.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                temp.close();
                jeu.show();
            }
        });
        quit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                temp.close();
            }
        });

        Scene scene = new Scene(root);
        this.setScene(scene);
        this.setResizable(false);
    }

    public void setJeu(Jeu j){
        jeu = j;
    }
}
