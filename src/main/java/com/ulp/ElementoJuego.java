package com.ulp;

public abstract class ElementoJuego {

    protected int x;
    protected int y;

    public ElementoJuego(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void mover(int x, int y) {
        this.x = x;
        this.y = y;
    }
}