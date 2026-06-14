package com.ulp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class parameterMailTest {

    public static boolean ValidarMail(String email) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }

    public static Collection<Object[]> datosEmails() {
        return Arrays.asList(new Object[][]{
            {"camilabiarnes@gmail.com", true},
            {"camilabiarnes@gmailcom", false},
            {"camilabiarnesgmail.com", false},
            {"@camilabiarnesgmail.com", false},
            {".camilabiarnes@gmail", false}
        });
    }

    @ParameterizedTest
    @MethodSource("datosEmails")
    public void testValidarEmailParametrizado(String email, boolean resultadoEsperado) {
        System.out.println("------------------------------------");
        System.out.println("Evaluando formato de correo: " + email);
        System.out.println("¿Debería ser valido?: " + (resultadoEsperado ? "SÍ" : "NO"));
        
        boolean resultadoActual = ValidarMail(email);
        assertEquals(resultadoEsperado, resultadoActual);
    }
}