package dcc025.trabalho.view;

import dcc025.trabalho.controller.PagamentoCredito;
import dcc025.trabalho.exceptions.AnoInvalidException;
import dcc025.trabalho.exceptions.CartaoInvalidException;
import dcc025.trabalho.exceptions.MesInvalidException;
import dcc025.trabalho.exceptions.NumberCartaoException;
import dcc025.trabalho.exceptions.NumberParcelasException;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class TelaPagamentoCredito extends Tela{    
    
    private final TelaPagamento telaAnterior;
    
    public TelaPagamentoCredito(TelaPagamento telaPagamento){
        super.tf = new ArrayList();
        super.labels = new ArrayList();
        super.botoes = new ArrayList();
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
        JPanel painel = configuraPainelMain("Pagamento em Credito");
        
        labels.add(new JLabel("Numero do Cartao(de 13 a 16 digitos): "));
        labels.add(new JLabel("Nome Completo: "));
        labels.add(new JLabel("Mes Expiracao: "));
        labels.add(new JLabel("Ano Expiracao: "));
        labels.add(new JLabel("Numero de Parcelas(1 a 12 parcelas): "));
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaTF(5, 20, tf));
        painel.add(painelAux, BorderLayout.CENTER);
        
        //Botão cancelar
        botoes.add(new JButton("Cancelar"));
        botoes.add(new JButton("Finalizar Pagamento"));
        
        //Configurações botões
        botoes.get(0).addActionListener((ActionEvent e) -> {
            tela.dispose();
            telaAnterior.abrir();
        });
        botoes.get(1).addActionListener((ActionEvent e) -> {
            try{
                finalizarPagamento();
            }
            catch(NumberCartaoException e1){
                JOptionPane.showMessageDialog(null, "Número do cartão inválido");
            }
            catch(MesInvalidException e1){
                JOptionPane.showMessageDialog(null, "Mês de expiração inválido");
            }
            catch(NumberParcelasException e1){
                JOptionPane.showMessageDialog(null, "Número de parcelas inválido");
            }
            catch(AnoInvalidException e1){
                JOptionPane.showMessageDialog(null, "Ano de expiração inválido");
            }
            catch(CartaoInvalidException e1){
                JOptionPane.showMessageDialog(null, "Data de expiração inválida");
            }
            catch(NumberFormatException e1){
                JOptionPane.showMessageDialog(null, "Mês/ano de expiração inválido");
            }
        });
        
        painel.add(desenhaBotoes(botoes), BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    public void finalizarPagamento() throws NumberFormatException, CartaoInvalidException{
        String nCartao = tf.get(0).getText();
        String nome = tf.get(1).getText();
        int mes = Integer.parseInt(tf.get(2).getText());
        int ano = Integer.parseInt(tf.get(3).getText());
        int quantParcelas = Integer.parseInt(tf.get(4).getText());
        PagamentoCredito pagamento = new PagamentoCredito(nCartao, nome, mes, ano, quantParcelas);
        telaAnterior.pagar();
        tela.dispose();
    }
}
