package CodeV1;

public class Game {

    public Monde grille;

    public Game() {
        this.grille = new Monde();
    }

    public void start() {
        this.grille.Generation_Map();
        this.grille.AfficherMonde();
    }

}
