/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.Usuario;

import dcc025.trabalho.exceptions.ProductAlreadyShoppingCart;
import dcc025.trabalho.model.Produto;
import dcc025.trabalho.persistence.Persistence;
import dcc025.trabalho.persistence.ProdutoPersistence;
import dcc025.trabalho.persistence.VendedorPersistence;

import javax.swing.JOptionPane;

import javax.swing.*;
import java.util.*;

public class CarrinhoCompras {
    private Map<String, Integer> carrinho; //Gabriel: Armazena o produto junto com sua quantidade
    private double totalPagar;
    
    public CarrinhoCompras()
    {
        this.totalPagar = 0.0;
        carrinho =  new HashMap<>();
    }

    public void insereProduto(String product_id, int quantidade){
        ProdutoPersistence persistence = new ProdutoPersistence();
        Produto produto = persistence.getProductbyID(product_id);
        try{
            checkException(produto.getProduct_id());
            carrinho.put(produto.getProduct_id(), quantidade);
        }
        catch(ProductAlreadyShoppingCart e){
            carrinho.put(produto.getProduct_id(), carrinho.get(produto.getProduct_id())+1);
        }
        totalPagar += produto.getPreco();
    }
    
    public void checkException(String s) throws ProductAlreadyShoppingCart{
        if(carrinho.containsKey(s))
            throw new ProductAlreadyShoppingCart();
    }

    public void removeProduto(String product_id, int quantidade)
    {

        ProdutoPersistence persistence = new ProdutoPersistence();
        Produto produto = persistence.getProductbyID(product_id);

        if(carrinho.get(product_id) - quantidade > 0)
        {
            this.totalPagar -= produto.getPreco()*quantidade;
            int quantidadeNoCarrinhoAposRemocao = carrinho.get(product_id) - quantidade;
            carrinho.put(produto.getProduct_id(), quantidadeNoCarrinhoAposRemocao);
        }
        else{
            this.totalPagar -= carrinho.get(product_id)*produto.getPreco();
            carrinho.remove(product_id);
        }
    }

    public void comprarTudo()
    {
        ProdutoPersistence persistence = new ProdutoPersistence();
        List<Produto> allProducts = new ArrayList<>();
        allProducts = persistence.findAll();

        for (Produto produto : allProducts)
        {
            try{
                if(carrinho.containsKey(produto.getProduct_id()))
                {
                    VendedorPersistence vendedorPers = new VendedorPersistence();
                    Vendedor vendedor = vendedorPers.findVendedorByProductID(produto.getProduct_id());
                    vendedor.adicionaSaldo(produto.getPreco() * carrinho.get(produto.getProduct_id()));
                }
            } catch (NullPointerException e){
                JOptionPane.showMessageDialog(null, "Produto esgotado");
            }
            finally {
                carrinho.remove(produto.getProduct_id());
            }
        }
        allProducts.clear();
        allProducts = null;
    }

    public double getTotalPagar(){
        return totalPagar;
    }
    
    public List<Produto> getProdutos(){
        ProdutoPersistence persistence = new ProdutoPersistence();
        List<Produto> produtos = new ArrayList();
        
        List<String> invalido = new ArrayList();
        this.totalPagar = 0;
        
        for(String s: this.carrinho.keySet()){
            Produto produto = persistence.getProductbyID(s);
            if(produto!=null){
                produto.setQuantidade(this.carrinho.getOrDefault(s, 1));
                produtos.add(produto);
                totalPagar += produto.getPreco()*produto.getQuantidade();
                System.out.println(s);
            }
            else{
                System.out.println( "Tem que apagar: "+s);
                invalido.add(s);
            }
        }
        
        for(String s: invalido){
            this.carrinho.remove(s);
        }
        return produtos;
    }
    public int quantidadeEmCarrinho(String id){
        return carrinho.get(id);
    }
    
    public boolean isEmpty(){
        return this.carrinho.isEmpty();
    }
}
