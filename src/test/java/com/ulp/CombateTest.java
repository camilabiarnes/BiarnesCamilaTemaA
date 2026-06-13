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
        enemigo.setVida(100);
        heroe.CapacidadOfensiva = 20;
        heroe.atacar(enemigo);
        assertEquals(80, enemigo.getVida());
    }

    @Test
    public void testGolpeMataEnemigo() {
        enemigo.setVida(30);
        heroe.CapacidadOfensiva = 30;
        heroe.atacar(enemigo);
        assertEquals(0, enemigo.getVida());
    }

    @Test
    public void testGolpeExcesivoNoBajaDeCero() {
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
    public void testNoPuedeCurarse() {
        assertThrows(NullPointerException.class, () -> {
            Comida comidaEncontrada = mochila.buscarComida();
            if (comidaEncontrada == null) {
                throw new NullPointerException("Comida no encontrada");
            }
            heroe.curarVida(comidaEncontrada);
        });
    }
}