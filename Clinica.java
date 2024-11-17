

package main;

import java.io.*;
import java.util.*;

public class Clinica {
    private List<Medico> medicos;

    public Clinica() {
        this.medicos = new ArrayList<>();
    }

    public void crearMedico() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Tipo de médico? (1: Especialista, 2: Cirujano)");
        int tipo = sc.nextInt();
        sc.nextLine();  // Consumir el salto de línea

        System.out.print("Nombre del médico: ");
        String nombre = sc.nextLine();
        System.out.print("Número de identificación: ");
        String identificacion = sc.nextLine();
        System.out.print("Valor por hora de consulta: ");
        double valorHora = sc.nextDouble();
        sc.nextLine();  // Consumir el salto de línea

        if (tipo == 1) {
            System.out.print("Especialidad: ");
            String especialidad = sc.nextLine();
            MedicoEspecialista medico = new MedicoEspecialista(nombre, identificacion, valorHora, especialidad);
            medicos.add(medico);
        } else if (tipo == 2) {
            List<String> cirugias = new ArrayList<>();
            MedicoCirujano medico = new MedicoCirujano(nombre, identificacion, valorHora, cirugias);
            System.out.print("Número de tipos de cirugía: ");
            int cantidad = sc.nextInt();
            sc.nextLine();  // Consumir el salto de línea
            for (int i = 0; i < cantidad; i++) {
                System.out.print("Tipo de cirugía " + (i + 1) + ": ");
                String cirugia = sc.nextLine();
                medico.agregarCirugia(cirugia);
            }
            medicos.add(medico);
        }

        // Guardar el médico en un archivo
        guardarMedicos();
    }

    public void cargarMedicos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("medicos.dat"))) {
            medicos = (List<Medico>) ois.readObject();
        } catch (Exception e) {
            System.out.println("No se pudo cargar la lista de médicos.");
        }
    }

    private void guardarMedicos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("medicos.dat"))) {
            oos.writeObject(medicos);
        } catch (IOException e) {
            System.out.println("Error al guardar los médicos.");
        }
    }

    public List<Medico> getMedicos() {
        return medicos;
    }
}


