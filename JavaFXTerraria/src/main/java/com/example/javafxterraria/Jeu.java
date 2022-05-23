package com.example.javafxterraria;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Jeu extends Stage {
    private Group grille = new Group();
    private Monde monde;

    public void Matrice(int debutX, int debutY){
        grille.getChildren().clear();
        int x = debutX;
        int y = debutY;
        for (int i=0; i<10; i++){
            for (int k=0; k<10; k++){
                String s = "";
                String j = "";
                Object o=monde.get_element(i,k,0);
                if(o instanceof Eau){
                    Eau eau = (Eau) o;
                    if (eau.get_eau()){
                        s="";
                        j=("eau.png");
                    }
                    else{
                        Object o1=monde.get_element(i,k,1);
                        if (o1 instanceof Robot){
                            Robot r= (Robot) o1;
                            s="" +r.get_numero();
                            int n=r.get_numero();
                            if ((n)==2 || (n)==4 || (n)==6 || (n)==8 || (n)==10 ){
                                j =("robot1nickel.png");}
                            else{
                                j=("robot.png");
                            }
                        }
                        else{
                            j=("herbe.png");
                        }
                    }
                }
                else if (o instanceof Mine){
                    Mine mine = (Mine) o;
                    Object o1=monde.get_element(i,k,1);
                    if(o1 instanceof Robot) {
                        Robot r = (Robot) o1;
                        s = "" + r.get_numero();
                        //j =("minerobot.png");
                    }
                    else{
                        s = "" + mine.get_numero();
                        j =("mine.png");
                        int n = mine.get_numero();
                        if ((n)==2 || (n)==4 || (n)==6 || (n)==8 || (n)==10 ){
                            j =("mineor.png");}
                        else{
                            j=("minenickel.png");
                        }
                    }
                }
                else{
                    Entrepot e = (Entrepot) o;
                    Object o1=monde.get_element(i,k,1);
                    if(o1 instanceof Robot) {
                        Robot r = (Robot) o1;
                        s = "" + r.get_numero();
                        //j =("entrepotrobot.png");
                        int n = e.get_numero();
                        if ((n)==2){
                            j =("entrepotniquelrobot.png");}
                        else{
                            j=("entrepotorrobot.png");
                        }
                    }
                    else{
                        s = "" + e.get_numero();
                        int n = e.get_numero();
                        if ((n)==2){
                            j =("entrepotniquel.png");}
                        else{
                            j=("entrepotor.png");
                        }
                    }
                }
                Button b = new Button(s);
                b.setLayoutX(x);
                b.setLayoutY(y);
                b.setPrefSize(50,50);
                b.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
                if(!j.equals("")){

                    Image img = new Image(j);
                    ImageView view = new ImageView(img);
                    view.setFitHeight(100);
                    view.setPreserveRatio(true); //permet de ne pas étirer les boutons
                    view.setFitHeight(30);
                    b.setGraphic(view);

                }
                    grille.getChildren().add(b);
                x=x+50;
            }
            x=debutX;
            y+=50;
        }
    }

    public void setGrille(Group grille) {
        this.grille = grille;
    }

    public Jeu(Monde monde){
        this.monde=monde;
        this.setTitle("Jeu");
        Image image = new Image("New Piskel.png");
        ImageView bg = new ImageView(image);
        Group g = new Group();
        Group root = new Group();
        Matrice(147,175);
        HBox h = new HBox();
        VBox v = new VBox();
        root.getChildren().addAll(bg,g);
        g.getChildren().add(grille);
        Scene scene =  new Scene(root,789,788);
        this.setScene(scene);
        this.setResizable(false);
        this.show();
    }
}
