package controller.ejercicios;

import java.util.Scanner;

public class llamadas {
    // Constantes para los precios por minuto por zona
    public static final double PRECIO_AMERICA_NORTE = 2.75;
    public static final double PRECIO_AMERICA_CENTRAL = 1.89;
    public static final double PRECIO_AMERICA_SUR = 1.60;
    public static final double PRECIO_EUROPA = 3.50;
    public static final double PRECIO_ASIA = 4.50;
    public static final double PRECIO_AFRICA = 3.10;
    public static final double PRECIO_OCEANIA = 3.00;
    public static final double PRECIO_RESTO_MUNDO = 6.00;
    public static double calcularCostoLlamada(Zona zona, int minutos) {
        double precioPorMinuto = obtenerPrecioPorMinuto(zona);
        return precioPorMinuto * minutos;
    }
    public  static void llamada () {
        // Crear objeto Scanner para capturar entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar la zona de destino
        System.out.print("Ingrese la zona de destino: ");
        String zonaInput = scanner.nextLine().toUpperCase().replace(" ", "_");
        Zona zonaDestino = Zona.valueOf(zonaInput);

        // Solicitar la cantidad de minutos
        System.out.print("Ingrese la cantidad de minutos de la llamada: ");
        int minutos = scanner.nextInt();

        // Calcular el costo total de la llamada
        double costoTotal = calcularCostoLlamada(zonaDestino, minutos);

        // Mostrar el costo total
        System.out.printf("El costo total de la llamada de %d minutos a la zona %s es: $%.2f%n", minutos, zonaDestino.name(), costoTotal);

    }

    public static double obtenerPrecioPorMinuto(Zona zona) {
        switch (zona) {
            case AMERICA_DEL_NORTE:
                return PRECIO_AMERICA_NORTE;
            case AMERICA_CENTRAL:
                return PRECIO_AMERICA_CENTRAL;
            case AMERICA_DEL_SUR:
                return PRECIO_AMERICA_SUR;
            case EUROPA:
                return PRECIO_EUROPA;
            case ASIA:
                return PRECIO_ASIA;
            case AFRICA:
                return PRECIO_AFRICA;
            case OCEANIA:
                return PRECIO_OCEANIA;
            case RESTO_DEL_MUNDO:
                return PRECIO_RESTO_MUNDO;
            default:
                throw new IllegalArgumentException("Zona de destino no válida");
        }
    }
    public enum Zona {
        AMERICA_DEL_NORTE,
        AMERICA_CENTRAL,
        AMERICA_DEL_SUR,
        EUROPA,
        ASIA,
        AFRICA,
        OCEANIA,
        RESTO_DEL_MUNDO
    }
}
