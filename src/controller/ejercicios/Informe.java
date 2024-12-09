package controller.ejercicios;
import java.util.Scanner;
public class Informe {
        private static final double sueldoempead = 2500.0;
        private static final int  comisiones = 250;
        public  void programauto() {
        Scanner sc = new Scanner(System.in);
        double utilidad = 0.05;
        double precioauto= 0f;
        double sumaauto= 0f;
        double autosvendidos = 0;
        double autosConComision=0;
        String continuar = " ";
        do{
            System.out.println("Ingrese precio del auto");
            precioauto = sc.nextDouble();
            if (precioauto<=0) {
                System.out.println("Ingrese numeros mayores a cero");
                return;//romper ciclo
            }
            sumaauto += precioauto;
            autosvendidos++;
            if (precioauto > 10000) {
                autosConComision++;
            }
            System.out.println("Desea ingresar otro precio de auto?");
        System.out.println("Ingrese s para continuar ingresando precio de auto  u otra letra para generar generar el informe");
        sc.nextLine(); 
        continuar = sc.nextLine().toLowerCase();
        } while (continuar.equalsIgnoreCase("s")); 
        //llamada metodo de total comision de auto
        double totalComision = totalComision(autosConComision);
         // Método para calcular la utilidad en base a la venta total de autos 
        double utilidad1 = utilidad1(sumaauto, utilidad);
            // Metodo para calcular el monto total desl sueldo del empleado
        double sueldofin = sueldofin(sueldoempead, utilidad1, totalComision);
        //metodo para imprimir resultados
        mostrarResultados(sumaauto, autosvendidos, autosConComision, totalComision, sueldoempead,
    utilidad1, sueldofin);
    }
    
//Metodo para mostrar cada uno de los resultados requeridos 
public static void mostrarResultados(double sumaauto, double autosvendidos, double autosConComision, double totalComision, 
    double sueldoempead, double utilidad1, double sueldofin) {
        System.out.println("Precio total de venta de autos: $" + String.format("%.2f", sumaauto));
        System.out.println("Número de autos vendidos: " + String.format("%.0f", autosvendidos));
        System.out.println("Número de autos con comisión: " + String.format("%.0f", autosConComision));
        System.out.println("Valor total de comisión: $" + String.format("%.2f", totalComision));
        System.out.println("Sueldo base mensual: $" + String.format("%.2f", sueldoempead));
        System.out.println("Utilidad del valor total de ventas: $" + String.format("%.2f", utilidad1));
        System.out.println("Monto total: $" + String.format("%.2f", sueldofin));
    }
//Metodo para calcular la comision de auto
    public static double totalComision(double autosConComision) {
        return autosConComision * comisiones;
    }

    // Método para calcular la utilidad en base a la venta total de autos 
    public static double utilidad1(double sumaauto, double utilidad) {
        return sumaauto * utilidad; 
    }

    // Metodo para calcular el monto total desl sueldo del empleado
    public static double sueldofin(double sueldoempead, double utilidad1, double totalComision) {
        return sueldoempead + utilidad1 + totalComision;
    }}