package dcc025.trabalho.controller;

import dcc025.trabalho.model.ListaQuantidadeCor;
import dcc025.trabalho.model.Produto;
import dcc025.trabalho.view.AddProduto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dcc025.trabalho.view.TelaVendedor;
import java.util.HashMap;
import java.util.Map;

public class AdicionarProduto implements ActionListener{
    
    private final AddProduto telaAdd;
    
    public AdicionarProduto(AddProduto telaAdd){
        this.telaAdd = telaAdd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        telaAdd.adicionarProduto();
        telaAdd.fechar();
    }
       
}
