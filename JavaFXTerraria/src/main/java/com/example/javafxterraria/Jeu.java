package com.example.javafxterraria;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Jeu extends Stage {
    private Group grille = new Group();
    private Monde monde;
    private Robot rob;
    private Fenetre fenetre;
    private int nbtour=1;
    private Text tour;
    private Text tr;
    private final Group infoJeu = new Group();

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
                        int n = mine.get_numero();
                        s = "" + r.get_numero() + n;
                        if ((n)==2 || (n)==4 || (n)==6 || (n)==8 || (n)==10 ){
                            j =("mineorrob.png");}
                        else{
                            j=("minenickelrob.png");
                        }
                    }
                    else{
                        s = "" + mine.get_numero();
                        int n = mine.get_numero();
                        if ((n)==2 || (n)==4 || (n)==6 || (n)==8 || (n)==10 ){
                            j =("mineor (1).png");}
                        else{
                            j=("minenickel (1).png");
                        }
                    }
                }
                else{
                    Entrepot e = (Entrepot) o;
                    Object o1=monde.get_element(i,k,1);
                    if(o1 instanceof Robot) {
                        Robot r = (Robot) o1;
                        int n = e.get_numero();
                        s = "" + r.get_numero() + n;
                        if ((n)==2){
                            j =("entrepotniquelrobot.png");}
                        else{
                            j=("entrepotrobot.png");
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
                b.setStyle("-fx-text-fill: black; -fx-font-size: 14px;");
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
        Robot rob = monde.getRoboList()[0];
        this.setTitle("Jeu");
        Image image = new Image("partie.png");
        ImageView bg = new ImageView(image);
        Group g = new Group();
        Group root = new Group();
        Matrice(147,175);
        get_infoJeu(770,325);
        root.getChildren().addAll(bg,g);
        g.getChildren().addAll(grille,infoJeu);
        Scene scene =  new Scene(root,1000,800);
        scene.setOnKeyPressed(new GestionEventGame(monde,this,rob));
        this.setScene(scene);
        this.setResizable(false);
        this.show();
    }

    public void get_infoJeu(int debut_x, int debut_y) {
        int y = debut_y;
        String t;
        infoJeu.getChildren().clear();
        for (Mine mine : monde.getMineList()) {
            if (mine == null) {break;}
            else{
                t = ("M " + mine.get_numero() + "\t");
                t += (" " + mine.get_x() + 1 + "\t");
                t += (" " + (mine.get_y() + 1 + "\t"));
                if (mine.get_nickel()) {
                    t += ("NI" + "\t");
                } else {
                    t += ("OR" + "\t");
                }
                t += ("" + mine.get_quantite() + " / " + mine.get_max());
                Text text = new Text(t);
                text.setLayoutX(debut_x);
                text.setLayoutY(y);
                text.setFill(Color.BLACK);
                text.setStyle("-fx-font: 16 arial");
                infoJeu.getChildren().add(text);
                y += 20;}
        }
        y += 10;
        for (Entrepot entrepot : monde.getEntrepotList()) {
            t = ("E " + entrepot.get_numero() + "\t");
            t += (" " + entrepot.get_x() + 1 + "\t");
            t += (" " + (entrepot.get_y() + 1 + "\t"));
            if (entrepot.get_nickel()) {
                t += ("NI" + "\t");
            } else {
                t += ("OR" + "\t");
            }
            t += (" " + entrepot.get_stockage());
            Text text = new Text(t);
            text.setLayoutX(debut_x);
            text.setLayoutY(y);
            text.setFill(Color.BLACK);
            text.setStyle("-fx-font: 16 arial");
            infoJeu.getChildren().add(text);
            y += 20;
        }
        y += 10;
        for (Robot robot : monde.getRoboList()) {
            if (robot == null) {break;}
            else{
            t = ("R " + robot.get_numero() + "\t");
            t += (" " + robot.get_x() + 1 + "\t");
            t += (" " + (robot.get_y() + 1 + "\t"));
            if (robot.get_nickel()) {
                t += ("NI " + "\t");
            } else {
                t += ("OR " + "\t");
            }
            t += (" " + robot.get_stockage() + " / " + robot.get_max());
            Text text = new Text(t);
            text.setLayoutX(debut_x);
            text.setLayoutY(y);
            text.setFill(Color.BLACK);
            text.setStyle("-fx-font: 16 arial");
            infoJeu.getChildren().add(text);
            y += 20;}

        }
    }
        public void chosen_robot(){
            tr.setText("SELECTED ROBOT : " +rob.get_numero());
        }
        public void nb_tour(){nbtour+=1;tour.setText("TURN :" +(nbtour));}
        public void set_rob(Robot r) {rob=r;}
}


