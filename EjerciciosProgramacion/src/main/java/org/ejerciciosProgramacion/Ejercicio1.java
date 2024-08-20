package org.ejerciciosProgramacion;
import java.util.Scanner;

public class Ejercicio1 {

    // Función estática que calcula el valor de la función algebraica
    public static int calcularFuncionAlgebraica(int x, int y) {
        return (x * x) + (2 * x * y) + (y * y);
    }

    // Función que integra el cálculo y la lectura de datos del usuario
    public static void calcular() {
        Scanner scanner = new Scanner(System.in);

        // Leer los valores de x e y
        System.out.print("Ingrese el valor de x: ");
        int x = scanner.nextInt();

        System.out.print("Ingrese el valor de y: ");
        int y = scanner.nextInt();

        // Calcular el valor de la función algebraica
        int resultado = calcularFuncionAlgebraica(x, y);

        // Imprimir el resultado
        System.out.println("El valor de f(x, y) = x^2 + 2xy + y^2 es: " + resultado);
    }

}