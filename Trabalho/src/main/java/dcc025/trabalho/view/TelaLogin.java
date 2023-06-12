/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.*;

import java.awt.*;
import javax.swing.*;

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
        
        painel.add(bpainel, BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
   
}
