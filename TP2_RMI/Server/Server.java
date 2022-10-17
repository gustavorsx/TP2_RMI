import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public Server() throws RemoteException, MalformedURLException {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            LocateRegistry.createRegistry(12345);
            System.setProperty("java.rmi.server.hostname", ip);
            Naming.rebind("rmi://localhost:12345/ParOuImpar", new ParOuImparImplements());
            System.out.println("Server ready: " + ip);
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

    public static void main(String[] args) {

        try {
            new Server();
            System.out.println("Servidor rodando...");
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }

}