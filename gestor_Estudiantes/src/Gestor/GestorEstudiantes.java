package Gestor;

import estudiantes.Estudiante;
import java.sql.*;

public class GestorEstudiantes {
    private Connection conexion;

    public GestorEstudiantes() {
        conexion = Conexion.getConnection();
    }

    // === AGREGAR ===
    public void agregarEstudiante(Estudiante e) {
        String sql = "INSERT INTO estudiantes (nombre, dni, curso) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, e.getNombre());
            ps.setInt(2, e.getDni());
            ps.setString(3, e.getCurso());
            ps.executeUpdate();
            System.out.println("✅ Estudiante agregado correctamente.");
        } catch (SQLException ex) {
            System.out.println("❌ Error al agregar estudiante.");
            ex.printStackTrace();
        }
    }

    // === LISTAR ===
    public void listarEstudiantes() {
        String sql = "SELECT * FROM estudiantes ORDER BY nombre ASC";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            System.out.println("\n📋 LISTA DE ESTUDIANTES:");
            boolean vacio = true;
            while (rs.next()) {
                vacio = false;
                System.out.println("👤 Nombre: " + rs.getString("nombre")
                        + " | DNI: " + rs.getInt("dni")
                        + " | Curso: " + rs.getString("curso"));
            }
            if (vacio) System.out.println("⚠️ No hay estudiantes cargados.");
        } catch (SQLException e) {
            System.out.println("❌ Error al listar estudiantes.");
            e.printStackTrace();
        }
    }

    // === BUSCAR ===
    public void buscarPorDni(int dni) {
        String sql = "SELECT * FROM estudiantes WHERE dni = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("🔍 Encontrado: " +
                        rs.getString("nombre") + " | Curso: " + rs.getString("curso"));
            } else {
                System.out.println("⚠️ No se encontró estudiante con DNI " + dni);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al buscar estudiante.");
            e.printStackTrace();
        }
    }

    // === ELIMINAR ===
    public void eliminarPorDni(int dni) {
        String sql = "DELETE FROM estudiantes WHERE dni = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, dni);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("🗑️ Estudiante eliminado correctamente.");
            } else {
                System.out.println("⚠️ No existe estudiante con ese DNI.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar estudiante.");
            e.printStackTrace();
        }
    }
}
