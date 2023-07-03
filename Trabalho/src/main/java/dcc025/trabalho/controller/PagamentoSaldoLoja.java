package dcc025.trabalho.controller;

public class PagamentoSaldoLoja extends Pagamento {
    private double saldo;

    public PagamentoSaldoLoja() {
    }
    public void paga(double valor){ // valor = valor a pagar
//        if(usuario.getSaldo()> valor){
//            saldo = usuario.getSaldo()- calculaDesconto(valor);
//            usuario.setSaldo(saldo);
//        }
//        else{
//            System.out.println("Saldo insuficiente");
//        }
    }
    public double calculaDesconto(double valor){
        valor = valor*0.9;
        System.out.println("Valor com desconto: " + valor);
        return valor;
    }
}
