public abstract class Conta implements IConta {

    private static final String AGENCIA_PADRAO = "378";
    private static int SEQUENCIAL = 1;

    protected String agencia;
    protected String numero;
    protected double saldo = 0;

    public Conta() {
        this.agencia = AGENCIA_PADRAO;
        this.numero = "00" + SEQUENCIAL++;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Número: " + this.numero);
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