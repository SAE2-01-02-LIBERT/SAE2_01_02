package CodeV2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Monde world = new Monde(1);
        world.creer_monde();
        while (world.getMineList()[0].get_max() != 0 && world.getMineList()[1].get_max() != 0 && world.getMineList()[2].get_max() != 0 && world.getMineList()[3].get_max() != 0) {
            try {
        world.afficher_console(0);
        Scanner scan = new Scanner(System.in);

        String robot=scan.next();
        String mouv=scan.next();
        {
            if (mouv.equals("z")){
                robot.nord();
            }
        }
    }
}
