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
        double valorUser;

        switch (opcaoUser){
            case 1:
                user.exibirSaldo();
                bank(user);
                return;
            case 2:
                valorUser = user.receberSaldo();
                if (valorUser< 0){
                    System.out.println("Valor Invalido!");
                    bank(user);
                    return;
                }
                user.atualizaSaldo(valorUser, 2);
                bank(user);
                return;
            case 3:
                valorUser= user.transferirSaldo();
                if (valorUser> user.saldo) {
                    System.out.println("Saldo insuficiente!");
                    bank(user);
                    return;
                }
                user.atualizaSaldo(valorUser, 3);
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
