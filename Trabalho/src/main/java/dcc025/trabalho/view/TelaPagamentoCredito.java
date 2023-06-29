package dcc025.trabalho.view;

import dcc025.trabalho.controller.PagamentoCredito;

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
        
        labels.add(new JLabel("Numero do Cartao: "));
        labels.add(new JLabel("Nome Completo: "));
        labels.add(new JLabel("Mes Expiracao: "));
        labels.add(new JLabel("Ano Expiracao: "));
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaTF(4, 20, tf));
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
