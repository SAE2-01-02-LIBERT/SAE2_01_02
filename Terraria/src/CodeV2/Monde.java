package CodeV2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Monde {
    private int id_monde;
    private Object[][][] matrice;

    public Monde(int i) {
        this.id_monde = i;
        this.matrice = new Object[10][10][2];
    }


    public int get_id_monde() {
        return this.id_monde;
    }

    public Object[][][] get_matrice() {
        return this.matrice;
    }

    public Object get_element(int i, int j, int k) {
        return this.matrice[i][j][k];
    }

    public void creer_monde() {
        Random ran = new Random();
        int[] nb_el = new int[4];
        nb_el[0] = ran.nextInt(10);
        nb_el[1] = ran.nextInt(2) + 2;
        nb_el[2] = ran.nextInt(8) + 2;
        nb_el[3] = 2;
        int i;
        for (i = 0; i < nb_el.length; i++) {
            for (int k = 0; k < nb_el[i]; k++) {
                boolean place = false;
                while (!place) {
                    int x = ran.nextInt(10);
                    int y = ran.nextInt(10);
                    if (i == 0 && this.matrice[x][y][0] == null && this.matrice[x][y][1] == null) {
                        this.matrice[x][y][0] = new Eau(this, x, y, true);
                        this.matrice[x][y][1] = new Eau(this, x, y, true);
                        place = true;
                    }
                    if (i == 1 && this.matrice[x][y][0] == null && this.matrice[x][y][1] == null) {
                        this.matrice[x][y][1] = new Eau(this, x, y, false);
                        int q = ran.nextInt(51) + 100;
                        if ((k+1)%2 == 0) {
                            this.matrice[x][y][0] = new Mine(this, x, y, false, q, k + 1);
                        } else {
                            this.matrice[x][y][0] = new Mine(this, x, y, true, q, k + 1);
                        }
                        place = true;
                    }
                    if (i == 2 && this.matrice[x][y][0] == null && this.matrice[x][y][1] == null) {
                        int max = ran.nextInt(5) + 5;
                        int cm = ran.nextInt(2) + 3;
                        this.matrice[x][y][0] = new Eau(this, x, y, false);
                        if ((k+1)%2 == 0) {
                            this.matrice[x][y][1] = new Robot(this, x, y, false, max, cm, k + 1);
                        } else {
                            this.matrice[x][y][1] = new Robot(this, x, y, true, max, cm, k + 1);
                        }
                        place = true;
                    }
                    if (i == 3 && this.matrice[x][y][0] == null && this.matrice[x][y][1] == null) {
                        this.matrice[x][y][1] = new Eau(this, x, y, false);
                        if ((k+1)%2 == 0) {
                            this.matrice[x][y][0] = new Entrepot(this, x, y, false, k + 1);
                        } else {
                            this.matrice[x][y][0] = new Entrepot(this, x, y, true, k + 1);
                        }
                        place = true;
                    }
                }
            }
        }
        for (i = 0; i < this.matrice.length; i++) {
            for (int j = 0; j < (this.matrice[0]).length; j++) {
                for (int k = 0; k < (this.matrice[0][0]).length; k++) {
                    if (this.matrice[i][j][k] == null)
                        this.matrice[i][j][k] = new Eau(this, i, j, false);
                }
            }
        }
    }

    public void afficher_console(int tour) {
        ArrayList<Entrepot> entr = new ArrayList<>();
        ArrayList<Robot> rob = new ArrayList<>();
        ArrayList<Mine> min = new ArrayList<>();
        System.out.println();
        for (int j = 0; j < (this.matrice[0]).length; j++)
            System.out.print("   | " + (j + 1));
        System.out.print("  |");
        System.out.println();
        System.out.println("_______________________________________________________________|");
        System.out.print("\n");
        int i;
        for (i = 0; i < this.matrice.length; i++) {
            for (int k = 0; k < (this.matrice[0][0]).length; k++) {
                if (k == 0) {
                    if (i + 1 == 10) {
                        System.out.print(1 + i);
                    } else {
                        System.out.print(" " + (1 + i));
                    }
                } else {
                    System.out.print("  ");
                }
                for (int m = 0; m < (this.matrice[0]).length; m++) {
                    if (this.matrice[i][m][k] instanceof Eau) {
                        Eau e = Eau.class.cast(this.matrice[i][m][k]);
                        if (e.get_eau()==true) {
                            System.out.print(" | X X");
                        } else {
                            System.out.print(" |    ");
                        }
                    } else if (this.matrice[i][m][k] instanceof Mine) {
                        Mine mine = Mine.class.cast(this.matrice[i][m][k]);
                        System.out.print(" | M " + mine.get_numero());
                        min.add(mine);
                    } else if (this.matrice[i][m][k] instanceof Entrepot) {
                        Entrepot e = Entrepot.class.cast(this.matrice[i][m][k]);
                        System.out.print(" | E " + e.get_numero());
                        entr.add(e);
                    } else if (this.matrice[i][m][k] instanceof Robot) {
                        Robot r = Robot.class.cast(this.matrice[i][m][k]);
                        System.out.print(" | R " + r.get_numero());
                        rob.add(r);
                    }
                }
                System.out.print(" |");
                System.out.println();
            }
            System.out.println("_______________________________________________________________|");
            if (i == this.matrice.length - 1) {
                System.out.println();
            } else {
                System.out.println("                                                               |");
            }
        }
        Collections.sort(entr);
        Collections.sort(rob);
        Collections.sort(min);
        System.out.println();
        System.out.println("Tours :" + tour);
        System.out.println();
        for (Mine mine : min) {
            System.out.print("M" + mine.get_numero());
            System.out.print("  " + mine.get_x() + " " + mine.get_y());
            if (mine.get_nickel()==true) {
                System.out.print("  NI ");
            } else {
                System.out.print("  OR ");
            }
            System.out.print("  " + mine.get_quantite() + " / " + mine.get_max());
            System.out.println();
        }
        for (Entrepot entrepot : entr) {
            System.out.print("E" + entrepot.get_numero());
            System.out.print("  " + entrepot.get_x() + " " + entrepot.get_y());
            if (entrepot.get_nickel()==true) {
                System.out.print("  NI ");
            } else {
                System.out.print("  OR ");
            }
            System.out.print("  " + entrepot.get_stockage());
            System.out.println();
        }
        for (Robot robot : rob) {
            System.out.print("R" + robot.get_numero());
            System.out.print("  " + robot.get_x() + " " + robot.get_y());
            if (robot.get_nickel()==true) {
                System.out.print("  NI ");
            } else {
                System.out.print("  OR ");
            }
            System.out.print("  " + robot.get_stockage() + " / " + robot.get_max());
            System.out.println();
        }
    }
}
