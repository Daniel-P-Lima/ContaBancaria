import java.util.Scanner;

public class ContaBancariaSegundaVersão {
    private static String nomeDoCliente = "Daniel Pereira Lima";
    private static String tipoDeConta = "Corrente";
    private static double saldo = 500.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirDadosCliente();

            exibirOpcoes();

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    sacarValor(scanner);
                    break;
                case 3:
                    realizarTransferencia(scanner);
                    break;
                case 4:
                    System.out.println("Obrigado!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Por favor, escolha novamente.");
            }
        }
    }

    private static void  exibirDadosCliente() {
        System.out.println("""
                **************************************************************
                Dados iniciais do cliente:
                                
                Nome: %s
                Tipo de Conta: %s
                Saldo inicial: R$%.2f
                **************************************************************
                """.formatted(nomeDoCliente, tipoDeConta, saldo));
    }

    private static void exibirOpcoes() {
        System.out.print("""
                Opções:
                                
                1- Consultar saldo
                2- Sacar Valor
                3- Transferência Bancária
                4- Sair
                                
                Digite a opção desejada: """);
    }

    private static void consultarSaldo() {
        System.out.println("Você escolheu [Consultar saldo]!");
        System.out.printf("Seu saldo é de: R$%.2f%n", saldo);
    }

    private static void sacarValor(Scanner scanner) {
        System.out.println("Você escolheu [Sacar valor]");
        System.out.print("Digite o valor que deseja sacar: ");
        double valorSaque = scanner.nextDouble();

        if (valorSaque > saldo) {
            System.out.println("Saldo indisponível!");
        } else {
            saldo -= valorSaque;
            System.out.printf("Seu saldo final é de: R$%.2f%n", saldo);
        }
    }

    private static void realizarTransferencia(Scanner scanner) {
        System.out.println("Você escolheu [Transferência Bancária]");
        System.out.print("Digite o valor que deseja transferir: ");
        double valorTransferencia = scanner.nextDouble();
        System.out.print("Digite o id da conta para transferência: ");
        int idTransferencia = scanner.nextInt();

        if (valorTransferencia > saldo || idTransferencia < 0) {
            System.out.println("Saldo insuficiente ou conta inexistente! ");
        } else {
            saldo -= valorTransferencia;
            System.out.printf("Seu saldo atual é de: R$%.2f%n", saldo);
        }
    }
}
