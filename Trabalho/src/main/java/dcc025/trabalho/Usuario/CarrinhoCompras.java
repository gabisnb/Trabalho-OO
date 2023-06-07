/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.Usuario;

import dcc025.trabalho.model.Produto;
import java.util.*;

public class CarrinhoCompras {
    private Map<Produto, Integer> carrinho; //Gabriel: Armazena o produto junto com sua quantidade
    private double totalPagar;
    
    public CarrinhoCompras()
    {
        this.totalPagar = 0.0;
        carrinho =  new HashMap<>();
    }

    public void insereProduto(Produto produto, int quantidade){
        this.totalPagar += produto.getPreco() * quantidade;
        this.carrinho.put(produto, quantidade);
    }

    public void removeProduto(Produto produto, int quantidade)
    {
        if(carrinho.get(produto) - quantidade > 0)
        {
        this.totalPagar -= produto.getPreco()*quantidade;
        int quantidadeNoCarrinhoAposRemocao = carrinho.get(produto) - quantidade;
            carrinho.put(produto, quantidadeNoCarrinhoAposRemocao);
        }
        else{
            this.totalPagar -= carrinho.get(produto)*produto.getPreco();
            carrinho.remove(produto);
        }
    }
    
    public double getTotalPagar(){
        return totalPagar;
    }

}
