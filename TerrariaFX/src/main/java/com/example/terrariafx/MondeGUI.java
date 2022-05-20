package com.example.terrariafx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class MondeGUI extends GridPane {
    private Monde world;
    private GridPane grille;

    public MondeGUI() throws ExecutionException {
        this.grille =new GridPane(); ;
        this.world = new Monde();
        this.genererMonde();
    }
    public void genererMonde() throws ExecutionException {
        world.creerMonde();
        world.generationEntrepot();
        world.generationRobot();
        world.generationMine();
        world.ajoutElements();
        world.affichermonde(0);
    }
    public void setGrille() {
        Image terre = new Image("terre.png");
        Image eau =new Image("eau.png");
        Image rb = new Image("robot1or.png");
        GridPane grille = new GridPane();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                SecteurGUI sec = new SecteurGUI(world.getMonde()[i][j]);

                if (sec.getsecteurtype().equals("Terre")) {
                    sec.getRectangle().setFill(new ImagePattern(terre));
                }

                else {
                    sec.getRectangle().setFill(new ImagePattern(eau));
                }
                GridPane.setRowIndex(sec.getRectangle(), i);
                GridPane.setColumnIndex(sec.getRectangle(), j);
                grille.getChildren().addAll(sec.getRectangle());
            }
        }
        this.grille = grille;
    }
    public void lancerpartie(){
        int cpt = 0;
        while (world.getMineList()[0].getStock() != 0 && world.getMineList()[1].getStock() != 0 && world.getMineList()[2].getStock() != 0 && world.getMineList()[3].getStock() != 0) {
            try {
                Scanner selectRobot = new Scanner(System.in);
                System.out.println("Veuillez selectionner le Robot à deplacer (de 1 a "+world.getNbrRobot()+")");
                int num = 0;
                String saisie = "";
                while (true) {
                    saisie = selectRobot.nextLine();
                    try{
                        num = Integer.parseInt(saisie);
                        if (num < 1 || num > world.getNbrRobot()) {
                            System.out.println("Sélectionnez un robot existant!");
                        }
                        else{
                            break;
                        }
                    }
                    catch (Exception e){
                        System.out.println("Entrez un entier!");
                    }
                }
                System.out.println("Vous avez selectionne " + world.getRoboList()[num - 1].getInfo()); // faire en sorte qu'il ne puisse selectionner que 1 ou 2


                Scanner action = new Scanner(System.in);
                System.out.println("Interaction : `R` Récolter ; `D`  Déposer ;");
                System.out.println("Déplacement : `N`aller au Nord de 1  ; `S` aller au Sud de 1 ;" +
                        " `E` aller a l'Est de 1  ; `O`aller a l'Ouest de 1 ");
                String Act = action.nextLine();

                System.out.println("Vous avez selectionner " + Act);
                System.out.println(world.getRoboList()[num - 1].afficher());
                world.actionRobot(world.getRoboList()[num - 1], Act);
                cpt++;
                world.affichermonde(cpt);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public GridPane getGrille(){
        return this.grille;
    }
}
