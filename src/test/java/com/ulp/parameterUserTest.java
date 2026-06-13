package com.ulp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.Collection;

public class parameterUserTest {

    public static Collection<Object[]> datosContrasenas() {
        return Arrays.asList(new Object[][]{
            {1212, new Usuario("camilabiarnes", 1212), 1234, "1234"},
            {1212, new Usuario("camilabiarnes", 1212), 1234, "123"},
            {1212, new Usuario("camilabiarnes", 1212), 1234, "5678"}
        });
    }

    @ParameterizedTest
    @MethodSource("datosContrasenas")
    public void testChangePassParametrizado(int valorActual,
                                           Usuario usr,
                                           int valorEsperado,
                                           String nuevoPassString) {

        usr.cambioPassword(nuevoPassString);

        assertEquals(valorEsperado, usr.getPass());
    }
}