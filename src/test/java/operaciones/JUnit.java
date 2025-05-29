package operaciones;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Pruebas")
public class JUnit {
    static String cadena;// Iniciar en before all pq es static se hace asi

    @BeforeAll
    static void pedirAntes() {
        cadena = "hola";
    }

    // Ejercicio 1
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

    // Ejercicio 2
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

    // Ejercicio 3
    int[] vector1;
    int[] vector2;
    int[] vector3;

    @BeforeEach
    void AntesDeCadaUno() {
        vector1 = new int[] { 1, 2, 3, 4, 0 };
        vector2 = new int[] { 4, 4, 4, 4, 4 };
        vector3 = new int[] { -1, -2, -3, -4, -5 };
    }

    @Test
    public void testNumMayor() {
        assertEquals(4, Pruebas.numeroMayor(vector1));
        assertEquals(4, Pruebas.numeroMayor(vector2));
        assertEquals(-1, Pruebas.numeroMayor(vector3));
    }

    @Test
    public void testNumMenor() {
        assertEquals(0, Pruebas.numeroMenor(vector1));
        assertEquals(4, Pruebas.numeroMenor(vector2));
        assertEquals(-5, Pruebas.numeroMenor(vector3));
    }

    @Test
    public void testNumFails() {

        try {
            assertEquals(3, Pruebas.numeroMenor(vector1));
        } catch (IllegalArgumentException e) {
            System.err.println("Expected equivocado");
        }

        try {
            assertEquals(3, Pruebas.numeroMenor(vector2));
        } catch (IllegalArgumentException e) {
            System.err.println("Expected equivocado");
        }

        try {
            assertEquals(-1, Pruebas.numeroMenor(vector3));
        } catch (IllegalArgumentException e) {
            System.err.println("Expected equivocado");
        }

    }

    @Test
    public void testIntercambiaPosiciones() {
        assertTrue(Pruebas.intercambiarDatos(vector1, 2, 4));
        assertTrue(Pruebas.intercambiarDatos(vector1, 0, 4));
        assertTrue(Pruebas.intercambiarDatos(vector1, 4, 0));
        assertTrue(Pruebas.intercambiarDatos(vector1, 2, 4));
    }

    //#region MOCKS
    public int[] ordenaVector(int[] v) {
        return v;
    }

    public int sumaRango(int[] v, int inicio, int fin) {
        return 0;
    }
    // #endregion

    @Test
    public void testOrdenaVector() {
        assertArrayEquals(new int[] {0, 1, 2, 3, 4}, ordenaVector(vector1), "Se ordena");
    }
}
