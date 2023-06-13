/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.Vendedor;
import dcc025.trabalho.model.*;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class TelaVende {
    
    private Vendedor usuario;
    
    private TelaLogin menu;
    
    private JFrame tela;
    private final int ALTURA = 300;
    private final int LARGURA = 400;
    
    private JLabel jlNome;
    private JLabel jlEmail;
    
    private JButton jbAddProduto;
    private JButton jbRemProduto;
    private JButton jbSair;
    
    private JList<Produto> jlistProdutos;

    public TelaVende(TelaLogin login, Vendedor vend) {
        usuario = vend;
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
        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA));
        painel.setBorder(BorderFactory.createTitledBorder("Vendedor"));
        painel.setLayout(new BorderLayout());
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel());
        painelAux.add(desenhaLista());
        painelAux.add(desenhaBotoes());
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
//        JButton jbEntrar = new JButton("Entrar");
//        bpainel.add(jbEntrar);
        jbSair = new JButton("Menu");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                fechar();
                menu.abrir();
            }
        });
        bpainel.add(jbSair);
        
        painel.add(bpainel, BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    private JPanel desenhaLabel(){
        JPanel painelLabel = new JPanel();
        painelLabel.setLayout(new GridLayout(0, 1, 5, 10));
        jlNome = new JLabel("Nome: " + usuario.getNome());
        jlEmail = new JLabel("Email: " + usuario.getEmail());
        
        painelLabel.add(jlNome);
        painelLabel.add(jlEmail);
        
        return painelLabel;
    }
    
    private JPanel desenhaBotoes(){
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(1, 0, 5, 10));
        
        jbRemProduto =  new JButton("Remover Produto");
//        jbSair = new JButton("Sair");
        jbAddProduto =  new JButton("Adicionar Produto");
        
        painelBotoes.add(jbAddProduto);
        painelBotoes.add(jbRemProduto);
//        painelBotoes.add(jbSair);
        
        return painelBotoes;
    }
    
    private JPanel desenhaLista(){

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Produtos"));
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA/3));
        painel.setLayout(new BorderLayout());

        DefaultListModel<Produto> model = new DefaultListModel<>();


        jlistProdutos = new JList<>(model);

        painel.add(new JScrollPane(jlistProdutos), BorderLayout.CENTER);

        return painel;
    }
    
    public void carregaProdutos(java.util.List<Produto> produtos){
        DefaultListModel<Produto> model = (DefaultListModel<Produto>)jlistProdutos.getModel();
        
        for (Produto c: produtos) {
            model.addElement(c);
        }
    }
    
    public java.util.List<Produto> listaProdutos(){
        DefaultListModel<Produto> model = (DefaultListModel<Produto>)jlistProdutos.getModel();
        java.util.List<Produto> produtos = new ArrayList<>();

        for (int i = 0; i < model.size(); i++) {
            produtos.add(model.get(i));
        }

        return produtos;
    }

    public void addProduto(){

        DefaultListModel<Produto> model = (DefaultListModel<Produto>)jlistProdutos.getModel();
        //abrir tela de adição de produto
        
//        String input;
//        
//        Produto produto;
//        model.addElement();

    }
//
//    public void removerContato(){
//
//        int selectedIndex = jlContatos.getSelectedIndex();
//
//        if(selectedIndex != -1){
//
//            DefaultListModel<Contato> model = (DefaultListModel<Contato>)jlContatos.getModel();
//            model.remove(selectedIndex);
//        }
//    }
    
    public void fechar(){
        //salvar informações no banco
        tela.dispose();
    }
    
}
