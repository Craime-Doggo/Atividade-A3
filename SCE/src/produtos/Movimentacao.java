/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtos;

/**
 *
 * @author parto
 */
public class Movimentacao {

    private int idProduto;
    private String tipo; // "entrada" ou "retirada"
    private int quantidade;
    
    public Movimentacao() {
    // construtor vazio
}

    public Movimentacao(int idProduto, String tipo, int quantidade) {
        this.idProduto = idProduto;
        this.tipo = tipo;
        this.quantidade = quantidade;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Movimentacao{" +
                "idProduto=" + idProduto +
                ", tipo='" + tipo + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
} 


