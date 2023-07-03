package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.Comprador;

import dcc025.trabalho.controller.PagamentoSaldoLoja;
import dcc025.trabalho.exceptions.SaldoException;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;


public class TelaPagamentoSaldoLoja extends Tela{
    
    private final Comprador usuario;
    
    private final TelaPagamento telaAnterior;
    
    private final PagamentoSaldoLoja pagamento;
    
    public TelaPagamentoSaldoLoja(Comprador comprador, TelaPagamento telaPagamento){
        super.labels = new ArrayList();
        super.botoes = new ArrayList();
        usuario = comprador;
        telaAnterior = telaPagamento;
        this.pagamento = new PagamentoSaldoLoja(this.usuario.getCarrinho().getTotalPagar());
    }
    
    public void desenha(){
        tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(LARGURA+75, ALTURA-100);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        
        desenhaMenu();
        
        tela.pack();
    }
    
    @Override
    protected JPanel configuraPainelMain(String nome){
        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(LARGURA+75, ALTURA-100));
        painel.setBorder(BorderFactory.createTitledBorder(nome));
        painel.setLayout(new BorderLayout());
        return painel;
    }
    
    private void desenhaMenu(){
        JPanel painel = configuraPainelMain("Pagamento pelo Saldo");
        
        labels.add(new JLabel("Nome Completo: " + usuario.getNome()));
        labels.add(new JLabel("Saldo disponível: " + usuario.getSaldo()));
        labels.add(new JLabel("Total a pagar: " + this.pagamento.getValor()));
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painel.add(painelAux, BorderLayout.CENTER);
        
        
        botoes.add(new JButton("Cancelar"));
        botoes.add(new JButton("Finalizar Pagamento"));
        
        botoes.get(0).addActionListener((ActionEvent e) -> {
            tela.dispose();
            telaAnterior.abrir();
        });
        botoes.get(1).addActionListener((ActionEvent e) -> {
            try{
                finalizarCompra();
            }
            catch(SaldoException e1){
                JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
            }
        });
        
        painel.add(desenhaBotoes(botoes), BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    public void finalizarCompra() throws SaldoException{
        if(!pagamento.verificaSaldo(this.usuario.getSaldo()))
            throw new SaldoException();
        
        this.usuario.setSaldo(this.usuario.getSaldo() - pagamento.getValor());
        telaAnterior.pagar();
        tela.dispose();
    }
}
