package com.ulp;

public class Item extends Objeto {

    public Item(String nombre) {
        super(nombre);
    }

    @Override
    public void usar() {
        System.out.println("Usando item " + nombre);
    }
}