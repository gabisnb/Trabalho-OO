package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.Comprador;
import dcc025.trabalho.controller.PagamentoSaldoLoja;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;


public class TelaPagamentoSaldoLoja extends Tela{
    
    private final Comprador usuario;
    
    private final TelaPagamento telaAnterior;
    
    public TelaPagamentoSaldoLoja(Comprador comprador, TelaPagamento telaPagamento){
        super.labels = new ArrayList();
        super.botoes = new ArrayList();
        usuario = comprador;
        telaAnterior = telaPagamento;
    }
    
    public void desenha(){
        tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(LARGURA, ALTURA);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        
        desenhaMenu();
        
        tela.pack();
    }
    
    private void desenhaMenu(){
        JPanel painel = configuraPainelMain("Pagamento pelo Saldo");
        
        labels.add(new JLabel("Nome Completo: " + usuario.getNome()));
        labels.add(new JLabel("Saldo disponível: " + usuario.getSaldo()));
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painel.add(painelAux, BorderLayout.CENTER);
        
        
        botoes.add(new JButton("Cancelar"));
        botoes.add(new JButton("Finalizar Pagamento"));
        
        botoes.get(0).addActionListener((ActionEvent e) -> {
            tela.dispose();
            telaAnterior.abrir();
        });
        
        painel.add(desenhaBotoes(botoes), BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
}
