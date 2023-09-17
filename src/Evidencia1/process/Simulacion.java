package Evidencia1.process;
import Evidencia1.elementos.Valorespila;
import Evidencia1.elementos.ElementoPriorizado;

import java.util.PriorityQueue;
import java.util.Random;

public class Simulacion {
    private static int tiempoS;
    private static int topeC;
    private static int minLlegada;
    private static int maxLlegada;
    private static int minServicio;
    private static int maxServicio;
    private static int cambioIntervalo;

    private PriorityQueue<ElementoPriorizado> colaPriorizada;
    private Random rand;
    private int tiempoActual;

    public Simulacion() {
        // Inicializa los valores estáticos desde Valorespila
        tiempoS = Valorespila.duracionSimulacion;
        topeC = Valorespila.topeCola;
        minLlegada = Valorespila.minTiempoLlegada;
        maxLlegada = Valorespila.maxTiempoLlegada;
        minServicio = Valorespila.minTiempoServicio;
        maxServicio = Valorespila.maxTiempoServicio;
        cambioIntervalo = Valorespila.cambiodeIntervalo;

        colaPriorizada = new PriorityQueue<>();
        rand = new Random();
        tiempoActual = 0;
    }

    public void iniciarSimulacion() {
        System.out.println("Simulación de Cola Priorizada con Tope");
        System.out.println("Duración de la simulación: " + tiempoS + " segundos");
        System.out.println("Tope de la cola: " + topeC);
        System.out.println("Rango de tiempo de llegada: " + minLlegada + " - " + maxLlegada + " segundos");
        System.out.println("Rango de tiempo de servicio: " + minServicio + " - " + maxServicio + " segundos");

        while (tiempoActual < tiempoS) {
            int tiempoLlegada = rand.nextInt(maxLlegada - minLlegada + 1) + minLlegada;
            int tiempoServicio = rand.nextInt(maxServicio - minServicio + 1) + minServicio;

            if (tiempoActual % cambioIntervalo == 0) {
                mostrarEstadoCola();
            }

            if (tiempoActual % tiempoLlegada == 0) {
                if (colaPriorizada.size() < topeC) {
                    int prioridad = rand.nextInt(5) + 1;
                    ElementoPriorizado elemento = new ElementoPriorizado(prioridad, tiempoServicio);
                    colaPriorizada.offer(elemento);
                    System.out.println("Nuevo elemento en cola: Prioridad " + prioridad);
                } else {
                    System.out.println("Cola llena, elemento rechazado.");
                }
            }

            if (!colaPriorizada.isEmpty() && tiempoActual % tiempoServicio == 0) {
                ElementoPriorizado elementoAtendido = colaPriorizada.poll();
                System.out.println("Elemento atendido y removido de la cola: Prioridad " + elementoAtendido.getPrioridad());
            }

            tiempoActual++;
            try {
                Thread.sleep(1000); // Simula un segundo de tiempo real
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void mostrarEstadoCola() {
        System.out.println("Tiempo: " + tiempoActual + " segundos");
        System.out.println("Tamaño de la cola: " + colaPriorizada.size());
        System.out.println("Contenido de la cola: " + colaPriorizada);
        System.out.println("-------------");
    }
}