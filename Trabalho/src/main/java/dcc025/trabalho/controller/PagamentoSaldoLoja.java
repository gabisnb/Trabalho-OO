
package dcc025.trabalho.controller;

import dcc025.trabalho.controller.Pagamento;
import dcc025.trabalho.Usuario.Comprador;
import dcc025.trabalho.Usuario.CarrinhoCompras;
import dcc025.trabalho.exceptions.SaldoException;

public class PagamentoSaldoLoja extends Pagamento {
    private double preco;

    public PagamentoSaldoLoja(double preco){
        this.preco = calculaDesconto(preco);
    }
    
    public double calculaDesconto(double valor){
        valor = valor*0.9;
        return valor;
    }
    
    public double getValor(){
        return preco;
    }
    
    public boolean verificaSaldo(double saldo){
        if(saldo<preco)
            return false;
        return true;
    }
}
