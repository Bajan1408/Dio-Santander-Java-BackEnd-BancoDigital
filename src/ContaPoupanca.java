public class ContaPoupanca extends Conta {
    protected String cliente;

    public ContaPoupanca(String cliente) {
        super.cliente = cliente;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("===== Extrato Poupança ======");
        System.out.println("=============================");
        imprimirInfosComuns();
    }

    @Override
    public String toString() {
        return "ContaPoupanca [agencia=" + agencia + ", numero=" + numero + ", saldo=" + saldo + "]";
    } 
    
    
}
