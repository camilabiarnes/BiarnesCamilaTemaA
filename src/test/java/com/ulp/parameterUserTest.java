package com.ulp;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

public class parameterUserTest {

    private static Stream<Arguments> profeDatos() {
        return Stream.of(
            Arguments.of(1, new Usuario("Camila 1", 1212), 1234, "1234"),
            Arguments.of(2, new Usuario("Camila 2", 9999), 123, "123"),
            Arguments.of(3, new Usuario("Camila 3", 8888), 5678, "5678")
        );
    }

    @ParameterizedTest
    @MethodSource("profeDatos")
    public void testChangePassParametrizado(int id, Usuario usuario, int esperado, String nuevoPass) {
        usuario.cambioPassword(nuevoPass);
        assertEquals(esperado, usuario.getPass()); 
    }
}