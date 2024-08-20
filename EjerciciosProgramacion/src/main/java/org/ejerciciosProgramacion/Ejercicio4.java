package org.ejerciciosProgramacion;
import java.util.Scanner;

public class Ejercicio4 {

    // Función para calcular el gasto en arriendo
    public static double calcularGastoArriendo(double sueldo) {
        return sueldo * 0.40;
    }

    // Función para calcular el gasto en comida
    public static double calcularGastoComida(double sueldo) {
        return sueldo * 0.15;
    }

    // Función que integra el cálculo de gastos y dinero restante
    public static void calcularGastos() {
        Scanner scanner = new Scanner(System.in);

        // Leer el sueldo del usuario
        System.out.print("Ingrese el sueldo de Pedro: ");
        double sueldo = scanner.nextDouble();

        // Validar el sueldo
        if (sueldo <= 0) {
            System.out.println("Error: El sueldo debe ser un número positivo.");
            return;
        }

        // Calcular los gastos
        double gastoArriendo = calcularGastoArriendo(sueldo);
        double gastoComida = calcularGastoComida(sueldo);
        double dineroRestante = sueldo - gastoArriendo - gastoComida;


        System.out.println("Gasto en arriendo: " + gastoArriendo);
        System.out.println("Gasto en comida: " + gastoComida);
        System.out.println("Dinero restante: " + dineroRestante);
    }
}