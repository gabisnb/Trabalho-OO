/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho;

/**
 *
 * @author joaov
 */
public class Comprador extends Pessoa{
    private double saldo;
    private ListaProdutos carrinho;

    public Comprador(double saldo, String nome, String login, String senha) {
        super(nome, login, senha);
        this.saldo = saldo;
    }
    
}
