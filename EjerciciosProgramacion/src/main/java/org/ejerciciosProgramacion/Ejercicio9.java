package org.ejerciciosProgramacion;
import java.util.Scanner;

public class Ejercicio9 {

    public static void compararNumeros() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        int num1 = scanner.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int num2 = scanner.nextInt();

        int mayor = obtenerMayor(num1, num2);
        System.out.println("El mayor número es: " + mayor);
    }

    private static int obtenerMayor(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }
}