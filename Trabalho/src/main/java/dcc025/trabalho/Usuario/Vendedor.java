/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.Usuario;

import dcc025.trabalho.Usuario.Pessoa;
import dcc025.trabalho.model.Produto;
import dcc025.trabalho.model.ListaQuantidadeCor.Cor;
import java.util.*;

public class Vendedor extends Pessoa {

    private List <Produto> loja ;
    private static String user_id;

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha);
        loja = new ArrayList();
    }
    
    public void adicionarProduto(Produto produto){
        loja.add(produto);
    }
    public String getId(){ return user_id.toString(); }
    
    //Função adicionada apenas para testagem da adição de produto, mudar depois
    public List<Produto> getListaProdutos(){
        return this.loja;
    }
}
