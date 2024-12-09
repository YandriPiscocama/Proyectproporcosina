package controller.ejercicios;

import java.util.Scanner;

public class Serie {
    public static void serienumeros() {
        Scanner sc = new Scanner(System.in);
        // Solicitar al usuario el número de términos de la serie
        System.out.print("Ingrese el número de términos de la serie: ");
        int cantidadTerminos = sc.nextInt();

        // Calcular la serie y mostrar resultados
        double suma = calcularSerie(cantidadTerminos);
        System.out.printf("\nSuma de la serie: %.5f\n", suma);
    }

    // Función para calcular la serie y mostrar la serie completa
    public static double calcularSerie(int cantidadTerminos) {
        int numerador1 = 1, numerador2 = 1; // Valores iniciales de Fibonacci
        int denominador = 1; // Denominador inicial
        int potencia = 2; // Potencia inicial
        int signo = 1; // Alternancia de signos: 1 para positivo, -1 para negativo
        double suma = 0; // Suma acumulativa de la serie

        StringBuilder serieCompleta = new StringBuilder(); // Para almacenar la serie generada

        System.out.println("\nSerie generada:");
        for (int i = 1; i <= cantidadTerminos; i++) {
            // Calcular el numerador usando Fibonacci
            int numerador = numerador1;
            numerador1 = numerador2;
            numerador2 = numerador + numerador1;

            // Calcular el término actual
            double termino = calcularTermino(numerador, denominador, potencia, signo);

            // Agregar el término a la serie completa
            if (i > 1) {
                serieCompleta.append((signo > 0) ? " + " : " - ");
            }
            serieCompleta.append(String.format("(%d / %d)^%d", numerador, denominador, potencia));

            // Mostrar término
            mostrarTermino(i, numerador, denominador, potencia, signo, termino);

            // Sumar el término a la suma total
            suma += termino;

            // Actualizar valores
            denominador += 2; // Incrementar el denominador en 2
            potencia += 2; // Incrementar la potencia en 2
            signo = alternarSigno(i, signo);
        }

        // Mostrar la serie generada
        System.out.println("\nSerie completa:");
        System.out.println(serieCompleta);

        return suma;
    }

    // Función para calcular un término de la serie
    public static double calcularTermino(int numerador, int denominador, int potencia, int signo) {
        return Math.pow((double) numerador / denominador, potencia) * signo;
    }

    // Función para alternar el signo según la posición
    public static int alternarSigno(int posicion, int signoActual) {
        if (posicion % 4 == 0)
            return 1; // Cambiar signo después de dos negativos
        else if (posicion % 4 == 2)
            return -1; // Cambiar signo después de dos positivos
        return signoActual;
    }

    // Función para mostrar los detalles de un término
    public static void mostrarTermino(int posicion, int numerador, int denominador, int potencia,
    int signo, double valor) {
        System.out.printf("Término %d: (%d / %d)^%d %s = %.5f\n",
        posicion, numerador, denominador, potencia, (signo > 0) ? "+" : "-", valor);
    }
}

