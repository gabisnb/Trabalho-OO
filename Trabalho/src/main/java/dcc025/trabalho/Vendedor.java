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
    private Produto [] loja;

    public Vendedor(String nome, String login, String senha) {
        super(nome, login, senha);
        loja = new Produto[10];
    }
    
    public void exibirEstoque()
    {
        for(Produto aux : loja)
        {
        aux.exibirCatalogo();
        }
    }
}
