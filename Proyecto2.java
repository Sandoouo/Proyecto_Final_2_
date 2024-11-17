package main;

import java.util.*;

public class Proyecto2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear algunos usuarios
        Administrador admin = new Administrador("admin@clinica.com", "Admin", "1234", "admin123"); //admin@clinica.com y admin123
        UsuarioFinal usuarioFinal = new UsuarioFinal("usuario@clinica.com", "Juan Pérez", "5678", "user123"); //"usuario@clinica.com" y user123

        // Crear el sistema de autenticación
        Usuario[] usuarios = {admin, usuarioFinal};

        // Login
        System.out.println("---- Sistema de Clínica ----");
        System.out.print("Correo electrónico: ");
        String correo = sc.nextLine();
        System.out.print("Clave de ingreso: ");
        String clave = sc.nextLine();

        Usuario usuarioLogueado = autenticarUsuario(correo, clave, usuarios);

        if (usuarioLogueado != null) {
            System.out.println("¡Bienvenido, " + usuarioLogueado.getNombre() + "!");
            usuarioLogueado.mostrarMenu();
        } else {
            System.out.println("Correo o clave incorrectos.");
        }
    }

    private static Usuario autenticarUsuario(String correo, String clave, Usuario[] usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo) && usuario.getClaveIngreso().equals(clave)) {
                return usuario;
            }
        }
        return null;  // Usuario no encontrado
    }
}