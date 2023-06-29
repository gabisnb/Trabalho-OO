/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.controller;

import dcc025.trabalho.Usuario.Vendedor;
import dcc025.trabalho.model.Produto;
import dcc025.trabalho.persistence.Persistence;
import dcc025.trabalho.persistence.ProdutoPersistence;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import dcc025.trabalho.view.TelaVendedor;
import java.util.List;


public class GerenciarProdutos implements WindowListener{
    
    private final TelaVendedor tela;
    private Vendedor vendedor;
    
    public GerenciarProdutos(TelaVendedor tela, Vendedor vendedor){
        this.tela = tela;
        this.vendedor = vendedor;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //List<Produto> produtos = vendedor.getProdutosByVendedorID(vendedor.getId());
        //tela.carregaProdutosBanco(produtos);
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
