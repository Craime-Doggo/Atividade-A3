/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import produtos.Movimentacao;
import javax.swing.JOptionPane;

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
        try (Connection con = getConexao()) {
            con.setAutoCommit(false); // Transação feita de forma manual

            // Buscar estoque 
            int estoqueAtual = getEstoqueAtual(con, mov.getIdProduto());

            // Calcular o estoque novo
            int novoEstoque = estoqueAtual;
            if (mov.getTipo().equalsIgnoreCase("Entrada")) {
                novoEstoque += mov.getQuantidade();
            } else if (mov.getTipo().equalsIgnoreCase("Saída")) {
                if (estoqueAtual < mov.getQuantidade()) {
                    JOptionPane.showMessageDialog(null, "Estoque insuficiente para saída!");
                    return false;
                }
                novoEstoque -= mov.getQuantidade();
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de movimentação inválido!");
                return false;
            }

            // Atualizar esse estoque
            String sqlUpdate = "UPDATE tb_produto SET estoque = ? WHERE id = ?";
            try (PreparedStatement psUpdate = con.prepareStatement(sqlUpdate)) {
                psUpdate.setInt(1, novoEstoque);
                psUpdate.setInt(2, mov.getIdProduto());
                psUpdate.executeUpdate();
            }

            // Inserir a movimentação
            String sqlInsert = "INSERT INTO tb_movimentacao (Id, Tipo_movimentacao, Quantidade) VALUES (?, ?, ?)";
            try (PreparedStatement psInsert = con.prepareStatement(sqlInsert)) {
                psInsert.setInt(1, mov.getIdProduto());
                psInsert.setString(2, mov.getTipo());
                psInsert.setInt(3, mov.getQuantidade());
                psInsert.executeUpdate();
            }

            con.commit(); // Confirma a transação
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar movimentação: " + e.getMessage());
            return false;
        }
    }

    private int getEstoqueAtual(Connection con, int idProduto) throws SQLException {
        String sql = "SELECT estoque FROM tb_produto WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProduto);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("estoque");
                } else {
                    throw new SQLException("Produto não encontrado com ID: " + idProduto);
                }
            }
        }
    }
}



