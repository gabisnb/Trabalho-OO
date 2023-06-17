package dcc025.trabalho.view;

import dcc025.trabalho.controller.PagamentoCredito;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

public class TelaPagamentoCredito extends Tela{
    
    private ArrayList<JTextField> tf;  // Numero, Nome, Mes, Ano
    
    private JButton jbPagar;
    private JButton jbCancelar;
    
    public TelaPagamentoCredito(){
        super.labels = new ArrayList();
    }
    
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
        
        labels.add(new JLabel("Numero do Cartao: "));
        labels.add(new JLabel("Nome Completo: "));
        labels.add(new JLabel("Mes Expiracao: "));
        labels.add(new JLabel("Ano Expiracao: "));
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaTF(4, 20, tf));
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
