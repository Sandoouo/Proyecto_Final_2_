package main;

import java.util.Scanner;

public class Administrador extends Usuario {

    public Administrador(String correo, String nombre, String numeroIdentificacion, String claveIngreso) {
        super(correo, nombre, numeroIdentificacion, claveIngreso, "Administrador");
    }

    @Override
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        Clinica clinica = new Clinica();
        clinica.cargarMedicos();

        while (true) {
            System.out.println("\n---- Menú Administrador ----");
            System.out.println("1. Crear nuevo médico");
            System.out.println("2. Ver médicos disponibles");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    clinica.crearMedico();
                    break;
                case 2:
                    // Mostrar médicos disponibles
                    for (Medico medico : clinica.getMedicos()) {
                        System.out.println(medico);
                    }
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
