public class Banco {
    private String nome;
    private String agencia;
    private Cliente cliente;

    public Banco(String nome, String agencia, Cliente cliente) {
        this.nome = nome;
        this.agencia = agencia;
        this.cliente = cliente;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Seja bem vindo ao nosso banco!");

        IConta contaCorrente = new ContaCorrente();
        Conta poupanca = new ContaPoupanca();

        contaCorrente.depositar(100.00);
        contaCorrente.imprimirExtrato();
        poupanca.imprimirExtrato();

        contaCorrente.transferir(30, poupanca);

        contaCorrente.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
