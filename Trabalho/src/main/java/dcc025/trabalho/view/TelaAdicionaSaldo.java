package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.Comprador;
import dcc025.trabalho.exceptions.CPFException;
import dcc025.trabalho.exceptions.SaldoException;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;


public class TelaAdicionaSaldo extends Tela{
    
    private final Comprador usuario;
    private TelaComprador tComprador;
    
    private ArrayList<JTextField> tf;
    
    public TelaAdicionaSaldo(TelaComprador tela, Comprador comprador){
        super.labels = new ArrayList();
        super.botoes = new ArrayList();
        tf = new ArrayList();
        usuario = comprador;
        tComprador = tela;
    }
    @Override
    protected JPanel configuraPainelMain(String nome){
        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA/2));
        painel.setBorder(BorderFactory.createTitledBorder(nome));
        painel.setLayout(new BorderLayout());
        return painel;
    }
    
    public void desenha(){
        tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(LARGURA, ALTURA/2);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        
        desenhaMenu();
        
        tela.pack();
    }
    
    public void desenhaMenu(){
        JPanel painel = configuraPainelMain("Adicionar Saldo");
        
        labels.add(new JLabel("Valor a ser adicionado: "));
        labels.add(new JLabel("CPF(apenas os números): "));
        
        JPanel panel = desenhaTF(2, 20, tf);
                
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(panel);
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
        
        botoes.add(new JButton("Voltar"));
        botoes.add(new JButton("Confirmar"));
        //Configuração
        botoes.get(0).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                tComprador.abrir();
                tela.dispose();
            }
        });
        botoes.get(1).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                adicionarSaldo();
            }
        });
        
        bpainel.add(botoes.get(0));
        bpainel.add(botoes.get(1));
        painel.add(bpainel, BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    public void adicionarSaldo(){
        try{
            String input = tf.get(0).getText();
            if(input.isEmpty())
                throw new NullPointerException();
            double saldo = Double.parseDouble(input);
            
            input = tf.get(1).getText();
            if(input.isEmpty())
                throw new NullPointerException();
//            double verificacao = Double.parseDouble(input);
            
            if(input.length() != 11 || !cpfVerificacao(input))
                throw new CPFException();
            
            this.usuario.adicionarSaldo(saldo);
            this.tComprador.carrega();
            this.tComprador.abrir();
            tela.dispose();
        }
        catch(NullPointerException e1){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
        catch(NumberFormatException e1){
            JOptionPane.showMessageDialog(null, "Formato de saldo/CPF inválido!");
        }
        catch(SaldoException e1){
            JOptionPane.showMessageDialog(null, "Valor de saldo inválido!");
        }
        catch(CPFException e1){
            JOptionPane.showMessageDialog(null, "CPF inválido!");
        }
    }
    
    private boolean cpfVerificacao(String str) throws NumberFormatException{
        char[] caracteres = str.toCharArray();
        int[] digitosCpf = new int[11]; //Os últimos dois digitos são Digitos Verificadores
        
        for(int i = 0; i < caracteres.length; i++){
            if(caracteres[i] != '0' && caracteres[i] != '1' && caracteres[i] != '2' && caracteres[i] != '3'
            && caracteres[i] != '4' && caracteres[i] != '5' && caracteres[i] != '6' && caracteres[i] != '7'
            && caracteres[i] != '8' && caracteres[i] != '9')
                throw new NumberFormatException();
            digitosCpf[i] = Character.getNumericValue(caracteres[i]);
        }
        
        //Digitos Verificadores
        int DV1, DV2;
        
        //resto da Divisao por 11 dos Digitos Verificadores
        int restoDV1 = (digitosCpf[0]*10 + digitosCpf[1]*9 + digitosCpf[2]*8 + digitosCpf[3]*7 + digitosCpf[4]*6
                 + digitosCpf[5]*5  + digitosCpf[6]*4 + digitosCpf[7]*3 + digitosCpf[8]*2) % 11;
        if(restoDV1 == 0 || restoDV1 == 1)
            DV1 = 0;
        else
            DV1 = 11 - restoDV1;
        
        int restoDV2 = (digitosCpf[1]*10 + digitosCpf[2]*9 + digitosCpf[3]*8 + digitosCpf[4]*7 + digitosCpf[5]*6
                 + digitosCpf[6]*5  + digitosCpf[7]*4 + digitosCpf[8]*3 + DV1*2) % 11;
        if(restoDV2 == 0 || restoDV2 == 1)
            DV2 = 0;
        else
            DV2 = 11 - restoDV2;
        
        return (DV1 == digitosCpf[9] && DV2 == digitosCpf[10]);
    }
}
