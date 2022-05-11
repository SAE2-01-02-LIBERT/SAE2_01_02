package CodeV2;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Monde world = new Monde(1);
        world.creer_monde();
        while (world.getStockTotal() != 0) {
            try {
                world.afficher_console(1000);
                Scanner selectRobot = new Scanner(System.in);
                System.out.println("Veuilliez selectionner le Robot à deplacer 1 ou 2");
                int num = 0;
                String saisie = "";
                while (true) {
                    saisie = selectRobot.nextLine();
                    try {
                        num = Integer.parseInt(saisie);
                        if (num < 1 || num > 2) {
                            System.out.println("Sélectionnez un robot existant!");
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Entrez un entier!");
                    }
                }
                System.out.println("Vous avez selectionner " + world.getRoboList()[num - 1].get_numero());
                Scanner action = new Scanner(System.in);
                System.out.println("Interaction : `R` Récolter ; `D`  Déposer ;");
                System.out.println("Déplacement : `Z`aller au Nord de 1  ; `S` aller au Sud de 1 ;" +
                        " `D` aller a l'Est de 1  ; `Q`aller a l'Ouest de 1 ");
                String Act = action.nextLine();
                Robot r = world.getRoboList()[(Integer.parseInt(saisie))-1];
                System.out.println(r);
                if(Objects.equals(Act, "Z")){
                    r.nord();
                }
                if(Objects.equals(Act, "Q")){
                    r.ouest();
                }
                if(Objects.equals(Act, "S")){
                    r.sud();
                }
                if(Objects.equals(Act, "D")){
                    r.est();
                }

                System.out.println("Vous avez selectionner " + Act);
                System.out.println(world.getRoboList()[num - 1].afficher());
                int cpt=0;
                cpt++;
                world.afficher_console(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        }
    }
}
