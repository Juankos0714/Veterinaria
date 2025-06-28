package org.example.modelo.conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/clinica_veterinaria";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "carlosmanuel";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static Connection conexion = null;

    public static Connection obtenerConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                Class.forName(DRIVER);
                conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                System.out.println("Conexión establecida exitosamente");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver no encontrado - " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos - " + e.getMessage());
        }
        return conexion;
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada exitosamente");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión - " + e.getMessage());
        }
    }

    public static boolean isConexionActiva() {
        try {
            return conexion != null && !conexion.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}
//-- Script para crear la base de datos de la clínica veterinaria ABC
//-- Base de datos: clinica_veterinaria
//
//CREATE DATABASE IF NOT EXISTS clinica_veterinaria;
//USE clinica_veterinaria;
//
//-- Tabla para almacenar información de personas (propietarios)
//CREATE TABLE persona (
//        documento VARCHAR(20) PRIMARY KEY,
//nombre VARCHAR(100) NOT NULL,
//apellido VARCHAR(100) NOT NULL,
//telefono VARCHAR(20),
//direccion VARCHAR(200),
//email VARCHAR(100)
//);
//
//        -- Tabla para almacenar información de mascotas
//CREATE TABLE mascota (
//        id INT AUTO_INCREMENT PRIMARY KEY,
//        nombre VARCHAR(100) NOT NULL,
//especie VARCHAR(50) NOT NULL,
//raza VARCHAR(50),
//edad INT,
//peso DECIMAL(5,2),
//color VARCHAR(50),
//propietario_documento VARCHAR(20),
//FOREIGN KEY (propietario_documento) REFERENCES persona(documento) ON DELETE CASCADE
//);
//
//        -- Insertar datos de ejemplo
//INSERT INTO persona (documento, nombre, apellido, telefono, direccion, email) VALUES
//('12345678', 'Juan', 'Pérez', '3001234567', 'Calle 123 #45-67', 'juan.perez@email.com'),
//        ('87654321', 'María', 'González', '3009876543', 'Carrera 89 #12-34', 'maria.gonzalez@email.com'),
//        ('11223344', 'Pedro', 'Rodríguez', '3001122334', 'Avenida 56 #78-90', 'pedro.rodriguez@email.com');
//
//INSERT INTO mascota (nombre, especie, raza, edad, peso, color, propietario_documento) VALUES
//('Firulais', 'Perro', 'Labrador', 3, 25.5, 'Dorado', '12345678'),
//        ('Michi', 'Gato', 'Siamés', 2, 4.2, 'Blanco', '87654321'),
//        ('Rex', 'Perro', 'Pastor Alemán', 5, 30.0, 'Negro', '11223344');
