/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import produtos.Produto;

/**
 *
 * @author parto
 */
public class ProdutoDAO {

/**
 *
 * @author parto
 */
public class CategoriaDAO {
    public ArrayList <Produto> minhaLista = new ArrayList();
<<<<<<< Updated upstream
=======
    private String user_check;
    private String pass_check;
    
    ProdutoDAO objetoProduto = new ProdutoDAO("root", "admin");

    
    public ProdutoDAO(String user, String password) {
        this.user_check = user;
        this.pass_check = password;
    }
    
>>>>>>> Stashed changes

    public ArrayList <Produto> getMinhaLista () {
        minhaLista.clear();
        
        try {
            Statement stmt = this.getConexao ().createStatement();
            ResultSet res = stmt.executeQuery ("SELECT * FROM tb_categoria");
            while (res.next()) {
                
                int id_categoria = res.getInt("id_categoria");
                String nome_categoria = res.getString("nome_categoria");
                String tamanho = res.getString("Tamanho");
                String embalagem = res.getString("Embalagem");
                /*
                Categoria objeto = new Categoria (id_categoria, nome_categoria, tamanho, embalagem);
                */
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
<<<<<<< Updated upstream
                ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_categoria");
=======
                ResultSet res = stmt.executeQuery("SELECT MAX(Id_produto) id FROM tb_produto");
>>>>>>> Stashed changes
                res.next();
                maiorID = res.getInt("id");
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("ERRO: " + ex);
            }
            return maiorID;
        
            public Connection getConexao(){
                
                Connection connection = null;
                try {
                    String driver = "com.mysql.cj.jdbc.Driver";
                    Class.forName(driver);
                    
                    String server = "admin";
                    String database = "database.com"; //INCLUIR FUTURO NOME DO DATABASE
                    String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
                    String user = "admin";
                    String password = "admin";
                    
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
<<<<<<< Updated upstream
            public boolean insertCategoriaBD (Produto objeto) {
                String sql = "INSERT INTO tb_categoria (id, tamanho, embalagem) VALUES(?,?,?)";
                try {
                    PreparedStatement stmt = this.getConexao().prepareStatement(sql);
                    
                    stmt.setInt(1, objeto.getId_categoria());
                    stmt.setString(2, objeto.getNome_categoria());
                    stmt.setString(3, objeto.getTamanho());
                    stmt.setString(4, objeto.getEmbalagem());
=======
            public boolean insertProdutoBD (Produto objeto) {
                String sql = "INSERT INTO tb_produto (Id_produto, Nome_produto, Preco_produto, Unidade_produto, Quantidade_estoque, Estoque_minimo, Estoque_maximo, Id_categoria, Nome_categoria, Tamanho, Embalagem ) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
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
                    stmt.setString(9, objeto.getNome_categoria());
                    stmt.setString(10, objeto.getTamanho());
                    stmt.setString(11, objeto.getEmbalagem());
>>>>>>> Stashed changes
                    
                    stmt.execute();
                    stmt.close();
                    
                    return true;
                } catch (SQLException erro) {
                    System.out.println("Erro: " + erro);
                    return false;
                }
        
            }
            public boolean deleteCategoriaBD (int id) {
                try {
                    Statement stmt = this.getConexao().createStatement();
<<<<<<< Updated upstream
                    stmt.executeUpdate("DELETE FROM tb_categoria WHERE id = " + id);
=======
                    stmt.executeUpdate("DELETE FROM tb_produto WHERE Id_produto = " + id);
>>>>>>> Stashed changes
                    stmt.close();
                } catch (SQLException erro) {
                    System.out.println("Erro: " + erro);
                }
                return false;
            }
<<<<<<< Updated upstream
            /* public boolean updateCategoriaBD (Categoria objeto) {
                String sql = "UPDATE tb_categoria set id = ?, tamanho = ?, embalagem = ?";
                
                try {
                    PreparedStatement stmt = this.getConexao().prepareStatement(sql);
                    stmt.setInt(1, objeto.getId_categoria());
                    stmt.setString(2, objeto.getNome_categoria());
                    stmt.setString(3, objeto.getTamanho());
                    stmt.setString(4, objeto.getEmbalagem());
=======
            public boolean updateProdutoBD (Produto objeto) {
                String sql = "UPDATE tb_produto SET Nome_produto = ?, Preco_produto = ?, Unidade_produto = ?, Quantidade_estoque = ?, Estoque_minimo = ?, Estoque_maximo = ? WHERE Id_produto = ?";
                
                try {
                    PreparedStatement stmt = this.getConexao().prepareStatement(sql);
                    stmt.setString(1, objeto.getNome());
                    stmt.setDouble(2, objeto.getPreco());
                    stmt.setString(3, objeto.getUnidade());
                    stmt.setInt(4, objeto.getQuantidade_estoque());
                    stmt.setInt(5, objeto.getEstoque_minimo());
                    stmt.setInt(6, objeto.getEstoque_maximo());
                    stmt.setInt(7, objeto.getId());

>>>>>>> Stashed changes
                    
                    stmt.execute();
                    stmt.close();
                    
                    return true;
                    
                } catch (SQLException erro) {
                    System.out.println("Erro: " + erro);
                    return false;
                }
            } 
            public Categoria carregaCategoria (int id ) {
                Categoria objeto = new Categoria ();
                objeto.setId_categoria (id);
                
                try {
                    Statement stmt = this.getConexao().createStatement();
                    
                    ResultSet res = stmt.executeQuery("SELECT * FROM tb_produto WHERE id = " + id);

                    res.next();
                    
<<<<<<< Updated upstream
                    objeto.setId_categoria (res.getInt("id"));
                    objeto.setNome_categoria (res.getString("Nome"));
                    objeto.setTamanho (res.getString("Tamanho"));
                    objeto.setEmbalagem (res.getString("Embalagem"));
=======
                    objeto.setId (res.getInt("id"));
                    objeto.setNome (res.getString("Nome"));
                    objeto.setPreco (res.getDouble ("Preco"));
                    objeto.setUnidade (res.getString("Unidade"));
                    objeto.setQuantidade_estoque(res.getInt("Quantidade_estoque"));
                    objeto.setEstoque_minimo(res.getInt("Estoque_minimo"));
                    objeto.setEstoque_maximo(res.getInt("Estoque_maximo"));
                    
>>>>>>> Stashed changes
                    
                    stmt.close();
                } catch (SQLException erro) {
                    System.out.println("Erro:  + " + erro);
                }
                return objeto;
*/
            }
    }

}
