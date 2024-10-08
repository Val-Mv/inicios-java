package org.example;

import java.time.Duration;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parqueadero {
    private List<Vehiculo> vehiculos;
    private List<Vehiculo> vehiculosHistoricos;

    public Parqueadero() {
        this.vehiculos = new ArrayList<>();
        this.vehiculosHistoricos = new ArrayList<>();
    }

    public void registrarEntrada(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public double registrarSalida(String placa) {
        Vehiculo vehiculo = buscarVehiculo(placa);
        if (vehiculo != null) {
            LocalDateTime horaSalida = LocalDateTime.now();
            Duration duracion = Duration.between(vehiculo.getHoraEntrada(), horaSalida);
            vehiculos.remove(vehiculo);
            vehiculosHistoricos.add(vehiculo);  // Mover el vehículo a la lista de históricos
            return calcularCosto(vehiculo, duracion);
        } else {
            throw new IllegalArgumentException("Vehículo no encontrado.");
        }
    }


    private Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                return vehiculo;
            }
        }
        return null;
    }

    private double calcularCosto(Vehiculo vehiculo, Duration duracion) {
        long horas = duracion.toHours();
        if (duracion.toMinutes() % 60 > 0) {
            horas++;
        }

        if (vehiculo instanceof Automovil) {
            return horas * 2000;  // Tarifa por hora
        } else if (vehiculo instanceof Motocicleta) {
            return horas * 1000;  // Tarifa por hora
        } else if (vehiculo instanceof Camion) {
            return horas * 5000;  // Tarifa por hora
        }
        return 0;
    }

    public List<Vehiculo> consultarEstado() {
        return vehiculos;
    }

    public List<Vehiculo> generarReporteDiario() {
        LocalDate hoy = LocalDate.now();
        return vehiculosHistoricos.stream()
                .filter(vehiculo -> vehiculo.getHoraEntrada().toLocalDate().isEqual(hoy))
                .collect(Collectors.toList());
    }
}
