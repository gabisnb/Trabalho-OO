/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class TelaLogin extends Tela{
    
    private JComboBox cbEscolha;
    
    public TelaLogin(){
        super.botoes = new ArrayList();
        super.labels = new ArrayList();
        tf = new ArrayList();
    }
    
    public void desenha(){
        tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(LARGURA, ALTURA);
        tela.setLocationRelativeTo(null);
        abrir();
        tela.setLayout(new BorderLayout());
        
        desenhaMenu();
        
        tela.pack();
    }
    
    private void desenhaMenu(){
        JPanel painel = ConfiguraPainelMain("Login");
        
        labels.add(new JLabel("Nome: "));
        labels.add(new JLabel("Email: "));
        labels.add(new JLabel("Senha: "));
        labels.add(new JLabel("Tipo de Usuário: "));
        
        cbEscolha = new JComboBox();
        cbEscolha.addItem("Comprador");
        cbEscolha.addItem("Vendedor");
        JPanel panel = desenhaTF(3, 20, tf);
        panel.add(cbEscolha);
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(panel);
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
        
        //Botão Entrar
        botoes.add(new JButton("Entrar"));
        //Configuração
        botoes.get(0).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                entrar();
            }
        });
        
        bpainel.add(botoes.get(0));
        painel.add(bpainel, BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    public void entrar(){
        String nome = tf.get(0).getText();
        String email = tf.get(1).getText();
        String senha = tf.get(2).getText();
        int opcao = cbEscolha.getSelectedIndex();
        if(opcao==0){
            //implementar verificação de dados
            TelaComprador comprador = new TelaComprador(this, new Comprador(nome, email, senha));
            comprador.desenha();
        }
        else{
            //implementar verificação de dados
            TelaVendedor vendedor = new TelaVendedor(this, new Vendedor(nome, email, senha));
            vendedor.desenha();
        }
        tela.setVisible(false);
    }
    
    public void abrir(){
        tela.setVisible(true);
    }
}
