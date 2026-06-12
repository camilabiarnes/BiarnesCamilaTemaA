/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulp;

/**
 *
 * @author camila biarnes
 */


public abstract class ObjetoInmovil extends ElementoJuego {
  public ObjetoInmovil(int x, int y) {
        super(x, y);
    }
}

class Edificio extends ObjetoInmovil {
    private int vida;
    private int resistenciaDisparos;

    public Edificio(int x, int y, int vida, int resistenciaDisparos) {
        super(x, y);
        this.vida = vida;
        this.resistenciaDisparos = resistenciaDisparos;
    }

    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }
    public int getResistenciaDisparos() { return resistenciaDisparos; }
    public void setResistenciaDisparos(int resistenciaDisparos) { this.resistenciaDisparos = resistenciaDisparos; }
}

class Torre extends ObjetoInmovil {
    private int alcance;
    private int potenciaDisparo;

    public Torre(int x, int y, int alcance, int potenciaDisparo) {
        super(x, y);
        this.alcance = alcance;
        this.potenciaDisparo = potenciaDisparo;
    }

    public int getAlcance() { return alcance; }
    public void setAlcance(int alcance) { this.alcance = alcance; }
    public int getPotenciaDisparo() { return potenciaDisparo; }
    public void setPotenciaDisparo(int potenciaDisparo) { this.potenciaDisparo = potenciaDisparo; }
}

class Muralla extends ObjetoInmovil {
    private int nivelRecuperacion;
    private int mejorasDefensa;

    public Muralla(int x, int y, int nivelRecuperacion, int mejorasDefensa) {
        super(x, y);
        this.nivelRecuperacion = nivelRecuperacion;
        this.mejorasDefensa = mejorasDefensa;
    }

    public int getNivelRecuperacion() { return nivelRecuperacion; }
    public void setNivelRecuperacion(int nivelRecuperacion) { this.nivelRecuperacion = nivelRecuperacion; }
    public int getMejorasDefensa() { return mejorasDefensa; }
    public void setMejorasDefensa(int mejorasDefensa) { this.mejorasDefensa = mejorasDefensa; }
}