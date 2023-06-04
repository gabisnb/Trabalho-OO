/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.*;
import dcc025.trabalho.model.*;
import java.awt.*;
import javax.swing.*;

public class TelaCarrinho {
    
    private Comprador usuario;
    private CarrinhoCompras carrinho;
    
    private JFrame tela;
    private final int ALTURA = 300;
    private final int LARGURA = 400;
    
    private JLabel jlNome;
    private JLabel jlEmail;
    private JLabel jlSaldo;
    private JLabel jlValorTotal;

    private JButton jbComprar;
    private JButton jbVoltar;
    private JButton jbSair;
    
    private JList<Produto> jlistProdutos;

    public TelaCarrinho(Comprador comp, CarrinhoCompras car) {
        usuario = comp;
        carrinho = car;
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
        painel.setBorder(BorderFactory.createTitledBorder("Carrinho de Compras"));
        painel.setLayout(new BorderLayout());
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel());
        painelAux.add(desenhaLista());
        painelAux.add(desenhaBotoes());
        painel.add(painelAux, BorderLayout.CENTER);

        jbSair = new JButton("Sair");
        JPanel bpainel = new JPanel();
        bpainel.add(jbSair);
        painel.add(bpainel, BorderLayout.PAGE_END);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    private JPanel desenhaLabel(){
        JPanel painelLabel = new JPanel();
        painelLabel.setLayout(new GridLayout(0, 1, 5, 10));
        jlNome = new JLabel("Nome: " + usuario.getNome());
        jlEmail = new JLabel("Email: " + usuario.getEmail());
        jlSaldo = new JLabel("Saldo: " + usuario.getSaldo());
        jlValorTotal = new JLabel("Valor Total: " + carrinho.getTotalPagar());
        
        painelLabel.add(jlNome);
        painelLabel.add(jlEmail);
        painelLabel.add(jlSaldo);
        painelLabel.add(jlValorTotal);
        
        return painelLabel;
    }
    
    private JPanel desenhaBotoes(){
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(1, 0, 5, 10));
        
        jbComprar =  new JButton("Comprar");
        jbVoltar = new JButton("Voltar");
//        jbSair = new JButton("Sair");
        
        painelBotoes.add(jbVoltar);
        painelBotoes.add(jbComprar);
//        painelBotoes.add(jbSair);
        
        return painelBotoes;
    }
    
    private JPanel desenhaLista(){

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Produtos no Carrinho"));
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA/3));
        painel.setLayout(new BorderLayout());

        DefaultListModel<Produto> model = new DefaultListModel<>();


        jlistProdutos = new JList<>(model);

        painel.add(new JScrollPane(jlistProdutos), BorderLayout.CENTER);

        return painel;
    }
    
}
