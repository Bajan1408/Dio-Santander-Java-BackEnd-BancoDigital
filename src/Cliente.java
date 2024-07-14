public class Cliente {
    private String nome;
    private int identidade;
    private int idade;
    private char sexo; 

    public Cliente(String nome, int identidade, int idade, char sexo) {
        this.nome = nome;
        this.identidade = identidade;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public int getIdentidade() {
        return identidade;
    }

    public int getIdade() {
        return idade;
    }

    public char getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", identidade=" + identidade + ", idade=" + idade + ", sexo=" + sexo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + identidade;
        result = prime * result + idade;
        result = prime * result + sexo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (identidade != other.identidade)
            return false;
        if (idade != other.idade)
            return false;
        if (sexo != other.sexo)
            return false;
        return true;
    }

    
}
