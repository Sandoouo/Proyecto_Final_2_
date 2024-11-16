import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class Clinica {
    private List<Medico> medicos;
    private final String archivoMedicos = "medicos.txt";

    public Clinica() {
        medicos = new ArrayList<>();
        cargarMedicos();
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
        guardarMedicoEnArchivo(medico);
    }

    public List<Medico> buscarMedicosDisponibles(Calendar fecha) {
        List<Medico> disponibles = new ArrayList<>();
        for (Medico medico : medicos) {
            if (medico.verificarDisponibilidad(fecha)) {
                disponibles.add(medico);
            }
        }
        return disponibles;
    }

    private void guardarMedicoEnArchivo(Medico medico) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoMedicos, true))) {
            writer.write(medico.getNombre() + "," + medico.getNumeroIdentificacion() + "," + medico.valorPorHora + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el médico en el archivo: " + e.getMessage());
        }
    }

    private void cargarMedicos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoMedicos))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                int id = Integer.parseInt(datos[1]);
                double valorPorHora = Double.parseDouble(datos[2]);
                // Por simplicidad, asumimos que todos son médicos generales.
                medicos.add(new MedicoEspecialista(nombre, id, valorPorHora, null));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los médicos del archivo: " + e.getMessage());
        }
    }
}