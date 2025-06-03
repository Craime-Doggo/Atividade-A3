package produtos;

import DAO.ProdutoDAO;

public class Produto extends Categoria{
<<<<<<< Updated upstream
    private int id;
    private String nome;
    private double preco;
    private String unidade;
    private int quantidade_estoque;
    private int estoque_minimo;
    private int estoque_maximo;
=======

    private int Id;
    private String Nome;
    private double Preco;
    private String Unidade;
    private int Quantidade_estoque;
    private int Estoque_minimo;
    private int Estoque_maximo;
    private int id_categoria;
>>>>>>> Stashed changes
    private ProdutoDAO dao;

    public Produto(int id_categoria, String nome_categoria, String tamanho, String embalagem, 
                   int id, String nome, double preco, String unidade, int quantidade_estoque, 
                   int estoque_minimo, int estoque_maximo) {
        super(id_categoria, nome_categoria, tamanho, embalagem);
<<<<<<< Updated upstream
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
=======
        this.Id = Id;
        this.Nome = Nome;
        this.Preco = Preco;
        this.Unidade = Unidade;
        this.Quantidade_estoque = Quantidade_estoque;
        this.Estoque_minimo = Estoque_minimo;
        this.Estoque_maximo = Estoque_maximo;
        this.id_categoria = id_categoria;
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
        this.id_categoria = id_categoria;
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
    public void setid_categoria (int id_categoria) {
        this.id_categoria = id_categoria;
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
      public boolean insertProdutoBD (int Id,
              String Nome, 
              double Preco, 
              String Unidade, 
              int Quantidade_estoque, 
              int Estoque_minimo, 
              int Estoque_maximo, 
              int id_categoria,
              String Nome_categoria, 
              String Tamanho, 
              String Embalagem,
              String user, 
              String password)
               {
        int id = this.maiorID() + 1;
        Produto objeto = new Produto(Id, Nome, Preco, Unidade, Quantidade_estoque, Estoque_minimo, Estoque_maximo, id_categoria ,nome_categoria, tamanho, embalagem, user, password);
        dao.insertProdutoBD(objeto);
        return true;
    }
      
      public boolean updateProdutoBD(int Id, String Nome, double Preco, String Unidade, int Quantidade_estoque, int Estoque_minimo, int Estoque_maximo) {
    Produto objeto = new Produto();
    objeto.setId(Id);
    objeto.setNome(Nome);
    objeto.setPreco(Preco);
    objeto.setUnidade(Unidade);
    objeto.setQuantidade_estoque(Quantidade_estoque);
    objeto.setEstoque_minimo(Estoque_minimo);
    objeto.setEstoque_maximo(Estoque_maximo);
    
    dao.updateProdutoBD(objeto);
    return true;
}

      
          public Produto carregaProduto(int id) {
        return dao.carregaProduto(id);
    }

    public int maiorID() {
        return dao.maiorID();
    }

}
>>>>>>> Stashed changes
