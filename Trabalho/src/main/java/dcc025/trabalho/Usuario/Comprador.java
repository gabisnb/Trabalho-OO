/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.Usuario;

import dcc025.trabalho.Usuario.Pessoa;
import dcc025.trabalho.model.Produto;
import dcc025.trabalho.model.ListaQuantidadeCor.Cor;
import dcc025.trabalho.model.TiposProdutos;

import dcc025.trabalho.exceptions.SaldoInvalidoException;

public class Comprador extends Pessoa {

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

    public void removeProdutoCarrinho(Produto produto, int quantidadeRemover) {
        this.carrinho.removeProduto(produto, quantidadeRemover);
    }

    public void adicionarCarrinho(Produto produto, int quantidadeAdicionar) {
        this.carrinho.insereProduto(produto, quantidadeAdicionar);
    }

    public void adicionarSaldo(double saldo) throws SaldoInvalidoException {
        if (saldo < 0) {
            throw new SaldoInvalidoException();
        }
        this.saldo += saldo;
    }

}
