package dcc025.trabalho.controller;

import dcc025.trabalho.controller.Pagamento;
import dcc025.trabalho.Usuario.Comprador;
import dcc025.trabalho.exceptions.NumberParcelasException;

public class PagamentoCredito extends Pagamento {
    private final String numero;
    private final String nome;
    private final int mesExp; 
    private final int anoExp; 
    private final int parcelas; 
    
    public PagamentoCredito(String numero, String nome ,int mesExp, int anoExp, int parcelas) throws NumberParcelasException{
        this.numero = numero; 
        this.nome = nome;
        this.mesExp = mesExp; 
        this.anoExp = anoExp;
        if(parcelas <= 0 && parcelas >12)
            throw new NumberParcelasException();
        this.parcelas = parcelas;
    }
    public void paga(double valor){
        System.out.println("Pagamento realizado no valor de " + calculaDesconto(valor));
    }
    public double calculaDesconto(double valor){
        valor = this.parcelas*0.95 + valor;
        return valor;
    }
}
