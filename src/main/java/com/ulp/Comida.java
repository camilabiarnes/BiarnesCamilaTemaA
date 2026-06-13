package com.ulp;

public class Comida extends Objeto {

    public int curacion;

    public Comida(String nombre, int curacion) {
        super(nombre);
        this.curacion = curacion;
    }

    public int getCuracion() {
        return curacion;
    }

    public void setCuracion(int curacion) {
        this.curacion = curacion;
    }

    @Override
    public void usar() {
        System.out.println("Consumir comida " + nombre);
    }
}