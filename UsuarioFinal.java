package main;

import java.util.*;
import java.text.SimpleDateFormat;

public class UsuarioFinal extends Usuario {
    private Clinica clinica;

    public UsuarioFinal(String correo, String nombre, String numeroIdentificacion, String claveIngreso) {
        super(correo, nombre, numeroIdentificacion, claveIngreso, "UsuarioFinal");
        clinica = new Clinica();
    }

    @Override
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- Menú Usuario Final ----");
            System.out.println("1. Ver médicos disponibles");
            System.out.println("2. Agendar cita");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    mostrarMedicosDisponibles();
                    break;
                case 2:
                    agendarCita();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void mostrarMedicosDisponibles() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione el tipo de médico:");
        System.out.println("1. Médico Especialista");
        System.out.println("2. Médico Cirujano");
        System.out.print("Seleccione una opción: ");
        int tipoMedico = sc.nextInt();
        sc.nextLine();  // Consumir el salto de línea

        System.out.print("Ingrese la fecha de la cita (dd/MM/yyyy): ");
        String fechaStr = sc.nextLine();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = formato.parse(fechaStr);  // Aquí deberías convertir el string en una fecha válida

        // Filtrar médicos según tipo
        List<Medico> medicosDisponibles = new ArrayList<>();
        for (Medico medico : clinica.getMedicos()) {
            if (tipoMedico == 1 && medico instanceof MedicoEspecialista) {
                if (medico.verificarDisponibilidad(fecha)) {
                    medicosDisponibles.add(medico);
                }
            } else if (tipoMedico == 2 && medico instanceof MedicoCirujano) {
                if (medico.verificarDisponibilidad(fecha)) {
                    medicosDisponibles.add(medico);
                }
            }
        }

        // Mostrar médicos disponibles
        if (medicosDisponibles.isEmpty()) {
            System.out.println("No hay médicos disponibles para esa fecha.");
        } else {
            System.out.println("\nMédicos disponibles:");
            for (int i = 0; i < medicosDisponibles.size(); i++) {
                System.out.println((i + 1) + ". " + medicosDisponibles.get(i));
            }
        }
    }

    private void agendarCita() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione el tipo de médico:");
        System.out.println("1. Médico Especialista");
        System.out.println("2. Médico Cirujano");
        System.out.print("Seleccione una opción: ");
        int tipoMedico = sc.nextInt();
        sc.nextLine();  // Consumir el salto de línea

        System.out.print("Ingrese la fecha de la cita (dd/MM/yyyy): ");
        String fechaStr = sc.nextLine();
        Date fecha = new Date(fechaStr);  // Aquí debes hacer la conversión adecuada

        List<Medico> medicosDisponibles = new ArrayList<>();
        for (Medico medico : clinica.getMedicos()) {
            if (tipoMedico == 1 && medico instanceof MedicoEspecialista) {
                if (medico.verificarDisponibilidad(fecha)) {
                    medicosDisponibles.add(medico);
                }
            } else if (tipoMedico == 2 && medico instanceof MedicoCirujano) {
                if (medico.verificarDisponibilidad(fecha)) {
                    medicosDisponibles.add(medico);
                }
            }
        }

        if (medicosDisponibles.isEmpty()) {
            System.out.println("No hay médicos disponibles para esa fecha.");
        } else {
            System.out.println("\nMédicos disponibles:");
            for (int i = 0; i < medicosDisponibles.size(); i++) {
                System.out.println((i + 1) + ". " + medicosDisponibles.get(i));
            }

            System.out.print("Seleccione un médico para agendar la cita: ");
            int seleccion = sc.nextInt();
            Medico medicoSeleccionado = medicosDisponibles.get(seleccion - 1);

            if (medicoSeleccionado.agendarCita(fecha)) {
                System.out.println("Cita agendada exitosamente con " + medicoSeleccionado.getNombre());
            } else {
                System.out.println("Error al agendar la cita.");
            }
        }
    }
}


