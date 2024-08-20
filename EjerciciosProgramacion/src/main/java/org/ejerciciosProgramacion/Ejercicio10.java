package org.ejerciciosProgramacion;
import java.util.Scanner;

public class Ejercicio10 {

    public static void realizarOperacionAritmetica() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        int num1 = scanner.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int num2 = scanner.nextInt();
        System.out.print("Ingrese la operación (+, -, *, /, %, **): ");
        String operacion = scanner.next();

        int resultado = calcularOperacion(num1, num2, operacion);
        System.out.println("El resultado de la operación es: " + resultado);
    }

    private static int calcularOperacion(int num1, int num2, String operacion) {
        switch (operacion) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            case "%":
                return num1 % num2;
            case "**":
                return (int) Math.pow(num1, num2);
            default:
                System.out.println("Operación no válida.");
                return 0;
        }
    }
}
