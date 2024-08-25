package org.example;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GestionParqueadero {

    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar Vehículo");
            System.out.println("2. Registrar Salida de Vehículo");
            System.out.println("3. Consultar Estado del Parqueadero");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el tipo de vehículo (1. Automóvil, 2. Motocicleta, 3. Camión):");
                    int tipoVehiculo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ingrese la placa:");
                    String placa = scanner.nextLine();

                    System.out.println("Ingrese la marca:");
                    String marca = scanner.nextLine();

                    System.out.println("Ingrese el modelo:");
                    String modelo = scanner.nextLine();

                    System.out.println("Ingrese la hora de entrada (formato: yyyy-MM-dd HH:mm):");
                    String horaEntradaStr = scanner.nextLine();
                    LocalDateTime horaEntrada = LocalDateTime.parse(horaEntradaStr, formatter);

                    Vehiculo vehiculo;
                    if (tipoVehiculo == 1) {
                        System.out.println("Ingrese el tipo de combustible:");
                        String tipoCombustible = scanner.nextLine();
                        vehiculo = new Automovil(placa, marca, modelo, horaEntrada, tipoCombustible);
                    } else if (tipoVehiculo == 2) {
                        System.out.println("Ingrese el cilindraje:");
                        int cilindraje = scanner.nextInt();
                        vehiculo = new Motocicleta(placa, marca, modelo, horaEntrada, cilindraje);
                    } else {
                        System.out.println("Ingrese la capacidad de carga (en toneladas):");
                        double capacidadCarga = scanner.nextDouble();
                        vehiculo = new Camion(placa, marca, modelo, horaEntrada, capacidadCarga);
                    }

                    parqueadero.registrarEntrada(vehiculo);
                    System.out.println("Vehículo registrado exitosamente.");
                    break;

                case 2:
                    System.out.println("Ingrese la placa del vehículo a registrar salida:");
                    String placaSalida = scanner.nextLine();
                    try {
                        double costo = parqueadero.registrarSalida(placaSalida);
                        System.out.println("El costo de parqueo es: $" + costo);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Vehículos en el parqueadero:");
                    for (Vehiculo v : parqueadero.consultarEstado()) {
                        System.out.println("Placa: " + v.getPlaca() + ", Marca: " + v.getMarca() + ", Modelo: " + v.getModelo());
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
