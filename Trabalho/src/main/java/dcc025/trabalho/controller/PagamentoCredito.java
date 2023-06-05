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

    public PagamentoCredito(Comprador atual) {
        super(atual);
    }
    
    public void paga(double valor){
        
    }
    public double calculaDesconto(double valor){
        return 0;
    }
    
}
