import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerRMI {

    public ServerRMI() throws RemoteException, MalformedURLException {
        String URL = "rmi://localhost:12345/ParOuImpar";
        try {
            LocateRegistry.createRegistry(12345);
            Naming.rebind(URL, new ParOuImparImplements());
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