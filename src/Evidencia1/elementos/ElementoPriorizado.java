package Evidencia1.elementos;

public class ElementoPriorizado implements Comparable<ElementoPriorizado> {
    public int prioridad;
    public int tiempoServicio;

    public ElementoPriorizado(int prioridad, int tiempoServicio) {
        this.prioridad = prioridad;
        this.tiempoServicio = tiempoServicio;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(ElementoPriorizado otro) {
        return Integer.compare(this.prioridad, otro.prioridad);
    }

    @Override
    public String toString() {
        return "Elemento[Prioridad=" + prioridad + "]";
    }
}