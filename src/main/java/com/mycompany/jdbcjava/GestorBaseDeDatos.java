package com.mycompany.jdbcjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorBaseDeDatos {
    private String url;
    private String user;
    private String password;

    public GestorBaseDeDatos(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void crearBaseDeDatos(String nombreBaseDatos) {
        String sql = "CREATE DATABASE IF NOT EXISTS " + nombreBaseDatos;
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Base de datos " + nombreBaseDatos + " creada exitosamente.");
        } catch (SQLException e) {
            /*e.printStackTrace();*/
        }
    }
}
