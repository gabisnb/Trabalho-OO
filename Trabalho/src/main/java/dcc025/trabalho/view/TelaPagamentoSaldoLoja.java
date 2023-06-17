/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.Comprador;
import dcc025.trabalho.controller.PagamentoSaldoLoja;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author joaov
 */
public class TelaPagamentoSaldoLoja extends Tela{
    
    private Comprador usuario;
    
    private JButton jbCancelar;
    private JButton jbPagar;
    
    public TelaPagamentoSaldoLoja(Comprador comprador){
        usuario = comprador;
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
        JPanel painel = ConfiguraPainelMain("Pagamento pelo Saldo");
        
        String[] labels = {"Nome Completo: "+usuario.getNome(),
                           "Saldo disponível: "+usuario.getSaldo()};
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
        jbCancelar = new JButton("Cancelar");
        bpainel.add(jbCancelar);
        jbPagar = new JButton("Finalizar Pagamento");
        bpainel.add(jbPagar);
        
        painel.add(bpainel, BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
}
