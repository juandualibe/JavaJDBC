package com.mycompany.jdbcjava;

public class JDBCJava {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root"; //Su usuario de MYSQL
        String password = "root"; //Su password MYSQL

        // Crear la base de datos
        GestorBaseDeDatos gBaseDatos = new GestorBaseDeDatos(url, user, password);
        gBaseDatos.crearBaseDeDatos("Empresa");

        // Crear una tabla en la base de datos
        CrearTabla tabla = new CrearTabla(url, user, password);
        String definicionTabla = "ID INT PRIMARY KEY, Nombre VARCHAR(50), Edad INT";
        tabla.crearTabla("Empresa", "Clientes", definicionTabla);

        // Insertar datos en la tabla
        GestorDatos gestorDatos = new GestorDatos(url, user, password);
        gestorDatos.insertarDatos("Empresa", "Clientes", "1, 'Ernesto Castro', 32");
        gestorDatos.insertarDatos("Empresa", "Clientes", "2, 'Ana García', 25");
        gestorDatos.insertarDatos("Empresa", "Clientes", "3, 'Juan Dualibe', 32");
        gestorDatos.insertarDatos("Empresa", "Clientes", "4, 'Pablo Acosta', 18");
    }
}
