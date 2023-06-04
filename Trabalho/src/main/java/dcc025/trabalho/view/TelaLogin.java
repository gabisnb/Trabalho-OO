/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.*;
import java.awt.*;
import javax.swing.*;

public class TelaLogin {
    
    private JFrame tela;
    private final int ALTURA = 300;
    private final int LARGURA = 400;
    
    private JLabel jlEscolha;
    private JLabel jlNome;
    private JLabel jlEmail;
    private JLabel jlSenha;
    
    private JTextField tfNome;
    private JTextField tfEmail;
    private JTextField tfSenha;

    private JComboBox<String> cbEscolha;
    
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
        painel.setBorder(BorderFactory.createTitledBorder("Login"));
        painel.setLayout(new BorderLayout());
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel());
        painelAux.add(desenhaTF());
        painel.add(painelAux, BorderLayout.CENTER);
        
        JButton jbEntrar = new JButton("Entrar");
        JPanel bpainel = new JPanel();
        bpainel.add(jbEntrar);
        
        painel.add(bpainel, BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    private JPanel desenhaLabel(){
        JPanel painelLabel = new JPanel();
        painelLabel.setLayout(new GridLayout(0, 1, 5, 10));
        
        jlNome = new JLabel("Nome:");
        jlEmail = new JLabel("Email:");
        jlSenha = new JLabel("Senha:");
        jlEscolha = new JLabel("Tipo de Usuário:");
        
        painelLabel.add(jlNome);
        painelLabel.add(jlEmail);
        painelLabel.add(jlSenha);
        painelLabel.add(jlEscolha);
        
        return painelLabel;
    }
    
    private JPanel desenhaTF(){
        JPanel painelTF = new JPanel();
        painelTF.setLayout(new GridLayout(0,1, 5, 4));
        tfNome = new JTextField(20);
        tfEmail = new JTextField(20);
        tfSenha = new JTextField(20);
        cbEscolha = new JComboBox();
        
        cbEscolha.addItem("Comprador");
        cbEscolha.addItem("Vendedor");
        
        painelTF.add(tfNome);
        painelTF.add(tfEmail);
        painelTF.add(tfSenha);
        painelTF.add(cbEscolha);
        
        return painelTF;
    }
}