package main;

//import model.Usuario;
//import model.Medico;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.List;

class SistemaCitas {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Clinica clinica = new Clinica();

            //--------------------------------------------------------------------------------------
            System.out.println("Ingrese su correo electrónico:");
            String correo = reader.readLine();

            System.out.println("Ingrese su nombre completo:");
            String nombre = reader.readLine();

            System.out.println("Ingrese su número de identificación:");
            int identificacion = Integer.parseInt(reader.readLine());

            Usuario usuario = new Usuario(correo, nombre, identificacion);

            //-----------------------------------------------------------------------------------------
            System.out.println("Ingrese el año de la cita (ejemplo: 2024):");
            int anio = Integer.parseInt(reader.readLine());

            System.out.println("Ingrese el mes de la cita (1-12):");
            int mes = Integer.parseInt(reader.readLine()) - 1; // Los meses empiezan en 0 en Calendar

            System.out.println("Ingrese el día de la cita:");
            int dia = Integer.parseInt(reader.readLine());

            System.out.println("Ingrese la hora de la cita (formato 24 horas):");
            int hora = Integer.parseInt(reader.readLine());

            System.out.println("Ingrese los minutos de la cita:");
            int minutos = Integer.parseInt(reader.readLine());

            Calendar fecha = Calendar.getInstance();
            fecha.set(anio, mes, dia, hora, minutos);

            //------------------------------------------------------------------------------------
            List<Medico> disponibles = clinica.buscarMedicosDisponibles(fecha);
            if (disponibles.isEmpty()) {
                System.out.println("No hay médicos disponibles para la fecha ingresada.");
            } else {
                System.out.println("Médicos disponibles:");
                for (int i = 0; i < disponibles.size(); i++) {
                    Medico medico = disponibles.get(i);
                    System.out.println((i + 1) + ". Médico: " + medico.getNombre() +
                            " | ID: " + medico.getNumeroIdentificacion());
                }

                //---------------------------------------------------------------------------------
                System.out.println("Seleccione el número del médico para agendar la cita:");
                int seleccion = Integer.parseInt(reader.readLine()) - 1;

                if (seleccion >= 0 && seleccion < disponibles.size()) {
                    Medico medicoSeleccionado = disponibles.get(seleccion);
                    medicoSeleccionado.reservarFecha(fecha);
                    System.out.println("Cita agendada con el Dr./Dra. " + medicoSeleccionado.getNombre());
                } else {
                    System.out.println("Selección inválida.");
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}