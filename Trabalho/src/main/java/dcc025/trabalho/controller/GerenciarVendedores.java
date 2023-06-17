package dcc025.trabalho.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import dcc025.trabalho.view.TelaComprador;
import dcc025.trabalho.view.TelaLogin;

public class GerenciarVendedores implements WindowListener{
    
    private final TelaComprador tela;
    
    public GerenciarVendedores(TelaComprador tela){
        this.tela = tela;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        //adicionar atualização de vendedores
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //adicionar o salvamento de dados no banco
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
}
