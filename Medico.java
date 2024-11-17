package main;

import java.util.*;

public abstract class Medico {
    private String nombre;
    private String numeroIdentificacion;
    private double valorHoraConsulta;
    private List<Date> fechasReservadas;

    public Medico(String nombre, String numeroIdentificacion, double valorHoraConsulta) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.valorHoraConsulta = valorHoraConsulta;
        this.fechasReservadas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public double getValorHoraConsulta() {
        return valorHoraConsulta;
    }

    public List<Date> getFechasReservadas() {
        return fechasReservadas;
    }

   public abstract double calcularValorCita(int tiempoEnMinutos);

    public abstract boolean verificarDisponibilidad(Date fecha);

    public boolean agendarCita(Date fecha) {
        if (verificarDisponibilidad(fecha)) {
            fechasReservadas.add(fecha);
            return true;
        }
        return false;
    }
}
