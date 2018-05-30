/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capamodelo;

import java.beans.*;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mela
 */
public class VueloDAO implements Serializable {
  
   
    public List obtenerVuelos(){
        
        
           List<VueloVO>vuelos=new ArrayList<>();
                Conexion conex=new Conexion();
        try {
            java.sql.Statement stmt = conex.getConexion().createStatement();      
            ResultSet rs = stmt.executeQuery("SELECT * from vuelo ");                     
            while (rs.next()) {  
                VueloVO vuelo=new VueloVO();
                vuelo.setCod_vuelo(rs.getInt("cod_vuelo"));
                vuelo.setCod_avion(rs.getInt("cod_avion"));
                vuelo.setDestino(rs.getString("destino"));
                vuelo.setOrigen(rs.getString("origen"));
                vuelo.setFecha_llegada(rs.getDate("fecha_llegada"));
                vuelo.setFecha_salida(rs.getDate("fecha_salida"));
                vuelo.setPrecio(rs.getFloat("precio"));
                vuelos.add(vuelo);
            }
            rs.close();                        
            stmt.close();                           
            conex.desconectar();
            return vuelos;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
 
  
}
