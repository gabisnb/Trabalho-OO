package dcc025.trabalho.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dcc025.trabalho.view.TelaCompra;

public class AdicionarSaldo implements ActionListener{
    private final TelaCompra tela;
    
    public AdicionarSaldo(TelaCompra tela){
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        tela.adicionarSaldo();
        tela.carrega();
    }
}
