import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Conta user = new Conta("Rafael Cardoso", "Corrente", 2500.00);

        String mensagem = String.format("""
                          ************************************************
                          Dados Iniciais do cliente:
                         \s
                          Nome: %s\s
                          Tipo conta: %s\s
                          Saldo Inicial: %.2f\s
                          ************************************************
                         \s""", user.nome, user.tipoConta, user.saldo);
        System.out.println(mensagem);
        bank(user);

    }

    public static void bank(Conta user) {
        Scanner leitor = new Scanner(System.in);
        String operacoesMensagem = """
                                   Operacoes
                                   
                                   1- Consultar Saldo
                                   2- Receber Valor
                                   3- Tranferir Valor
                                   4- Sair
                                   
                                   Digite a operacao desejada:
                
                                   """;
        System.out.println(operacoesMensagem);
        int opcaoUser = leitor.nextInt();

        switch (opcaoUser){
            case 1:
                System.out.println("O seu saldo atual e de R$ " + user.saldo);
                bank(user);
                return;
            case 2:
                System.out.println("Qual valor deseja receber?");
                double valorUserCase2 = leitor.nextDouble();
                if (valorUserCase2 < 0){
                    System.out.println("Valor Invalido!");
                    bank(user);
                    return;
                }
                user.saldo += valorUserCase2;
                bank(user);
                return;
            case 3:
                System.out.println("Qual valor deseja transferir?");
                double valorUserCase3 = leitor.nextDouble();
                if (valorUserCase3 > user.saldo) {
                    System.out.println("Saldo insuficiente!");
                    bank(user);
                    return;
                }
                user.saldo -= valorUserCase3;
                bank(user);
                return;
            case 4:
                System.out.println("Atendimento Finalizado!");
                return;
            default:
                System.out.println("Insira uma opcao valida!");
                bank(user);
        }
    }
}
