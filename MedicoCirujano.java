import java.util.Calendar;
import java.util.List;

class MedicoCirujano extends Medico {
    private List<String> tiposCirugia;

    public MedicoCirujano(String nombre, int numeroIdentificacion, double valorPorHora, List<String> tiposCirugia) {
        super(nombre, numeroIdentificacion, valorPorHora);
        this.tiposCirugia = tiposCirugia;
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

    public List<String> getTiposCirugia() {
        return tiposCirugia;
    }
}