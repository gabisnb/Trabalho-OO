/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.controller;

import dcc025.trabalho.controller.Pagamento;
import dcc025.trabalho.Usuario.Comprador;
/**
 *
 * @author gabri
 */
public class PagamentoDebito extends Pagamento {
    private final String nome;
    private final String instituicao;
    private final int tipo;  // utilizar select na interface gráfica 
    private final int agencia; 
    private final String conta;
    
    public PagamentoDebito(Comprador atual, String nome, String instituicao, int tipo, int agencia, String conta) {
        super(atual);
        this.nome = nome; 
        this.instituicao = instituicao; 
        this.tipo = tipo;
        this.agencia = agencia; 
        this.conta = conta;
        
    }
    
    public void paga(double valor){
        System.out.println("Pagamento efetuado no valor de "+ calculaDesconto(valor));
    }
    public double calculaDesconto(double valor){
        valor = valor*0.95;
        return valor;
    }
}
