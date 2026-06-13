package com.ulp;

public class Parcial2_Ing {

    public static void main(String[] args) {

        System.out.println("=== SIMULACION DEL VIDEOJUEGO ===");

        Personaje heroe =
                new Personaje("Heroe", 100, 20);

        Mochila mochila = new Mochila();

        heroe.setMochila(mochila);

        Personaje enemigo =
                new Personaje("Hongo", 100, 10);

        System.out.println("Simulacion lista. Corre los Test Files para evaluar.");
    }
}