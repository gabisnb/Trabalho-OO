/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.Usuario;

import dcc025.trabalho.Usuario.Pessoa;
import dcc025.trabalho.model.Produto;
import dcc025.trabalho.model.ListaQuantidadeCor.Cor;
import dcc025.trabalho.persistence.ProdutoPersistence;


import java.util.*;

public class Vendedor extends Pessoa {
    private static int user_id = 1;
    private final int id;
    private double saldo_loja;

    public Vendedor(String nome, String email, String senha) {

        super(nome, email, senha);
        this.id = user_id++;

    }
    public String getId(){ return Integer.toString(id); }

    public void adicionaSaldo(double valor){
        saldo_loja += valor;
    }
    
    //Função adicionada apenas para testagem da adição de produto, mudar depois


    public static List<Produto> getProdutosByVendedorID(String vender_id){
        ProdutoPersistence persistence = new ProdutoPersistence();
        List<Produto> allProducts = new ArrayList<>();
        allProducts = persistence.findAll();

        List<Produto> sameIdProducts = new ArrayList<>();

        for(Produto produto : allProducts){
            if(separateProductId(produto.getProduct_id()).equals(vender_id))
                sameIdProducts.add(produto);
        }
        return sameIdProducts;
    }

    private static String separateProductId(String product_id){
        String[] id = product_id.split("x");

        return id[0];
    }
    
    @Override
    public String toString(){
        return "Loja de " +  this.getNome();
    }
}
