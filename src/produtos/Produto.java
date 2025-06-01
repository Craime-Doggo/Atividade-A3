package produtos;

import dao.ProdutoDAO;
import java.util.ArrayList;

public class Produto extends Categoria{

    private int Id;
    private String Nome;
    private double Preco;
    private String Unidade;
    private int Quantidade_estoque;
    private int Estoque_minimo;
    private int Estoque_maximo;
    private ProdutoDAO dao;
    
    public Produto() {
        this("root", "admin");
    }

    public Produto(String user, String password) {
        this(0, "", 0, "", 0, 0, 0, 0, "", "", "", user, password);
    }

    public Produto(int Id, String Nome, double Preco, String Unidade, int Quantidade_estoque, int Estoque_minimo, int Estoque_maximo, int id_categoria, String nome_categoria, String tamanho, String embalagem) {
        super(id_categoria, nome_categoria, tamanho, embalagem);
        this.Id = Id;
        this.Nome = Nome;
        this.Preco = Preco;
        this.Unidade = Unidade;
        this.Quantidade_estoque = Quantidade_estoque;
        this.Estoque_minimo = Estoque_minimo;
        this.Estoque_maximo = Estoque_maximo;
        this.dao = new ProdutoDAO("root", "admin");
    }
    
    public Produto(int Id, String Nome, double Preco, String Unidade, int Quantidade_estoque, int Estoque_minimo, int Estoque_maximo, int id_categoria, String nome_categoria, String tamanho, String embalagem,
                   String user, String password) {
        super(id_categoria, nome_categoria, tamanho, embalagem);
        this.Id = Id;
        this.Nome = Nome;
        this.Preco = Preco;
        this.Unidade = Unidade;
        this.Quantidade_estoque = Quantidade_estoque;
        this.Estoque_minimo = Estoque_minimo;
        this.Estoque_maximo = Estoque_maximo;
        this.dao = new ProdutoDAO(user, password);
    }
    
    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the Preco
     */
    public double getPreco() {
        return Preco;
    }

    /**
     * @param Preco the Preco to set
     */
    public void setPreco(double Preco) {
        this.Preco = Preco;
    }

    /**
     * @return the Unidade
     */
    public String getUnidade() {
        return Unidade;
    }

    /**
     * @param Unidade the Unidade to set
     */
    public void setUnidade(String Unidade) {
        this.Unidade = Unidade;
    }

    /**
     * @return the Quantidade_estoque
     */
    public int getQuantidade_estoque() {
        return Quantidade_estoque;
    }

    /**
     * @param Quantidade_estoque the Quantidade_estoque to set
     */
    public void setQuantidade_estoque(int Quantidade_estoque) {
        this.Quantidade_estoque = Quantidade_estoque;
    }

    /**
     * @return the Estoque_minimo
     */
    public int getEstoque_minimo() {
        return Estoque_minimo;
    }

    /**
     * @param Estoque_minimo the Estoque_minimo to set
     */
    public void setEstoque_minimo(int Estoque_minimo) {
        this.Estoque_minimo = Estoque_minimo;
    }

    /**
     * @return the Estoque_maximo
     */
    public int getEstoque_maximo() {
        return Estoque_maximo;
    }

    public void setEstoque_maximo(int Estoque_maximo) {
        this.Estoque_maximo = Estoque_maximo;
    }
    /**
     * @param Estoque_maximo the Estoque_maximo to set
     */
@Override
public String toString() {
    return super.toString()
        + " id = " + Id
        + ", nome = " + Nome
        + ", preco = " + Preco
        + ", unidade = " + Unidade
        + ", quantidade_estoque = " + Quantidade_estoque
        + ", estoque_minimo = " + Estoque_minimo
        + ", estoque_maximo = " + Estoque_maximo
        + ", id_categoria = " + getId_categoria()
        + ", nome_categoria = " + getNome_categoria()
        + ", tamanho = " + getTamanho()
        + ", embalagem = " + getEmbalagem();
}
  public ArrayList<Produto> getMinhaLista() {
        return dao.getMinhaLista();
  }

}
