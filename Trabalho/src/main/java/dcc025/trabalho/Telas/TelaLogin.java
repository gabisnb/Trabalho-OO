/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.Telas;

import dcc025.trabalho.Usuario.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaLogin{
    
    private JFrame tela;
    private final int ALTURA = 200;
    private final int LARGURA = 400;
    
    private JLabel jlNome;
    private JLabel jlEmail;
    private JLabel jlSenha;
    private JTextField tfNome;
    private JTextField tfEmail;
    private JTextField tfSenha;
    private JLabel jlEscolha;
    private JComboBox<String> cbEscolha;
    
    public void desenha(){
        tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(LARGURA, ALTURA);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        
        desenhaMenu();
        
        tela.pack();
        
//        cbEscolha = new JComboBox<>(new String[] { "Vendedor", "Comprador" });
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
        painel.add(jbEntrar);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    private JPanel desenhaLabel(){
        JPanel painelLabel = new JPanel();
        painelLabel.setLayout(new GridLayout(0, 1));
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
        painelTF.setLayout(new GridLayout(0,1));
        tfNome = new JTextField(20);
        tfEmail = new JTextField(20);
        tfSenha = new JTextField(20);
        painelTF.add(tfNome);
        painelTF.add(tfEmail);
        painelTF.add(tfSenha);
        
        return painelTF;
    }
}
