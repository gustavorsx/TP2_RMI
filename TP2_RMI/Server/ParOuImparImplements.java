import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ParOuImparImplements extends UnicastRemoteObject implements RMIInterface {

    public List<Cliente> clients = new ArrayList<Cliente>();

    public void addClients(int team)
            throws RemoteException, MalformedURLException, NotBoundException, UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        int numUsers = 0;
        boolean isPar = team == 0;
        while (numUsers < 2) {
            // Client client = (Client) Naming.lookup("rmi://localhost:12345/ParOuImpar");
            clients.add(new Cliente(isPar));

            String msgSend = isPar ? "Voce joga como par" : "Voce joga como impar";
            enviarMensagem(msgSend);
            isPar = false;
            numUsers++;
        }
    }

    public int verifyWin() throws RemoteException {
        int sum = 0;
        for (Cliente cliente : clients) {
            sum += cliente.getNumber();
        }
        return sum;
    }

    public void setNumber(int i, int number) throws RemoteException {
        clients.get(i).setNumber(number);
    }

    public List<Cliente> getClients() throws RemoteException {
        return clients;
    }

    public ParOuImparImplements() throws RemoteException {
        super();
    }

    public void enviarMensagem(String mensagem) throws RemoteException {
        System.out.println(mensagem);
    }
}