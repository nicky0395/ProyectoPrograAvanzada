/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capamodelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NicoleJeem
 */
public class Conexion {
   static String bd = "baseAviones";
    static String login = "root";
    static String password ="JAZMELA0205";
    static String url = "jdbc:mysql://localhost/" + bd;

    Connection conn = null;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            if (conn != null) {
                System.out.println("Conexion OK");
            } else {
                System.err.println("Conexion ERROR");
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.err.println("Conexion ERROR");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public Connection getConexion() {
        return conn;
    }

    public void desconectar() {
        conn = null;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Conexion.url = url;
    }
}
