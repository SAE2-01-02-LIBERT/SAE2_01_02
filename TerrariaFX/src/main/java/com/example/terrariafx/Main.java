package com.example.terrariafx;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage stage) throws Exception {

        Jeu jeu = new Jeu();
        Menu menu = new Menu();
        Information info = new Information();
        menu.setInfo(info);
        info.setMenu(menu);
        menu.setJeu(jeu);
        jeu.setMenu(menu);
        jeu.setInfo(info);
        GestionEvent gestionEvent = new GestionEvent(menu, jeu,info);
        jeu.setGestionEvent(gestionEvent);
        menu.show();
    }
    public static void main(String[] args){launch(args);}
}