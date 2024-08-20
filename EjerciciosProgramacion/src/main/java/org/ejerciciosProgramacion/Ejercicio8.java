package org.ejerciciosProgramacion;
import java.util.Scanner;

public class Ejercicio8 {

    // Función para calcular el número de salones
    public static int calcularNumeroDeSalones(int numeroEstudiantes, int capacidadSalon) {
        return (int) Math.ceil((double) numeroEstudiantes / capacidadSalon);
    }

    // Función para calcular el número de pisos
    public static int calcularNumeroDePisos(int numeroSalones, int salonesPorPiso) {
        return (int) Math.ceil((double) numeroSalones / salonesPorPiso);
    }

    // Función que integra el cálculo de salones y pisos
    public static void calcularEdificio() {
        Scanner scanner = new Scanner(System.in);

        // Leer los datos del usuario
        System.out.print("Ingrese el número de estudiantes: ");
        int numeroEstudiantes = scanner.nextInt();
        System.out.print("Ingrese la capacidad de un salón: ");
        int capacidadSalon = scanner.nextInt();
        System.out.print("Ingrese el número de salones por piso: ");
        int salonesPorPiso = scanner.nextInt();

        // Calcular el número de salones
        int numeroSalones = calcularNumeroDeSalones(numeroEstudiantes, capacidadSalon);
        // Calcular el número de pisos
        int numeroPisos = calcularNumeroDePisos(numeroSalones, salonesPorPiso);

        // Imprimir los resultados
        System.out.println("Número de salones necesarios: " + numeroSalones);
        System.out.println("Número de pisos necesarios: " + numeroPisos);
}
}