/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.*;
import dcc025.trabalho.controller.GerenciaCompradores;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import dcc025.trabalho.controller.GerenciarVendedores;


import dcc025.trabalho.exceptions.SaldoInvalidoException;
import dcc025.trabalho.persistence.CompradorPersistence;
import dcc025.trabalho.persistence.Persistence;

public class TelaComprador extends Tela{
    
    private TelaLogin menu;
    
    private final Comprador usuario;
    
    private JList<Vendedor> jlistVendedores;

    protected TelaComprador(TelaLogin login, Comprador comp) {
        usuario = comp;
        menu = login;
        super.botoes = new ArrayList();
        super.labels = new ArrayList();
    }
    
    public void desenha(){
        tela = new JFrame();
        tela.addWindowListener(new GerenciaCompradores(this));
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(LARGURA, ALTURA);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        
        desenhaMenu();
        
        tela.pack();
    }
    
    private void desenhaMenu(){
        JPanel painel = ConfiguraPainelMain("Comprador");
        
        labels.add(new JLabel("Nome: "+usuario.getNome()));
        labels.add(new JLabel("Email: "+usuario.getEmail()));
        labels.add(new JLabel("Saldo: "+usuario.getSaldo()));
        
        //Botão Adicionar Saldo
        botoes.add(new JButton("Aumentar Saldo"));
        //Configuração
        botoes.get(0).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                adicionarSaldo();
            }
        });
        
        //Botão Carrinho de Compras
        botoes.add(new JButton("Carrinho de Compras"));
        //Configuração
        botoes.get(1).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                abrirCarrinho();
            }
        });
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaLista("Vendedores Disponíveis"));
        painelAux.add(desenhaBotoes(botoes));
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
        
        //Botão Sair
        botoes.add(new JButton("Sair"));
        //Configuração
        botoes.get(2).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                fechar();
                menu.abrir();
            }
        });
        
        //Adicionando o botão no bpainel
        bpainel.add(botoes.get(2), BorderLayout.PAGE_END);
        
        painel.add(bpainel, BorderLayout.SOUTH);

        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    public void adicionarSaldo(){
        TelaAdicionaSaldo addSaldo = new TelaAdicionaSaldo(this, usuario);
        addSaldo.desenha();
    }
    
    public void carrega(){
        //Salvando dados
        salvar();
        
        //Atualizando labels
        labels.get(0).setText("Nome: "+usuario.getNome());
        labels.get(1).setText("Email: "+usuario.getEmail());
        labels.get(2).setText("Saldo: "+usuario.getSaldo());
    }
    
    protected void abrir(){
        tela.setVisible(true);
    }
    
    public void fechar(){
        //salvar informações no banco
        tela.dispose();
    }
    
    public void salvar(){
        //Salvando dados
        Persistence<Comprador> persistence = new CompradorPersistence();
        java.util.List<Comprador> comprador =  new ArrayList();
        comprador.add(this.usuario);
        persistence.save(comprador);
    }
    
    public void abrirCarrinho(){
        TelaCarrinho carrinho = new TelaCarrinho(usuario, this, menu);
        carrinho.desenha();
        tela.setVisible(false);
    }
    
}
