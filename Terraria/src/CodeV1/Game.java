package CodeV1;

import java.util.*;
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
        partie.ajoutElement();
        partie.ajoutMine();
        partie.affichermonde(0);
        int cpt = 0;
        while (partie.getMineList()[0].getStock() != 0 && partie.getMineList()[1].getStock() != 0 && partie.getMineList()[2].getStock() != 0 && partie.getMineList()[3].getStock() != 0) {
            try {
                Scanner selectRobot = new Scanner(System.in);
                System.out.println("Veuilliez selectionner le Robot à deplacer 1 ou 2");
                int num = selectRobot.nextInt();
                System.out.println("Vous avez selectionner " + partie.getRoboList()[num - 1].getInfo()); // faire en sorte qu'il ne puisse selectionner que 1 ou 2


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