package com.example.javafxterraria;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.security.Key;

public class GestionEventGame implements EventHandler<KeyEvent> {
    private final Jeu jeu;
    private final Monde monde;
    private Robot rob;

    public GestionEventGame(Monde monde, Jeu jeu, Robot r) {
        this.monde = monde;
        this.jeu = jeu;
        this.rob = r;
    }

    @Override
    public void handle(KeyEvent k) {
        if (k.getText().equals("&")) {
            rob = monde.getRoboList()[0];
            jeu.set_rob(rob);
            jeu.chosen_robot();
        } else if (k.getText().equals("é")) {
            rob = monde.getRoboList()[1];
            jeu.set_rob(rob);
            jeu.chosen_robot();
        } else if (k.getText().equals(Character.toString((char) 34))) {
            if (monde.getRoboList().length >= 3) {
                rob = monde.getRoboList()[2];
                jeu.set_rob(rob);
                jeu.chosen_robot();
            }
        } else if (k.getText().equals("'")) {
            if (monde.getRoboList().length >= 4) {
                rob = monde.getRoboList()[3];
                jeu.set_rob(rob);
                jeu.chosen_robot();
            }
        } else if (k.getText().equals("(")) {
            if (monde.getRoboList().length >= 5) {
                rob = monde.getRoboList()[4];
                jeu.set_rob(rob);
                jeu.chosen_robot();
            }
        } else if (k.getText().equals("-")) {
            if (monde.getRoboList().length >= 6) {
                rob = monde.getRoboList()[5];
                jeu.set_rob(rob);
                jeu.chosen_robot();
            }
        } else if (k.getText().equals("è")) {
            if (monde.getRoboList().length >= 7) {
                rob = monde.getRoboList()[6];
                jeu.set_rob(rob);
                jeu.chosen_robot();
            }
        } else if (k.getText().equals("_")) {
            if (monde.getRoboList().length >= 8) {
                rob = monde.getRoboList()[7];
                jeu.set_rob(rob);
                jeu.chosen_robot();
            }
        } else if (k.getText().equals("ç")) {
            if (monde.getRoboList().length >= 9) {
                rob = monde.getRoboList()[8];
                jeu.set_rob(rob);
                jeu.chosen_robot();
            }
        } else if (k.getText().equals("à")) {
            if (monde.getRoboList().length >= 10) {
                rob = monde.getRoboList()[9];
                jeu.set_rob(rob);
                jeu.chosen_robot();
            }
        } else if (k.getText().equals("z")) {
            boolean b = rob.nord();
            if (b) {
                jeu.nb_tour();
                jeu.Matrice(147, 175);
                jeu.get_infoJeu(950,250);
            }
        } else if (k.getText().equals("s")) {
            boolean b = rob.sud();
            if (b) {
                jeu.nb_tour();
                jeu.Matrice(147, 175);
                jeu.get_infoJeu(950,250);
            }
        } else if (k.getText().equals("q")) {
            boolean b = rob.ouest();
            if (b) {
                jeu.nb_tour();
                jeu.Matrice(147, 175);
                jeu.get_infoJeu(950,250);
            }
        } else if (k.getText().equals("d")) {
            boolean b = rob.est();
            if (b) {
                jeu.nb_tour();
                jeu.Matrice(147, 175);
                jeu.get_infoJeu(950,250);
            }
        } else if (k.getText().equals("e")) {
            boolean b = rob.vider();
            if (b) {
                jeu.nb_tour();
                jeu.Matrice(147, 175);
                jeu.get_infoJeu(950,250);
            }
        } else if (k.getText().equals("f")) {
            boolean b = rob.mine();
            if (b) {
                jeu.nb_tour();
                jeu.Matrice(147, 175);
                jeu.get_infoJeu(950,250);
            }
        }
    }
}