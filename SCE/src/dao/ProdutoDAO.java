/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Gabriel
 */
public class ProdutoDAO {
    /**
    *
    *
    public Connection getConexao() {
Connection connection = null; //instância da conexão
try {
// Carregamento do JDBC Driver
String driver = "com.mysql.cj.jdbc.Driver";
Class.forName(driver);
// Configurar a conexão
String server = "localhost";
String database = "db_alunos";
String url = "jdbc:mysql://" + server + ":3306/"
+ database + "?useTimezone=true&serverTimezone=UTC";
String user = "root";
String password = "root";


// Conectando..
connection = DriverManager.getConnection(url, user, password);
// Testando..
if (connection != null) {
System.out.println("Status: Conectado!");
} else {
System.out.println("Status: NÃO CONECTADO!");
}
return connection;
} catch (ClassNotFoundException e) { //Driver não encontrado
System.out.println("O driver nao foi encontrado.");
return null;
} catch (SQLException e) {
System.out.println("Nao foi possivel conectar...");
return null;
}
    **/
    
}
