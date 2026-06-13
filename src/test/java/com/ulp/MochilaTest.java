package com.ulp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MochilaTest {

    private Mochila mochila;

    @BeforeEach
    public void setUp() {
        mochila = new Mochila();
    }

    @Test
    public void testGuardarObjetosHastaLimite() {
        System.out.println("--- Prueba: Guardar objetos hasta el límite ---");
        System.out.println("Guardando 3 objetos en la mochila...");
        
        mochila.guardarEnMochila(new Item("Objeto1"));
        mochila.guardarEnMochila(new Item("Objeto2"));
        mochila.guardarEnMochila(new Item("Objeto3"));
        
        assertTrue(mochila.getCantidadActual() == 3);
    }

    @Test
    public void testRechazarGuardarAlSuperarLimite() {
        System.out.println("--- Prueba: Rechazar guardar al superar el límite ---");
        System.out.println("Intentando agregar un cuarto objeto a la mochila llena...");
        
        mochila.guardarEnMochila(new Item("Objeto1"));
        mochila.guardarEnMochila(new Item("Objeto2"));
        mochila.guardarEnMochila(new Item("Objeto3"));

        try {
            mochila.guardarEnMochila(new Item("Objeto4"));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Rechazado: Mochila llena");
        }

        assertEquals(3, mochila.getCantidadActual());
    }

    @Test
    public void testAmpliarCapacidadYPermitirMas() {
        System.out.println("--- Prueba: Ampliar capacidad de la mochila ---");
        System.out.println("Mochila llena. Solicitando ampliación de espacio...");
        
        mochila.guardarEnMochila(new Item("Objeto1"));
        mochila.guardarEnMochila(new Item("Objeto2"));
        mochila.guardarEnMochila(new Item("Objeto3"));

        mochila.ampliarCapacidad();
        
        mochila.guardarEnMochila(new Item("Objeto4"));
        assertEquals(4, mochila.getCantidadActual());
    }
}