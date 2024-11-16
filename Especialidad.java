class Especialidad {
    private String nombreEspecialidad;
    private String universidad;

    public Especialidad(String nombreEspecialidad, String universidad) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.universidad = universidad;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public String getUniversidad() {
        return universidad;
    }
}