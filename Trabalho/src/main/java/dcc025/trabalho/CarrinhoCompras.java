/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho;

import java.util.*;

/**
 *
 * @author Gabriel
 */
public class CarrinhoCompras {
    private HashMap<Produto, Integer> carrinho; //Gabriel: Armazena o produto junto com sua quantidade
    private double totalPagar;
    
    public CarrinhoCompras()
    {
        this.totalPagar = 0.0;
        carrinho =  new HashMap<Produto, Integer>();
    }

    public void insereProduto(Produto produto, int quantidade){
        this.totalPagar = produto.getPreco() * quantidade;
        this.carrinho.put(produto, quantidade);
    }

    public void removeProduto(Produto produto, int quantidadeRemover)
    {
        if(carrinho.get(produto) - quantidadeRemover >= 0)
        {
        int quantidadeNoCarrinhoAposRemocao = carrinho.get(produto) - quantidadeRemover;
            carrinho.put(produto, quantidadeNoCarrinhoAposRemocao);
        }
        else
            carrinho.remove(produto);
    }
    
    public double getTotalPagar(){
        return totalPagar;
    }

    public void itensNoCarrinho()
    {
        System.out.println("Itens no Carrinho:");
        for(Map.Entry<Produto,Integer> aux : carrinho.entrySet())
        {
            Produto produto = aux.getKey();
            produto.exibirResumoProduto();
            System.out.println("Quantidade em Carrinho: " + aux.getValue());
        }
    }
}
