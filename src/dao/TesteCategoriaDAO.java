/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import produtos.Categoria;
import dao.CategoriaDAO;
/**
 *
 * @author Allex
 */
public class TesteCategoriaDAO {
public static void main(String[] args) {
        // Aqui você passa o usuário e a senha do seu MySQL
        CategoriaDAO dao = new CategoriaDAO("root", "admin");

        // Testa se a conexão funciona chamando algum método que usa conexão
        ArrayList<Categoria> lista = dao.getMinhaLista();

        // Exibe os produtos encontrados (ou nada se estiver vazio)
        if (lista.isEmpty()) {
            System.out.println("Nenhuma Categoria encontrada.");
        } else {
            for (Categoria c : lista) {
            System.out.println("Categoria: " + c.getNome_categoria());
            }
        }
    }
} teste