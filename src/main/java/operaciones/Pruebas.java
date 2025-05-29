package operaciones;

public class Pruebas {
    //1
    
    /**
     * Comprueba si un año es bisiesto
     * 
     * @param año el año que se quiere comprobar
     * @return (true) si es bisiesto, (false) en caso contrario
     */
    public static boolean bisiesto(int año) {
        if (año % 4 == 0) {
            if (año % 100 == 0) {
                return año % 400 == 0;
            }
            return true; // Es divisible por 4 pero no por 100
        }
        return false; // No es bisiesto si es divisible por 4
    }

    public static double calcularCilindro() {
        double altura = 1;
        double radio = 1;
        return (2 * 3.1416 * radio * radio) + (2 * 3.1416 * radio * altura);

    }

    public static double potencia(double b, int e) {
        double resultado = 1;
        int exp = Math.abs(e);

        for (int i = 0; i < exp; i++) {
            resultado *= b;
        }
        if (e < 0) {
            resultado = 1 / resultado;
        }
        return resultado;

    }
    // 2
    public static String subCadena(String cadena, int posicion, int caracteres) {
        String palabra = "";
        if (posicion < 0 || posicion > cadena.length() || (posicion + caracteres) > cadena.length()) {
            throw new IllegalArgumentException("Parámetros invalidos cadena: " + cadena + " posicion inicial: "
                    + posicion + " cantidad de caracteres a coger: " + caracteres);
        } else {
            for (int i = posicion; i < caracteres + posicion; i++) {// No estaba teniendo en cuenta la posicion para
                                                                    // empezar a pintar caracteres
                palabra = palabra + cadena.charAt(i);
            }
        }
        return palabra;
    }
    // 3
    public static int[] crearAleatorio(int n) {
        int listaNums[] = new int[n];
        for (int i = 0; i < n; i++) {
            listaNums[i] = (int) (Math.random() * 4001 + 1000);
        }
        return listaNums;
    }

    public static void mostrarNumeros(int[] numeros) {
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }

    public static int numeroMayor(int[] numeros) {
        int auxiliar = numeros[0];
        for (int i = 0; i < numeros.length; i++) {
            if (auxiliar < numeros[i]) {
                auxiliar = numeros[i];
            }
        }
        return auxiliar;
    }

    public static int numeroMenor(int[] numeros) {
        int auxiliar = numeros[0];
        for (int numero : numeros) {
            if (auxiliar > numero) {
                auxiliar = numero;
            }
        }
        return auxiliar;
    }

    public static boolean intercambiarDatos(int[] numeros, int n1, int n2) {
        int auxiliar;
        if (numeros.length <= n1 || numeros.length <= n2 || n1 < 0 || n2 < 0) {
            return false;
        } else {
            auxiliar = numeros[n1];
            numeros[n1] = numeros[n2];
            numeros[n2] = auxiliar;
            return true;
        }
    }

    public static void main(String[] args) {

    }
}
