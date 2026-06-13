package com.ulp;

public class Mochila {

    public int capacidad = 3;
    public Objeto[] mochi = new Objeto[5];

    public void guardarEnMochila(Objeto cosa) {

        boolean guardado = false;

        for (int i = 0; i < capacidad; i++) {

            if (mochi[i] == null) {
                mochi[i] = cosa;
                guardado = true;
                break;
            }
        }

        if (!guardado) {
            System.out.println("NO puedes tomar MAS COSAS!");
            throw new ArrayIndexOutOfBoundsException("Mochila llena");
        }
    }

    public Comida buscarComida() {

        for (int i = 0; i < capacidad; i++) {

            if (mochi[i] instanceof Comida) {

                Comida c = (Comida) mochi[i];
                mochi[i] = null;
                return c;
            }
        }

        System.out.println("...No encuentra comida !!!");
        return null;
    }

    public void ampliarCapacidad() {

        if (capacidad < 5) {
            capacidad++;
            System.out.println("Capacidad ampliada a " + capacidad);
        } else {
            System.out.println("No se puede ampliar mas que 5");
        }
    }

    public void mostrarContenido() {

        for (int i = 0; i < capacidad; i++) {

            if (mochi[i] != null) {
                System.out.println(mochi[i].getNombre());
            }
        }
    }

    public int contarObjetos() {

        int contador = 0;

        for (Objeto obj : mochi) {

            if (obj != null) {
                contador++;
            }
        }

        return contador;
    }
    public int getCantidadActual() {
    int contador = 0;
    for (Objeto obj : mochi) {
        if (obj != null) contador++;
    }
    return contador;
}
}