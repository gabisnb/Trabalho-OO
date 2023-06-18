package dcc025.trabalho.view;

import dcc025.trabalho.controller.PagamentoDebito;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;


public class TelaPagamentoDebito extends Tela{
    
    private ArrayList<JTextField> tf;  //Instituicao, Nome, TipoConta, Agencia
    
    private JButton jbCancelar;
    private JButton jbPagar;
    
    public TelaPagamentoDebito(){
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
        JPanel painel = ConfiguraPainelMain("Pagamento em Debito");
        
        labels.add(new JLabel("Instituicao Financeira: "));
        labels.add(new JLabel("Nome Completo: "));
        labels.add(new JLabel("Tipo da Conta: "));
        labels.add(new JLabel("Agencia: "));
        labels.add(new JLabel("Conta com Digito: "));
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaTF(5, 20, tf));
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
        jbCancelar = new JButton("Cancelar");
        bpainel.add(jbCancelar);
        jbPagar = new JButton("Finalizar Pagamento");
        bpainel.add(jbPagar);
        
        painel.add(bpainel, BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
}
