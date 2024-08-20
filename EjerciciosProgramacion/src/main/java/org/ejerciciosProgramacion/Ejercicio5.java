package org.ejerciciosProgramacion;
import java.util.Scanner;

public class Ejercicio5 {

    // Función para calcular el área de un círculo
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }

    // Función para calcular el área de una corona circular
    public static double calcularAreaCoronaCircular(double radioInterior, double radioExterior) {
        // Usar la función de área del círculo para calcular las áreas
        double areaExterior = calcularAreaCirculo(radioExterior);
        double areaInterior = calcularAreaCirculo(radioInterior);
        // Resta de áreas
        return areaExterior - areaInterior;
    }

    // Función que integra el cálculo del área de la corona circular
    public static void calcularAreaCorona() {
        Scanner scanner = new Scanner(System.in);

        // Leer los radios del usuario
        System.out.print("Ingrese el radio del círculo pequeño (r): ");
        double radioInterior = scanner.nextDouble();
        System.out.print("Ingrese el radio del círculo grande (R): ");
        double radioExterior = scanner.nextDouble();

        // Validar los radios
        if (radioInterior <= 0 || radioExterior <= 0 || radioInterior >= radioExterior) {
            System.out.println("Error: El radio interior debe ser mayor que cero y menor que el radio exterior.");
            System.out.println("Por favor, intente nuevamente.");
            return;
        }

        // Calcular el área de la corona circular
        double areaCorona = calcularAreaCoronaCircular(radioInterior, radioExterior);

        // Imprimir el resultado
        System.out.println("El área de la corona circular es: " + areaCorona);
    }
}