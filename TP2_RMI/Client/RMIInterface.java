import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIInterface extends Remote {

    public void enviarMensagem(String mensagem) throws RemoteException;

    public void addClients(int team) throws RemoteException;

    public List<Cliente> getClients() throws RemoteException;

    public void setNumber(int i, int number) throws RemoteException;

    public int verifyWin() throws RemoteException;
}
