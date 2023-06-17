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
    private final String nomeCompleto;
    private final String instituicaoFinanceira;
    private final int tipoConta;  // utilizar select na interface gráfica 
    private final int agencia; 
    private final String contaComDigito;
    
    public PagamentoDebito(Comprador atual, String nome, String instituicao, int tipo, int agencia, String conta) {
        super(atual);
        this.nomeCompleto = nome; 
        this.instituicaoFinanceira = instituicao; 
        this.tipoConta = tipo;
        this.agencia = agencia; 
        this.contaComDigito = conta;
        
    }
    
    public void paga(double valor){
        
    }
    public double calculaDesconto(double valor){
        return 0;
    }
}
