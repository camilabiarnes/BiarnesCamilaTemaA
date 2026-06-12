
package com.ulp;


public class Parcial2_Ing {

    public static void main(String[] args) {
  System.out.println("INICIANDO SIMULACIÓN ");

        Heroe heroe = new Heroe(0, 0, 68, 3, 25, 32, 64, "heroe.png");
        
        Comida manzana = new Comida(0, 0, "Manzana", 50, 1);
        heroe.getMochila().guardarItem(manzana);
        
        System.out.println("Energía inicial del héroe: " + heroe.getEnergia() + " PS");
        ObjetoMovil item = heroe.getMochila().obtenerItem(0);
        if (item != null) {
            item.usar(heroe);
        }

        System.out.println("\nINICIANDO COMBATE ");
        EnemigoComun hongo = new EnemigoComun(1, 1, 54, 1, 10, 16, 16, "hongo.png");
        Arma espada = new Arma(0, 0, "Espada de Acero", 0, 1, 1, 35);
        heroe.equiparArma(espada);

        System.out.println("Coordenadas del enemigo antes del golpe: (" + hongo.getX() + ", " + hongo.getY() + ")");
        heroe.atacar(hongo);
        System.out.println("Coordenadas del enemigo después del golpe: (" + hongo.getX() + ", " + hongo.getY() + ")");
    }


    }

