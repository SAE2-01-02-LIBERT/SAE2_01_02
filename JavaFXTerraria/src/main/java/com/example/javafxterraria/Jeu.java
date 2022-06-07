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
import java.util.Random;

public class Jeu extends Stage {
    private Group grille = new Group();
    private final Monde monde;
    private Robot rob;
    private Fenetre fenetre;
    private final int nbtour=1;
    private Text tour;
    private Text tr;
    private final Group infoJeu = new Group();

    public void Matrice(int debutX, int debutY){
        grille.getChildren().clear();
        Random ran = new Random();
        int[] nb = new int[4];
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
                        nb[0] = ran.nextInt(4);
                        if (nb[0]==1) {
                            j = ("eau.png");
                        }else if (nb[0]==2){
                            j = ("eaucanard.png");}
                        else if (nb[0]==3){
                            j = ("eaunenu.png");}
                        else{j = ("eau.png");}
                    }
                    else{
                        Object o1=monde.get_element(i,k,1);
                        if (o1 instanceof Robot){
                            Robot r= (Robot) o1;
                            s="" +r.get_numero();
                            int n=r.get_numero();
                            if ((n)==2 || (n)==4 || (n)==6 || (n)==8 || (n)==10 ){
                                j=("robot.png");}
                            else{
                                j =("robot1nickel.png");
                            }
                        }
                        else{
                            nb[1] = ran.nextInt(20);
                            if (nb[1]==1) {
                                j = ("herbe.png");
                            }else if (nb[1]==2){
                                //j = ("herbe2.png");}
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==3){
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==4){
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==5){
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==6){
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==7){
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==8){
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==9){
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==10){
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==11){
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==12){
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==13){
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==14){
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==15){
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==16){
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==17){
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==18){
                                j = ("hautesHerbes.png");}
                            else if (nb[1]==19){
                                j = ("herbefleur1.png");}
                            else{
                                j= ("herbe.png");
                            }
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
                            j=("entrepotrobot.png");}
                        else{
                            j =("entrepotniquelrobot.png");
                        }
                    }
                    else{
                        s = "" + e.get_numero();
                        int n = e.get_numero();
                        if ((n)==2){
                            j=("entrepotor.png");}
                        else{
                            j =("entrepotniquel.png");
                        }
                    }
                }
                Button b = new Button(s);
                b.setStyle("-fx-text-fill: black; -fx-font-size: 14px;");
                b.setLayoutX(x);
                b.setLayoutY(y);
                b.setPrefSize(50,50);
                b.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
                Image img = new Image(j);
                ImageView view = new ImageView(img);
                view.setFitHeight(100);
                view.setPreserveRatio(true); //permet de ne pas étirer les boutons
                view.setFitHeight(30);
                b.setGraphic(view);
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
        Image image = new Image("partiefinal.png");
        ImageView bg = new ImageView(image);
        Group g = new Group();
        Group root = new Group();
        Matrice(147,175);
        get_infoJeu(770,325);
        //chosen_robot(770,325);
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
                t += ("" + mine.get_x()  + "\t");
                t += ("" + (mine.get_y()  + "\t"));
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
            t += ("" + entrepot.get_x()  + "\t");
            t += ("" + (entrepot.get_y()  + "\t"));
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
            if (robot == null) {
                break;
            } else {
                t = ("R " + robot.get_numero() + "\t");
                t += ("" + robot.get_x() + "\t");
                t += ("" + (robot.get_y() + "\t"));
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
                y += 20;
            }
        }
    }
        //public void chosen_robot(){
        //    tr.setText("SELECTED ROBOT : " +rob.get_numero());
        //}
        //public void nb_tour(){nbtour+=1;tour.setText("TURN :" +(nbtour));}
        public void set_rob(Robot r) {rob=r;}
}


