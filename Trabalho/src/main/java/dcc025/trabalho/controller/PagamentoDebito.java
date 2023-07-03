package dcc025.trabalho.controller;

import dcc025.trabalho.controller.Pagamento;
import dcc025.trabalho.Usuario.Comprador;
import dcc025.trabalho.exceptions.NumberCartaoException;

public class PagamentoDebito extends Pagamento {
    private final String nome;
    private final String instituicao;
    private final int tipo;  // utilizar select na interface gráfica 
    private final String agencia; 
    private final String conta;
    
    public PagamentoDebito(String nome, String instituicao, int tipo, String agencia, String conta) throws NumberCartaoException{
        this.nome = nome; 
        this.instituicao = instituicao; 
        this.tipo = tipo;
        if(agencia.length()!=5)
            throw new NumberCartaoException();
        this.agencia = agencia; 
        if(conta.length()<6 || conta.length()>8)
            throw new NumberCartaoException();
        this.conta = conta;
    }
    
    public double calculaDesconto(double valor){
        valor = valor*0.95;
        return valor;
    }
}
