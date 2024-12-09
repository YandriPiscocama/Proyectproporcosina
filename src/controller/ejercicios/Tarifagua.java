package controller.ejercicios;
import java.util.Scanner;
public class Tarifagua {
    public static void tarifaagua(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String opcion;
        do {
            // Solicitar datos del usuario
            System.out.print("Consumo mensual en m³: ");
            double consumo = entrada.nextDouble();
            System.out.print("¿Es una persona de la tercera edad? (s/n): ");
            boolean esTerceraEdad = leerBooleano(entrada);

            System.out.print("¿Tiene alguna discapacidad? (s/n): ");
            boolean esDiscapacitado = leerBooleano(entrada);

            double porcentajeDiscapacidad = 0;
            if (esDiscapacitado) {
                System.out.print("Porcentaje de discapacidad (%): ");
                porcentajeDiscapacidad = entrada.nextDouble();
            }

            // Cálculo del servicio de agua potable
            double tarifaBase = calcularServicio(consumo);
            double descuento = calcularDescuento(consumo, tarifaBase, esTerceraEdad, esDiscapacitado, porcentajeDiscapacidad);
            double tarifaConDescuento = tarifaBase - descuento;

            // Cálculo de otros rubros
            double alcantarillado = tarifaConDescuento * 0.35;
            double basura = 0.75;
            double procesamiento = 0.50;

            // Sumar rubros y mostrar desglose
            double total = tarifaConDescuento + alcantarillado + basura + procesamiento;
            mostrarDesglose(tarifaBase, descuento, tarifaConDescuento, alcantarillado, basura,
                            procesamiento, total);
            // Continuar
            System.out.print("\n¿Desea calcular otra tarifa? (s/n): ");
            opcion = entrada.next();
        } while (opcion.equalsIgnoreCase("s"));
        System.out.println("¡Gracias !");
    }
    public static boolean leerBooleano(Scanner entrada) {
        String respuesta;
        do {
            respuesta = entrada.next();
            if (respuesta.equalsIgnoreCase("s")) return true;
            if (respuesta.equalsIgnoreCase("n")) return false;
            System.out.print("Respuesta inválida. Intente nuevamente (s/n): ");
        } while (true);
    }

    public static double calcularServicio(double consumo) {
        if (consumo <= 15) return 3.00;
        if (consumo <= 25) return 3.00 + (consumo - 15) * 0.10;
        if (consumo <= 40) return 3.00 + (10 * 0.10) + (consumo - 25) * 0.20;
        if (consumo <= 60) return 3.00 + (10 * 0.10) + (15 * 0.20) + (consumo - 40) * 0.30;
        return 3.00 + (10 * 0.10) + (15 * 0.20) + (20 * 0.30) + (consumo - 60) * 0.35;
    }

    public static double calcularDescuento(double consumo, double tarifaBase, boolean terceraEdad, 
    boolean discapacidad, double porcentaje) {
        double descuento = 0;
        double descuentoBase = 3.00; // Siempre sobre el rango base

        if (terceraEdad) {
            if (consumo <= 15) {
                descuento += descuentoBase * 0.50; // Descuento del 50%
            } else {
                descuento += descuentoBase * 0.30; // Descuento del 30% si supera 15 m³
            }
        }

        if (discapacidad) {
            descuento += descuentoBase * (porcentaje / 100); // Porcentaje de discapacidad sobre el rango base
        }

        return descuento;
    }
    public static void mostrarDesglose(double tarifaBase, double descuento, double tarifaConDescuento,double 
    alcantarillado, double basura, double procesamiento, double total) {
        System.out.println("\nDetalle de la factura:");
        System.out.printf("Precio inicial (sin descuento): $%.2f\n", tarifaBase);
        System.out.printf("Descuento aplicado: $%.2f\n", descuento);
        System.out.printf("Precio con descuento: $%.2f\n", tarifaConDescuento);
        System.out.printf("Impuesto de alcantarillado (35%%): $%.2f\n", alcantarillado);
        System.out.printf("Recolección de basura: $%.2f\n", basura);
        System.out.printf("Procesamiento de datos: $%.2f\n", procesamiento);
        System.out.printf("Total a pagar: $%.2f\n", total);
    }
}
