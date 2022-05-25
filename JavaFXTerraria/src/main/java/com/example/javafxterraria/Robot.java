package com.example.javafxterraria;

public class Robot implements Comparable<Robot>{
    private final Monde monde;
    private int x;
    private int y;
    private final boolean nickel;
    private int stockage;
    private final int max;
    private final int capacite_minage;
    private final int numero;


    public Robot(Monde mond, int i, int j, boolean b, int m, int cm, int n) {
        this.monde = mond;
        this.x = i;
        this.y = j;
        this.nickel = b;
        this.stockage = 0;
        this.max = m;
        this.capacite_minage = cm;
        this.numero = n;
    }


    public Monde get_monde() {
        return this.monde;
    }

    public int get_x() {
        return this.x;
    }

    public int get_y() {
        return this.y;
    }

    public boolean get_nickel() {
        return this.nickel;
    }

    public int get_stockage() {
        return this.stockage;
    }

    public int get_max() {
        return this.max;
    }

    public int get_cm() {
        return this.capacite_minage;
    }

    public int get_numero() {
        return this.numero;
    }
    public String afficher() {
        return " R | " + this.numero + " ";
    }

    @Override
    public int compareTo(Robot r) {
        return (numero - r.numero);
    }

    public boolean nord() {
        if (this.x - 1 >= 0) {
            Object s = this.monde.get_element(this.x - 1, this.y, 1);
            if (s instanceof Eau) {
                Eau sol = (Eau) s;
                if (!sol.get_eau()) {
                    Object[][][] m = this.monde.get_matrice();
                    m[this.x - 1][this.y][1] = this;
                    m[this.x][this.y][1] = new Eau(monde,this.x,this.y,false);
                    this.x-=1;
                    return true;
                }else {
                    return false;
                }
            } else {
                return false;
            }
        }	else {
            return false;
        }
    }
    public boolean sud() {
        if (this.x + 1 <= 9) {
            Object s = this.monde.get_element(this.x + 1, this.y, 1);
            if (s instanceof Eau) {
                Eau sol = (Eau) s;
                if (!sol.get_eau()) {
                    Object[][][] m = this.monde.get_matrice();
                    m[this.x + 1][this.y][1] = this;
                    m[this.x][this.y][1] =new Eau(monde,this.x,this.y,false);
                    this.x+=1;
                    return true;
                }else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean ouest() {
        if (this.y - 1 >= 0) {
            Object s = this.monde.get_element(this.x, this.y - 1, 1);
            if (s instanceof Eau) {
                Eau sol = (Eau) s;
                if (!sol.get_eau()) {
                    Object[][][] m = this.monde.get_matrice();
                    m[this.x][this.y - 1][1] = this;
                    m[this.x][this.y][1] = new Eau(monde,this.x,this.y,false);
                    this.y-=1;
                    return true;
                }else {
                    return false;
                }
            } else {
                return false;
            }
        }	else {
            return false;
        }
    }

    public boolean est() {
        if (this.y + 1 <= 9) {
            Object s = this.monde.get_element(this.x, this.y + 1, 1);
            if (s instanceof Eau) {
                Eau sol = (Eau) s;
                if (!sol.get_eau()) {
                    Object[][][] m = this.monde.get_matrice();
                    m[this.x][this.y + 1][1] = this;
                    m[this.x][this.y][1] = new Eau(monde,this.x,this.y,false);
                    this.y+=1;
                    return true;
                }else {
                    return false;
                }
            } else {
                return false;
            }
        }	else {
            return false;
        }
    }

    public boolean mine() {
        Object m = this.monde.get_element(this.x, this.y, 0);
        if (m instanceof Mine) {
            Mine mine = (Mine) m;
            if (mine.get_quantite() == 0) {
                return false;}
            else{
                if (mine.get_nickel() == this.nickel) {
                    if (this.max - this.stockage >= this.capacite_minage) {
                        int a = mine.miner(this.capacite_minage);
                        mine.miner(this.capacite_minage);
                        this.stockage += a;
                        return true;
                    } else if (this.max > this.stockage) {
                        int a = mine.miner(this.max - this.stockage);
                        this.stockage += a;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    public boolean vider() {
        Object e = this.monde.get_element(this.x, this.y, 0);
        if (e instanceof Entrepot) {
            Entrepot entr = (Entrepot) e;
            if (entr.get_nickel() == this.nickel) {
                entr.ajouter(this.stockage);
                this.stockage = 0;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
