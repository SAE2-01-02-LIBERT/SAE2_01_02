package CodeV1;

import java.util.*;

public class Game {
    private Monde partie;

    public Game() {
        partie = new Monde();
    }

    public void start() {
        partie.creerMonde();
        partie.affichermonde();
        this.end();
    }

    public void end() {
        partie=null;
    }
}