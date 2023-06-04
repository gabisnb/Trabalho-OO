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
    protected ListaQuantidadeCor quantidadeCor;
    protected TiposProdutos tipo;

    public Produto(double preco, int quantidade, Map quantidadeCor, TiposProdutos tipo)
    {
        this.preco = preco;
        quantidadeTotal = quantidade;
        this.quantidadeCor.quantidade = quantidadeCor;
        this.tipo = tipo;
    }
    
    public Produto(double preco,int quantidade , Cor cor, String tipo) {
        
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
        
        checkType(tipo);
    }
    
    private void checkType(String tipo){
        Movel [] TipoMovel = Movel.values();
        
        for(int i=0; i<TipoMovel.length; i++){
            Movel aux;
            aux = TipoMovel[i];
            if(tipo.equalsIgnoreCase(aux.name()))
                this.tipo = new TiposProdutos<Movel>(aux);
        }
        
        Roupa [] TipoRoupa = Roupa.values();
        
        for(int i=0; i<TipoRoupa.length; i++){
            Roupa aux;
            aux = TipoRoupa[i];
            if(tipo.equalsIgnoreCase(aux.name()))
                this.tipo = new TiposProdutos<Roupa>(aux);
        }
        
        Eletrodomestico [] TipoEletrodomestico = Eletrodomestico.values();
        
        for(int i=0; i<TipoEletrodomestico.length; i++){
            Eletrodomestico aux;
            aux = TipoEletrodomestico[i];
            if(tipo.equalsIgnoreCase(aux.name()))
                this.tipo = new TiposProdutos<Eletrodomestico>(aux);
        }
        
        MaterialEscritorio [] TipoMaterialEscrit = MaterialEscritorio.values();
        
        for(int i=0; i<TipoMaterialEscrit.length; i++){
            MaterialEscritorio aux;
            aux = TipoMaterialEscrit[i];
            if(tipo.equalsIgnoreCase(aux.name()))
                this.tipo = new TiposProdutos<MaterialEscritorio>(aux);
        }
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
    
    public String getTipo(){
        return this.tipo.getTipo().toString();
    }
    
    public void addCorProduto(int quantidade, Cor cor){
        if(quantidade>=0)
            this.quantidadeTotal += quantidade;
        else
            quantidade = 0;
        
        this.quantidadeCor.setQuantidade(quantidade, cor);
    }
    
    public void exibirCatalogo()
    {
        System.out.println("\n-------" + this.tipo.getTipo().toString() + "-------");
        System.out.println("Preco do Produto: " + getPreco());
        System.out.println("Quantidade total em estoque: " + getQuantidade());
        System.out.println("Cores disponiveis: ");
        quantidadeCor.listaCoresQuantidade();
    }
    
    public void exibirResumoProduto()
    {
        
//        String name = this.tipo.getTipo().toString();
//        name = name.toLowerCase();
        System.out.println("\n\nTipo: " + this.tipo.getTipo().toString() + "\nPreco: " + getPreco());
    } 
}
