package dcc025.trabalho.controller;

import dcc025.trabalho.exceptions.InvalidProductException;
import dcc025.trabalho.view.TelaAddProduto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AdicionarProduto implements ActionListener{
    
    private final TelaAddProduto telaAdd;
    
    public AdicionarProduto(TelaAddProduto telaAdd){
        this.telaAdd = telaAdd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            telaAdd.adicionarProduto();
            telaAdd.fechar();
        }catch (InvalidProductException ex){
        }

    }
       
}
