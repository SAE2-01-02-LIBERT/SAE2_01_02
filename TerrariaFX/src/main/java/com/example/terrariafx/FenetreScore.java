package com.example.terrariafx;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class FenetreScore extends Stage {

    private Menu menu;
    private int orRecup;
    private int orRestant;
    private int niRecup;
    private int niRestant;
    private int tours;

    public FenetreScore(Menu menu, int orRecup, int orRestant, int niRecup, int niRestant, int tours){
        super();
        this.menu = menu;
        this.orRecup = orRecup;
        this.orRestant = orRestant;
        this.niRecup = niRecup;
        this.niRestant = niRestant;
        this.tours = tours;

        this.setTitle("Fin de partie");
        Label go = new Label("GAME OVER");
        Label sf = new Label("Score final :");
        Label or1 = new Label("Or récupéré : "+this.orRecup);
        Label or2 = new Label("Or restant : "+this.orRestant);
        Label ni1 = new Label("Nickel récupéré : "+this.niRecup);
        Label ni2 = new Label("Nickel restant : "+this.niRestant);
        Label t = new Label("Nombre de tours joué : "+this.tours);
        Button quit = new Button("Quitter");

        go.setTextAlignment(TextAlignment.CENTER);
        go.setMinHeight(40);
        go.setMaxHeight(40);

        VBox vbox = new VBox();
        vbox.getChildren().add(go);
        vbox.getChildren().add(sf);
        vbox.getChildren().add(or1);
        vbox.getChildren().add(or2);
        vbox.getChildren().add(ni1);
        vbox.getChildren().add(ni2);
        vbox.getChildren().add(t);
        vbox.getChildren().add(quit);

        Stage temp = this;
        quit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                temp.close();
                menu.show();
            }
        });

        Scene scene = new Scene(vbox, 120, 200);
        this.setScene(scene);
        this.sizeToScene();
    }
}
