package org.ejerciciosProgramacion;
import java.util.Scanner;

public class Ejercicio7 {

    // Método para calcular la distancia entre dos puntos
    public static double calcularDistancia(double x1, double y1, double x2, double y2) {
        double diferenciaX = x2 - x1;
        double diferenciaY = y2 - y1;
        return Math.sqrt(diferenciaX * diferenciaX + diferenciaY * diferenciaY);
    }

    // Método para calcular la pendiente de la recta que une dos puntos
    public static double calcularPendiente(double x1, double y1, double x2, double y2) {
        if (x1 == x2) {
            throw new ArithmeticException("La pendiente es indefinida para puntos con la misma coordenada x.");
        }
        return (y2 - y1) / (x2 - x1);
    }

    // Método que integra la lógica de cálculo y la entrada del usuario
    public static void calcular() {
        Scanner scanner = new Scanner(System.in);

        // Lectura de las coordenadas del primer punto
        System.out.print("Ingrese la coordenada x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Ingrese la coordenada y1: ");
        double y1 = scanner.nextDouble();

        // Lectura de las coordenadas del segundo punto
        System.out.print("Ingrese la coordenada x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Ingrese la coordenada y2: ");
        double y2 = scanner.nextDouble();

        // Cálculo de la distancia y la pendiente
        double distancia = calcularDistancia(x1, y1, x2, y2);
        double pendiente = calcularPendiente(x1, y1, x2, y2);

        // Impresión de los resultados
        System.out.println("La distancia entre los dos puntos es: " + distancia);
        System.out.println("La pendiente de la recta que une los dos puntos es: " + pendiente);
    }


}