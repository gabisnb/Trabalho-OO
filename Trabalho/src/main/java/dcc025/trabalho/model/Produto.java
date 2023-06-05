/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.model;
import java.util.*;
import dcc025.trabalho.model.ListaQuantidadeCor.Cor;

public class Produto{
    protected double preco;
    protected int quantidadeTotal;
    protected ListaQuantidadeCor quantidadeCor = new ListaQuantidadeCor();
    protected TiposProdutos tipo;
    protected SubTipoProduto subtipo;

    public Produto(double preco, int quantidade, Map<Cor, Integer> quantidadeCor, TiposProdutos tipo, SubTipoProduto subtipo)
    {
        this.preco = preco;
        quantidadeTotal = quantidade;
        this.quantidadeCor.quantidade = quantidadeCor;
        this.tipo = tipo;
        this.subtipo = subtipo;
    }
    
    public double getPreco() {return preco;}
    
    public void setPreco(double preco){
        if(preco>=0)
            this.preco = preco;
    }

    public int getQuantidade() {return quantidadeTotal;}
    
    public void setQuantidade(int quantidade){
        if(quantidade>=0)
            this.quantidadeTotal = quantidade;
    }
     
    public String getTipo(){return this.tipo.toString();}
    public String setSubTipo(){return this.subtipo.toString();}
}
