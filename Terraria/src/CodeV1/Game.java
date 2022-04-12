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
        partie.affichermonde();
        partie.ajoutMine();

        this.end();
    }



    public void end() {
        partie=null;
    }
}