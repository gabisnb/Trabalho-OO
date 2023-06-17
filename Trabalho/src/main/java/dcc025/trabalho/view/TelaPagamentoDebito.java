/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.view;

import dcc025.trabalho.controller.PagamentoDebito;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author joaov
 */
public class TelaPagamentoDebito extends Tela{
    
    private JTextField tfInstituicaoFinanceira;
    private JTextField tfNomeCompleto;
    private JTextField tfTipoDaConta;
    private JTextField tfAgencia;
    private JTextField tfContaComDigito;
    
    private JButton jbCancelar;
    private JButton jbPagar;
    
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
        JPanel painel = ConfiguraPainelMain("Pagamento em Debito");
        
        String[] labels = {"Instituicao Financeira: ",
                            "Nome Completo: ",
                            "Tipo da Conta: ",
                            "Agencia: ",
                            "Conta com Digito: "};
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaTF());
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
        jbCancelar = new JButton("Cancelar");
        bpainel.add(jbCancelar);
        jbPagar = new JButton("Finalizar Pagamento");
        bpainel.add(jbPagar);
        
        painel.add(bpainel, BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    private JPanel desenhaTF(){
        JPanel painelTF = new JPanel();
        painelTF.setLayout(new GridLayout(0,1, 5, 4));
        
        tfInstituicaoFinanceira = new JTextField(20);
        tfNomeCompleto = new JTextField(20);
        tfTipoDaConta = new JTextField(20);
        tfAgencia = new JTextField(20);
        tfContaComDigito = new JTextField(20);
        
        painelTF.add(tfInstituicaoFinanceira);
        painelTF.add(tfNomeCompleto);
        painelTF.add(tfTipoDaConta);
        painelTF.add(tfAgencia);
        painelTF.add(tfContaComDigito);

        return painelTF;
    }
}
