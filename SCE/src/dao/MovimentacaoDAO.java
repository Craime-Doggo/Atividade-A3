/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;

/**
 *
 * @author parto
 */
public class MovimentacaoDAO {
   
    private String user;
    private String password;

    public MovimentacaoDAO(String user, String password) {
        this.user = user;
        this.password = password;
    }

    private Connection getConexao() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/seu_banco";
        return DriverManager.getConnection(url, user, password);
    }

    public boolean inserirMovimentacao(Movimentacao mov) {
        String sql = "INSERT INTO tb_movimentacao (Id, Tipo_movimentacao, Quantidade) VALUES (?, ?, ?)";

        try (Connection con = getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, mov.getIdProduto());
            ps.setString(2, mov.getTipo());
            ps.setInt(3, mov.getQuantidade());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir movimentação: " + e.getMessage());
            return false;
        }
    }
}


