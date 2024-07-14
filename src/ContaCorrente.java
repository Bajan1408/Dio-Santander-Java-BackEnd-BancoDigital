
public class ContaCorrente extends Conta implements Comparable<Conta> {
    protected String cliente;
    protected int numero;
    protected int agencia;

    public ContaCorrente(String cliente) {
        super.cliente = cliente;
        this.numero = super.numero;
        this.agencia = super.agencia;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato conta corrente ===");
        System.out.println("==============================");
        imprimirInfosComuns();
    }

    @Override
    public String toString() {
        return "ContaCorrente [agencia=" + agencia + ", numero=" + numero + ", saldo=" + saldo + "]";
    }

    @Override
    public int compareTo(Conta o) {
        if(this.numero > o.numero) {
            return 1;
        } else if(this.numero < o.numero) {
            return -1;
        } else {
            return 0;
        }
    }
 
    
}