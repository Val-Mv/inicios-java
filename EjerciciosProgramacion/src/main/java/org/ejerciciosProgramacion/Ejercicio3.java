package org.ejerciciosProgramacion;
import java.util.Scanner;

public class Ejercicio3 {


    // Función que calcula la longitud de la escalera (y) dado x y el ángulo α
    public static double calcularLongitudEscalera(double x, double anguloGrados) {
        // Convertir el ángulo de grados a radianes
        double anguloRadianes = Math.toRadians(anguloGrados);
        // Usar la relación trigonométrica para hallar y
        return x / Math.sin(anguloRadianes);
    }


    public static void obtenerLongitud() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la altura de la escalera (x): ");
        double x = scanner.nextDouble();

        System.out.print("Ingrese el ángulo de inclinación (α) en grados: ");
        double angulo = scanner.nextDouble();

        double longitudEscalera = calcularLongitudEscalera(x, angulo);

        System.out.println("La longitud de la escalera (y) es: " + longitudEscalera);
    }
}