package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.Comprador;
import dcc025.trabalho.controller.*;
import dcc025.trabalho.exceptions.CartaoInvalidException;
import dcc025.trabalho.exceptions.NumberParcelasException;
import dcc025.trabalho.exceptions.SaldoException;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
        tela.setSize(LARGURA, ALTURA-100);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        
        desenhaMenu();
        
        tela.pack();
    }
    
    @Override
    protected JPanel configuraPainelMain(String nome){
        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA-100));
        painel.setBorder(BorderFactory.createTitledBorder(nome));
        painel.setLayout(new BorderLayout());
        return painel;
    }
    
    private void desenhaMenu(){
        JPanel painel = configuraPainelMain("Pagamento");
        
        PagamentoDebito debito = null;
        try{
            debito = new PagamentoDebito(usuario.getNome(), "a", 0, "00000", "000000");
        }
        catch(CartaoInvalidException e){}
        PagamentoCredito credito = null;
        try{
            credito = new PagamentoCredito("0000000000000", usuario.getNome(), 1, 2024, 1);
        }
        catch(CartaoInvalidException e){}
        
        PagamentoSaldoLoja saldo = new PagamentoSaldoLoja(this.usuario.getCarrinho().getTotalPagar());
        double valor = usuario.getCarrinho().getTotalPagar();
        
        labels.add(new JLabel("Valor Total:       R$" + df.format(valor)));
        labels.add(new JLabel("Valor por Crédito(1x): R$" + df.format(credito.calculaDesconto(valor))));
        labels.add(new JLabel("Valor por Débito:  R$" + df.format(debito.calculaDesconto(valor))));
        labels.add(new JLabel("Valor por Saldo:   R$" + df.format(saldo.calculaDesconto(valor))));
        
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
            fechar();
        });
        
        botoes.get(1).addActionListener((java.awt.event.ActionEvent e) -> {
            abrirPagamento();
        });
        
        painel.add(desenhaBotoes(botoes), BorderLayout.PAGE_END);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    private void abrirPagamento(){
        
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
    public void fechar(){
        tela.dispose();
        telaAnterior.abrir();
    }
    
    public void pagar(){
        this.usuario.comprarCarrinho();
        JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!");
        telaAnterior.recarregaSaldo();
        fechar();
    }
}
