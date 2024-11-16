class Usuario {
    private String correo;
    private String nombre;
    private int identificacion;

    public Usuario(String correo, String nombre, int identificacion) {
        this.correo = correo;
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }
}