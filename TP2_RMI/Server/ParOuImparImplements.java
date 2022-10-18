import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Interface.Cliente;
import Interface.RMIInterface;

public class ParOuImparImplements extends UnicastRemoteObject implements RMIInterface {

    public List<Cliente> clients = new ArrayList<Cliente>();

    public String addClients(int team)
            throws RemoteException, MalformedURLException, NotBoundException, UnknownHostException {
        try {
            int numUsers = 0;
            boolean isPar = team == 0;
            clients.add(new Cliente(team));

            String msgSend = isPar ? "Voce joga como par" : "Voce joga como impar";
            numUsers++;
            return msgSend;
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
            return "";
        }
    }

    public void waitCustomers() {
        while (clients.size() < 2);
    }

    public int[] verifyWin(int team) throws RemoteException {
        int sum = 0;
        waitCustomers();
        try {
            for (Cliente cliente : clients) {
                sum += cliente.getNumber();
            }
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

        if (sum % 2 == 0 && team == 0 || sum % 2 != 0 && team == 1) {
            int[] result = { 1, sum };
            return result;
        } else {
            int[] result = { 0, sum };
            return result;
        }
    }

    public void setNumber(int i, int number) throws RemoteException {
        try {
            clients.stream().filter(p -> p.getTeam() == i).collect(Collectors.toList()).get(0).setNumber(number);
            ;
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public List<Cliente> getClients() throws RemoteException {
        return clients;
    }

    public ParOuImparImplements() throws RemoteException {
        super();
    }
}