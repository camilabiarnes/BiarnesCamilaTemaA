package com.ulp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;

public class CombateTest {

    private Personaje heroe;
    private Personaje enemigo;
    private Mochila mochila;

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        String nombreMetodo = testInfo.getTestMethod().map(m -> m.getName()).orElse("desconocido");
        String displayName = testInfo.getDisplayName();
        System.out.printf("-- Prueba: %s [%s] --\n", nombreMetodo, displayName);

        mochila = new Mochila();
        heroe = new Personaje("Heroe", 100, 20);
        heroe.setMochila(mochila);
        enemigo = new Personaje("Hongo", 100, 10);
    }

    @AfterEach
    public void tearDown() {
        if (enemigo.getVida() <= 0) {
            System.out.println("El enemigo HA MUERTO. Su vida se redujo a 0");
        } else {
            System.out.println("enemigo con " + enemigo.getVida() + " de vida");
        }
    }

    @Test
    public void testGolpeRestaVidaSinMorir() {
        System.out.println("Enemigo inicia con 100 de vida");
        System.out.println("Personaje ataca pegando un golpe de 20");
        
        enemigo.setVida(100);
        heroe.CapacidadOfensiva = 20;
        heroe.atacar(enemigo);
        assertEquals(80, enemigo.getVida());
    }

    @Test
    public void testGolpeMataEnemigo() {
        System.out.println("Enemigo se encuentra debilitado con 30 de vida");
        System.out.println("Personaje ataca pegando un golpe de 30");
        enemigo.setVida(30);
        heroe.CapacidadOfensiva = 30;
        heroe.atacar(enemigo);
        assertEquals(0, enemigo.getVida());
    }

    @Test
    public void testGolpeExcesivoNoBajaDeCero() {
        System.out.println("Enemigo tiene solo 10 de vida");
        System.out.println("Personaje realiza un golpe excesivo de 50 de daño");
        
        enemigo.setVida(10);
        heroe.CapacidadOfensiva = 50;
        heroe.atacar(enemigo);
        assertEquals(0, enemigo.getVida());
    }

    @Test
    public void testCurarVida() {
        heroe.setVida(30);
        Comida manzana = new Comida("Manzana", 15);
        heroe.curarVida(manzana);
        assertEquals(45, heroe.getVida());
    }

    @Test
    public void testNoCannotCurarse() {
        System.out.println("Personaje se encuentra herido y con poca vida");
        System.out.println("Intenta buscar comida en su mochila...");
        assertThrows(NullPointerException.class, () -> {
            Comida comidaEncontrada = mochila.buscarComida();
            if (comidaEncontrada == null) {
                System.out.println("Resultado: La mochila esta vacía, no se pudo curar");
                throw new NullPointerException("Comida no encontrada");
            }
            heroe.curarVida(comidaEncontrada);
        });
    }

    @Test
    public void testCurarVidaConPocaVida() {
        System.out.println("Personaje inicia combate con el enemigo");
        
        heroe.vida = 68; 
        System.out.println("Personaje se encuentra herido, tiene 68 de vida");
        
        com.ulp.Comida manzana = new com.ulp.Comida("Manzana", 32);
        System.out.println("Personaje busca en su mochila y saca una manzana");
        
        heroe.curarVida(manzana);
        System.out.println("Personaje consumo comida y curo su vida a 100");
        
        assertEquals(100, heroe.vida);
    }
}