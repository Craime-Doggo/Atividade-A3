package produtos;
import dao.CategoriaDAO;

public class Categoria {

    private int id_categoria;
    private String nome_categoria;
    private String tamanho;
    private String embalagem;
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
        this.id_categoria = id_categoria;
        this.nome_categoria = nome_categoria;
        this.tamanho = tamanho;
        this.embalagem = embalagem;
        this.dao = new CategoriaDAO(user, password);
    }
    
    
    /**
     * @return the id_categoria
     */
    public int getId_categoria() {
        return id_categoria;
    }

    /**
     * @param id_categoria the id_categoria to set
     */
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    /**
     * @return the nome_categoria
     */
    public String getNome_categoria() {
        return nome_categoria;
    }

    /**
     * @param nome_categoria the nome_categoria to set
     */
    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    /**
     * @return the tamanho
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * @return the embalagem
     */
    public String getEmbalagem() {
        return embalagem;
    }

    /**
     * @param embalagem the embalagem to set
     */
    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }
}
