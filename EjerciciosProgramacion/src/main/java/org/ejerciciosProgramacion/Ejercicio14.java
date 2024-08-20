package org.ejerciciosProgramacion;
import java.util.Scanner;

public class Ejercicio14 {

    public static void encontrarHermanoMayor() {
        Scanner scanner = new Scanner(System.in);

        // Leer información del primer hermano
        System.out.print("Ingrese el nombre del primer hermano: ");
        String nombre1 = scanner.nextLine();
        System.out.print("Ingrese la edad del primer hermano: ");
        int edad1 = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea restante

        // Leer información del segundo hermano
        System.out.print("Ingrese el nombre del segundo hermano: ");
        String nombre2 = scanner.nextLine();
        System.out.print("Ingrese la edad del segundo hermano: ");
        int edad2 = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea restante

        // Leer información del tercer hermano
        System.out.print("Ingrese el nombre del tercer hermano: ");
        String nombre3 = scanner.nextLine();
        System.out.print("Ingrese la edad del tercer hermano: ");
        int edad3 = scanner.nextInt();

        // Obtener el nombre del hermano mayor
        String hermanoMayor = obtenerHermanoMayor(nombre1, edad1, nombre2, edad2, nombre3, edad3);
        System.out.println("El hermano mayor es: " + hermanoMayor);
    }

    private static String obtenerHermanoMayor(String nombre1, int edad1, String nombre2, int edad2, String nombre3, int edad3) {
        if (edad1 >= edad2 && edad1 >= edad3) {
            return nombre1;
        } else if (edad2 >= edad1 && edad2 >= edad3) {
            return nombre2;
        } else {
            return nombre3;
        }
    }
}