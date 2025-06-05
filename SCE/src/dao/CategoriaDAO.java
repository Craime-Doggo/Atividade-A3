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

/**
 *
 * @author parto
 */
public class CategoriaDAO {

    public ArrayList<Categoria> minhaLista = new ArrayList();
    private String user_check;
    private String pass_check;

    public CategoriaDAO(String user, String password) {
        this.user_check = user;
        this.pass_check = password;
    }

    public ArrayList<Categoria> getMinhaLista() {
        minhaLista.clear();

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_categoria");
            while (res.next()) {

                int id_categoria = res.getInt("categoria_id");
                String nome_categoria = res.getString("nome_categoria");
                String tamanho = res.getString("tamanho");
                String embalagem = res.getString("embalagem");

                Categoria objeto = new Categoria(id_categoria, nome_categoria, tamanho, embalagem);

                minhaLista.add(objeto);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro" + ex);
        }
        return minhaLista;
    }

    public int maiorID() {
        int maiorID = 0;

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(categoria_id) categoria_id FROM tb_categoria");
            res.next();
            maiorID = res.getInt("categoria_id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("ERRO: " + ex);
        }
        return maiorID;
    }

    public Connection getConexao() {

        Connection connection = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String server = "localhost";              // Endereço do servidor MySQL (localhost = sua máquina)
            String database = "estoque";            // Nome do banco
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = user_check;
            String password = pass_check;

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Status: CONECTADO!");
            } else {
                System.out.println("Status: NÃO CONECTADO.");
            }
            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("O driver não foi encontrado. " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar....");
            return null;
        }
    }

    public boolean insertCategoriaBD(Categoria objeto) {
        String sql = "INSERT INTO tb_categoria (categoria_id, nome_categoria, tamanho, embalagem) VALUES(?,?,?,?)";
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

    public boolean deleteCategoriaBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_categoria WHERE categoria_id = " + id);
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return true;
    }

    public boolean updateCategoriaBD(Categoria objeto) {
        String sql = "UPDATE tb_categoria SET nome_categoria = ?, tamanho = ?, embalagem = ? WHERE categoria_id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setString(1, objeto.getNome_categoria());
            stmt.setString(2, objeto.getTamanho());
            stmt.setString(3, objeto.getEmbalagem());
            stmt.setInt(4, objeto.getId_categoria());

            stmt.executeUpdate();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    public Categoria carregaCategoria(int id) {
        Categoria objeto = new Categoria();
        objeto.setId_categoria(id);

        try {
            Statement stmt = this.getConexao().createStatement();

            ResultSet res = stmt.executeQuery("SELECT * FROM tb_categoria WHERE categoria_id = " + id);
            res.next();

            objeto.setId_categoria(res.getInt("categoria_id"));
            objeto.setNome_categoria(res.getString("nome_categoria"));
            objeto.setTamanho(res.getString("tamanho"));
            objeto.setEmbalagem(res.getString("embalagem"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:  + " + erro);
        }
        return objeto;
    }

    public List<Categoria> buscarPorNome(String nomeBusca) {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_categoria WHERE nome_categoria LIKE ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setString(1, "%" + nomeBusca + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId_categoria(rs.getInt("categoria_id"));
                c.setNome_categoria(rs.getString("nome_categoria"));
                c.setTamanho(rs.getString("tamanho"));
                c.setEmbalagem(rs.getString("embalagem"));
                lista.add(c);
            }

            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao buscar categorias: " + erro.getMessage());
        }

        return lista;
    }
    
    public int BuscarId(String nomeBusca) {
        int id = -1; // Valor padrão caso não encontre

        String sql = "SELECT categoria_id FROM tb_categoria WHERE nome_categoria LIKE ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setString(1, "%" + nomeBusca + "%");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("categoria_id");
            }

            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao buscar ID da categoria: " + erro.getMessage());
        }

        return id;
    }
    
    public String BuscarNome(int idBusca) {
        String nomecat = ""; // Valor padrão caso não encontre

        String sql = "SELECT nome_categoria FROM tb_categoria WHERE categoria_id LIKE ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setInt(1, idBusca);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nomecat = rs.getString("nome_categoria");
            }

            rs.close();
            stmt.close();
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao buscar nome da categoria: " + erro.getMessage());
        }

        return nomecat;
    }
    
    public List<String> listarCategorias() {
        List<String> categorias = new ArrayList<>();
        String sql = "SELECT nome_categoria FROM tb_categoria"; // Altere o nome da tabela e da coluna conforme seu banco
        try (Connection conn = this.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                categorias.add(rs.getString("nome_categoria"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categorias;
    }

}
