package com.example.terrariafx;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class SecteurGUI {

        private Secteur secteur;
        private StackPane Bufferbutton;
        private Rectangle rectangle;
        private Button batimentB;
        private Button robotB;
        private Robot rb;
        private Batiment batiment;

        public SecteurGUI(Secteur s) {
                this.secteur = s;
                this.batimentB = new Button("    ");
                batimentB.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
                this.robotB = new Button("    ");
                robotB.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
                VBox elet = new VBox();
                elet.getChildren().add(batimentB);
                elet.getChildren().add(robotB);
                this.rectangle = new Rectangle(76, 76);
                this.Bufferbutton = new StackPane(rectangle, elet);
        }

        public Secteur getSecteur() {
                return secteur;
        }

        public String getsecteurtype() {
                return secteur.gettype();
        }

        public Rectangle getRectangle() {
                return this.rectangle;
        }

        public StackPane getBufferbutton() {
                return this.Bufferbutton;
        }

        public void setRb(Robot rb) {
                this.rb = rb;

                if (rb.getTypeMateriau() == "OR") {
                        ImageView view =new ImageView(new Image("robot1or.png"));
                        view.setFitHeight(60);
                        view.setPreserveRatio(true); //permet de ne pas étirer les boutons
                        view.setFitHeight(30);
                        this.robotB.setGraphic(view);
                } else {
                        ImageView view =new ImageView(new Image("robot1nickel.png"));
                        view.setFitHeight(60);
                        view.setPreserveRatio(true); //permet de ne pas étirer les boutons
                        view.setFitHeight(30);
                        this.robotB.setGraphic(view);
                }
        }
        public void setBatiment(Batiment batiment) {
                this.batiment = batiment;
                if (batiment instanceof Mine) {
                        if (batiment.getType() == "Mine") {
                                if (batiment.getTypeMateriau() == "OR") {
                                        ImageView view = new ImageView(new Image("mineor (1).png"));
                                        view.setFitHeight(60);
                                        view.setPreserveRatio(true); //permet de ne pas étirer les boutons
                                        view.setFitHeight(30);
                                        this.batimentB.setGraphic(view);
                                } else {
                                        ImageView view = new ImageView(new Image("minenickel (1).png"));
                                        view.setFitHeight(60);
                                        view.setPreserveRatio(true); //permet de ne pas étirer les boutons
                                        view.setFitHeight(30);
                                        this.batimentB.setGraphic(view);
                                }
                        }
                } else {
                        if (batiment instanceof Entrepot) {
                                if (batiment.getType() == "Entrepot") {
                                        if (batiment.getTypeMateriau() == "OR") {
                                                ImageView view = new ImageView(new Image("entrepotor.png"));
                                                view.setFitHeight(60);
                                                view.setPreserveRatio(true); //permet de ne pas étirer les boutons
                                                view.setFitHeight(30);
                                                this.batimentB.setGraphic(view);
                                        } else {
                                                ImageView view = new ImageView(new Image("entrepotniquel.png"));
                                                view.setFitHeight(60);
                                                view.setPreserveRatio(true); //permet de ne pas étirer les boutons
                                                view.setFitHeight(30);
                                                this.batimentB.setGraphic(view);
                                        }
                                }
                        }
                }
        }
        public void updateSecteur(){
                if (rb.getPosition()[0]!= secteur.getposition()[0] || rb.getPosition()[1]!= secteur.getposition()[1]){
                        this.robotB.setGraphic(null);
                        this.rb = null;
                }
        }

}

