package org.ejerciciosProgramacion;
import java.util.Scanner;

public class Ejercicio2 {

    // Función para calcular el número de buses necesarios
    public static int calcularNumeroDeBuses(int sillasPorBus, int estudiantesGordos, int estudiantesFlacos) {
        // Cada estudiante gordo ocupa 2 sillas, y cada estudiante flaco ocupa 1 silla
        int sillasNecesarias = (estudiantesGordos * 2) + estudiantesFlacos;
        // Calcular el número de buses necesarios (redondear hacia arriba)
        int busesNecesarios = (int) Math.ceil((double) sillasNecesarias / sillasPorBus);
        return busesNecesarios;
    }

    // Función que integra el cálculo de buses
    public static void calcularBuses() {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de sillas por bus
        System.out.print("Ingrese el número de sillas por bus: ");
        int sillasPorBus = scanner.nextInt();

        // Leer el número de estudiantes gordos
        System.out.print("Ingrese el número de estudiantes gordos: ");
        int estudiantesGordos = scanner.nextInt();

        // Leer el número de estudiantes flacos
        System.out.print("Ingrese el número de estudiantes flacos: ");
        int estudiantesFlacos = scanner.nextInt();

        // Validar entradas
        if (sillasPorBus <= 0 || estudiantesGordos < 0 || estudiantesFlacos < 0) {
            System.out.println("Error: Todos los valores deben ser positivos y el número de sillas debe ser mayor que cero.");
            return;
        }

        // Calcular el número de buses necesarios
        int busesNecesarios = calcularNumeroDeBuses(sillasPorBus, estudiantesGordos, estudiantesFlacos);

        // Imprimir el resultado
        System.out.println("Número de buses necesarios: " + busesNecesarios);
    }
}