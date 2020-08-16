public class PaginacaoUtil<T> {

    private int tamanho;
    private int pagina;
    private int totalPaginas;
    private List<T> registros;

    public PaginacaoUtil(int tamanho, int pagina, int totalPaginas, List<T> registros) {
        this.tamanho = tamanho;
        this.pagina = pagina;
        this.totalPaginas = totalPaginas;
        this.registros = registros;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getPagina() {
        return pagina;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public List<T> getRegistros() {
        return registros;
    }
}