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


// Retorna a Lista de Alunos(objetos)
public ArrayList<Aluno> getMinhaLista() {
minhaLista.clear(); // Limpa nosso ArrayList
try {
Statement stmt = this.getConexao().createStatement();
ResultSet res = stmt.executeQuery("SELECT * FROM tb_alunos");
while (res.next()) {
int id = res.getInt("id");
String nome = res.getString("nome");
int idade = res.getInt("idade");
String curso = res.getString("curso");
int fase = res.getInt("fase");
Aluno objeto = new Aluno(id, nome, idade, curso, fase);
minhaLista.add(objeto);



res.close();
stmt.close();
} catch (SQLException ex) {
}
return minhaLista;
}


//Carrega um aluno pelo ID
public Aluno carregaAluno(int id) {
Aluno objeto = new Aluno();
objeto.setId(id);
try {
Statement stmt = this.getConexao().createStatement();
ResultSet res = stmt.executeQuery("SELECT * FROM tb_alunos WHERE id = " + id);
res.next();
objeto.setNome(res.getString("nome"));
objeto.setIdade(res.getInt("idade"));
objeto.setCurso(res.getString("curso"));
objeto.setFase(res.getInt("fase"));
stmt.close();
} catch (SQLException erro) {
System.out.println("Erro:" + erro);
}
return objeto;
}

// Cadastra novo aluno
public boolean insertAlunoBD(Aluno objeto) {
String sql = "INSERT INTO tb_alunos(id,nome,idade,curso,fase) VALUES(?,?,?,?,?)";
try {
PreparedStatement stmt = this.getConexao().prepareStatement(sql);
stmt.setInt(1, objeto.getId());
stmt.setString(2, objeto.getNome());
stmt.setInt(3, objeto.getIdade());
stmt.setString(4, objeto.getCurso());
stmt.setInt(5, objeto.getFase());
stmt.execute();
stmt.close();
return true;
} catch (SQLException erro) {
System.out.println("Erro:" + erro);
throw new RuntimeException(erro);
}
}


PEGAR AS INFORMACOES ACIMA E EDITAR 
O que fazer:
- Criar CategoriaDao e produtoDao
- Insert de produtos e categoria
- set true and false movimentacao
- Usuario e senha do mysql pra admin(pros 2)
- 


    **/
    
}
