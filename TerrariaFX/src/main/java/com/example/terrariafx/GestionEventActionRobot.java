package com.example.terrariafx;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.util.concurrent.ExecutionException;

public class GestionEventActionRobot implements EventHandler<KeyEvent> {
    private final Jeu jeu;
    private final Monde monde;
    private Robot rob;

    public GestionEventActionRobot(Monde monde, Jeu jeu, Robot r) {
        this.monde = monde;
        this.jeu = jeu;
        this.rob = r;
    }

    @Override
    public void handle(KeyEvent k) {
        if (k.getText().equals("&")) {
            rob = monde.getRoboList()[0];
            jeu.setRbD(rob);
        } else if (k.getText().equals("é")) {
            rob = monde.getRoboList()[1];
            jeu.setRbD(rob);
        } else if (k.getText().equals(Character.toString((char) 34))) {
            if (monde.getNbrRobot() >= 3) {
                rob = monde.getRoboList()[2];
                jeu.setRbD(rob);
            }
        } else if (k.getText().equals("'")) {
            if (monde.getNbrRobot() >= 4) {
                rob = monde.getRoboList()[3];
                jeu.setRbD(rob);
            }
        } else if (k.getText().equals("(")) {
            if (monde.getNbrRobot() >= 5) {
                rob = monde.getRoboList()[4];
                jeu.setRbD(rob);
            }
        } else if (k.getText().equals("-")) {
            if (monde.getNbrRobot() >= 6) {
                rob = monde.getRoboList()[5];
                jeu.setRbD(rob);
            }
        } else if (k.getText().equals("è")) {
            if (monde.getNbrRobot() >= 7) {
                rob = monde.getRoboList()[6];
                jeu.setRbD(rob);
            }
        } else if (k.getText().equals("_")) {
            if (monde.getNbrRobot() >= 8) {
                rob = monde.getRoboList()[7];
                jeu.setRbD(rob);
            }
        } else if (k.getText().equals("ç")) {
            if (monde.getNbrRobot() >= 9) {
                rob = monde.getRoboList()[8];
                jeu.setRbD(rob);
            }
        } else if (k.getText().equals("à")) {
            if (monde.getNbrRobot() >= 10) {
                rob = monde.getRoboList()[9];
                jeu.setRbD(rob);
            }
        } else if (k.getText().equals("z")) {
            try {
                monde.actionRobot(jeu.getRbD(),"N");
                jeu.getMondeGUI().updateGrille();

            } catch (ExecutionException e) {

                throw new RuntimeException(e);
            }

        }
        else if (k.getText().equals("s")) {
            try {
                monde.actionRobot(jeu.getRbD(), "S");
                jeu.getMondeGUI().updateGrille();

            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }

        }
        else if (k.getText().equals("q")) {
            try {
                monde.actionRobot(jeu.getRbD(), "O");
                jeu.getMondeGUI().updateGrille();
                jeu.setTour();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }

        } else if (k.getText().equals("d")) {
            try {
                monde.actionRobot(jeu.getRbD(), "E");
                jeu.getMondeGUI().updateGrille();
                jeu.setTour();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        else if (k.getText().equals("e")) {
            try {
                monde.actionRobot(jeu.getRbD(), "R");
                jeu.getMondeGUI().updateGrille();
                jeu.setTour();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        } else if (k.getText().equals("f")) {
            try {
                monde.actionRobot(jeu.getRbD(), "R");
                jeu.getMondeGUI().updateGrille();
                jeu.setTour();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
