package org.ejerciciosProgramacion;
import java.util.Scanner;

public class Ejercicio6 {

    // Función que halla el área de un rectángulo a partir de su base y su altura
    public static double areaRectangulo(double base, double altura) {
        return base * altura;
    }

    // Función que halla la hipotenusa de un triángulo rectángulo a partir de los catetos
    public static double hallarHipotenusa(double catetoA, double catetoB) {
        return Math.sqrt(catetoA * catetoA + catetoB * catetoB);
    }

    // Función que halla el área de un triángulo a partir de su base y su altura
    public static double areaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }

    // Función que halla el perímetro del terreno a partir de los lados A, B y C
    public static double perimetroTerreno(double A, double B, double C) {
        double hipotenusa = hallarHipotenusa(A - C, B); // Hallar la hipotenusa del triángulo
        return A + B + C + hipotenusa;
    }

    // Función que halla el área total del terreno (triángulo + rectángulo)
    public static double areaTerreno(double A, double B, double C) {
        double areaTriangulo = areaTriangulo(B, A - C); // Área del triángulo
        double areaRectangulo = areaRectangulo(B, C);   // Área del rectángulo
        return areaTriangulo + areaRectangulo;
    }

    // Método principal del ejercicio 3 que se invoca desde el menú
    public static void calcularAreaYPerimetro() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la dimensión A: ");
        double A = scanner.nextDouble();
        System.out.print("Ingrese la dimensión B: ");
        double B = scanner.nextDouble();
        System.out.print("Ingrese la dimensión C: ");
        double C = scanner.nextDouble();

        double area = areaTerreno(A, B, C);
        double perimetro = perimetroTerreno(A, B, C);

        System.out.println("El área del terreno es: " + area);
        System.out.println("El perímetro del terreno es: " + perimetro);
    }

}