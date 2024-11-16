import java.util.Calendar;

class MedicoEspecialista extends Medico {
    private Especialidad especialidad;

    public MedicoEspecialista(String nombre, int numeroIdentificacion, double valorPorHora, Especialidad especialidad) {
        super(nombre, numeroIdentificacion, valorPorHora);
        this.especialidad = especialidad;
    }

    @Override
    public double calcularValorCita(int minutos) {
        return (valorPorHora / 60) * minutos;
    }

    @Override
    public boolean verificarDisponibilidad(Calendar fecha) {
        for (Calendar reservada : fechasReservadas) {
            if (reservada.equals(fecha)) {
                return false;
            }
        }
        return true;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}