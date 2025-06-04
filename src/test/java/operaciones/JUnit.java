package operaciones;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
            assertFalse(Pruebas.bisiesto(añosNoBisiestos[i]), "Falla el numero " + añosNoBisiestos[i]);
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
        assertEquals(Math.pow(2, 0), Pruebas.potencia(2, 0), 0);

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
            Pruebas.subCadena(cadena, 0, 5);
            fail("Longitud de caracteres pedida demasiado larga.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            Pruebas.subCadena(cadena, 4, 1);
            fail("Posicion inicio fuera de rango.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            Pruebas.subCadena(cadena, -1, 2);
            fail("Posicion Inicio no valida.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            Pruebas.subCadena(cadena, 2, -1);
            fail("Cantidad de caracteres negativa.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

    }

    // Ejercicio 3
    int[] ordenado;
    int[] iguales;
    int[] negativos;
    int[] desordenado;
    int[] lengthUno;
    int[] lengthCero;

    @BeforeEach
    void AntesDeCadaUno() {
        ordenado = new int[] { 1, 2, 3, 4, 0 };
        iguales = new int[] { 4, 4, 4, 4, 4 };
        negativos = new int[] { -1, -2, -3, -4, -5 };
        desordenado = new int[] {2, 5, -1, 4, -5};
        lengthCero = new int[]{};
        lengthUno = new int[]{3};
    }

    @Test
    public void testNumMayor() {
        assertEquals(4, Pruebas.numeroMayor(ordenado));
        assertEquals(4, Pruebas.numeroMayor(iguales));
        assertEquals(-1, Pruebas.numeroMayor(negativos));
        assertEquals(5, Pruebas.numeroMayor(desordenado));
        
    }

    @Test
    public void testNumMenor() {
        assertEquals(0, Pruebas.numeroMenor(ordenado));
        assertEquals(4, Pruebas.numeroMenor(iguales));
        assertEquals(-5, Pruebas.numeroMenor(negativos));
        assertEquals(-5, Pruebas.numeroMenor(desordenado));
    }

    @Test
    public void testNumFails() {

        try {
            Pruebas.numeroMenor(null);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        try {
            Pruebas.numeroMenor(lengthCero);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        try {
            Pruebas.numeroMenor(lengthUno);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

    }

    @Test
    public void testIntercambiaPosiciones() { //AssertArrayEquals

        assertTrue(Pruebas.intercambiarDatos(ordenado, 2, 4));
        assertArrayEquals(new int[] {1, 2, 0, 4, 3}, ordenado);

        assertTrue(Pruebas.intercambiarDatos(ordenado, 0, 4));
        assertArrayEquals(new int[] {4, 1, 2, 3, 0}, ordenado);

        assertTrue(Pruebas.intercambiarDatos(ordenado, 4, 0));
        assertArrayEquals(new int[] {4, 1, 2, 3, 0}, ordenado);

        assertTrue(Pruebas.intercambiarDatos(ordenado, 4, 2));
        assertArrayEquals(new int[] {1, 2, 0, 4, 3}, ordenado);

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
        assertArrayEquals(new int[] {0, 1, 2, 3, 4}, ordenaVector(ordenado),
        "Se ordena");
    }

    @Test
    public void testSumaRango(){
        assertEquals(6, sumaRango(ordenado, 1, 3));
        assertEquals(10, sumaRango(ordenado, 0, 4));
        assertEquals(3, sumaRango(ordenado, 1, 2));
        try {
            sumaRango(ordenado, -2, 6);
            fail("Valores fuera de rango");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            sumaRango(ordenado, 4, 2);
            fail("Inicio > Fin");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        try {
            sumaRango(null, 1,3);
            fail("Vector Null");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
