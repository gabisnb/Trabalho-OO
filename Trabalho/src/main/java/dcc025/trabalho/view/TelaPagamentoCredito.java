/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.view;

import dcc025.trabalho.controller.PagamentoCredito;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class TelaPagamentoCredito extends Tela{
    
    private JTextField tfNumero;
    private JTextField tfNomeCompleto;
    private JTextField tfMesExpiracao;
    private JTextField tfAnoExpiracao;
    
    private JButton jbPagar;
    private JButton jbCancelar;
    
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
        JPanel painel = ConfiguraPainelMain("Pagamento em Credito");
        
        String[] labels = {"Numero do Cartao: ",
                            "Nome Completo: ",
                            "Mes Expiracao: ",
                            "Ano Expiracao: "};
        
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
        
        tfNumero = new JTextField(20);
        tfNomeCompleto = new JTextField(20);
        tfMesExpiracao = new JTextField(20);
        tfAnoExpiracao = new JTextField(20);
        
        painelTF.add(tfNumero);
        painelTF.add(tfNomeCompleto);
        painelTF.add(tfMesExpiracao);
        painelTF.add(tfAnoExpiracao);

        return painelTF;
    }
}
