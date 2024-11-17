package main;

import java.util.Scanner;

public class Sistema {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Crear algunos usuarios para probar
        Administrador admin = new Administrador("admin@clinica.com", "Admin", "1234", "admin123");
        UsuarioFinal usuario1 = new UsuarioFinal("usuario@clinica.com", "Juan Pérez", "5678", "user123");

        // Se pueden almacenar los usuarios en una lista o base de datos en una implementación real
        Usuario[] usuarios = {admin, usuario1};

        // Sistema de login
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

