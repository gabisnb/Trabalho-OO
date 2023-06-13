package dcc025.trabalho.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dcc025.trabalho.view.*;
public class LoginEntrar implements ActionListener{
    private final TelaLogin tela;

    public LoginEntrar(TelaLogin tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.entrar();
    }
}
