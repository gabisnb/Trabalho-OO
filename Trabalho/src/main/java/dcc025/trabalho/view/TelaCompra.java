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

public class TelaCompra {
    
    private TelaLogin menu;
    
    private Comprador usuario;
    
    private JFrame tela;
    private final int ALTURA = 300;
    private final int LARGURA = 400;
    
    private JLabel jlNome;
    private JLabel jlEmail;
    private JLabel jlSaldo;
    
    private JButton jbSaldo;
    private JButton jbCarrinho;
    private JButton jbSair;
    
    private JList<Vendedor> jlistVendedores;

    public TelaCompra(TelaLogin login, Comprador comp) {
        usuario = comp;
        menu = login;
    }
    
    public void desenha(){
        tela = new JFrame();
        tela.addWindowListener(new GerenciarVendedores(this));
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(LARGURA, ALTURA);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        
        desenhaMenu();
        
        tela.pack();
    }
    
    private void desenhaMenu(){
        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA));
        painel.setBorder(BorderFactory.createTitledBorder("Comprador"));
        painel.setLayout(new BorderLayout());
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel());
        painelAux.add(desenhaLista());
        painelAux.add(desenhaBotoes());
        painel.add(painelAux, BorderLayout.CENTER);
        
//        JButton jbEntrar = new JButton("Entrar");
        jbSair = new JButton("Menu");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                fechar();
                menu.abrir();
            }
        });
        
        JPanel bpainel = new JPanel();
//        bpainel.add(jbEntrar);
        bpainel.add(jbSair, BorderLayout.PAGE_END);
        
        painel.add(bpainel, BorderLayout.SOUTH);
//        painel.add(desenhaBotoes(), BorderLayout.PAGE_END);

        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    private JPanel desenhaLabel(){
        JPanel painelLabel = new JPanel();
        painelLabel.setLayout(new GridLayout(0, 1, 5, 10));
        jlNome = new JLabel("Nome: " + usuario.getNome());
        jlEmail = new JLabel("Email: " + usuario.getEmail());
        jlSaldo = new JLabel("Saldo: " + usuario.getSaldo());
        
        painelLabel.add(jlNome);
        painelLabel.add(jlEmail);
        painelLabel.add(jlSaldo);
        
        return painelLabel;
    }
    
    private JPanel desenhaBotoes(){
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(1, 0, 5, 10));
        
        jbCarrinho =  new JButton("Carrinho de Compras");
        jbCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                abrirCarrinho();
            }
        });
        
//        jbSair = new JButton("Sair");
        jbSaldo =  new JButton("Aumentar Saldo");
        jbSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                adicionarSaldo();
                carrega();
            }
        });
        
        painelBotoes.add(jbSaldo);
        painelBotoes.add(jbCarrinho);
//        painelBotoes.add(jbSair);
        
        return painelBotoes;
    }
    
    private JPanel desenhaLista(){

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Vendedores disponiveis"));
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA/3));
        painel.setLayout(new BorderLayout());

        DefaultListModel<Vendedor> model = new DefaultListModel<>();


        jlistVendedores = new JList<>(model);

        painel.add(new JScrollPane(jlistVendedores), BorderLayout.CENTER);

        return painel;
    }
    
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
