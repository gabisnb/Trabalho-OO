/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dcc025.trabalho.model;

/**
 *
 * @author gabri
 */
public class TiposProdutos <T> {

    private T tipo;
    
    public TiposProdutos(T tipo){
        this.tipo = tipo;
    }
    
    public void setTipo(T tipo){
        this.tipo = tipo;
    }
    public T getTipo(){
        return this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return tipo.toString();
    }
}
