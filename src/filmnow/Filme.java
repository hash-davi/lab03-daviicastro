package filmnow;

/**
 * Representação de um filme
 *
 * @author Davi
 */
public class Filme {
    private String nome;
    private int anoDeLancamento;
    private String localDisponivel;

    /**
     * Cria o filme
     *
     * @param nome Nome do filme
     * @param ano Ano de lançamento do filme
     * @param local Local aonde o filme pode ser assistindo
     */
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
        return this.nome + ", " + this.anoDeLancamento + "\n" +
                this.localDisponivel;
    }
}
