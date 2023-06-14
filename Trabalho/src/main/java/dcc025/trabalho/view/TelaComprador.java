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
        
        String[] labels = {"Nome: "+usuario.getNome(),
                           "Email: "+usuario.getEmail(),
                           "Saldo: "+usuario.getSaldo()};
        
        String[] botoes = {"Aumentar Saldo",
                            "Carrinho de Compras"};
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaLista("Vendedores Disponíveis"));
        painelAux.add(desenhaBotoes(botoes));
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
        bpainel.add(new JButton("Sair"), BorderLayout.PAGE_END);
        
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
    
    public void carrega(){
//        jlNome.setText("Nome: " + usuario.getNome());
//        jlEmail.setText("Email: " + usuario.getEmail());
        jlSaldo.setText("Saldo: " + usuario.getSaldo());
//        jlNome = new JLabel("Nome: " + usuario.getNome());
//        jlEmail = new JLabel("Email: " + usuario.getEmail());
//        jlSaldo = new JLabel("Saldo: " + usuario.getSaldo());
    }
    
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