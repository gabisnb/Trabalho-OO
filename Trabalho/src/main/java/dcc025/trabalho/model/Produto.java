/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.model;
import java.util.*;

import dcc025.trabalho.exceptions.NegativePriceException;
import dcc025.trabalho.exceptions.NegativeQuantityException;
import dcc025.trabalho.model.ListaQuantidadeCor.Cor;
import dcc025.trabalho.persistence.Persistence;
import dcc025.trabalho.persistence.ProdutoPersistence;
import java.text.DecimalFormat;

public class Produto{
    protected double preco;
    protected int quantidadeTotal;
    protected Cor cor;
    protected TiposProdutos tipo;
    protected SubTipoProduto subtipo;
    protected final String product_id;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Produto(double preco, int quantidade, Cor cor, TiposProdutos tipo, SubTipoProduto subtipo, String vender_id) throws NegativePriceException, NegativeQuantityException {
        if(preco <= 0) throw new NegativePriceException();
        this.preco = preco;
        if(quantidade <= 0) throw new NegativeQuantityException();
        this.quantidadeTotal = quantidade;
        this.cor = cor;
        this.tipo = tipo;
        this.subtipo = subtipo;
        this.product_id = createId(vender_id);
    }

    public String getProduct_id() {
        return product_id;
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

    private String createId(String vender_id){
        Persistence<Produto> allProdutos = new ProdutoPersistence();
        Random random = new Random();
        int id = random.nextInt(1000);
        for(Produto produto : allProdutos.findAll()){
            if(produto.getProduct_id().equals(Integer.toString(id)))
                createId(vender_id);
        }
        return vender_id + "x" + id;
    }
    @Override
    public String toString(){
        return this.subtipo.name() + "    Cor: " + this.cor + "    Preço: " + df.format(this.preco) + "    Quantidade: " + this.quantidadeTotal;
    }
    
}
