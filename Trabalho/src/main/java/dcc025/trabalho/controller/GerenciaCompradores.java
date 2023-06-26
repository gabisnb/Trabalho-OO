package dcc025.trabalho.controller;

import dcc025.trabalho.Usuario.Comprador;
import dcc025.trabalho.persistence.CompradorPersistence;
import dcc025.trabalho.persistence.Persistence;
import dcc025.trabalho.view.TelaComprador;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;

public class GerenciaCompradores  implements WindowListener{
    
    public final TelaComprador tela;
    
    public GerenciaCompradores(TelaComprador tela){
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        tela.salvar();
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
