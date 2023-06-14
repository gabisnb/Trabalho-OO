/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class TelaLogin extends Tela{
    
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
        JPanel painel = ConfiguraPainelMain("Login");
        
        String[] labels = {"Nome: ",
                            "Email: ",
                            "Senha: ",
                            "Tipo de Usuário: "};
        
        JComboBox<String> cbEscolha = new JComboBox();
        cbEscolha.addItem("Comprador");
        cbEscolha.addItem("Vendedor");
        JPanel panel = desenhaTF(3, 20);
        panel.add(cbEscolha);
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(panel);
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
        bpainel.add(new JButton("Entrar"));
        
        JButton jbEntrar = new JButton("Entrar");
        jbEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                entrar();
            }
        });
        
        painel.add(bpainel, BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }

    public ArrayList<Vendedor> listaVendedores(){
        DefaultListModel<Vendedor> model = (DefaultListModel<Vendedor>)jlVendedores.getModel();
        ArrayList<Vendedor> vendedores = new ArrayList<>();

        for (int i = 0; i < model.size(); i++) {
            vendedores.add(model.get(i));
        }

        return vendedores;
    }
    
    
    public void entrar(){
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String senha = tfSenha.getText();
        int opcao = cbEscolha.getSelectedIndex();
        if(opcao==0){
            //implementar verificação de dados
            TelaCompra comprador = new TelaCompra(this, new Comprador(nome, email, senha));
            comprador.desenha();
        }
        else{
            //implementar verificação de dados
            TelaVende vendedor = new TelaVende(this, new Vendedor(nome, email, senha));
            vendedor.desenha();
        }
        tela.setVisible(false);
    }
    
    public void abrir(){
        tela.setVisible(true);
    }
}
