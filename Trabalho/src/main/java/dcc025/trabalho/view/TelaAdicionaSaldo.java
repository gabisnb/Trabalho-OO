package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.Comprador;
import dcc025.trabalho.exceptions.SaldoException;
import dcc025.trabalho.model.*;

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
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        labels.add(new JLabel("CPF: "));
        
        JPanel panel = desenhaTF(2, 20, tf);
        
        tf.get(0).addKeyListener(new java.awt.event.KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    adicionarSaldo();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(panel);
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
        
        //Botão Entrar
        botoes.add(new JButton("Confirmar"));
        //Configuração
        botoes.get(0).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                adicionarSaldo();
            }
        });
        botoes.get(0).addKeyListener(new java.awt.event.KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    adicionarSaldo();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        
        bpainel.add(botoes.get(0));
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
            double verificacao = Double.parseDouble(input);
            if(input.length()!=11)
                throw new Exception();
            
            this.usuario.adicionarSaldo(saldo);
            this.tComprador.carrega();
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
        catch(Exception e1){
            JOptionPane.showMessageDialog(null, "CPF inválido, deve conter 11 digitos!");
        }
    }
    
}
