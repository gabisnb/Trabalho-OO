/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.Usuario;
import dcc025.trabalho.Usuario.Pessoa;
import dcc025.trabalho.model.Produto;
import dcc025.trabalho.model.ListaQuantidadeCor.Cor;
import dcc025.trabalho.model.TiposProdutos;

public class Comprador extends Pessoa{
    private double saldo;
    private CarrinhoCompras carrinho;
    private static int qtdContas = 0;

    public Comprador(String nome, String email, String senha) {
        super(nome, email, senha);
        this.saldo = 100.00;
        this.carrinho = new CarrinhoCompras();
        qtdContas++;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void removeProdutoCarrinho(Produto produto, int quantidadeRemover)
    {
        this.carrinho.removeProduto(produto, quantidadeRemover);
    }
    
    public void adicionarCarrinho(Produto produto, int quantidadeAdicionar)
    {
        this.carrinho.insereProduto(produto, quantidadeAdicionar);
    }
    
    public void adicionarSaldo(double saldo){
        this.saldo += saldo;
    }
    
    public void DadosComprador()
    {
        System.out.println("");
        System.out.println("--Cliente--");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Saldo: " + this.saldo);
    }   
}
