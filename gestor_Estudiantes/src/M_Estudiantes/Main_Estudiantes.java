package M_Estudiantes;

import estudiantes.Estudiante;
import Gestor.GestorEstudiantes;
import java.util.Scanner;

public class Main_Estudiantes {
    public static void main(String[] args) {
        GestorEstudiantes gestor = new GestorEstudiantes();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Buscar por DNI");
            System.out.println("4. Eliminar por DNI");
            System.out.println("0. Salir");
            System.out.print("👉 Elegí una opción: ");
            int op = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (op) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("DNI: ");
                    int dni = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Curso: ");
                    String curso = sc.nextLine();
                    gestor.agregarEstudiante(new Estudiante(nombre, dni, curso));
                    break;

                case 2:
                    gestor.listarEstudiantes();
                    break;

                case 3:
                    System.out.print("DNI a buscar: ");
                    gestor.buscarPorDni(sc.nextInt());
                    break;

                case 4:
                    System.out.print("DNI a eliminar: ");
                    gestor.eliminarPorDni(sc.nextInt());
                    break;

                case 0:
                    System.out.println("👋 Cerrando programa...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("⚠️ Opción inválida");
            }
        }
    }
}
