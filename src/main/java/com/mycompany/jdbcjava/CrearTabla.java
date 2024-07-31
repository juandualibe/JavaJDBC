package com.mycompany.jdbcjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {
    private String url;
    private String user;
    private String password;

    public CrearTabla(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void crearTabla(String nombreBaseDatos, String nombreTabla, String definicionTabla) {
        String sql = "CREATE TABLE IF NOT EXISTS " + nombreTabla + " (" + definicionTabla + ")";
        try (Connection connection = DriverManager.getConnection(url + "/" + nombreBaseDatos, user, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Tabla " + nombreTabla + " creada exitosamente en la base de datos " + nombreBaseDatos);
        } catch (SQLException e) {
            /*e.printStackTrace();*/
        }
    }
}
