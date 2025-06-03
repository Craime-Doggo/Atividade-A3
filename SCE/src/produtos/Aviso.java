/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtos;

/**
 *
 * @author parto
 */
// * Classe que trata os avisos de exceções do sistema.
public class Aviso extends Exception{

    //Construtor com parâmetro.
  
    public Aviso (String Aviso) {
        super(Aviso);
    }
}

