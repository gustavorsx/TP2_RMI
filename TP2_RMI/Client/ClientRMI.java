import java.net.UnknownHostException;
import java.rmi.Naming;
import java.util.Scanner;

import Interface.RMIInterface;

public class ClientRMI {
    public static void main(String[] args) throws UnknownHostException {
        try {
            Scanner scanner = new Scanner(System.in);
            RMIInterface server = (RMIInterface) Naming.lookup("rmi://localhost:12345/ParOuImpar");

            System.out.println("Selecione 0 para par e 1 para ímpar: ");
            int team = scanner.nextInt();
            System.out.println(server.addClients(team));
            System.out.println("Digite seu número: ");
            int number = scanner.nextInt();
            server.setNumber(team, number);

            server.waitCustomers();

            int result[] = server.verifyWin(team);

            if (result[0] == 1) {
                System.out.println("Parabéns! Você ganhou, resultado: " + result[1]);
            } else {
                System.out.println("Que pena! Você perdeu, resultado: " + result[1]);
            }
        } catch (Exception e) {
            System.out.println("Erro: 4" + e);
        }
    }
}