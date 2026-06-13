package com.ulp;

public abstract class Objeto {

    protected String nombre;

    public Objeto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void usar() {
        System.out.println("Usando objeto " + nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}