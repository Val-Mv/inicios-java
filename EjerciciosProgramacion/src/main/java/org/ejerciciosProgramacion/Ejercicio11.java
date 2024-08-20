package org.ejerciciosProgramacion;
import java.util.Scanner;

public class Ejercicio11 {

    public static void convertirANumerosRomanos() {
        Scanner scanner = new Scanner(System.in);

        // Leer el número entero
        System.out.print("Ingrese un número entero entre 1 y 99: ");
        int numero = scanner.nextInt();

        // Validar el número
        if (numero < 1 || numero > 99) {
            System.out.println("Número fuera del rango permitido. Debe estar entre 1 y 99.");
            return;
        }

        // Obtener cifras de decenas y unidades
        int decenas = obtenerCifraDecenas(numero);
        int unidades = obtenerCifraUnidades(numero);

        // Convertir cifras a números romanos
        String romanDecenas = convertirDecenasARomanos(decenas);
        String romanUnidades = convertirUnidadesARomanos(unidades);

        // Imprimir el resultado
        System.out.println("Número en romano: " + romanDecenas + romanUnidades);
    }

    private static int obtenerCifraDecenas(int numero) {
        return numero / 10;
    }

    private static int obtenerCifraUnidades(int numero) {
        return numero % 10;
    }

    private static String convertirUnidadesARomanos(int unidad) {
        switch (unidad) {
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
            default: return "";
        }
    }

    private static String convertirDecenasARomanos(int decena) {
        switch (decena) {
            case 1: return "X";
            case 2: return "XX";
            case 3: return "XXX";
            case 4: return "XL";
            case 5: return "L";
            default: return "";
        }
    }
}