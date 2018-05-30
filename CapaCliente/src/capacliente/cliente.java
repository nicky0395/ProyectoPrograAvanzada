/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capacliente;

import capanegocio.GestorReserva;
import capanegocio.InGestorReserva;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Oscar Fierro <omfierro@espe.edu.ec>
 */
public class cliente extends UnicastRemoteObject implements clienteIF {
    private InGestorReserva res;
    
    public cliente() throws RemoteException{}
    
    protected cliente(InGestorReserva reserva) throws RemoteException{
        this.res = reserva;
    }
    

    @Override
    public void ImprimirAsiento(String mensaje) throws RemoteException {
        System.out.println("Numero de asiento reservador: "+mensaje);
    }

}
