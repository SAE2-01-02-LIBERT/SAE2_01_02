package com.example.terrariafx;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.util.concurrent.ExecutionException;

public class GestionEventActionRobot implements EventHandler<KeyEvent> {
    private final Jeu jeu;
    private final Monde monde; //redondance d'info
    private String Rbsect;
    private Robot rob;
    private Text afficherRobot;

    public GestionEventActionRobot(Monde monde, Jeu jeu, Robot r, Text aR) {
        this.monde = monde;
        this.jeu = jeu;
        this.Rbsect = "&";
        this.rob = r;
        this.afficherRobot = aR;
    }
    @Override
    public void handle(KeyEvent k) {
        if (k.getText().equals("&")) {
            this.Rbsect= k.getText();
            rob = monde.getRoboList()[0];
            jeu.setRbD(rob);
            afficherRobot = new Text("Robot selectionne : 1");

        } else if (k.getText().equals("é")) {
            this.Rbsect= k.getText();
            rob = monde.getRoboList()[1];
            jeu.setRbD(rob);
            afficherRobot = new Text("Robot selectionne : 2");

        } else if (k.getText().equals(Character.toString((char) 34))) {
            if (monde.getNbrRobot() >= 3) {
                this.Rbsect= k.getText();
                rob = monde.getRoboList()[2];
                jeu.setRbD(rob);
                afficherRobot = new Text("Robot selectionne : 3");
            }

        } else if (k.getText().equals("'")) {
            if (monde.getNbrRobot() >= 4) {
                this.Rbsect= k.getText();
                rob = monde.getRoboList()[3];
                jeu.setRbD(rob);
                afficherRobot = new Text("Robot selectionne : 4");
            }

        } else if (k.getText().equals("(")) {
            if (monde.getNbrRobot() >= 5) {
                this.Rbsect= k.getText();
                rob = monde.getRoboList()[4];
                jeu.setRbD(rob);
                afficherRobot = new Text("Robot selectionne : 5");
            }

        } else if (k.getText().equals("-")) {
            if (monde.getNbrRobot() >= 6) {
                this.Rbsect= k.getText();
                rob = monde.getRoboList()[5];
                jeu.setRbD(rob);
                afficherRobot = new Text("Robot selectionne : 6");
            }

        } else if (k.getText().equals("è")) {
            if (monde.getNbrRobot() >= 7) {
                this.Rbsect= k.getText();
                rob = monde.getRoboList()[6];
                jeu.setRbD(rob);
                afficherRobot = new Text("Robot selectionne : 7");
            }

        } else if (k.getText().equals("_")) {
            if (monde.getNbrRobot() >= 8) {
                this.Rbsect= k.getText();
                rob = monde.getRoboList()[7];
                jeu.setRbD(rob);
                afficherRobot = new Text("Robot selectionne : 8");
            }

        } else if (k.getText().equals("ç")) {
            if (monde.getNbrRobot() >= 9) {
                this.Rbsect= k.getText();
                rob = monde.getRoboList()[8];
                jeu.setRbD(rob);
                afficherRobot = new Text("Robot selectionne : 9");
            }

        } else if (k.getText().equals("à")) {
            if (monde.getNbrRobot() >= 10) {
                this.Rbsect = k.getText();
                rob = monde.getRoboList()[9];
                jeu.setRbD(rob);
                afficherRobot = new Text("Robot selectionne : 10");
            }
        }
        jeu.actualiserinfop();
        if (k.getText().equals("z")) {
            try {
                monde.actionRobot(jeu.getRbD(), "N");
                jeu.getMondeGUI().setGrille();
                int rbnum = 0;
                if (Rbsect.equals("&")) {
                    if (monde.getNbrRobot() >= 2) {
                        rbnum = 0;
                    }
                } else if (Rbsect.equals("é")) {
                    if (monde.getNbrRobot() >= 2) {
                        rbnum = 1;
                    }
                } else if (Rbsect.equals(Character.toString((char) 34))) {
                    if (monde.getNbrRobot() >= 3) {
                        rbnum = 2;
                    }
                } else if (Rbsect.equals("'")) {
                    if (monde.getNbrRobot() >= 4) {
                        rbnum = 3;
                    }
                } else if (Rbsect.equals("(")) {
                    if (monde.getNbrRobot() >= 5) {
                        rbnum = 4;
                    }
                } else if (Rbsect.equals("-")) {
                    if (monde.getNbrRobot() >= 6) {
                        rbnum = 5;
                    }
                } else if (Rbsect.equals("è")) {
                    if (monde.getNbrRobot() >= 7) {
                        rbnum = 6;
                    }
                } else if (Rbsect.equals("_")) {
                    if (monde.getNbrRobot() >= 8) {
                        rbnum = 7;
                    }
                } else if (Rbsect.equals("ç")) {
                    if (monde.getNbrRobot() >= 9) {
                        rbnum = 8;
                    }
                } else if (Rbsect.equals("à")) {
                    rbnum = 9;

                }
                jeu.setRbD(monde.getRoboList()[rbnum]);
                jeu.setTour();
                jeu.actualiserinfop();

                if(jeu.getMondeGUI().mineraisinRobot()==0 && jeu.getMondeGUI().stockRestantinmine()== 0 ){
                    jeu.score();
                }

            } catch(ExecutionException e){
                    throw new RuntimeException(e);
            }
        }
        else if (k.getText().equals("s")) {
            try {
                monde.actionRobot(jeu.getRbD(), "S");
                jeu.getMondeGUI().setGrille();
                int rbnum = 0;
                if (Rbsect.equals("&")) {
                    if (monde.getNbrRobot() >= 2) {
                        rbnum = 0;
                    }
                } else if (Rbsect.equals("é")) {
                    if (monde.getNbrRobot() >= 2) {
                        rbnum = 1;
                    }
                } else if (Rbsect.equals(Character.toString((char) 34))) {
                    if (monde.getNbrRobot() >= 3) {
                        rbnum = 2;
                    }
                } else if (Rbsect.equals("'")) {
                    if (monde.getNbrRobot() >= 4) {
                        rbnum = 3;
                    }
                } else if (Rbsect.equals("(")) {
                    if (monde.getNbrRobot() >= 5) {
                        rbnum = 4;
                    }
                } else if (Rbsect.equals("-")) {
                    if (monde.getNbrRobot() >= 6) {
                        rbnum = 5;
                    }
                } else if (Rbsect.equals("è")) {
                    if (monde.getNbrRobot() >= 7) {
                        rbnum = 6;
                    }
                } else if (Rbsect.equals("_")) {
                    if (monde.getNbrRobot() >= 8) {
                        rbnum = 7;
                    }
                } else if (Rbsect.equals("ç")) {
                    if (monde.getNbrRobot() >= 9) {
                        rbnum = 8;
                    }
                } else if (Rbsect.equals("à")) {
                    rbnum = 9;

                }
                jeu.setRbD(monde.getRoboList()[rbnum]);
                jeu.setTour();
                jeu.actualiserinfop();

                if(jeu.getMondeGUI().mineraisinRobot()==0 && jeu.getMondeGUI().stockRestantinmine()== 0 ){
                    jeu.score();
                }

            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        else if (k.getText().equals("q")) {
            try {
                monde.actionRobot(jeu.getRbD(), "O");
                jeu.getMondeGUI().setGrille();
                int rbnum = 0;
                if (Rbsect.equals("&")) {
                    if (monde.getNbrRobot() >= 2) {
                        rbnum = 0;
                    }
                } else if (Rbsect.equals("é")) {
                    if (monde.getNbrRobot() >= 2) {
                        rbnum = 1;
                    }
                } else if (Rbsect.equals(Character.toString((char) 34))) {
                    if (monde.getNbrRobot() >= 3) {
                        rbnum = 2;
                    }
                } else if (Rbsect.equals("'")) {
                    if (monde.getNbrRobot() >= 4) {
                        rbnum = 3;
                    }
                } else if (Rbsect.equals("(")) {
                    if (monde.getNbrRobot() >= 5) {
                        rbnum = 4;
                    }
                } else if (Rbsect.equals("-")) {
                    if (monde.getNbrRobot() >= 6) {
                        rbnum = 5;
                    }
                } else if (Rbsect.equals("è")) {
                    if (monde.getNbrRobot() >= 7) {
                        rbnum = 6;
                    }
                } else if (Rbsect.equals("_")) {
                    if (monde.getNbrRobot() >= 8) {
                        rbnum = 7;
                    }
                } else if (Rbsect.equals("ç")) {
                    if (monde.getNbrRobot() >= 9) {
                        rbnum = 8;
                    }
                } else if (Rbsect.equals("à")) {
                    rbnum = 9;

                }
                jeu.setRbD(monde.getRoboList()[rbnum]);
                jeu.setTour();
                jeu.actualiserinfop();

                if(jeu.getMondeGUI().mineraisinRobot()==0 && jeu.getMondeGUI().stockRestantinmine()== 0 ){
                    jeu.score();
                }


            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        else if (k.getText().equals("d")) {
            try {
                monde.actionRobot(jeu.getRbD(), "E");
                jeu.getMondeGUI().setGrille();
                int rbnum = 0;
                if (Rbsect.equals("&")) {
                    if (monde.getNbrRobot() >= 2) {
                        rbnum = 0;
                    }
                } else if (Rbsect.equals("é")) {
                    if (monde.getNbrRobot() >= 2) {
                        rbnum = 1;
                    }
                } else if (Rbsect.equals(Character.toString((char) 34))) {
                    if (monde.getNbrRobot() >= 3) {
                        rbnum = 2;
                    }
                } else if (Rbsect.equals("'")) {
                    if (monde.getNbrRobot() >= 4) {
                        rbnum = 3;
                    }
                } else if (Rbsect.equals("(")) {
                    if (monde.getNbrRobot() >= 5) {
                        rbnum = 4;
                    }
                } else if (Rbsect.equals("-")) {
                    if (monde.getNbrRobot() >= 6) {
                        rbnum = 5;
                    }
                } else if (Rbsect.equals("è")) {
                    if (monde.getNbrRobot() >= 7) {
                        rbnum = 6;
                    }
                } else if (Rbsect.equals("_")) {
                    if (monde.getNbrRobot() >= 8) {
                        rbnum = 7;
                    }
                } else if (Rbsect.equals("ç")) {
                    if (monde.getNbrRobot() >= 9) {
                        rbnum = 8;
                    }
                } else if (Rbsect.equals("à")) {
                    rbnum = 9;

                }
                jeu.setRbD(monde.getRoboList()[rbnum]);
                jeu.setTour();
                jeu.actualiserinfop();

                if(jeu.getMondeGUI().mineraisinRobot()==0 && jeu.getMondeGUI().stockRestantinmine()== 0 ){
                    jeu.score();
                }


            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        else if (k.getText().equals("r")) {
            try {
                monde.actionRobot(jeu.getRbD(), "R");
                jeu.getMondeGUI().setGrille();
                int rbnum = 0;
                if (Rbsect.equals("&")) {
                    if (monde.getNbrRobot() >= 2) {
                        rbnum = 0;
                    }
                } else if (Rbsect.equals("é")) {
                    if (monde.getNbrRobot() >= 2) {
                        rbnum = 1;
                    }
                } else if (Rbsect.equals(Character.toString((char) 34))) {
                    if (monde.getNbrRobot() >= 3) {
                        rbnum = 2;
                    }
                } else if (Rbsect.equals("'")) {
                    if (monde.getNbrRobot() >= 4) {
                        rbnum = 3;
                    }
                } else if (Rbsect.equals("(")) {
                    if (monde.getNbrRobot() >= 5) {
                        rbnum = 4;
                    }
                } else if (Rbsect.equals("-")) {
                    if (monde.getNbrRobot() >= 6) {
                        rbnum = 5;
                    }
                } else if (Rbsect.equals("è")) {
                    if (monde.getNbrRobot() >= 7) {
                        rbnum = 6;
                    }
                } else if (Rbsect.equals("_")) {
                    if (monde.getNbrRobot() >= 8) {
                        rbnum = 7;
                    }
                } else if (Rbsect.equals("ç")) {
                    if (monde.getNbrRobot() >= 9) {
                        rbnum = 8;
                    }
                } else if (Rbsect.equals("à")) {
                    rbnum = 9;

                }
                jeu.setRbD(monde.getRoboList()[rbnum]);
                jeu.setTour();
                jeu.actualiserinfop();

                if(jeu.getMondeGUI().mineraisinRobot()==0 && jeu.getMondeGUI().stockRestantinmine()== 0 ){
                    jeu.score();
                }


            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        else if (k.getText().equals("f")) {
            try {
                monde.actionRobot(jeu.getRbD(), "D");
                jeu.getMondeGUI().setGrille();
                int rbnum = 0;
                if (Rbsect.equals("&")) {
                    if (monde.getNbrRobot() >= 2) {
                        rbnum = 0;
                    }
                } else if (Rbsect.equals("é")) {
                    if (monde.getNbrRobot() >= 2) {
                        rbnum = 1;
                    }
                } else if (Rbsect.equals(Character.toString((char) 34))) {
                    if (monde.getNbrRobot() >= 3) {
                        rbnum = 2;
                    }
                } else if (Rbsect.equals("'")) {
                    if (monde.getNbrRobot() >= 4) {
                        rbnum = 3;
                    }
                } else if (Rbsect.equals("(")) {
                    if (monde.getNbrRobot() >= 5) {
                        rbnum = 4;
                    }
                } else if (Rbsect.equals("-")) {
                    if (monde.getNbrRobot() >= 6) {
                        rbnum = 5;
                    }
                } else if (Rbsect.equals("è")) {
                    if (monde.getNbrRobot() >= 7) {
                        rbnum = 6;
                    }
                } else if (Rbsect.equals("_")) {
                    if (monde.getNbrRobot() >= 8) {
                        rbnum = 7;
                    }
                } else if (Rbsect.equals("ç")) {
                    if (monde.getNbrRobot() >= 9) {
                        rbnum = 8;
                    }
                } else if (Rbsect.equals("à")) {
                    rbnum = 9;

                }
                jeu.setRbD(monde.getRoboList()[rbnum]);
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
