package com.example.javafxterraria;

import javafx.event.Event;
import javafx.event.EventHandler;

public class GestionEventMenu implements EventHandler {
    private final Monde monde;
    private final Fenetre fenetre;
    private final int i;

    public GestionEventMenu(Monde monde, Fenetre fenetre, int i){
        this.monde=monde;
        this.fenetre=fenetre;
        this.i=i;
    }
    @Override
    public void handle(Event event) {
        if(i == 1){
            Jeu jeu = new Jeu(monde);
            jeu.show();
            fenetre.close();
        }
        if(i == 2){
            fenetre.close();
        }
    }
}
