package org.ejerciciosProgramacion;
import java.util.Scanner;

public class Ejercicio13 {

    public static void calcularAumentoYSalario() {
        Scanner scanner = new Scanner(System.in);

        // Leer el sueldo actual
        System.out.print("Ingrese el sueldo actual del empleado: ");
        double sueldoActual = scanner.nextDouble();

        // Calcular el aumento y el nuevo salario
        double aumento = calcularAumento(sueldoActual);
        double nuevoSalario = sueldoActual + aumento;

        // Imprimir el valor del aumento y el nuevo salario
        System.out.println("El aumento es: $" + aumento);
        System.out.println("El nuevo salario es: $" + nuevoSalario);
    }

    private static double calcularAumento(double sueldo) {
        double aumento;
        if (sueldo <= 800000) {
            aumento = sueldo * 0.10;
        } else if (sueldo <= 1200000) {
            aumento = sueldo * 0.08;
        } else {
            aumento = sueldo * 0.05;
        }
        return aumento;
    }
}