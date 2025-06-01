/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import dao.ProdutoDAO;
import produtos.Produto;
import java.util.ArrayList;
/**
 *
 * @author Allex
 */
public class TesteProdutoDao {
public static void main(String[] args) {
        // Aqui você passa o usuário e a senha do seu MySQL
        ProdutoDAO dao = new ProdutoDAO("root", "admin");

        // Testa se a conexão funciona chamando algum método que usa conexão
        ArrayList<Produto> lista = dao.getMinhaLista();

        // Exibe os produtos encontrados (ou nada se estiver vazio)
        if (lista.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            for (Produto p : lista) {
                System.out.println("Produto: " + p.getNome());
            }
        }
    }
}