package com.example.terrariafx;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.util.concurrent.ExecutionException;

public class GestionEventAvtionRobotAI implements EventHandler  {

    private  Jeu jeu;
    private  Monde monde; //redondance d'info

    private Robot roborIa;

    private String Rbsect;
    private Text afficherRobot;

    private AI ia;

    public GestionEventAvtionRobotAI(Monde monde, Jeu jeu, Text aR) {
        this.monde=monde;
        this.jeu=jeu;
        this.afficherRobot=aR;
        this.ia = new AI(monde);
        this.roborIa = ia.getRb();
    }

    @Override
    public void handle(Event event) {
        if(event.getSource().toString().contains("")){

        }

    }
}