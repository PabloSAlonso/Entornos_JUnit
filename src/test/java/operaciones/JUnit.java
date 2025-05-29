package operaciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Pruebas")
public class JUnit {
    String cadena = "hola";

    //Ejercicio 1
    @Test
    public void testBisiesto() {
        int[] añosBisiestos = { 2000, 2004 };
        int[] añosNoBisiestos = { 1800, 2006, 2021 };
        for (int i = 0; i < añosBisiestos.length; i++) {
            assertTrue(Pruebas.bisiesto(añosBisiestos[i]), "Falla el numero " + añosBisiestos[i]);
        }
        for (int i = 0; i < añosNoBisiestos.length; i++) {
            assertTrue(Pruebas.bisiesto(añosNoBisiestos[i]), "Falla el numero " + añosNoBisiestos[i]);
        }
    }

    @Test
    public void testCilindro() {
        assertEquals((2 * Math.PI * 1 * 1) + (2 * Math.PI * 1 * 1), Pruebas.calcularCilindro(), 0.00001);
    }

    @Test
    public void testPotencia() {
        assertEquals(Math.pow(2, 2), Pruebas.potencia(2, 2), 0);
        assertEquals(Math.pow(0, 2), Pruebas.potencia(0, 2), 0);
        assertEquals(Math.pow(0, -1), Pruebas.potencia(0, -1), 0);
        assertEquals(Math.pow(-1, 1), Pruebas.potencia(-1, 1), 0);
        assertEquals(Math.pow(-1, 2), Pruebas.potencia(-1, 2), 0);
        assertEquals(Math.pow(-1, -2), Pruebas.potencia(-1, -2), 0);
        assertEquals(Math.pow(2, -2), Pruebas.potencia(2, -2), 0);
        assertEquals(Math.pow(2, -2), Pruebas.potencia(2, 0), 0);

    }
    //Ejercicio 2
    @Test
    public void testSubCadena() {
        assertEquals("hola", Pruebas.subCadena(cadena, 0, 4));
        assertEquals("a", Pruebas.subCadena(cadena, 3, 1));
        assertEquals("la", Pruebas.subCadena(cadena, 2, 2));
        assertEquals("", Pruebas.subCadena(cadena, 0, 0));
    }

    @Test
    public void comprobarErrores() {
        try {
            assertEquals("hola ", Pruebas.subCadena(cadena, 0, 5));
            fail("Longitud de caracteres pedida demasiado larga.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            assertEquals(" ", Pruebas.subCadena(cadena, 4, 1));
            fail("Posicion inicio fuera de rango.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            assertEquals("ol ", Pruebas.subCadena(cadena, -1, 2));
            fail("Posicion Inicio no valida.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            assertEquals("ol ", Pruebas.subCadena(cadena, 2, -1));
            fail("Cantidad de caracteres negativa.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

    }
    //Ejercicio 3
    @Test
    public void testFunciones() {

    }

}
