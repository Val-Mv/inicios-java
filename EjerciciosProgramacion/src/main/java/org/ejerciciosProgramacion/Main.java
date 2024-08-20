package org.ejerciciosProgramacion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("================================================");
            System.out.println("               MENÚ DE EJERCICIOS               ");
            System.out.println("================================================");

            System.out.println("Seleccione el ejercicio a ejecutar:");

            System.out.println("1. Calcular el valor de la función algebraica");
            System.out.println("2. Ejercicio 2 - Calcular el número de buses necesarios para el paseo");
            System.out.println("3. Ejercicio 3 - Calcular longitud de la escalera");
            System.out.println("4. Ejercicio 4 - Calcular gastos y dinero restante de Pedro");
            System.out.println("5. Ejercicio 5 - Calcular el área de la corona circular");
            System.out.println("6. Ejercicio 6 - Calcular área y perímetro del terreno");
            System.out.println("7. Ejercicio 7 - Calcular distancia y pendiente entre dos puntos");
            System.out.println("8. Ejercicio 8 - Calcular número de salones y pisos");
            System.out.println("9. Ejercicio 9 - Comparar dos números");
            System.out.println("10. Ejercicio 10 - Realizar operación aritmética");
            System.out.println("11. Ejercicio 11 - Convertir número a romanos");
            System.out.println("12. Ejercicio 12 - Obtener el día siguiente");
            System.out.println("13. Ejercicio 13 - Calcular aumento y nuevo salario");
            System.out.println("14. Ejercicio 14 - Encontrar hermano mayor");
            System.out.println("0. Salir");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        Ejercicio1.calcular();
                        break;
                    case 2:
                        Ejercicio2.calcularBuses();
                        break;
                    case 3:
                        Ejercicio3.obtenerLongitud();
                        break;
                    case 4:
                        Ejercicio4.calcularGastos();
                        break;
                    case 5:
                        Ejercicio5.calcularAreaCorona();
                        break;
                    case 6:
                        Ejercicio6.calcularAreaYPerimetro();
                        break;
                    case 7:
                        Ejercicio7.calcular();
                        break;
                    case 8:
                        Ejercicio8.calcularEdificio();
                        break;
                    case 9:
                        Ejercicio9.compararNumeros();
                        break;
                    case 10:
                        Ejercicio10.realizarOperacionAritmetica();
                        break;
                    case 11:
                        Ejercicio11.convertirANumerosRomanos();
                        break;
                    case 12:
                        Ejercicio12.diaSiguiente();
                        break;
                    case 13:
                        Ejercicio13.calcularAumentoYSalario();
                        break;
                    case 14:
                        Ejercicio14.encontrarHermanoMayor();
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }  catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor ingrese un número.");
            scanner.nextLine();
        }
            // Esperar unos segundos antes de mostrar el menú nuevamente
            try {
                System.out.println("Volviendo al menú en 3 segundos...");
                Thread.sleep(3000); // Pausa de 3 segundos (3000 milisegundos)
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
