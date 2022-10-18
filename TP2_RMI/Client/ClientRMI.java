import java.net.UnknownHostException;
import java.rmi.Naming;
import java.util.Scanner;

import Interface.RMIInterface;

public class ClientRMI {

    public static void main(String[] args) throws UnknownHostException {
        String URL = "rmi://localhost:12345/ParOuImpar";

        try {
            Scanner scanner = new Scanner(System.in);
            RMIInterface server = (RMIInterface) Naming.lookup(URL);

            System.out.println("Selecione 0 para par e 1 para impar: ");
            int team = scanner.nextInt();
            while (team < 0 || team > 1) {
                System.out.println("Selecione 0 para par e 1 para impar: ");
                team = scanner.nextInt();
            }
            System.out.println(server.addClients(team)); // Adiciona o usuário no servidor e retorna se o usuário é par ou impar
            System.out.println("Digite seu número: ");
            int number = scanner.nextInt();
            while (number <= 0) {
                System.out.println("Digite um número maior que 0: ");
                number = scanner.nextInt();
            }
            server.setNumber(team, number); // Usuário escolhe o número

            while (!server.waitClientPlay()) { // Espera os dois usuários jogarem
            }

            int result[] = server.verifyWin(team); // Retorna qual usuário venceu o jogo

            if (result[0] == 1) {
                System.out.println("Parabéns! Você ganhou, resultado: " + result[1]);
            } else {
                System.out.println("Que pena! Você perdeu, resultado: " + result[1]);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
}