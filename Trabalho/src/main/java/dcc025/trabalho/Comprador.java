/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho;
import dcc025.trabalho.ListaQuantidadeCor.Cor;

public class Comprador extends Pessoa implements TiposProdutos{
    private double saldo;
    private CarrinhoCompras carrinho;
    static int qtdContas = 0;

    public Comprador(String nome, String email, String senha) {
        super(nome, email, senha);
        this.saldo = 100.00;
        this.carrinho = new CarrinhoCompras();
        qtdContas++;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void olharProdutos(Vendedor vendedor){
        vendedor.exibirEstoque();
    }
    
    public void exibirCarrinho()
    {
        this.carrinho.itensNoCarrinho();
        System.out.println("\nTotal a pagar: " + carrinho.getTotalPagar());
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
