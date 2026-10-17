package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes.
 *
 * @author eliane
 *
 */
public class FilmNow {
    private static final int TAM_FILMES = 100;
    private static final int TAM_HOT = 10;

    private Filme[] filmes; // Uma representacao simploria da lista de filmes
    private Filme[] hotList;

    /**
     * Cria o FilmNow.
     */
    public FilmNow() {
        this.filmes = new Filme[TAM_FILMES];
        this.hotList = new Filme[TAM_HOT];
    }

    /**
     * Acessa a lista de filmes mantida.
     * @return O array de filmes.
     */
    public Filme[] getFilmes() {
        return this.filmes.clone();
    }

    public Filme[] getHotList() { return this.hotList.clone(); }

    /**
     * Acessa os dados de um filme específico.
     * @param posicao Posição do filme no sistema.
     * @return Dados do filme. Null se não há filme na posição.
     */
    public Filme getFilme(int posicao) {
        return this.filmes[posicao];
    }

    /**
     * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior.
     * @param posicao Posição do filme.
     * @param nome Nome do filme.
     * @param ano Ano de lançamento do filme.
     * @param local Local onde o filme pode ser assistido.
     */
    public boolean cadastraFilme(int posicao, String nome, int ano, String local) {
        Filme novoFilme = new Filme(nome, ano, local);
        if (verificaFilme(novoFilme)) {
            return false;
        }

        this.filmes[posicao] = novoFilme;
        return true;
    }

//    public String[] mostrarFilmes() {
//        String[] buffer = new String[TAMANHO];
//
//        int i = 0;
//        for (Filme filme : this.filmes) {
//            if (filme != null) {
//                buffer[i++] = filme.toString();
//            }
//        }
//
//        String[] filmesMostrados = new String[i];
//        for (int j = 0; j < i; j++) {
//            filmesMostrados[j] = buffer[j];
//        }
//
//        return filmesMostrados;
//    }

    public boolean atribuirHot(int posicaoFilme, int posicaoHot){
        Filme filmeAdicionado = this.filmes[posicaoFilme];

        if (isHot(filmeAdicionado)) {
            return false;
        }

        this.hotList[posicaoHot] = filmeAdicionado;
        return true;
    }

    public void removerHot(int posicao) {
        this.hotList[posicao] = null;
    }

    public boolean isHot(Filme filme) {
        for (Filme hot : this.hotList) {
            if (hot == null) continue;

            if (hot.equals(filme)) {
                return true;
            }
        }

        return false;
    }

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