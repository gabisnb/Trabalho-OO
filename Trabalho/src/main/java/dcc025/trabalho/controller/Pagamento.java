/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.controller;
import dcc025.trabalho.Usuario.Comprador;
/**
 *
 * @author gabri
 */
public abstract class Pagamento {

    public Pagamento() {
        
    }
    public abstract double calculaDesconto(double valor); 
}
