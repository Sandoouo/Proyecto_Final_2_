
package main;

import java.util.*;

public class MedicoEspecialista extends Medico {
    private String especialidad;

    public MedicoEspecialista(String nombre, String numeroIdentificacion, double valorHoraConsulta, String especialidad) {
        super(nombre, numeroIdentificacion, valorHoraConsulta);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public double calcularValorCita(int tiempoEnMinutos) {
        return getValorHoraConsulta() * (tiempoEnMinutos / 60.0);
    }

    @Override
    public boolean verificarDisponibilidad(Date fecha) {
        // Suponiendo que un médico especialista tiene horarios de lunes a viernes, 8 AM - 5 PM
        // Se puede implementar una lógica para verificar si la fecha está dentro de este rango
        return !getFechasReservadas().contains(fecha);
    }

    @Override
    public String toString() {
        return "Médico Especialista: " + getNombre() + " (Especialidad: " + especialidad + ")";
    }
}