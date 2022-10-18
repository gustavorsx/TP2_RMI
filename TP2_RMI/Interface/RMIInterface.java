package Interface;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {

    public boolean waitClientPlay() throws RemoteException;

    public String addClients(int team) throws RemoteException, MalformedURLException, NotBoundException, UnknownHostException;

    public void setNumber(int i, int number) throws RemoteException;
    
    public int[] verifyWin(int team) throws RemoteException;
}
