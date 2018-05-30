
package capanegocio;
import  capamodelo.ReservaVO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author Mela
 */
public interface InGestorReserva extends Remote{
    public void reservar(ReservaVO reserva) throws RemoteException;
    public List actualizar(int cod_vuelo) throws RemoteException;
    public List obtenerVuelos() throws RemoteException;
    public List obtenerClientes() throws RemoteException;
}
