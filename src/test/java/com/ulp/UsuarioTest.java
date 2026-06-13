package com.ulp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.Duration;

public class UsuarioTest {

    private static Usuario usr;
    private static int testCounter = 0;

    @BeforeAll
    public static void antesDeTodo() {
        usr = new Usuario("Juanjo", 1212);
        System.out.println("TEST de usuario");
    }

    @AfterAll
    public static void despuesDeTodo() {
        LocalDate ayer = LocalDate.now().minusDays(1);
        System.out.println("Fin de las pruebas " + ayer);
    }

    @BeforeEach
    public void setUp() {
        testCounter++;
        System.out.println("------------------------------------");
        System.out.println("Iniciando Test Número: " + testCounter);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("------------------------------------");
    }

    @Test
    public void testValidarUsr() {
        System.out.println("validarPassword");
        int contra = 2222;
        boolean resultado = usr.validarPassword(contra);
        assertTrue(resultado, "La contraseña no coincide, se esperaba que falle");
    }

    @Test
    public void testValidarEmail() {
        String email = "juanjo@ulp.edu.ar";
        boolean tieneArroba = email.contains("@");
        boolean tienePunto = email.contains(".");
        boolean largoCorrecto = email.length() < 20;
        assertTrue(tieneArroba && tienePunto && largoCorrecto);
    }

    @Test
    public void testChangePass() {
        System.out.println("cambiopass");
        String newPass = "1234";
        usr.cambioPassword(newPass);
        System.out.println("Nuevo Pass " + usr.getPass());
        assertEquals(1234, usr.getPass());
    }

    @Test
    public void testDelay() {
        System.out.println("delay");
        assertTimeout(Duration.ofMillis(30), () -> {
            usr.delay(50);
        });
    }

    @Test
    public void testUsuariosDiferentes() {
        Usuario u1 = new Usuario("Analía", 5555);
        Usuario u2 = new Usuario("Pedro", 9999);
        assertNotSame(u1, u2, "mismo usuario");
    }
}