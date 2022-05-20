package com.example.javafxterraria;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class GestionEvent implements EventHandler {

    private Fenetre fenetre;

    public GestionEvent(Fenetre fenetre){
        this.fenetre = fenetre;
    }

    public void handle(Event event){
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
            if(event.getSource() instanceof Button) {
                if (event.getSource().toString().contains("Quitter")) {
                    fenetre.show();
                }
            }
        }
    }
}