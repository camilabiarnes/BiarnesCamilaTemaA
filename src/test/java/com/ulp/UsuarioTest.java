package com.ulp;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private static Usuario usr;
    private static int contador = 0;

    @BeforeAll
    public static void antesDeTodo() {
        usr = new Usuario("Camila", 1212);
        System.out.println("TEST de usuario - Camila Biarnes");
    }

    @AfterAll
    public static void despuesDeTodo() {
        LocalDate ayer = LocalDate.now().minusDays(1);
        System.out.println("Fin de las pruebas " + ayer);
    }

    @BeforeEach
    public void setUp() {
        contador++;
        System.out.println("------------------------------------");
        System.out.println("Iniciando Test Número: " + contador);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("------------------------------------");
    }

    @Test
    public void testValidarUsr() {
        int contra = 2222;
        assertFalse(usr.validarPassword(contra), "La contraseña no coincide, se esperaba que falle");
    }

    @Test
    public void testValidarEmail() {
        String email = "camila@gmail.com";
        assertTrue(email.contains("@") && email.contains(".") && email.length() < 20);
    }

    @Test
    public void testCambioPass() {
        String newPass = "1234";
        usr.cambioPassword(newPass);
        assertEquals(1234, usr.getPass());
        System.out.println("Nuevo Pass " + usr.getPass());
    }

    @Test
    public void testDelay() throws InterruptedException {
     
        assertTimeoutPreemptively(java.time.Duration.ofMillis(30), () -> {
            try {
                usr.delay(10); 
            } catch (Exception e) {
               
            }
        });
    }

    @Test
    public void testUsuariosDiferentes() {
        Usuario u1 = new Usuario("Camila", 4444);
        Usuario u2 = new Usuario("Marta", 5555);
        assertTrue(u1.usuariosDiferentes(u2));
        assertNotSame(u1, u2, "mismo usuario");
    }
}