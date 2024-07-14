import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
    Map<Cliente, Conta> listaContas;
    
    public Banco() {
        this.listaContas = new HashMap<>();
    }

    public void abrirContaCorrente(String nome, int identidade, int idade, char sexo) {
        listaContas.put(new Cliente(nome, identidade, idade, sexo), new ContaCorrente(nome));
    }

    public void abrirContaPoupanca(String nome, int identidade, int idade, char sexo) {
        listaContas.put(new Cliente(nome, identidade, idade, sexo), new ContaPoupanca(nome));
    }

    public void listarClientes() {
        System.out.println(listaContas);
    }

    public void imprimirExtrato(String nomeCliente) {
        for(Map.Entry<Cliente, Conta> cliente : listaContas.entrySet()) {
            if(cliente.getKey().getNome().equalsIgnoreCase(nomeCliente)) {
                cliente.getValue().imprimirExtrato();
            }
        }
    }

    public void pesquisarNumContaCliente(String nome) {
        int numeroConta = 0;
        for(Map.Entry<Cliente, Conta> conta : listaContas.entrySet()) {
            if(conta.getKey().getNome().equalsIgnoreCase(nome)) {
                numeroConta = conta.getValue().getNumero();
                break;
            } 
        }
        if(numeroConta != 0) {
            System.out.println("O número da conta de " + nome + " é " + String.format("%03d", numeroConta) + ".");
        } else {
            System.out.println("Não foram encontrados clientes com o nome fornecido. Verifique a digitação!");
        }
    }

    public void depositar(String nome, double valor) {
        for(Map.Entry<Cliente, Conta> conta : listaContas.entrySet()) {
            if(conta.getKey().getNome().equalsIgnoreCase(nome)) {
                conta.getValue().depositar(valor);
            }
        }
    }

    public void sacar(String nome, double valor) {
        for(Map.Entry<Cliente, Conta> conta : listaContas.entrySet()) {
            if(conta.getKey().getNome().equalsIgnoreCase(nome)) {
                conta.getValue().sacar(valor);
            }
        }
    }

    public void transferir(String titularOrigem, double valor, String titularDestino) {
        for(Map.Entry<Cliente, Conta> conta : listaContas.entrySet()) {
            if(conta.getKey().getNome().equalsIgnoreCase(titularOrigem)) {
                conta.getValue().sacar(valor);
            }
            else if(conta.getKey().getNome().equalsIgnoreCase(titularDestino)) {
                conta.getValue().depositar(valor);
            }
        }
    }

    public void exibirContasPorNumero() {
        List<Map.Entry<Cliente, Conta>> lista = new ArrayList<>(listaContas.entrySet());

        lista.sort(Map.Entry.comparingByValue(new CompararContaPorNumero()));
        
        for (Map.Entry<Cliente, Conta> entry : lista) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    
    public static void main(String[] args) throws Exception {
        System.out.println("Seja bem vindo ao nosso banco!");

        Banco banco = new Banco();

        banco.listarClientes();

        banco.abrirContaCorrente("João Silva", 122, 56, 'M');
        banco.abrirContaPoupanca("Diego Fernandes", 125, 38, 'M');
        banco.abrirContaPoupanca("Julia Roberts", 124, 36, 'F');
        banco.abrirContaCorrente("Paola Rodrigues", 123, 38, 'F');
        banco.abrirContaCorrente("Jane Fonda", 121, 63, 'F');

        banco.listarClientes();

        banco.imprimirExtrato("Jane Fonda");

        banco.pesquisarNumContaCliente("Jane Sonda");
        banco.depositar("Jane fonda", 35.00);

        banco.imprimirExtrato("Jane Fonda");

        banco.sacar("Jane fonda", 15.00);
        banco.imprimirExtrato("Jane Fonda");
        banco.imprimirExtrato("Diego Fernandes");

        banco.transferir("Jane fonda", 10.50, "Diego fernandes");

        banco.imprimirExtrato("Jane Fonda");
        banco.imprimirExtrato("Diego Fernandes");

        banco.exibirContasPorNumero();

    }
}
