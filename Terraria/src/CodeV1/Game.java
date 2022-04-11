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
        partie.generationMine();
        partie.ajoutElement();
        partie.affichermonde();
        partie.ajoutMine();
        partie.affichermonde();

        this.end();
    }



    public void end() {
        partie=null;
    }
}