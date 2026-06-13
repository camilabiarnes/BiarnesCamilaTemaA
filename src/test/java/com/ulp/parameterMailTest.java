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
            {"camilabiarnes@tototita.com", true},
            {"camilabiarnes@tototitacom", false},
            {"camilabiarnestototita.com", false},
            {"@camilabiarnestototita.com", false},
            {".camilabiarnestototita@com", false}
        });
    }

    @ParameterizedTest
    @MethodSource("datosEmails")
    public void testValidarEmailParametrizado(String email, boolean resultadoEsperado) {
        boolean resultadoActual = ValidarMail(email);
        assertEquals(resultadoEsperado, resultadoActual);
    }
}