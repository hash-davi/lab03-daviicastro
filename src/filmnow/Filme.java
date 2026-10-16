package filmnow;

public class Filme {
    private String nome;
    private int anoDeLancamento;
    private String localDisponivel;

    public Filme(String nome, int ano, String local) {
        this.nome = nome;
        this.anoDeLancamento = ano;
        this.localDisponivel = local;
    }

    public String getNome() {
        return this.nome;
    }

    public int getAnoDeLancamento() {
        return this.anoDeLancamento;
    }

    public String getLocalDisponivel() {
        return this.localDisponivel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Filme)) {
            return false;
        }

        Filme filme = (Filme) o;

        return filme.getNome().equals(this.nome);
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" +
                "Ano de lançamento: " + this.anoDeLancamento + "\n" +
                "Onde assistir: " + this.localDisponivel;
    }
}
