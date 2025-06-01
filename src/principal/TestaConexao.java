/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Allex
 */
public class TestaConexao {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/estoque?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "admin";

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(" Conexão realizada com sucesso!");
            conn.close();
        } catch (Exception e) {
            System.out.println(" Erro na conexão: " + e.getMessage());
        }
    }
}