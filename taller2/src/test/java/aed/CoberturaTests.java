package aed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CoberturaTests {
    Cobertura cobertura = new Cobertura();

    @Test
    void testFizzBuzz() {
        assertEquals("Fizz",cobertura.fizzBuzz(3));
        assertEquals("Buzz", cobertura.fizzBuzz(5));
        assertEquals("FizzBuzz", cobertura.fizzBuzz(15));
        assertEquals("4",cobertura.fizzBuzz(4));
    }

    @Test
    void testNumeroCombinatorio() {
        assertEquals(1, cobertura.numeroCombinatorio(5, 0));
        assertEquals(1, cobertura.numeroCombinatorio(5, 5));
        assertEquals(462, cobertura.numeroCombinatorio(11, 5));
        assertEquals(184756, cobertura.numeroCombinatorio(20, 10));
    }

    @Test
    void testRepeticionesConsecutivas() {
        assertTrue(false);
    }
}
