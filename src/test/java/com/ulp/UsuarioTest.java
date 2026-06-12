package com.ulp;

import java.time.LocalDate;
import java.time.Duration;

public class UsuarioTest {

    private static Usuario usr;
    private static int testCounter = 0;

    @org.junit.jupiter.api.BeforeAll
    public static void antesDeTodo() {
        usr = new Usuario("Juanjo", 1212);
        System.out.println("TEST de usuario");
    }

    @org.junit.jupiter.api.AfterAll
    public static void despuesDeTodo() {
        LocalDate ayer = LocalDate.now().minusDays(1);
        System.out.println("Fin de las pruebas " + ayer);
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        testCounter++;
        System.out.println("------------------------------------");
        System.out.println("Iniciando Test Número: " + testCounter);
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() {
        System.out.println("------------------------------------");
    }

    @org.junit.jupiter.api.Test
    public void testValidarUsr() {
        System.out.println("validarPassword");
        int contra = 2222;
        boolean resultado = usr.validarPassword(contra);
        org.junit.jupiter.api.Assertions.assertTrue(resultado, "La contraseña no coincide, se esperaba que falle");
    }

    @org.junit.jupiter.api.Test
    public void testValidarEmail() {
        String email = "juanjo@ulp.edu.ar";
        boolean tieneArroba = email.contains("@");
        boolean tienePunto = email.contains(".");
        boolean largoCorrecto = email.length() < 20;
        org.junit.jupiter.api.Assertions.assertTrue(tieneArroba && tienePunto && largoCorrecto);
    }

    @org.junit.jupiter.api.Test
    public void testCambioPass() {
        System.out.println("cambiopass");
        String newPass = "1234";
        usr.cambioPassword(newPass);
        System.out.println("Nuevo Pass " + usr.getPass());
        org.junit.jupiter.api.Assertions.assertEquals(1234, usr.getPass());
    }

    @org.junit.jupiter.api.Test
    public void testDelay() {
        System.out.println("delay");
        org.junit.jupiter.api.Assertions.assertTimeout(Duration.ofMillis(30), () -> {
            usr.delay(50);
        });
    }

    @org.junit.jupiter.api.Test
    public void testUsuariosDiferentes() {
        Usuario u1 = new Usuario("Analía", 5555);
        Usuario u2 = new Usuario("Pedro", 9999);
        boolean sonDiferentes = u1.usuariosDiferentes(u2);
        System.out.println("UsuariosDiferentes? " + sonDiferentes);
        org.junit.jupiter.api.Assertions.assertNotSame(u1, u2, "mismo usuario");
    }
}