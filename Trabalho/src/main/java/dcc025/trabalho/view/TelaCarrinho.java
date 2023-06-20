/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.*;
import dcc025.trabalho.model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;

public class TelaCarrinho extends Tela{
    
    private Comprador usuario;
    private CarrinhoCompras carrinho;
    
    private TelaComprador telaComp;
    private TelaLogin menu;
    
    private JList<Produto> jlistProdutos;

    protected TelaCarrinho(Comprador comp, TelaComprador tela, TelaLogin login) {
        usuario = comp;
        carrinho = usuario.getCarrinho();
        telaComp = tela;
        menu = login;
        super.botoes = new ArrayList();
        super.labels = new ArrayList();
    }
    
    public void desenha(){
        tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(LARGURA, ALTURA);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        
        desenhaMenu();
        
        tela.pack();
    }
    
    private void desenhaMenu(){
        JPanel painel = ConfiguraPainelMain("Carrinho de Compras");
        
        labels.add(new JLabel("Nome: " + usuario.getNome()));
        labels.add(new JLabel("Email: " + usuario.getEmail()));
        labels.add(new JLabel("Saldo: " + usuario.getSaldo()));
        labels.add(new JLabel("Valor Total: " + carrinho.getTotalPagar()));
                
        //Botão Comprar
        botoes.add(new JButton("Comprar"));
        
        //Botão Voltar
        botoes.add(new JButton("Voltar"));
        botoes.get(1).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                tela.dispose();
                telaComp.abrir();
            }
        });
        
        botoes.get(0).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                abrirPagamento();
            }
        });
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaLista("Produtos no Carrinho"));
        painelAux.add(desenhaBotoes(botoes));
        painel.add(painelAux, BorderLayout.CENTER);

        //Botão Sair
        botoes.add(new JButton("Sair"));
        botoes.get(2).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                tela.dispose();
                telaComp.fechar();
                menu.abrir();
            }
        });
        
        JPanel bpainel = new JPanel();
        bpainel.add(botoes.get(2));
        painel.add(bpainel, BorderLayout.PAGE_END);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    protected void abrirPagamento(){
        TelaPagamento telaPaga = new TelaPagamento(usuario, this);
        telaPaga.desenha();
        tela.setVisible(false);
    }
    
    protected void abrir(){
        tela.setVisible(true);
    }
}
