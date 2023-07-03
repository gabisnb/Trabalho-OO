package dcc025.trabalho.view;

import dcc025.trabalho.controller.PagamentoDebito;
import dcc025.trabalho.exceptions.CartaoInvalidException;
import dcc025.trabalho.exceptions.NumberCartaoException;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class TelaPagamentoDebito extends Tela{    
    
    private final TelaPagamento telaAnterior;
    
    public TelaPagamentoDebito(TelaPagamento telaPagamento){
        super.tf = new ArrayList();
        super.labels = new ArrayList();
        super.botoes = new ArrayList();
        telaAnterior = telaPagamento;
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
        JPanel painel = configuraPainelMain("Pagamento em Debito");
        
        labels.add(new JLabel("Instituicao Financeira: "));
        labels.add(new JLabel("Nome Completo: "));
        labels.add(new JLabel("Tipo da Conta: "));
        labels.add(new JLabel("Agencia(5 digitos): "));
        labels.add(new JLabel("Conta(de 6 a 8 digitos): "));
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaTF(5, 20, tf));
        painel.add(painelAux, BorderLayout.CENTER);
        
        
        botoes.add(new JButton("Cancelar"));
        botoes.add(new JButton("Finalizar Pagamento"));
        
        botoes.get(0).addActionListener((ActionEvent e) -> {
            tela.dispose();
            telaAnterior.abrir();
        });
        botoes.get(1).addActionListener((ActionEvent e) -> {
            try{
                finalizarPagamento();
            }
            catch(NumberCartaoException e1){
                
            }
            catch(NumberFormatException e1){
                
            }
        });
        
        painel.add(desenhaBotoes(botoes), BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    public void finalizarPagamento() throws NumberCartaoException, NumberFormatException{
        String instituicao = tf.get(0).getText();
        String nome = tf.get(1).getText();
        int tipo = Integer.parseInt(tf.get(2).getText());
        String agencia = tf.get(3).getText();
        String conta = tf.get(4).getText();
        PagamentoDebito pagamento = new PagamentoDebito(nome, instituicao, tipo, agencia, conta);
        telaAnterior.pagar();
        tela.dispose();
    }
}
