import java.util.Scanner;
import controller.ejercicios.Informe;
import controller.ejercicios.Serie;
import controller.ejercicios.Tarifagua;
import controller.ejercicios.llamadas;
public class Main {
    public static void main(String[] args) {
        Informe infor = new Informe();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Selecciona una opción:");
            System.out.println("1.  Informe desglosado por empleado ");
            System.out.println("2. llamadas telefónicas internacionales");
            System.out.println("3. Empresa municipal de agua potable de Loja");
            System.out.println("4. Serie");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                System.out.println("Bienvenido al programa de nuestra compania");
                infor.programauto();
                    break;
                case 2:
                System.out.println("Bienvenido a receptorio de llamadas telefónicas");
                llamadas.llamada();
                break;
                case 3:
                System.out.println("Bienvenido a tu gestor de mededidor de agua");
                Tarifagua.tarifaagua(args);
                case 4:
                System.out.println("Bienvenido a la presentacion de la serie ");
                Serie.serienumeros();
                break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 5);
        scanner.close();}
}