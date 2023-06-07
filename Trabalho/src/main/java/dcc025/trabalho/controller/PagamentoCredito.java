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
public class PagamentoCredito extends Pagamento {
    private final String numeroCartao;
    private final String nomeCompleto;
    private final int mesExpiracao; 
    private final int anoExpiracao; 
    
    public PagamentoCredito(Comprador atual, String numero, String nome ,int mes, int ano) {
        super(atual);
        this.numeroCartao = numero; 
        this.nomeCompleto = nome;
        this.mesExpiracao = mes; 
        this.anoExpiracao = ano;
    }
    
    public void paga(double valor){
        
    }
    public double calculaDesconto(double valor){
        return 0;
    }
    
}
