import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nome = "Rafael Cardoso";
        String tipoConta = "Corrente ";
        double saldo = 2500.00;
        String mensagem = String.format("""
                          ************************************************
                          Dados Iniciais do cliente:
                          
                          Nome: %s 
                          Tipo conta: %s 
                          Saldo Inicial: %.2f 
                          ************************************************
                          """, nome, tipoConta, saldo);
        System.out.println(mensagem);
        bank(saldo);

    }

    public static void bank(double saldo) {
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
                System.out.println("O seu saldo atual e de R$ " + saldo);
                bank(saldo);
                return;
            case 2:
                System.out.println("Qual valor deseja receber?");
                double valorUser = leitor.nextDouble();
                if (valorUser < 0){
                    System.out.println("Valor Invalido!");
                    bank(saldo);
                    return;
                }
                saldo += valorUser;
                bank(saldo);
                return;
            case 3:
                System.out.println("Qual valor deseja transferir?");
                valorUser = leitor.nextDouble();
                if (valorUser > saldo) {
                    System.out.println("Saldo insuficiente!");
                    bank(saldo);
                    return;
                }
                saldo -= valorUser;
                bank(saldo);
                return;
            case 4:
                System.out.println("Atendimento Finalizado!");
                return;
            default:
                System.out.println("Insira uma opcao valida!");
                bank(saldo);
                return;
        }
    }
}
