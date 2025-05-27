/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabalho.a3;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author parto
 */
public class Percentual {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        JOptionPane.showInputDialog(null, "Digite o valor do produto: ");
        double valor = scanner.nextDouble();
        
        JOptionPane.showInputDialog(null, "Digite a porcentagem: ");
        double percentual = scanner.nextDouble();
        
       double resultado = valor * percentual / 100;
       System.out.println("O valor da porcentagem é de: " + resultado);
       // arraylist_preço = preço * ((100 + x)/100)
        
    }
}
