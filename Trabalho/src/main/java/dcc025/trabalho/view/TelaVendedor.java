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

public class TelaVendedor extends Tela{
    
    private final Vendedor usuario;
    
    private TelaLogin menu;
    
    private JList<Produto> jlistProdutos;

    protected TelaVendedor(TelaLogin login, Vendedor vend) {
        usuario = vend;
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
        JPanel painel = ConfiguraPainelMain("Vendedor");
        
        labels.add(new JLabel("Nome: " + usuario.getNome()));
        labels.add(new JLabel("Email: " + usuario.getEmail()));
        
        botoes.add(new JButton("Adicionar Produto"));
        botoes.get(0).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                abrirAddProduto();
            }
        });
        botoes.add(new JButton("Remover Produto"));
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaLista("Produtos"));
        painelAux.add(desenhaBotoes(botoes));
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
        
        //Botão Sair
        botoes.add(new JButton("Sair"));
        botoes.get(2).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                fechar();
                menu.abrir();
            }
        });
        
        bpainel.add(botoes.get(2));
        
        painel.add(bpainel, BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
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
    public void abrirAddProduto(){
        AddProduto telaAddProd = new AddProduto(this, usuario);
        telaAddProd.desenha();
        tela.setVisible(false);
    }
    
    public void abrir(){
        tela.setVisible(true);
    }
    
    public void fechar(){
        //salvar informações no banco
        tela.dispose();
    }
    
}
