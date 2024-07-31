package com.mycompany.jdbcjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorDatos {
    private String url;
    private String user;
    private String password;

    public GestorDatos(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void insertarDatos(String nombreBaseDatos, String nombreTabla, String valores) {
        String sql = "INSERT INTO " + nombreTabla + " VALUES (" + valores + ")";
        try (Connection connection = DriverManager.getConnection(url + "/" + nombreBaseDatos, user, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Datos insertados exitosamente en la tabla " + nombreTabla);
        } catch (SQLException e) {
            /*e.printStackTrace();*/
        }
    }
}