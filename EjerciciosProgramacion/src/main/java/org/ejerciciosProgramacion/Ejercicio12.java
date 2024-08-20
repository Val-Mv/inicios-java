package org.ejerciciosProgramacion;
import java.util.Scanner;

public class Ejercicio12 {

    // Método que recibe el nombre de un día y retorna el nombre del día siguiente
    public static String obtenerDiaSiguiente(String dia) {
        switch (dia.toLowerCase()) {
            case "lunes":
                return "martes";
            case "martes":
                return "miércoles";
            case "miércoles":
                return "jueves";
            case "jueves":
                return "viernes";
            case "viernes":
                return "sábado";
            case "sábado":
                return "domingo";
            case "domingo":
                return "lunes";
            default:
                return "Día inválido";
        }
    }

    // Método que integra la lógica de cálculo y la entrada del usuario
    public static void diaSiguiente() {
        Scanner scanner = new Scanner(System.in);

        // Leer el nombre del día desde el teclado
        System.out.print("Ingrese el nombre del día: ");
        String dia = scanner.nextLine();

        // Obtener el nombre del día siguiente
        String diaSiguiente = obtenerDiaSiguiente(dia);

        // Imprimir el resultado
        if (diaSiguiente.equals("Día inválido")) {
            System.out.println("El día ingresado no es válido.");
        } else {
            System.out.println("El día siguiente es: " + diaSiguiente);
        }
    }


}