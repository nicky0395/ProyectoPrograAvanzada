/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capamodelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mela
 */
public class ReservaDAO { 
 

    public void InsertarReserva(ReservaVO reserva) {
        //Primero creamos la conexion
       Conexion conex=new Conexion();
       try {
           Statement orden=conex.getConexion().createStatement();
           orden.executeUpdate("INSERT INTO reserva (cod_reserva,numero_asiento,cod_vuelo,cod_cliente) VALUES( "
                   +obtenerCodigoReserva()+","
                   +reserva.getNumero_asiento()+","
                   +reserva.getCod_vuelo()+","
                    +reserva.getCod_cliente()+")");
           JOptionPane.showMessageDialog(null, "Se ha registrado la reserva");
           orden.close();
           conex.desconectar();
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
           
       }
   }
    public  int obtenerCodigoReserva(){
          List<Integer>codigos=obtenerCodigos();
           Collections.sort(codigos,Collections.reverseOrder() );
           System.out.println(codigos.get(0));
          return (codigos.get(0)+1);
        
    }
    public List obtenerAsientosOcupados(int cod_vuelo){
           List<Integer>asientosOcupados=new ArrayList<>();
                Conexion conex=new Conexion();
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
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public List obtenerCodigos(){
           List<Integer>codigos=new ArrayList<>();
                Conexion conex=new Conexion();
        try {
            java.sql.Statement stmt = conex.getConexion().createStatement();      
            ResultSet rs = stmt.executeQuery("SELECT cod_reserva from reserva");                     
            while (rs.next()) {                         
                 codigos.add(rs.getInt(1));        
            }
            rs.close();                        
            stmt.close();                           
            conex.desconectar();
            return codigos;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
