/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.*;

import java.awt.*;
import javax.swing.*;

public class TelaLogin extends Tela{

    
    private JTextField tfNome;
    private JTextField tfEmail;
    private JTextField tfSenha;
    private JComboBox cbEscolha;
    
    public void desenha(){
        tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(LARGURA, ALTURA);
        abrir();
        tela.setLayout(new BorderLayout());
        
        desenhaMenu();
        
        tela.pack();
    }
    
    private void desenhaMenu(){
        JPanel painel = ConfiguraPainelMain("Login");
        
        String[] labels = {"Nome: ",
                            "Email: ",
                            "Senha: ",
                            "Tipo de Usuário: "};
        
        cbEscolha = new JComboBox();
        cbEscolha.addItem("Comprador");
        cbEscolha.addItem("Vendedor");
        JPanel panel = desenhaTF();
        panel.add(cbEscolha);
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(panel);
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
<<<<<<< Updated upstream
        bpainel.add(new JButton("Entrar"));
=======
        JButton jbEntrar = new JButton("Entrar");
        bpainel.add(jbEntrar);
        
        jbEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                entrar();
            }
        });
>>>>>>> Stashed changes
        
        painel.add(bpainel, BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
<<<<<<< Updated upstream
   
=======
    
    private JPanel desenhaTF(){
        JPanel painelTF = new JPanel();
        painelTF.setLayout(new GridLayout(0,1, 5, 4));
        
        tfNome = new JTextField(20);
        tfEmail = new JTextField(20);
        tfSenha = new JTextField(20);
        
        painelTF.add(tfNome);
        painelTF.add(tfEmail);
        painelTF.add(tfSenha);
        
        return painelTF;
    }
    
    public void entrar(){
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String senha = tfSenha.getText();
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
>>>>>>> Stashed changes
}
