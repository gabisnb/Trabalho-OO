/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho.Telas;

import javax.swing.*;

public class TelaInicio{
    
    private JFrame tela;
    private final int ALTURA = 500;
    private final int LARGURA = 500;
    
    private JButton jbEntrar;
    private JLabel jlMenu;
    private JLabel jlNome;
    private JLabel jlEmail;
    private JLabel jlSenha;
    private JTextField tfNome;
    private JTextField tfEmail;
    private JTextField tfSenha;
    private JLabel jlEscolha;
    private JComboBox<String> cbEscolha;
    
    public void TelaInicio(){
        tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(LARGURA, ALTURA);
        tela.setVisible(true);
        
        jbEntrar = new JButton();
        jlMenu = new JLabel("Menu");
        jlNome = new JLabel("Nome:");
        jlEmail = new JLabel("Email:");
        jlSenha = new JLabel("Senha:");
        jlEscolha = new JLabel("Tipo de usuário:");
        cbEscolha = new JComboBox<>(new String[] { "Vendedor", "Comprador" });
    }
}
