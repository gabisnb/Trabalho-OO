package dcc025.trabalho.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

public abstract class Tela {
    protected JFrame tela;
    protected final int ALTURA = 300;
    protected final int LARGURA = 400;
    
    protected ArrayList<JButton> botoes;
    protected ArrayList<JLabel> labels;
    
    protected JPanel ConfiguraPainelMain(String nome){
        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA));
        painel.setBorder(BorderFactory.createTitledBorder(nome));
        painel.setLayout(new BorderLayout());
        return painel;
    }
    
    protected JPanel desenhaLabel(ArrayList<JLabel> labels){
        JPanel painelLabel = new JPanel();
        painelLabel.setLayout(new GridLayout(0, 1, 5, 10));
        
        for(JLabel label : labels)
            painelLabel.add(label);
        
        return painelLabel;
    }
    
    protected JPanel desenhaBotoes(ArrayList<JButton> botoes){
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(1, 0, 5, 10));
        
        for(JButton botao : botoes)
            painelBotoes.add(botao);
        
        return painelBotoes;
    }
    
    protected JPanel desenhaTF(int quantidade, int tamanho, ArrayList<JTextField> tf){
        JPanel painelTF = new JPanel();
        painelTF.setLayout(new GridLayout(0,1, 5, 4));
        
        for(int i = 0; i < quantidade; i++){
            tf.add(new JTextField(tamanho));
        }
        
        for(JTextField textfield : tf){
            painelTF.add(textfield);
        }

        return painelTF;
    }
    
    protected <T> JPanel desenhaLista(String string){

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder(string));
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA/3));
        painel.setLayout(new BorderLayout());

        DefaultListModel<T> model = new DefaultListModel<>();

        JList jlist = new JList<>(model);

        painel.add(new JScrollPane(jlist), BorderLayout.CENTER);

        return painel;
    }
}
