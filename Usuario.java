package main;

public abstract class Usuario {
    private String correo;
    private String nombre;
    private String numeroIdentificacion;
    private String claveIngreso;
    private String tipoUsuario;  // "Administrador" o "UsuarioFinal"

    public Usuario(String correo, String nombre, String numeroIdentificacion, String claveIngreso, String tipoUsuario) {
        this.correo = correo;
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.claveIngreso = claveIngreso;
        this.tipoUsuario = tipoUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getClaveIngreso() {
        return claveIngreso;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public abstract void mostrarMenu();
}
