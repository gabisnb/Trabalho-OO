/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import dcc025.trabalho.controller.GerenciarVendedores;


import dcc025.trabalho.exceptions.SaldoInvalidoException;

public class TelaComprador extends Tela{
    
    private TelaLogin menu;
    
    private Comprador usuario;
    
    private JList<Vendedor> jlistVendedores;

    protected TelaComprador(TelaLogin login, Comprador comp) {
        usuario = comp;
        menu = login;
        super.botoes = new ArrayList();
        super.labels = new ArrayList();
    }
    
    public void desenha(){
        tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(LARGURA, ALTURA);
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
//        String[] labels = {"Nome: "+usuario.getNome(),
//                           "Email: "+usuario.getEmail(),
//                           "Saldo: "+usuario.getSaldo()};
        
        //Botão Adicionar Saldo
        botoes.add(new JButton("Aumentar Saldo"));
        botoes.get(0).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                adicionarSaldo();
                //carrega();
            }
        });
        
        //Botão Carrinho de Compras
        botoes.add(new JButton("Carrinho de Compras"));
        botoes.get(1).addActionListener(new java.awt.event.ActionListener() {
            //Função que implementa a troca de tela para a tela do carrinho de compras do usuário
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
        //Adicionando função do botão sair
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
    
    
//    private JPanel desenhaBotoes(){
//        JPanel painelBotoes = new JPanel();
//        painelBotoes.setLayout(new GridLayout(1, 0, 5, 10));
//        
//        jbCarrinho =  new JButton("Carrinho de Compras");
//        jbCarrinho.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent e) {
//                abrirCarrinho();
//            }
//        });
//        
////        jbSair = new JButton("Sair");
//        jbSaldo =  new JButton("Aumentar Saldo");
//        jbSaldo.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent e) {
//                adicionarSaldo();
//                carrega();
//            }
//        });
//        
//        painelBotoes.add(jbSaldo);
//        painelBotoes.add(jbCarrinho);
////        painelBotoes.add(jbSair);
//        
//        return painelBotoes;
//    }
    
    public void adicionarSaldo(){
        String input = JOptionPane.showInputDialog("Valor a ser adicionado:");
        try{
            double saldo = Double.parseDouble(input);
            this.usuario.adicionarSaldo(saldo);
        }
        catch(NullPointerException e){
            //nada
        }
        catch(SaldoInvalidoException e){
            JOptionPane.showMessageDialog(null, "Valor inválido");
        }
    }
    
    public void abrir(){
        tela.setVisible(true);
    }
    
    public void fechar(){
        //salvar informações no banco
        tela.dispose();
    }
    
    public void abrirCarrinho(){
        TelaCarrinho carrinho = new TelaCarrinho(usuario, this, menu);
        carrinho.desenha();
        tela.setVisible(false);
    }
    
}
