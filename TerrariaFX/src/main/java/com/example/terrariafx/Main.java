package com.example.terrariafx;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage stage) throws Exception {
        Jeu jeu = new Jeu();
        Menu menu = new Menu();
        menu.setJeu(jeu);
        GestionEvent gestionEvent = new GestionEvent(menu, jeu);
        jeu.setGestionEvent(gestionEvent);
        menu.show();
    }
    public static void main(String[] args){launch(args);}
}
