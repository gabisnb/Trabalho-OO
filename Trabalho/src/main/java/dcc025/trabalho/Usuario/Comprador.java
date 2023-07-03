/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.Usuario;

import dcc025.trabalho.Usuario.Pessoa;
import dcc025.trabalho.model.Produto;
import dcc025.trabalho.model.ListaQuantidadeCor.Cor;
import dcc025.trabalho.model.TiposProdutos;

import dcc025.trabalho.exceptions.SaldoException;
import dcc025.trabalho.exceptions.NegativeSaldoException;
import java.util.List;

public class Comprador extends Pessoa implements Compare<Comprador> {

    private double saldo;
    private CarrinhoCompras carrinho;

    public Comprador(String nome, String email, String senha, double saldo) {
        super(nome, email, senha);
        this.saldo = saldo;
        this.carrinho = new CarrinhoCompras();
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public CarrinhoCompras getCarrinho() {
        return this.carrinho;
    }

    public void removeProdutoCarrinho(String product_id, int quantidadeRemover) {
        this.carrinho.removeProduto(product_id, quantidadeRemover);
    }

    public void adicionarProdutoCarrinho(String product_id, int quantidadeAdicionar) {
        this.carrinho.insereProduto(product_id, quantidadeAdicionar);
    }

    public void comprarCarrinho(){carrinho.comprarTudo();}

    public void adicionarSaldo(double saldo) throws SaldoException {
        if (saldo < 0) {
            throw new NegativeSaldoException();
        }
        if(saldo==0){
            throw new SaldoException();
        }
        this.saldo += saldo;
    }
    
    public List<Produto> getProdutos(){
        return carrinho.getProdutos();
    }

    public int quantidadeEmCarrinho(String id){ return carrinho.quantidadeEmCarrinho(id);}

    @Override
    public boolean compare(Comprador item){
        return item.getEmail().equals(this.getEmail()) && item.getSenha().equals(this.getSenha() )&& item.getNome().equals(this.getNome());
    }

}
