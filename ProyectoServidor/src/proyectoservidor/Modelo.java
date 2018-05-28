/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoservidor;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author NicoleJeem
 */
public class Modelo {
    Conexion conex;

    public Modelo() {
        this.conex = new Conexion();
    }
    
    public void InsertarAvion(List<String> Avion) {
        //Primero creamos la conexion
       //Primero creamos la conexion
        PreparedStatement psInsertar;
        try {
            java.sql.Statement orden = conex.getConexion().createStatement();
            psInsertar = conex.getConexion().prepareStatement("INSERT INTO aviones (COD_AVION, MODELO, AEROLINEA)" + " values(?,?,?)");

            psInsertar.setInt(1,Integer.parseInt(Avion.get(0)));
            psInsertar.setString(2, Avion.get(1));
            psInsertar.setString(3,  Avion.get(2));
            JOptionPane.showMessageDialog(null, "Se ha registrado ok", "Exito", 1);
            orden.close();
            conex.desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public void InsertarCliente(List<String> cliente) {
        //Primero creamos la conexion
       //Primero creamos la conexion
        PreparedStatement psInsertar;
        try {
            java.sql.Statement orden = conex.getConexion().createStatement();
            psInsertar = conex.getConexion().prepareStatement("INSERT INTO cliente (APELLIDO_CLIENTE, CEDULA_CLIENTE, COD_CLIENTE,FECHA_NAC,NACIONALIDAD_CLIENTE,NOMBRE_CLIENTE)" + " values(?,?,?,?,?)");

            psInsertar.setInt(1,Integer.parseInt(cliente.get(0)));
            psInsertar.setString(2, cliente.get(1));
            psInsertar.setString(3,  cliente.get(2));
            psInsertar.setString(4,  cliente.get(3));
            psInsertar.setString(5,  cliente.get(4));
            psInsertar.setString(6,  cliente.get(5));
            JOptionPane.showMessageDialog(null, "Se ha registrado ok", "Exito", 1);
            orden.close();
            conex.desconectar();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }   
}
