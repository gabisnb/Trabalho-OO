/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho;
import java.util.*;
import dcc025.trabalho.ListaQuantidadeCor.Cor;

/**
 *
 * @author joaov
 */
public class Produto implements TiposProdutos{
    private double preco;
    private int quantidadeTotal;
    ListaQuantidadeCor quantidadeCor;

    public Produto(double preco, int quantidade, Cor cor) {
        
        quantidadeCor = new ListaQuantidadeCor();
        if(cor==null)
            cor = Cor.BRANCO;
        //Gabriela: a cor que será "default" para os produtos será a cor branca
        
        if(preco>=0)
            this.preco = preco;
        else
            this.preco = 0;
        
        if(quantidade>=0)
            this.quantidadeTotal = quantidade;
        else
            this.quantidadeTotal = 0;
        
        quantidadeCor.setQuantidade(this.quantidadeTotal, cor);
    }

    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco){
        if(preco>=0)
            this.preco = preco;
    }

    public int getQuantidade() {
        return quantidadeTotal;
    }
    
    public void setQuantidade(int quantidade){
        if(quantidade>=0)
            this.quantidadeTotal = quantidade;
    }
    
    public void addCorProduto(int quantidade, Cor cor){
        if(quantidade>=0)
            this.quantidadeTotal += quantidade;
        else
            quantidade = 0;
        
        this.quantidadeCor.setQuantidade(quantidade, cor);
    }
    
    public void exibirCatalogo(){}
    public void exibirResumoProduto(){}
}
