/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Allex
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CriarBD {
public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "admin";

        try {
            // Carrega o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conecta ao MySQL (sem escolher o banco ainda)
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // Cria o banco de dados se não existir
            String sqlCreateDatabase = "CREATE DATABASE IF NOT EXISTS estoque";
            stmt.executeUpdate(sqlCreateDatabase);
            System.out.println("Banco de dados 'estoque' criado/verificado com sucesso.");

            // Conecta ao banco 'estoque'
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estoque?useSSL=false&serverTimezone=UTC", user, password);
            stmt = conn.createStatement();

            // Cria a tabela tb_categoria
            String sqlCreateCategoria = """
                CREATE TABLE IF NOT EXISTS tb_categoria (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nome VARCHAR(100) NOT NULL,
                    tamanho VARCHAR(20),
                    embalagem VARCHAR(20)
                )
            """;
            stmt.executeUpdate(sqlCreateCategoria);
            System.out.println("Tabela 'tb_categoria' criada/verificada com sucesso.");

            // Cria a tabela tb_produto
            String sqlCreateProduto = """
                CREATE TABLE IF NOT EXISTS tb_produto (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nome VARCHAR(100) NOT NULL, 
                    preco_unitario DECIMAL(10, 2) NOT NULL, 
                    unidade VARCHAR(10) NOT NULL, 
                    quantidade_estoque INT NOT NULL,
                    quantidade_minima INT NOT NULL,
                    quantidade_maxima INT NOT NULL,
                    categoria_id INT,
                    FOREIGN KEY (categoria_id) REFERENCES tb_categoria(id)
                )
            """;
            stmt.executeUpdate(sqlCreateProduto);
            System.out.println("Tabela 'tb_produto' criada/verificada com sucesso.");

            // Fecha conexão
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Erro ao criar banco ou tabelas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}