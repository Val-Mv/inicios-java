/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Guía 2 - Actividad 2
 * Ejercicio: alcancia
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package mundo;

public class Alcancia {
    // Atributos
    private int numeroMonedas50;
    private int numeroMonedas100;
    private int numeroMonedas200;
    private int numeroMonedas500;
    private int numeroMonedas1000;
    private int estado;

    // Constructor
    public Alcancia() {
        numeroMonedas50 = 0;
        numeroMonedas100 = 0;
        numeroMonedas200 = 0;
        numeroMonedas500 = 0;
        numeroMonedas1000 = 0;
        estado = 0;
    }

    // Métodos para retornar el número de monedas de cada denominación
    public int darNumeroMonedas50() {
        return numeroMonedas50;
    }

    public int darNumeroMonedas100() {
        return numeroMonedas100;
    }

    public int darNumeroMonedas200() {
        return numeroMonedas200;
    }

    public int darNumeroMonedas500() {
        return numeroMonedas500;
    }

    public int darNumeroMonedas1000() {
        return numeroMonedas1000;
    }

    // Método para retornar el estado de la alcancía
    public String darEstado() {
        return estado == 0 ? "NO ROTA" : "ROTA";
    }

    // Método para calcular el total de dinero en la alcancía
    public int calcularTotalDinero() {
        return numeroMonedas50 * 50 +
                numeroMonedas100 * 100 +
                numeroMonedas200 * 200 +
                numeroMonedas500 * 500 +
                numeroMonedas1000 * 1000;
    }

    // Métodos para agregar monedas de cada denominación
    public void agregarMoneda50() {
        if (estado == 0) {
            numeroMonedas50++;
        }
    }

    public void agregarMoneda100() {
        if (estado == 0) {
            numeroMonedas100++;
        }
    }

    public void agregarMoneda200() {
        if (estado == 0) {
            numeroMonedas200++;
        }
    }

    public void agregarMoneda500() {
        if (estado == 0) {
            numeroMonedas500++;
        }
    }

    public void agregarMoneda1000() {
        if (estado == 0) {
            numeroMonedas1000++;
        }
    }

    // Método para romper la alcancía
    public void romperAlcancia() {
        estado = 1;
    }

    // Método para obtener la denominación con mayor cantidad de monedas
    public int obtenerDenominacionMasNumerosa() {
        int max = Math.max(
                Math.max(numeroMonedas50, numeroMonedas100),
                Math.max(numeroMonedas200, Math.max(numeroMonedas500, numeroMonedas1000))
        );

        if (max == numeroMonedas50) return 50;
        if (max == numeroMonedas100) return 100;
        if (max == numeroMonedas200) return 200;
        if (max == numeroMonedas500) return 500;
        return 1000;
    }

    // Método para determinar si la alcancía es valiosa
    public boolean valiosa() {
        return numeroMonedas50 == 0 &&
                numeroMonedas100 == 0 &&
                numeroMonedas200 == 0 &&
                (numeroMonedas500 > 0 || numeroMonedas1000 > 0);
    }
}
