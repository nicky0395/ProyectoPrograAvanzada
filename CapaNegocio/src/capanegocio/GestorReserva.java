/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capanegocio;

import capamodelo.ReservaDAO;
import capamodelo.ReservaVO;
import java.beans.*;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Mela
 */
public class GestorReserva extends UnicastRemoteObject implements Serializable,InGestorReserva  {

    ReservaDAO opReserva=new ReservaDAO();
    
    public static GestorReserva gesReserva;
    public GestorReserva() throws RemoteException{
      
    }
        //Patron singleton
    public  static GestorReserva getGestor() throws RemoteException {
        if (gesReserva == null) {
            gesReserva = new GestorReserva();
        }

        return gesReserva;
    }

   
    @Override
    public void reservar(ReservaVO reserva) {
  
       opReserva.InsertarReserva(reserva);
    }

    @Override
    public void actualizar(int cod_vuelo) {
       opReserva.obtenerAsientosOcupados(cod_vuelo);
    }
}