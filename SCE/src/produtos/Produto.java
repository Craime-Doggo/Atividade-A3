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
    private Categoria categoria;
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
    
//getters and setters
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }


    public String getNome() {
        return Nome;
    }

  
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

  
    public double getPreco() {
        return Preco;
    }

  
    public void setPreco(double Preco) {
        this.Preco = Preco;
    }


    public String getUnidade() {
        return Unidade;
    }


    public void setUnidade(String Unidade) {
        this.Unidade = Unidade;
    }

    public int getQuantidade_estoque() {
        return Quantidade_estoque;
    }

    public void setQuantidade_estoque(int Quantidade_estoque) {
        this.Quantidade_estoque = Quantidade_estoque;
    }


    public int getEstoque_minimo() {
        return Estoque_minimo;
    }

    public void setEstoque_minimo(int Estoque_minimo) {
        this.Estoque_minimo = Estoque_minimo;
    }


    public int getEstoque_maximo() {
        return Estoque_maximo;
    }

    public void setEstoque_maximo(int Estoque_maximo) {
        this.Estoque_maximo = Estoque_maximo;
    }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; 
    }

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
      public boolean insertProduto(
              String Nome, 
              double Preco, String Unidade, 
              int Quantidade_estoque, 
              int Estoque_minimo, 
              int Estoque_maximo, 
              int id_categoria, 
              String nome_categoria, 
              String tamanho, 
              String embalagem,
              String user, 
              String password) {
        int id = this.maiorID() + 1;
        Produto objeto = new Produto(id, Nome, Preco, Unidade, 
                Quantidade_estoque, Estoque_minimo, Estoque_maximo, id_categoria ,nome_categoria, 
                tamanho, embalagem, user, password);

        dao.insertProdutoBD(objeto);
        return true;
    }
          public Produto carregaProduto(int id) {
        return dao.carregaProduto(id);
    }

    public int maiorID() {
        return dao.maiorID();
    }

}
