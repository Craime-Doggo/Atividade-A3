package produtos;
import dao.CategoriaDAO;
import java.util.ArrayList;
import java.util.List;


public class Categoria {

    private int id_categoria;
    private String nome_categoria;
    private String tamanho;
    private String embalagem;
    private CategoriaDAO dao;
    private String user;
    private String password;
   
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
        this.id_categoria = id_categoria;
        this.nome_categoria = nome_categoria;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
        this.user = user;
        this.password = password;
        this.dao = new CategoriaDAO(user, password);
    }
    
    

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getEmbalagem() {
        return embalagem;
    }
    
    public boolean deleteCategoriaBD(int id) {
        dao.deleteCategoriaBD(id);
        return true;
    }
    
    public boolean updateCategoriaBD(int id_categoria, String nome_categoria, String tamanho, String embalagem) {
        Categoria objeto = new Categoria(id_categoria, nome_categoria, tamanho, embalagem);
        dao.updateCategoriaBD(objeto);
        return true;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }
    
    @Override
    public String toString() {
        return "id_categoria = " + id_categoria
                + ", nome_categoria = " + nome_categoria
                + ", tamanho = " + tamanho
                + ", embalagem = " + embalagem
                + ", user = root"
                + ", password = admin";
    }
    public ArrayList<Categoria> getMinhaListaCategoria() {
        return dao.getMinhaLista();
    }
    public boolean insertCategoria(String nome_categoria, String tamanho, String embalagem,String user, String password) {
        int id_categoria = this.maiorID() + 1;
        Categoria objeto = new Categoria(id_categoria ,nome_categoria, tamanho, embalagem, user, password);
        dao.insertCategoriaBD(objeto);
        return true;
    }
    public Categoria carregaCategoria(int id) {
        return dao.carregaCategoria(id);
    }
    public int maiorID() {
        return dao.maiorID();
    }
    
    public List<Categoria> buscarPorNome(String nome) {
        CategoriaDAO dao = new CategoriaDAO (user, password);
        return dao.buscarPorNome(nome);
    }
}
