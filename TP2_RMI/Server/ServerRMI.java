import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerRMI {

    public ServerRMI() throws RemoteException, MalformedURLException {
        try {
            LocateRegistry.createRegistry(12345);
            Naming.rebind("rmi://localhost:12345/ParOuImpar", new ParOuImparImplements());
            System.out.println("Server ready: ");
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }   

    public static void main(String[] args) {
        try {
            new ServerRMI();
            System.out.println("Servidor rodando...");
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

}