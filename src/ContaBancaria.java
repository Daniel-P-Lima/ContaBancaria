import java.util.Scanner;


public class ContaBancaria {
    public static void main(String[] args) {
        /*
        Printar dados iniciais do cliente
         */

        String nomeDoCLiente = "Daniel Pereira Lima";
        String tipoDeConta = "Corrente";
        double saldoInicial = 500.00;



        Scanner escolha = new Scanner(System.in);
        Scanner saque = new Scanner(System.in);
        Scanner transferencia = new Scanner(System.in);
        Scanner idDaConta = new Scanner(System.in);

    while (true) {
        System.out.println(String.format("""
                \n
                **************************************************************
                Dados iniciais do cliente:
                                
                Nome: %s
                Tipo de Conta: %s
                Saldo inicial: R$%.2f
                **************************************************************
                """, nomeDoCLiente, tipoDeConta, saldoInicial));

        System.out.print("""
                Opções:
                                
                1- Consultar saldos
                2- Sacar Valor
                3- Transferência Bancária
                4- Sair
                                
                Digite a opção desejada: """);

        int entrada = escolha.nextInt();

        if (entrada == 1) {
            System.out.println("Você escolheu [Consultar saldo]!");
            System.out.print(String.format("Seu saldo é de: R$%.2f", saldoInicial));
        }
        else if (entrada == 2) {
            System.out.println("Você escolheu [Sacar valor]");
            System.out.print("Digite o valor que queira sacar: ");
            double extrato = saque.nextDouble();
            if (extrato > saldoInicial) {
                System.out.println("Saldo indisponível!");
            } else {
                saldoInicial = saldoInicial - extrato;
                System.out.println(String.format("Seu saldo final é de: R$%.2f", saldoInicial));
            }
        } else if (entrada == 3) {
            System.out.println("Você escolheu [Transferência Bancária]");
            System.out.print("Digite o valor que você quer transferir: ");
            double valorDeTransferencia = transferencia.nextDouble();
            System.out.print("Digite o id da conta para transferência: ");
            int idDaTranferencia = idDaConta.nextInt();

            if (valorDeTransferencia < saldoInicial && idDaTranferencia < 0) {
                System.out.println("Saldo insufieciente ou Conta inexistente! ");
            } else {
                saldoInicial =- valorDeTransferencia;
                System.out.println(String.format("Seu saldo atual é de: R$%.2f", saldoInicial));
            }
        } else if (entrada == 4) {
            System.out.println("Obrigado!");
            break;
        }

    }
    }
}
