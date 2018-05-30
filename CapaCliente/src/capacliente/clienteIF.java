/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capacliente;

import java.rmi.RemoteException;

/**
 *
 * @author Oscar Fierro <omfierro@espe.edu.ec>
 */
public interface clienteIF {
    void ImprimirAsiento(String mensaje) throws RemoteException;
}
