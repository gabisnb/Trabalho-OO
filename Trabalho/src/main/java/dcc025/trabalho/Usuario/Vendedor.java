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

    public Vendedor(String nome, String email, String senha) {
        super(nome, email, senha);
        loja = new ArrayList();
    }
    
    public void adicionarProduto(Produto produto){
        loja.add(produto);
    }
    
//    public void adicionaCor(String tipo, int quant, Cor cor){
//        for(int i=0; i<this.loja.size(); i++){
//            if(this.loja.get(i).getTipo().equalsIgnoreCase(tipo)){
//                this.loja.get(i).addCorProduto(quant, cor);
//            }
//        }
//    }

    public void exibirEstoque() {
        for (Produto aux : loja) {
            aux.exibirCatalogo();
        }
    }

    public void DadosVendedor() {
        System.out.println("");
        System.out.println("--Vendedor--");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Email: " + this.getEmail());
    }
}