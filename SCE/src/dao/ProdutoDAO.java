/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import produtos.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import produtos.Produto;


    
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author parto
 */
public class ProdutoDAO {
    public ArrayList <Produto> minhaLista = new ArrayList();
    private String user_check;
    private String pass_check;
    
    public ProdutoDAO(String user, String password) {
        this.user_check = user;
        this.pass_check = password;
    }
   
    
    public ArrayList <Produto> getMinhaLista () {
        minhaLista.clear();
        
        try {
            Statement stmt = this.getConexao ().createStatement();
            ResultSet res = stmt.executeQuery ("SELECT * FROM tb_produto");
            while (res.next()) {
                
                int Id = res.getInt("Id");
                String Nome = res.getString("Nome");
                double Preco = res.getDouble("preco_unitario");  
                String Unidade = res.getString("Unidade");
                int Quantidade_estoque = res.getInt("Quantidade_estoque");
                int Estoque_minimo = res.getInt("quantidade_minima");
                int Estoque_maximo = res.getInt("quantidade_maxima");
                int id_categoria = res.getInt("categoria_id");
  
                
                Produto objeto = new Produto (Id, Nome, Preco, Unidade, Quantidade_estoque, Estoque_minimo, Estoque_maximo, id_categoria, "Placeholder", "Size", "Wrapping");
                
                minhaLista.add(objeto);
                }
            stmt.close();
            } catch (SQLException ex) {
                System.out.println("Erro" + ex);
            }
            return minhaLista;
        }
        public int maiorID () {
            int maiorID = 0;
            
            
            try {
                Statement stmt = this.getConexao().createStatement();
                ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_produto");
                res.next();
                maiorID = res.getInt("id");
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("ERRO: " + ex);
            }
            return maiorID;
        }
            
            // Conexão com o Banco de Dados 
        
            public Connection getConexao(){
                
                Connection connection = null;
                try {
                    String driver = "com.mysql.cj.jdbc.Driver";
                    Class.forName(driver);
                    
                    String server = "localhost";              // Endereço do servidor MySQL (localhost = sua máquina)
                    String database = "estoque";            // Nome do banco
                    String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
                    String user = user_check;
                    String password = pass_check;
                    
                    connection = DriverManager.getConnection (url, user, password);
                    
                    if (connection != null) {
                        System.out.println("Status: CONECTADO!");
                    } else {
                        System.out.println("Status: NÃO CONECTADO.");
                    }
                    return connection;
                    
                } catch (ClassNotFoundException e) {
                    System.out.println("O driver não foi encontrado. " + e.getMessage());
                    return null;
                } catch (SQLException e ){
                    System.out.println("Não foi possível conectar....");
                    return null;
                }
            }  
            
            public boolean insertProdutoBD (Produto objeto) {
                String sql = "INSERT INTO tb_produto (Id, Nome, preco_unitario, Unidade, Quantidade_estoque, Quantidade_minima, Quantidade_maxima, categoria_id) VALUES(?,?,?,?,?,?,?,?)";
                try {
                    PreparedStatement stmt = this.getConexao().prepareStatement(sql);
                    
                    stmt.setInt(1, objeto.getId());
                    stmt.setString(2, objeto.getNome());
                    stmt.setDouble(3, objeto.getPreco());
                    stmt.setString(4, objeto.getUnidade());
                    stmt.setInt(5, objeto.getQuantidade_estoque());
                    stmt.setInt(6, objeto.getEstoque_minimo());
                    stmt.setInt(7, objeto.getEstoque_maximo());
                    stmt.setInt(8, objeto.getId_categoria());
                    
                    stmt.execute();
                    stmt.close();
                    
                    return true;
                } catch (SQLException erro) {
                    System.out.println("Erro: " + erro);
                    throw new RuntimeException(erro);
                }
                
        
            }
            public ArrayList <Produto> listarTodosProdutos() {
            ArrayList <Produto> lista = new ArrayList<>();
            String sql = "SELECT * FROM tb_produto";

            try (Connection con = getConexao();
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Produto p = new Produto();
                    p.setId(rs.getInt("Id"));
                    p.setNome(rs.getString("Nome"));
                    p.setPreco(rs.getDouble("preco_unitario"));
                    p.setUnidade(rs.getString("Unidade"));
                    p.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
                        p.setEstoque_minimo(rs.getInt("quantidade_minima"));
                    p.setEstoque_maximo(rs.getInt("quantidade_maxima"));
                    
                    Categoria cat = new Categoria();
                    cat.setId_categoria(rs.getInt("categoria_id"));
                    cat.setNome_categoria(rs.getString("nome_categoria"));
                    p.setCategoria(cat);
                    lista.add(p);
                }

            } catch (SQLException e) {
                System.out.println("Erro ao listar produtos: " + e.getMessage());
            }
            return lista;
    }

    public Produto buscarPorNome(String nomeProduto) {
        Produto p = new Produto();
        String sql = "SELECT * FROM tb_produto WHERE Nome = ?";

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nomeProduto);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p = new Produto();
                p.setId(rs.getInt("Id"));
                p.setPreco(rs.getDouble("preco_unitario"));
                p.setNome(rs.getString("Nome"));
                p.setUnidade(rs.getString("Unidade"));
                p.setQuantidade_estoque(rs.getInt("Quantidade_estoque"));
                p.setEstoque_minimo(rs.getInt("quantidade_minima"));
                p.setEstoque_maximo(rs.getInt("quantidade_maxima"));
                p.setId_categoria(rs.getInt("categoria_id"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto: " + e.getMessage());
        }
        return p;
    }
            public boolean atualizarEstoque(int idProduto, int novaQuantidade) {
        String sql = "UPDATE tb_produto SET Quantidade_estoque = ? WHERE Id = ?";
        try (Connection con = getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, novaQuantidade);
            ps.setInt(2, idProduto);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar estoque: " + e.getMessage());
            return false;
        }
            }
            

            public boolean deleteProdutoBD (int id) {
                try {
                    Statement stmt = this.getConexao().createStatement();
                    stmt.executeUpdate("DELETE FROM tb_produto WHERE id = " + id);
                    stmt.close();
                } catch (SQLException erro) {
                    System.out.println("Erro: " + erro);
                }
                return true;
            }
            public boolean updateProdutoBD (Produto objeto, int categoria_id) {
                String sql = "UPDATE tb_produto set Id = ?, Nome = ?, preco_unitario = ?, Unidade = ?, Quantidade_estoque = ?, quantidade_minima = ?, quantidade_maxima = ?, categoria_id = ?";
                
                try {
                    PreparedStatement stmt = this.getConexao().prepareStatement(sql);
                    stmt.setInt(1, objeto.getId());
                    stmt.setString(2, objeto.getNome());
                    stmt.setDouble(3, objeto.getPreco());
                    stmt.setString(4, objeto.getUnidade());
                    stmt.setInt(5, objeto.getQuantidade_estoque());
                    stmt.setInt(6, objeto.getEstoque_minimo());
                    stmt.setInt(7, objeto.getEstoque_maximo());
                    stmt.setInt(8, categoria_id);
                    
                    stmt.execute();
                    stmt.close();
                    
                    return true;
                    
                } catch (SQLException erro) {
                    System.out.println("Erro: " + erro);
                    throw new RuntimeException(erro);
                }
            } 


    public Produto carregaProduto (int id) {
                Produto objeto = new Produto ();
                objeto.setId (id);
                
                try {
                    Statement stmt = this.getConexao().createStatement();
                    
                    ResultSet res = stmt.executeQuery("SELECT * FROM tb_categoria WHERE id = " + id);
                    res.next();
                    
                    objeto.setId (res.getInt("id"));
                    objeto.setNome (res.getString("Nome"));
                    objeto.setPreco (res.getDouble ("preco_unitario"));
                    objeto.setUnidade (res.getString("Unidade"));
                    objeto.setQuantidade_estoque(res.getInt("Quantidade_estoque"));
                    objeto.setEstoque_minimo(res.getInt("quantidade_minima"));
                    objeto.setEstoque_maximo(res.getInt("quantidade_maxima"));
                    objeto.setId_categoria(res.getInt("categoria_id"));
                    
                    
                    stmt.close();
                } catch (SQLException erro) {
                    System.out.println("Erro:  + " + erro);
                }
                return objeto;
            }
    
    public List<Produto> buscarListaProdutos(String nomeBusca) {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_produto WHERE nome LIKE ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setString(1, "%" + nomeBusca + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("Id"));
                p.setNome(rs.getString("Nome"));
                p.setPreco (rs.getDouble ("preco_unitario"));
                p.setUnidade(rs.getString("Unidade"));
                p.setQuantidade_estoque(rs.getInt("Quantidade_estoque"));
                p.setEstoque_minimo(rs.getInt("quantidade_minima"));
                p.setEstoque_maximo(rs.getInt("quantidade_maxima"));
                p.setId_categoria(rs.getInt("categoria_id"));
                lista.add(p);
            }

            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao buscar categorias: " + erro.getMessage());
        }

        return lista;
    }
}
