package com.example.javafxterraria;

public class Entrepot implements Comparable<Entrepot>{
    private final Monde monde;
    private final boolean nickel;
    private int stockage;
    private final int numero;
    private final int x;
    private final int y;


    public Entrepot(Monde m, int i, int j, boolean b, int n) {
        this.monde = m;
        this.nickel = b;
        this.stockage = 0;
        this.numero = n;
        this.x = i;
        this.y = j;
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

    public int get_numero() {
        return this.numero;
    }

    public void ajouter(int i) {
        this.stockage += i;
    }

    @Override
    public int compareTo(Entrepot e) {
        return (this.numero - e.numero);
    }
}
