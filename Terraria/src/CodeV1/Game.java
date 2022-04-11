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
        partie.affichermonde();
        partie.generationEntrepot();
        partie.generationRobot();
        partie.ajoutElement();
        partie.affichermonde();
        this.end();
    }



    public void end() {
        partie=null;
    }
}