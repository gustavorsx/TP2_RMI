import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Interface.RMIInterface;

public class ParOuImparImplements extends UnicastRemoteObject implements RMIInterface {

    public List<User> clients = new ArrayList<User>();

    public String addClients(int team) throws RemoteException {
        try {
            boolean isPar = team == 0;
            clients.add(new User(team));

            String msgSend = isPar ? "Voce joga como par" : "Voce joga como impar";
            return msgSend;
        } catch (Exception ex) {
            return "Erro: " + ex.getMessage();
        }
    }

    public boolean waitClientPlay() throws RemoteException {
        if (clients.size() == 2) {
            if (clients.stream().filter(p -> p.getNumber() == 0).collect(Collectors.toList()).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public int[] verifyWin(int team) throws RemoteException {
        int sum = 0;
        try {
            for (User cliente : clients) {
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

    public ParOuImparImplements() throws RemoteException {
        super();
    }
}