package produtos;

import dao.ProdutoDAO;

public class Produto extends Categoria{
    private int id;
    private String nome;
    private double preco;
    private String unidade;
    private int quantidade_estoque;
    private int estoque_minimo;
    private int estoque_maximo;
    private ProdutoDAO dao;

    public Produto(int id_categoria, String nome_categoria, String tamanho, String embalagem, 
                   int id, String nome, double preco, String unidade, int quantidade_estoque, 
                   int estoque_minimo, int estoque_maximo) {
        super(id_categoria, nome_categoria, tamanho, embalagem);
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.unidade = unidade;
        this.quantidade_estoque = quantidade_estoque;
        this.estoque_minimo = estoque_minimo;
        this.estoque_maximo = estoque_maximo;
        this.dao = new ProdutoDAO();
    }
}
