package dcc025.trabalho.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dcc025.trabalho.view.TelaCompra;

public class SairCompra implements ActionListener{
    private final TelaCompra telaCompra;
    
    public SairCompra(TelaCompra tela){
        this.telaCompra = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        telaCompra.sair();
    }
    
}
