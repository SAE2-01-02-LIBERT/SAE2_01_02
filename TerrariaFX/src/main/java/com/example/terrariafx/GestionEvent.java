package com.example.terrariafx;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class GestionEvent implements EventHandler {

    private Menu menu;
    private Jeu jeu;
    private Information info;

    public GestionEvent(Menu menu, Jeu jeu, Information info){
        this.menu = menu;
        this.jeu = jeu;
        this.info = info;
    }

    public void handle(Event event){
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED && event.getSource() instanceof Button && event.getSource().toString().contains("Quitter")){
            jeu.close();
            info.close();
            menu.show();
        }
    }
}
