package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes.
 *
 * @author eliane
 */
public class FilmNow {
    private static final int TAM_FILMES = 100;
    private static final int TAM_HOT = 10;

    private Filme[] filmes; // A lista de filmes
    private Filme[] hotList; // A lista com os filmes de maior prioridade

    /**
     * Cria o FilmNow.
     */
    public FilmNow() {
        this.filmes = new Filme[TAM_FILMES];
        this.hotList = new Filme[TAM_HOT];
    }

    /**
     * Acessa a lista de filmes mantida.
     *
     * @return O array de filmes.
     */
    public Filme[] getFilmes() {
        return this.filmes.clone();
    }

    /**
     * Acessa a HotList
     *
     * @return O array com a HotList
     */
    public Filme[] getHotList() { return this.hotList.clone(); }

    /**
     * Acessa os dados de um filme específico.
     *
     * @param posicao Posição do filme no sistema.
     * @return Dados do filme. Null se não há filme na posição.
     */
    public Filme getFilme(int posicao) {
        return this.filmes[posicao-1];
    }

    /**
     * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior.
     *
     * @param posicao Posição do filme.
     * @param nome Nome do filme.
     * @param ano Ano de lançamento do filme.
     * @param local Local onde o filme pode ser assistido.
     */
    public String cadastraFilme(int posicao, String nome, int ano, String local) {
        Filme novoFilme = new Filme(nome, ano, local);

        if (verificaFilme(novoFilme)) {
            return "Filme já adicionado!";
        }
        if (posicao > TAM_FILMES || posicao < 1) {
            return "Posição inválida!";
        }
        if (nome.isEmpty() || local.isEmpty()) {
            return "Filme inválido!";
        }

        this.filmes[posicao-1] = novoFilme;
        return "Filme adicionado com sucesso!";
    }

    /**
     * Adiciona um filme da lista principal à HotList. Se já existir um filme na posição dada, o novo irá sobrescrevê-lo.
     *
     * @param posicaoFilme Posição onde o filme se encontra na lista principal
     * @param posicaoHot Posição onde o filme será adicionado na HotList
     * @return Boolean que indica se o filme pôde ser adicionado à HotList
     */
    public boolean atribuirHot(int posicaoFilme, int posicaoHot){
        Filme filmeAdicionado = this.filmes[posicaoFilme-1];

        if (isHot(filmeAdicionado)) {
            return false;
        }
        if (posicaoFilme > TAM_FILMES || posicaoFilme < 1) {
            return false;
        }
        if (posicaoHot > TAM_HOT || posicaoHot < 1) {
            return false;
        }

        this.hotList[posicaoHot-1] = filmeAdicionado;
        return true;
    }

    /**
     * Remove um filme da HotList dada sua posição.
     *
     * @param posicao Posição do filme na HotList
     */
    public void removerHot(int posicao) {
        this.hotList[posicao-1] = null;
    }

    /**
     * Verifica se um filme está na HotList.
     *
     * @param filme Filme a ser comparado
     * @return Boolean que indica se o filme está ou não na HotList
     */
    public boolean isHot(Filme filme) {
        for (Filme hot : this.hotList) {
            if (hot == null) continue;

            if (hot.equals(filme)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Verifica se o filme está na lista principal.
     *
     * @param filme Filme a ser comparado
     * @return Boolean que indica se o filme está na lista principal
     */
    private boolean verificaFilme(Filme filme) {
        for (Filme f : this.filmes) {
            if (f == null) continue;

            if (f.equals(filme)) {
                return true;
            }
        }

        return false;
    }
}