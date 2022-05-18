package com.example.terrariafx;

import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SecteurGUI extends Rectangle {
        private Secteur secteur;
        private Rectangle rectangle;

        private Robot rb;
        private Batiment batiment;

        public SecteurGUI(Secteur s){
                this.secteur = s;
                this.rectangle = new Rectangle(50,50);
        }
        public Secteur getSecteur() {
                return secteur;
        }
        public String getsecteurtype(){
                return secteur.gettype();
        }

        public Rectangle getRectangle(){
                return this.rectangle;
        }
}