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
        JPanel painel = ConfiguraPainelMain("Vendedor");
        
        String[] labels = {"Nome: "+usuario.getNome(),
                           "Email: "+usuario.getEmail()};
        
        String[] botoes = {"Adicionar Produto",
                           "Remover Produto"};
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaLista("Produtos"));
        painelAux.add(desenhaBotoes(botoes));
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
        bpainel.add(new JButton("Sair"));
        
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
    
    public void fechar(){
        //salvar informações no banco
        tela.dispose();
    }
    
}
