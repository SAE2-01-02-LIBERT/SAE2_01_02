package com.example.javafxterraria;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Jeu extends Stage {
    private Group grille;
    private Monde monde;

    public void Matrice(int debutX, int debutY){
        grille.getChildren().clear();
        int x = debutX;
        int y = debutY;
        for (int i=0; i<10; i++){
            for (int k=0; k<10; k++){
                String s = "";
                Image j;
                Object o=monde.get_element(i,k,0);
                if(o instanceof Eau){
                    Eau eau = Eau.class.cast(o);
                    if (eau.get_eau() == true){
                        s="x";
                        j=new Image(eau.png);
                    }
                    else{
                        Object o1=monde.get_element(i,k,1);
                        if (o1 instanceof Robot){
                            Robot r= Robot.class.cast(o1);
                            s="R" +r.get_numero();
                            j=new Image(robot.png);
                        }
                        else{
                            j=new Image(terre.png);
                        }
                    }
                }
                else if (o instanceof Mine){
                    Mine mine = Mine.class.cast(o);
                    Object o1=monde.get_element(i,k,1);
                    if(o1 instanceof Robot) {
                        Robot r = Robot.class.cast(o1);
                        s = "R" + r.get_numero();
                        j = new Image(minerobot.png);
                    }
                    else{
                        s = "M" + mine.get_numero();
                        j = new Image(mine.png);
                    }
                }
                else{
                    Entrepot entrepot = Entrepot.class.cast(o);
                    Object o1=monde.get_element(i,k,1);
                    if(o1 instanceof Robot) {
                        Robot r = Robot.class.cast(o1);
                        s = "R" + r.get_numero();
                        j = new Image(entrepotrobot.png);
                    }
                    else{
                        s = "E" + entrepot.get_numero();
                        j = new Image(entrepot.png);
                    }
                }
                Button b = new Button(s);
                b.setLayoutX(x);
                b.setLayoutY(y);
                //b.setPrefSize();
                grille.getChildren().add(b);
                x=x+20;
            }
            x=debutX;
            y+=20;
        }
    }
    public Jeu(Monde monde){
        this.setTitle();
    }

}
