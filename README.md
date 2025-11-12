📚 Gestión de Estudiantes (Java + JDBC + MySQL)

Aplicación de consola desarrollada en **Java** para gestionar estudiantes utilizando **MySQL** como base de datos.  
El sistema permite *agregar, listar, buscar y eliminar estudiantes* mediante un menú interactivo, utilizando **JDBC** para la conexión a la base de datos.

---
 🚀 Tecnologías utilizadas

- **Java 17+**
- **MySQL / XAMPP**
- **JDBC Driver (MySQL Connector/J)**
- **NetBeans / IntelliJ / Eclipse**

---

 🧩 Estructura del proyecto
📁 src/
├── Conexion/
│ └── Conexion.java
├── estudiantes/
│ └── Estudiante.java
├── Gestor/
│ └── GestorEstudiantes.java
└── M_Estudiantes/
└── Main_Estudiantes.java


- `Conexion.java`: establece la conexión a la base de datos usando JDBC.  
- `Estudiante.java`: clase modelo que representa a un estudiante (nombre, DNI, curso).  
- `GestorEstudiantes.java`: contiene los métodos CRUD (crear, leer, buscar, eliminar).  
- `Main_Estudiantes.java`: clase principal con el menú interactivo para el usuario.

---

 🗃️ Estructura de la base de datos

Base de datos: **gestion_Estudiantes**  
Tabla: **estudiantes**

---sql:
CREATE DATABASE gestion_Estudiantes;
USE gestion_Estudiantes;

CREATE TABLE estudiantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    dni INT NOT NULL UNIQUE,
    curso VARCHAR(50)
);

 Ejecución

Encender XAMPP (activar Apache y MySQL).

Crear la base de datos con el script anterior.

Importar el conector JDBC (mysql-connector-j.jar) en las librerías del proyecto.

Ejecutar Main_Estudiantes.java.

🧮 Ejemplo de uso
===== MENÚ PRINCIPAL =====
1. Agregar estudiante
2. Listar estudiantes
3. Buscar por DNI
4. Eliminar por DNI
0. Salir
👉 Elegí una opción: 1
Nombre: Pablo Sintes
DNI: 45987654
Curso: Programación II
✅ Estudiante agregado correctamente.

📄 Autor

Pablo Sintes
📧 Proyecto académico de práctica con JDBC y MySQL
📅 Año: 2025
