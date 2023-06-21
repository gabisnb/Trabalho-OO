package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.Comprador;
import java.awt.BorderLayout;
import java.util.*;
import javax.swing.*;


public class TelaPagamento extends Tela{
    
    private final Comprador usuario;
    private final TelaCarrinho telaAnterior;
    
    private JComboBox cbEscolha;
    
    public TelaPagamento(Comprador comp, TelaCarrinho carrinho){
        usuario = comp;
        telaAnterior = carrinho;
        super.labels = new ArrayList();
        super.botoes = new ArrayList();
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
        cbEscolha.addItem("Metodo de Pagamento");
        cbEscolha.addItem("Credito");
        cbEscolha.addItem("Debito");
        cbEscolha.addItem("Saldo");
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painel.add(painelAux, BorderLayout.CENTER);
        painel.add(cbEscolha, BorderLayout.BEFORE_FIRST_LINE);

        
        botoes.add(new JButton("Cancelar"));
        botoes.add(new JButton("Ir para Pagamento"));
        
        botoes.get(0).addActionListener((java.awt.event.ActionEvent e) -> {
            tela.dispose();
            telaAnterior.abrir();
        });
        
        botoes.get(1).addActionListener((java.awt.event.ActionEvent e) -> {
            pagar();
        });
        
        painel.add(desenhaBotoes(botoes), BorderLayout.PAGE_END);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    private void pagar(){
        
        int opcao = cbEscolha.getSelectedIndex();
        
        switch(opcao){
            case 0 ->{
                //Implementar caso esteja como "Metodo de Pagamento"
                JOptionPane.showMessageDialog(null, "Escolha o Metodo de Pagamento para prosseguir");
            }
            case 1 ->{
                tela.dispose();
                TelaPagamentoCredito credito = new TelaPagamentoCredito(this);
                credito.desenha();
            }
            case 2 ->{
                tela.dispose();
                TelaPagamentoDebito debito = new TelaPagamentoDebito(this);
                debito.desenha();
            }
            case 3 ->{
                tela.dispose();
                TelaPagamentoSaldoLoja saldo = new TelaPagamentoSaldoLoja(usuario, this);
                saldo.desenha();
            }
        } 
    }
    
    protected void abrir(){
        tela.setVisible(true);
    }
}
