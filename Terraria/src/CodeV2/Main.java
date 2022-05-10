package CodeV2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Monde world = new Monde(1);
        world.creer_monde();
        while (world.getStockTotal() != 0) {
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
