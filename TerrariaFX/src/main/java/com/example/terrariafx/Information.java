package com.example.terrariafx;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Information extends Stage {
    private Menu menu;

    public Information() {
        super();
        this.setTitle("Information");
        Label z = new Label("Aller au Nord : Z");
        Label s = new Label("Aller au Sud : S");
        Label q = new Label("Aller au Ouest : Q");
        Label d = new Label("Aller au Est : D");
        Label r = new Label("Récolter des minerais : R");
        Label e = new Label("Déposer des minerais : E");
        VBox v = new VBox();
        v.getChildren().addAll(z,s,q,d,r,e);
        Scene scene = new Scene(v,300,300);
        this.setScene(scene);
        this.sizeToScene();
    }

    public void setMenu(Menu m) {
        menu = m;
    }
}
