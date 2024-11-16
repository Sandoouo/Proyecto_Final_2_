import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

abstract class Medico {
    protected String nombre;
    protected int numeroIdentificacion;
    protected double valorPorHora;
    protected List<Calendar> fechasReservadas;

    public Medico(String nombre, int numeroIdentificacion, double valorPorHora) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.valorPorHora = valorPorHora;
        this.fechasReservadas = new ArrayList<>();
    }

    public abstract double calcularValorCita(int minutos);

    public abstract boolean verificarDisponibilidad(Calendar fecha);

    public String getNombre() {
        return nombre;
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public List<Calendar> getFechasReservadas() {
        return fechasReservadas;
    }

    public void reservarFecha(Calendar fecha) {
        fechasReservadas.add(fecha);
    }
}