import java.util.Comparator;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 378;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected String cliente;
    protected double saldo = 0;

    public Conta() {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    public String getCliente() {
        return cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println("Agencia: " + this.agencia);
        System.out.println(String.format("Conta Número: %03d", this.numero));
        System.out.println("Cliente: " + this.cliente);
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }


    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
    
}

class CompararContaPorNumero implements Comparator<Conta> {

    @Override
    public int compare(Conta conta1, Conta conta2) {
        return Integer.compare(conta1.getNumero(), conta2.getNumero());
    }

}