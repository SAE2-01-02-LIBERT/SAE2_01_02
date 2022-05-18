package com.example.terrariafx;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SecteurGUI extends VBox {
        private Secteur secteur;
        private VBox vblocal;

        public SecteurGUI(Secteur s){
                this.secteur = s;
                this.vblocal = new VBox();
        }
        public Secteur getSecteur() {
                return secteur;
        }
        public String getsecteurtype(){
                return secteur.gettype();
        }
}