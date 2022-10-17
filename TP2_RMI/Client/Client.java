import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        try {
            Scanner scanner = new Scanner(System.in);
            RMIInterface chat = (RMIInterface) Naming.lookup("rmi://localhost:12345/ParOuImpar");

            System.out.println("Selecione 0 para par e 1 para ímpar: ");
            int team = scanner.nextInt();
            chat.addClients(team);
            System.out.println("Digite seu número: ");
            int number = scanner.nextInt();// recebe o digitado
            chat.getClients().get(team).setNumber(number);

            int result = chat.verifyWin();

            if (result % 2 == 0 && team == 0 || result % 2 != 0 && team == 1) {
                System.out.println("Parabéns! Você ganhou, resultado: " + result);
            } else {
                System.out.println("Que pena! Você perdeu, resultado: " + result);
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

    }
}