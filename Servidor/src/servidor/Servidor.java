/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import capanegocio.*;
import java.net.MalformedURLException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import capanegocio.GestorReserva;

/**
 *
 * @author Oscar Fierro <omfierro@espe.edu.ec>
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.rebind("ServerReservas",(InGestorReserva) GestorReserva.getGestor());
        System.out.println("Servidor ON");
        System.out.println("Atendiendo las peticiones...");
        System.out.println("Pulse Enter para salir...");

        

        // TODO code application logic here
    }

}
