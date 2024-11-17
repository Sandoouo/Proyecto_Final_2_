

package main;

import java.util.*;

public class MedicoCirujano extends Medico {
    private List<String> tiposCirugia;

    // Constructor con lista de cirugías
    public MedicoCirujano(String nombre, String numeroIdentificacion, double valorHoraConsulta, List<String> tiposCirugia) {
        super(nombre, numeroIdentificacion, valorHoraConsulta);
        this.tiposCirugia = tiposCirugia;
    }

    public List<String> getTiposCirugia() {
        return tiposCirugia;
    }

    // Método para agregar cirugías dinámicamente
    public void agregarCirugia(String cirugia) {
        this.tiposCirugia.add(cirugia);
    }

    @Override
    public double calcularValorCita(int tiempoEnMinutos) {
        return getValorHoraConsulta() * (tiempoEnMinutos / 60.0);
    }

    @Override
    public boolean verificarDisponibilidad(Date fecha) {
        // Suponiendo que el cirujano solo trabaja de lunes a viernes, 8 AM - 2 PM
        return !getFechasReservadas().contains(fecha);
    }

    @Override
    public String toString() {
        return "Médico Cirujano: " + getNombre() + " (Cirugías: " + String.join(", ", tiposCirugia) + ")";
    }
}
