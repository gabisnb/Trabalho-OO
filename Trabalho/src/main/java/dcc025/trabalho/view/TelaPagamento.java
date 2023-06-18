package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.Comprador;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;


public class TelaPagamento extends Tela{
    
    private Comprador usuario;
    
    private JComboBox cbEscolha;
    
    private JButton jbPagar;
    private JButton jbCancelar;
    
    public TelaPagamento(Comprador comp){
        usuario = comp;
        super.labels = new ArrayList();
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
        JPanel painel = ConfiguraPainelMain("Pagamento");
        
        labels.add(new JLabel("Valor Total:       R$"+usuario.getCarrinho().getTotalPagar()));
        labels.add(new JLabel("Valor por Credito: R$"));
        labels.add(new JLabel("Valor por Debito:  R$"));
        labels.add(new JLabel("Valor por Saldo:   R$"));
        
        cbEscolha = new JComboBox<>();
        cbEscolha.addItem("Modo de Pagamento");
        cbEscolha.addItem("Credito");
        cbEscolha.addItem("Debito");
        cbEscolha.addItem("Saldo");
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painel.add(painelAux, BorderLayout.CENTER);
        painel.add(cbEscolha, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
        jbCancelar = new JButton("Cancelar");
        bpainel.add(jbCancelar);
        jbPagar = new JButton("Ir para Pagamento");
        bpainel.add(jbPagar);
        
        painel.add(bpainel, BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
}
