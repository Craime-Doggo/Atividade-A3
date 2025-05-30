package produtos;

public abstract class Categoria {
    private int id_categoria;
    private String nome_categoria;
    private String tamanho;
    private String embalagem;

    public Categoria(int id_categoria, String nome_categoria, String tamanho, String embalagem) {
        this.id_categoria = id_categoria;
        this.nome_categoria = nome_categoria;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
    }
}
