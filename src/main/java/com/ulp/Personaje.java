package com.ulp;

public class Personaje {

    private String nombre;
    int vida;
    public int CapacidadOfensiva;
    private Mochila mochila;

    public Personaje(String nombre, int vida, int CapacidadOfensiva) {

        this.nombre = nombre;
        this.vida = vida;
        this.CapacidadOfensiva = CapacidadOfensiva;
    }

    public void atacar(Personaje enemigo) {

        if (enemigo.getVida() - this.CapacidadOfensiva > 0) {

            enemigo.setVida(
                    enemigo.getVida() - this.CapacidadOfensiva);

        } else {

            enemigo.setVida(0);
        }
    }

    public void curarVida(Comida comida) {

        if (comida != null) {
            this.vida += comida.curacion;
        }
    }

    public void caminar() {
        System.out.println(nombre + " esta caminando");
    }

    public void correr() {
        System.out.println(nombre + " esta corriendo");
    }

    public void saltar() {
        System.out.println(nombre + " esta saltando");
    }

    public void recogerObjeto(Objeto objeto) {

        if (mochila != null) {
            mochila.guardarEnMochila(objeto);
        }
    }

    public void setMochila(Mochila mochila) {
        this.mochila = mochila;
    }

    public Mochila getMochila() {
        return mochila;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}