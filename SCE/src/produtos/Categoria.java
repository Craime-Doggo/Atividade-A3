package produtos;
import dao.CategoriaDAO;

public class Categoria {

    private int Id_categoria;
    private String Nome_categoria;
    private String Tamanho;
    private String Embalagem;
    private CategoriaDAO dao;
   
    public Categoria() {
        this("root", "admin");
    }

    public Categoria(String user, String password) {
        this(0, "", "", "", user, password);
    }

    public Categoria(int id_categoria, String nome_categoria, String tamanho, String embalagem) {
        this(id_categoria, nome_categoria, tamanho, embalagem, "root", "admin");
    }

    public Categoria(int id_categoria, String nome_categoria, String tamanho, String embalagem, String user, String password) {
        this.Id_categoria = id_categoria;
        this.Nome_categoria = nome_categoria;
        this.Tamanho = tamanho;
        this.Embalagem = embalagem;
        this.dao = new CategoriaDAO(user, password);
    }
    
    

    public int getId_categoria() {
        return Id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.Id_categoria = id_categoria;
    }

    public String getNome_categoria() {
        return Nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.Nome_categoria = nome_categoria;
    }

    public String getTamanho() {
        return Tamanho;
    }

    public void setTamanho(String tamanho) {
        this.Tamanho = tamanho;
    }

    public String getEmbalagem() {
        return Embalagem;
    }


    public void setEmbalagem(String embalagem) {
        this.Embalagem = embalagem;
    }
@Override
public String toString() {
    return "id_categoria = " + Id_categoria +
           ", nome_categoria = " + Nome_categoria +
           ", tamanho = " + Tamanho +
           ", embalagem = " + Embalagem +
           ", user = root" +
           ", password = admin";
        }
}
