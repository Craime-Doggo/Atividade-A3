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

/**
 *
 * @author parto
 */
public class CategoriaDAO {
    public ArrayList <Categoria> minhaLista = new ArrayList();

    public ArrayList <Categoria> getMinhaLista () {
        minhaLista.clear();
        
        try {
            Statement stmt = this.getConexao ().createStatement();
            ResultSet res = stmt.executeQuery ("SELECT * FROM tb_categoria");
            while (res.next()) {
                
                int id_categoria = res.getInt("id_categoria");
                String nome_categoria = res.getString("nome_categoria");
                String tamanho = res.getString("Tamanho");
                String embalagem = res.getString("Embalagem");
                
                Categoria objeto = new Categoria (id_categoria, nome_categoria, tamanho, embalagem);
                
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
                ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_categoria");
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
                    String user = "root";
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
            public boolean insertCategoriaBD (Categoria objeto) {
                String sql = "INSERT INTO tb_categoria (Id_categoria, Nome_categoria, Tamanho, Embalagem) VALUES(?,?,?,?)";
                try {
                    PreparedStatement stmt = this.getConexao().prepareStatement(sql);
                    
                    stmt.setInt(1, objeto.getId_categoria());
                    stmt.setString(2, objeto.getNome_categoria());
                    stmt.setString(3, objeto.getTamanho());
                    stmt.setString(4, objeto.getEmbalagem());
                    
                    stmt.execute();
                    stmt.close();
                    
                    return true;
                } catch (SQLException erro) {
                    System.out.println("Erro: " + erro);
                    throw new RuntimeException(erro);
                }
        
            }
            public boolean deleteCategoriaBD (int id) {
                try {
                    Statement stmt = this.getConexao().createStatement();
                    stmt.executeUpdate("DELETE FROM tb_categoria WHERE id = " + id);
                    stmt.close();
                } catch (SQLException erro) {
                    System.out.println("Erro: " + erro);
                }
                return true;
            }
            public boolean updateCategoriaBD (Categoria objeto) {
                String sql = "UPDATE tb_categoria set id = ?, tamanho = ?, embalagem = ?";
                
                try {
                    PreparedStatement stmt = this.getConexao().prepareStatement(sql);
                    stmt.setInt(1, objeto.getId_categoria());
                    stmt.setString(2, objeto.getNome_categoria());
                    stmt.setString(3, objeto.getTamanho());
                    stmt.setString(4, objeto.getEmbalagem());
                    
                    stmt.execute();
                    stmt.close();
                    
                    return true;
                    
                } catch (SQLException erro) {
                    System.out.println("Erro: " + erro);
                    throw new RuntimeException(erro);
                }
            } 
            public Categoria carregaCategoria (int id ) {
                Categoria objeto = new Categoria ();
                objeto.setId_categoria (id);
                
                try {
                    Statement stmt = this.getConexao().createStatement();
                    
                    ResultSet res = stmt.executeQuery("SELECT * FROM tb_categoria WHERE id = " + id);
                    res.next();
                    
                    objeto.setId_categoria (res.getInt("id"));
                    objeto.setNome_categoria (res.getString("Nome"));
                    objeto.setTamanho (res.getString("Tamanho"));
                    objeto.setEmbalagem (res.getString("Embalagem"));
                    
                    stmt.close();
                } catch (SQLException erro) {
                    System.out.println("Erro:  + " + erro);
                }
                return objeto;
            }
    }
