/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Programa de Ingenier�a de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Gu�a 2 - Actividad 2
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

    // M�todos para retornar el n�mero de monedas de cada denominaci�n
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

    // M�todo para retornar el estado de la alcanc�a
    public String darEstado() {
        return estado == 0 ? "NO ROTA" : "ROTA";
    }

    // M�todo para calcular el total de dinero en la alcanc�a
    public int calcularTotalDinero() {
        return numeroMonedas50 * 50 +
                numeroMonedas100 * 100 +
                numeroMonedas200 * 200 +
                numeroMonedas500 * 500 +
                numeroMonedas1000 * 1000;
    }

    // M�todos para agregar monedas de cada denominaci�n
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

    // M�todo para romper la alcanc�a
    public void romperAlcancia() {
        estado = 1;
    }

    // M�todo para obtener la denominaci�n con mayor cantidad de monedas
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

    // M�todo para determinar si la alcanc�a es valiosa
    public boolean valiosa() {
        return numeroMonedas50 == 0 &&
                numeroMonedas100 == 0 &&
                numeroMonedas200 == 0 &&
                (numeroMonedas500 > 0 || numeroMonedas1000 > 0);
    }
}
