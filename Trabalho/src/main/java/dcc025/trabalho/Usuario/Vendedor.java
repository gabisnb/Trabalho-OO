/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.Usuario;

import dcc025.trabalho.Usuario.Pessoa;
import dcc025.trabalho.model.Produto;
import dcc025.trabalho.model.ListaQuantidadeCor.Cor;
import dcc025.trabalho.persistence.Persistence;
import dcc025.trabalho.persistence.ProdutoPersistence;
import dcc025.trabalho.persistence.VendedorPersistence;


import java.util.*;

public class Vendedor extends Pessoa {

    private final int id;
    private double saldo_loja;

    public Vendedor(String nome, String email, String senha) {

        super(nome, email, senha);
        this.id = createID() + 1;

    }
    public String getId(){ return Integer.toString(this.id); }

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
            if(separateProductId(produto.getProduct_id()).equals(vender_id)){
                sameIdProducts.add(produto);
                System.out.println(produto.getProduct_id() + ", " + vender_id);
            }
        }
        return sameIdProducts;
    }

    private static String separateProductId(String product_id){
        String[] id = product_id.split("x");

        return id[0];
    }

    private int createID(){
        Persistence<Vendedor> all = new VendedorPersistence();
        return all.findAll().size();
    }
    
    @Override
    public String toString(){
        return "Loja de " +  this.getNome();
    }
}
