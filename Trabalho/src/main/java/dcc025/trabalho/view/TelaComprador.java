/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.Comprador;

import java.awt.*;
import javax.swing.*;

public class TelaComprador extends Tela{
    
    private final Comprador usuario;    
    
    public TelaComprador(Comprador comp) {
        usuario = comp;
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
        JPanel painel = ConfiguraPainelMain("Comprador");
        
        String[] labels = {"Nome: "+usuario.getNome(),
                           "Email: "+usuario.getEmail(),
                           "Saldo: "+usuario.getSaldo()};
        
        String[] botoes = {"Aumentar Saldo",
                            "Carrinho de Compras"};
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaLista("Vendedores Disponíveis"));
        painelAux.add(desenhaBotoes(botoes));
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
        bpainel.add(new JButton("Sair"), BorderLayout.PAGE_END);
        
        painel.add(bpainel, BorderLayout.SOUTH);

        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
}
