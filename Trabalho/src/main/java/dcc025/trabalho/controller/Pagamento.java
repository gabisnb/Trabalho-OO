package dcc025.trabalho.controller;

public abstract class Pagamento {

    public Pagamento() {
        
    }   
    public abstract void paga(double valor);
    public abstract double calculaDesconto(double valor); 
}
