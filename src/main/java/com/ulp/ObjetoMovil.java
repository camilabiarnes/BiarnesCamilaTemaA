package com.ulp;


import java.util.ArrayList;
import java.util.List;

public abstract class ObjetoMovil extends ElementoJuego {
   private String nombre;

    public ObjetoMovil(int x, int y, String nombre) {
        super(x, y);
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }
    public abstract void usar(Heroe heroe);
}

class Comida extends ObjetoMovil {
    private int cantidadVidaCurada;
    private int usos;

    public Comida(int x, int y, String nombre, int cantidadVidaCurada, int usos) {
        super(x, y, nombre);
        this.cantidadVidaCurada = cantidadVidaCurada;
        this.usos = usos;
    }

    public int getCantidadVidaCurada() { return cantidadVidaCurada; }
    public int getUsos() { return usos; }

    @Override
    public void usar(Heroe heroe) {
        if (usos > 0) {
            heroe.curarVida(this.cantidadVidaCurada);
            usos--;
            if (usos == 0) {
                heroe.getMochila().removerItem(this);
            }
        }
    }
}

class Proyectil {
    private String tipo;
    private int cantidad;
    private int dañoCausado;
    private String efecto;

    public Proyectil(String tipo, int cantidad, int dañoCausado, String efecto) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.dañoCausado = dañoCausado;
        this.efecto = efecto;
    }

    public String getTipo() { return tipo; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public int getDañoCausado() { return dañoCausado; }
}

class Arma extends ObjetoMovil {
    private int potencia;
    private int cadencia;
    private int velocidadDisparo;
    private int factorPotenciador;
    private int contadorDisparos = 0;
    private List<Proyectil> proyectilesEquipados;

    public Arma(int x, int y, String nombre, int potencia, int cadencia, int velocidadDisparo, int factorPotenciador) {
        super(x, y, nombre);
        this.potencia = potencia;
        this.cadencia = cadencia;
        this.velocidadDisparo = velocidadDisparo;
        this.factorPotenciador = factorPotenciador;
        this.proyectilesEquipados = new ArrayList<>();
    }

    public int getFactorPotenciador() { return factorPotenciador; }
    public int getPotencia() { return potencia; }
    public boolean estaDestruida() { return contadorDisparos >= 30; }

    public void equiparProyectil(Proyectil p) {
        this.proyectilesEquipados.add(p);
    }

    public List<Proyectil> desequiparProyectiles() {
        List<Proyectil> copia = new ArrayList<>(this.proyectilesEquipados);
        this.proyectilesEquipados.clear();
        return copia;
    }

    @Override
    public void usar(Heroe heroe) {
        if (!estaDestruida()) {
            contadorDisparos++;
            if (estaDestruida()) {
                System.out.println("El arma " + getNombre() + " se ha roto.");
                List<Proyectil> salvados = desequiparProyectiles();
                heroe.recuperarProyectilesSueltos(salvados);
                heroe.getMochila().removerItem(this);
            }
        }
    }
}