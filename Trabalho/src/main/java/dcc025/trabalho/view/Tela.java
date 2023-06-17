/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public abstract class Tela {
    protected JFrame tela;
    protected final int ALTURA = 300;
    protected final int LARGURA = 400;
    
    protected JPanel ConfiguraPainelMain(String nome){
        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA));
        painel.setBorder(BorderFactory.createTitledBorder(nome));
        painel.setLayout(new BorderLayout());
        return painel;
    }
    
    protected JPanel desenhaLabel(String strings[]){
        JPanel painelLabel = new JPanel();
        painelLabel.setLayout(new GridLayout(0, 1, 5, 10));
        
        for(String string : strings)
            painelLabel.add(new JLabel(string));
        
        return painelLabel;
    }
    
    protected JPanel desenhaBotoes(String strings[]){
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(1, 0, 5, 10));
        
        for(String string : strings)
            painelBotoes.add(new JButton(string));
        
        return painelBotoes;
    }
    
//    protected JPanel desenhaTF(int quantidade, int tamanho, JTextField tf[]){
//        JPanel painelTF = new JPanel();
//        painelTF.setLayout(new GridLayout(0,1, 5, 4));
//        
//        tf = new JTextField[quantidade];
//
//        
//        for(JTextField textfield : tf){
//            textfield.setColumns(tamanho);
//            painelTF.add(textfield);
//        }
//
//        return painelTF;
//    }
    
    protected <T> JPanel desenhaLista(String string){

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder(string));
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA/3));
        painel.setLayout(new BorderLayout());

        DefaultListModel<T> model = new DefaultListModel<>();

        JList jlist = new JList<>(model);

        painel.add(new JScrollPane(jlist), BorderLayout.CENTER);

        return painel;
    }
}
