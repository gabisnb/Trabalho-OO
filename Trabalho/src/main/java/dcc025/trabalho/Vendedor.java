/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho;
import java.util.*;

/**
 *
 * @author joaov
 */
public class Vendedor extends Pessoa{
    HashSet<Produto> produtos;

    public Vendedor(String nome, String login, String senha) {
        super(nome, login, senha);
    }
    
}
