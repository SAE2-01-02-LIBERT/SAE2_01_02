package com.example.terrariafx;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.util.concurrent.ExecutionException;

public class GestionEventAvtionRobotAI implements EventHandler  {

    private  Jeu jeu;
    private  Monde monde; //redondance d'info
    private int Rbsect;
    private Text afficherRobot;
    private AI ia;

    public GestionEventAvtionRobotAI(Monde monde, Jeu jeu,Text aR,AI ia) {
        this.monde=monde;
        this.jeu=jeu;
        this.afficherRobot=aR;
        this.ia=ia;
        this.Rbsect = jeu.getRbch().getnum();
    }
    @Override
    public void handle(Event event) {
        int action = ia.resolution();

        if (event.getSource().toString().contains("Auto-Jeu")) {
            try {
                if (action == 0) {
                    monde.actionRobot(jeu.getRbD(), "N");
                    jeu.getMondeGUI().setGrille();

                    jeu.setRbD(monde.getRoboList()[Rbsect-1]);
                    jeu.getIa().setNwRb(jeu.getRbch());
                    jeu.setTour();
                    jeu.actualiserinfop();

                    if (jeu.getMondeGUI().mineraisinRobot() == 0 && jeu.getMondeGUI().stockRestantinmine() == 0) {
                        jeu.score();
                    }
                }
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        } else if (action == 1) {
            try {
                monde.actionRobot(jeu.getRbD(), "S");
                jeu.getMondeGUI().setGrille();
                jeu.setRbD(monde.getRoboList()[Rbsect-1]);
                jeu.getIa().setNwRb(jeu.getRbch());

                jeu.setTour();
                jeu.actualiserinfop();
                if (jeu.getMondeGUI().mineraisinRobot() == 0 && jeu.getMondeGUI().stockRestantinmine() == 0) {
                    jeu.score();
                }
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        } else if (action == 3) {
            try {
                monde.actionRobot(jeu.getRbD(), "O");
                jeu.getMondeGUI().setGrille();
                jeu.setRbD(monde.getRoboList()[Rbsect-1]);
                jeu.getIa().setNwRb(jeu.getRbch());
                jeu.setTour();
                jeu.actualiserinfop();
                if (jeu.getMondeGUI().mineraisinRobot() == 0 && jeu.getMondeGUI().stockRestantinmine() == 0) {
                    jeu.score();
                }
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        } else if (action == 2) {
            try {
                monde.actionRobot(jeu.getRbD(), "E");
                jeu.getMondeGUI().setGrille();
                jeu.setRbD(monde.getRoboList()[Rbsect-1]);
                jeu.getIa().setNwRb(jeu.getRbch());
                jeu.setTour();
                jeu.actualiserinfop();
                if (jeu.getMondeGUI().mineraisinRobot() == 0 && jeu.getMondeGUI().stockRestantinmine() == 0) {
                    jeu.score();
                }
            }catch(ExecutionException e){
                throw new RuntimeException(e);
            }
        }
        else if (action==4) {
            try {
                    monde.actionRobot(jeu.getRbD(), "R");
                    jeu.getMondeGUI().setGrille();
                    jeu.setRbD(monde.getRoboList()[Rbsect-1]);
                    jeu.setTour();
                    jeu.actualiserinfop();
                    if(jeu.getMondeGUI().mineraisinRobot()==0 && jeu.getMondeGUI().stockRestantinmine()== 0 ){
                        jeu.score();
                    }
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        else if (action==5) {
                try {
                    monde.actionRobot(jeu.getRbD(), "D");
                    jeu.getMondeGUI().setGrille();
                    jeu.setRbD(monde.getRoboList()[Rbsect-1]);
                    jeu.setTour();
                    System.out.println(jeu.getTour());
                    jeu.actualiserinfop();
                    if(jeu.getMondeGUI().mineraisinRobot()==0 && jeu.getMondeGUI().stockRestantinmine()== 0 ){
                        jeu.score();
                    }
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }

    }

}

