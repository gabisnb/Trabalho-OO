package dcc025.trabalho.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dcc025.trabalho.view.TelaVende;

public class SairVende implements ActionListener{
    private final TelaVende telaVende;
    
    public SairVende(TelaVende tela){
        this.telaVende = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        telaVende.sair();
    }
    
}
