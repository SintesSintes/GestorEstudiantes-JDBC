package estudiantes;

public class Estudiante {
    private String nombre;
    private int dni;
    private String curso;

    public Estudiante(String nombre, int dni, String curso) {
        this.nombre = nombre;
        this.dni = dni;
        this.curso = curso;
    }

    public String getNombre() { return nombre; }
    public int getDni() { return dni; }
    public String getCurso() { return curso; }

    @Override
    public String toString() {
        return nombre + " | DNI: " + dni + " | Curso: " + curso;
    }

    // Para que los duplicados se detecten por DNI
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Estudiante)) return false;
        Estudiante other = (Estudiante) obj;
        return this.dni == other.dni;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(dni);
    }
}
