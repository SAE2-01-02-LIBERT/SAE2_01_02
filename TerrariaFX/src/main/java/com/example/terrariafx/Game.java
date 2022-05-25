package com.example.terrariafx;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Game {
    private Monde partie;

    public Game() {
        partie = new Monde();
    }

    public void start() throws ExecutionException {
        partie.creerMonde();
        partie.generationEntrepot();
        partie.generationRobot();
        partie.generationMine();
        partie.ajoutElements();
        partie.affichermonde(0);
    }
    public void lancerpartie(){
        int cpt = 0;
        while (partie.getMineList()[0].getStock() != 0 && partie.getMineList()[1].getStock() != 0 && partie.getMineList()[2].getStock() != 0 && partie.getMineList()[3].getStock() != 0) {
            try {
                Scanner selectRobot = new Scanner(System.in);
                System.out.println("Veuillez selectionner le Robot à deplacer (de 1 a "+partie.getNbrRobot()+")");
                int num = 0;
                String saisie = "";
                while (true) {
                    saisie = selectRobot.nextLine();
                    try{
                        num = Integer.parseInt(saisie);
                        if (num < 1 || num > partie.getNbrRobot()) {
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
                System.out.println("Vous avez selectionne " + partie.getRoboList()[num - 1].getInfo()); // faire en sorte qu'il ne puisse selectionner que 1 ou 2


                Scanner action = new Scanner(System.in);
                System.out.println("Interaction : `R` Récolter ; `D`  Déposer ;");
                System.out.println("Déplacement : `N`aller au Nord de 1  ; `S` aller au Sud de 1 ;" +
                        " `E` aller a l'Est de 1  ; `O`aller a l'Ouest de 1 ");
                String Act = action.nextLine();

                System.out.println("Vous avez selectionner " + Act);
                System.out.println(partie.getRoboList()[num - 1].afficher());
                partie.actionRobot(partie.getRoboList()[num - 1], Act);
                cpt++;
                partie.affichermonde(cpt);

            } catch (Exception e) {
                System.out.println(e);
                this.end();
            }
        }
    }

    public void end() {
        partie = null;
    }
}
