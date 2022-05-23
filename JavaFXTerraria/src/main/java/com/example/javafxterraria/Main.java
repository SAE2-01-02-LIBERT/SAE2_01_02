package com.example.javafxterraria;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage stage) throws Exception {
        Monde monde=new Monde(1000);
        monde.creer_monde();
        Fenetre fenetre = new Fenetre(monde);
        Jeu jeu = new Jeu(monde);
    }

    public static void main(String[] args){launch(args);}
}
