/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class TelaCompra {
    
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

    public TelaCompra(Comprador comp) {
        usuario = comp;
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
        jbSair = new JButton("Sair");
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
//        jbSair = new JButton("Sair");
        jbSaldo =  new JButton("Aumentar Saldo");
        
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
    
}