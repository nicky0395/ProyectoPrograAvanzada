/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capamodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mela
 */
public class ReservaDAO { 
      Conexion conex=new Conexion();

    public void InsertarReserva(ReservaVO reserva) {
        //Primero creamos la conexion
       //Primero creamos la conexion
        PreparedStatement psInsertar;
        try {
            java.sql.Statement orden = conex.getConexion().createStatement();
            psInsertar = conex.getConexion().prepareStatement("INSERT INTO reserva (cod_vuelo, cod_reserva,cod_cliente,numero_asiento)" + " values(?,?,?)");

            psInsertar.setInt(1,reserva.getCod_vuelo());
            psInsertar.setInt(2,reserva.getCod_reserva());
            psInsertar.setInt(3, reserva.getCod_cliente());
            psInsertar.setInt(4, reserva.getNumero_asiento());
            JOptionPane.showMessageDialog(null, "Se ha registrado ok", "Exito", 1);
            orden.close();
            conex.desconectar();
        } catch (SQLException ex) {
             System.out.println("aqui");
        }
    }
    public List obtenerAsientosOcupados(int cod_vuelo){
           List<Integer>asientosOcupados=new ArrayList<>();
        try {
            java.sql.Statement stmt = conex.getConexion().createStatement();      
            ResultSet rs = stmt.executeQuery("SELECT numero_asiento from reserva where cod_vuelo="+cod_vuelo);                     
            while (rs.next()) {                         
                 asientosOcupados.add(rs.getInt(1));        
            }
            rs.close();                        
            stmt.close();                           
            conex.desconectar();
            return asientosOcupados;
        } catch (SQLException ex) {
            System.out.println("aqui");
            return null;
        }
    }
}
