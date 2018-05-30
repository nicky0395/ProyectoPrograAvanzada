
package capanegocio;
import  capamodelo.ReservaVO;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Mela
 */
public interface InGestorReserva extends Remote{
    public void reservar(ReservaVO reserva) throws RemoteException;
    public void actualizar(int cod_vuelo) throws RemoteException;
    
}
