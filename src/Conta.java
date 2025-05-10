import java.util.Scanner;

public class Conta {
    String nome;
    String tipoConta;
    double saldo;
    Scanner leitor = new Scanner(System.in);

    public Conta(String nome, String tipoConta, double saldo) {
        this.nome = nome;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

    void exibirSaldo(){
        System.out.println("O seu saldo atual e de R$ " + saldo);
    }

    double receberSaldo(){
        System.out.println("Qual valor deseja receber?");
        return leitor.nextDouble();
    }

    double transferirSaldo(){
        System.out.println("Qual valor deseja transferir?");
        return leitor.nextDouble();
    }
    void atualizaSaldo(double valorUser, int operacao){
        switch (operacao){
            case 2:
                this.saldo += valorUser;
                break;
            case 3:
                this.saldo -= valorUser;
                break;
        }
    }
}
