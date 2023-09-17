package Evidencia1.ui;
import Evidencia1.elementos.Valorespila;
import Evidencia1.process.Simulacion;

import java.util.Scanner;

public class CLI {
    public static Scanner scanner;

    public static void Menu() {
        scanner = new Scanner(System.in);
        int opcion;
        Simulacion simulacion = new Simulacion();

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    establecerTopeCola();
                    break;
                case 2:
                    establecerRangoTiempoLlegada();
                    break;
                case 3:
                    establecerRangoTiempoServicio();
                    break;
                case 4:
                    simulacion.iniciarSimulacion();
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("===== Menú =====");
        System.out.println("1. Establecer tope de la cola");
        System.out.println("2. Establecer rango de tiempo de llegada");
        System.out.println("3. Establecer rango de tiempo de servicio");
        System.out.println("4. Iniciar simulación");
        System.out.println("5. Salir");
        System.out.print("Elija una opción: ");
    }

    private static void establecerTopeCola() {
        System.out.print("Ingrese el tope de la cola: ");
        Valorespila.topeCola = scanner.nextInt();
        System.out.println("Tope de la cola establecido en: " + Valorespila.topeCola);
    }

    private static void establecerRangoTiempoLlegada() {
        int minTiempoLlegada, maxTiempoLlegada;

        do {
            System.out.print("Ingrese el tiempo mínimo de llegada: ");
            minTiempoLlegada = scanner.nextInt();
            System.out.print("Ingrese el tiempo máximo de llegada: ");
            maxTiempoLlegada = scanner.nextInt();

            if (minTiempoLlegada >= maxTiempoLlegada) {
                System.out.println("El tiempo mínimo debe ser menor que el tiempo máximo. Inténtelo de nuevo.");
            }
        } while (minTiempoLlegada >= maxTiempoLlegada);

        Valorespila.minTiempoLlegada = minTiempoLlegada;
        Valorespila.maxTiempoLlegada = maxTiempoLlegada;

        System.out.println("Rango de tiempo de llegada establecido: " + minTiempoLlegada + " - " + maxTiempoLlegada + " segundos");
    }

    private static void establecerRangoTiempoServicio() {
        int minTiempoServicio, maxTiempoServicio;

        do {
            System.out.print("Ingrese el tiempo mínimo de servicio: ");
            minTiempoServicio = scanner.nextInt();
            System.out.print("Ingrese el tiempo máximo de servicio: ");
            maxTiempoServicio = scanner.nextInt();

            if (minTiempoServicio >= maxTiempoServicio) {
                System.out.println("El tiempo mínimo debe ser menor que el tiempo máximo. Inténtelo de nuevo.");
            }
        } while (minTiempoServicio >= maxTiempoServicio);

        Valorespila.minTiempoServicio = minTiempoServicio;
        Valorespila.maxTiempoServicio = maxTiempoServicio;

        System.out.println("Rango de tiempo de servicio establecido: " + minTiempoServicio + " - " + maxTiempoServicio + " segundos");
    }
}
