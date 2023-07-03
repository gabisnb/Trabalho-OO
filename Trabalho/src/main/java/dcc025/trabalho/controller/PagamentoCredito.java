package dcc025.trabalho.controller;

import dcc025.trabalho.controller.Pagamento;
import dcc025.trabalho.Usuario.Comprador;
import dcc025.trabalho.exceptions.AnoInvalidException;
import dcc025.trabalho.exceptions.CartaoInvalidException;
import dcc025.trabalho.exceptions.MesInvalidException;
import dcc025.trabalho.exceptions.NumberParcelasException;
import dcc025.trabalho.exceptions.NumberCartaoException;

public class PagamentoCredito extends Pagamento {
    private final String numero;
    private final String nome;
    private final int mesExp; 
    private final int anoExp; 
    private final int parcelas; 
    
    public PagamentoCredito(String numero, String nome ,int mesExp, int anoExp, int parcelas) throws CartaoInvalidException{
        if(numero.length()<13 || numero.length()>16)
            throw new NumberCartaoException();
        this.numero = numero; 
        this.nome = nome;
        if(mesExp<=0 || mesExp>12)
            throw new MesInvalidException();
        this.mesExp = mesExp; 
        if(anoExp<2023)
            throw new AnoInvalidException();
        this.anoExp = anoExp;
        if(anoExp==2023 && mesExp<07)
            throw new CartaoInvalidException();
        if(parcelas <= 0 || parcelas >12)
            throw new NumberParcelasException();
        this.parcelas = parcelas;
    }
    public double calculaDesconto(double valor){
        valor = this.parcelas*0.95 + valor;
        return valor;
    }
}
