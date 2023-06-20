package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.Comprador;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;


public class TelaPagamento extends Tela{
    
    private Comprador usuario;
    private TelaCarrinho telaAnterior;
    
    private JComboBox cbEscolha;
    
    private JButton jbPagar;
    private JButton jbCancelar;
    
    public TelaPagamento(Comprador comp, TelaCarrinho carrinho){
        usuario = comp;
        telaAnterior = carrinho;
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
        painel.add(cbEscolha, BorderLayout.BEFORE_FIRST_LINE);
        
        JPanel bpainel = new JPanel();
        
        jbCancelar = new JButton("Cancelar");
        bpainel.add(jbCancelar);
//        botoes.get(0).addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent e) {
//                tela.dispose();
//                telaAnterior.abrir();
//            }
//        });
        
        jbPagar = new JButton("Ir para Pagamento");
        bpainel.add(jbPagar);
        
        painel.add(bpainel, BorderLayout.PAGE_END);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    protected void abrir(){
        tela.setVisible(true);
    }
}
