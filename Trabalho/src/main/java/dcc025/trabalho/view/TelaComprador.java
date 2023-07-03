package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import dcc025.trabalho.controller.GerenciarVendedores;
import dcc025.trabalho.exceptions.SaldoException;
import dcc025.trabalho.model.Produto;
import dcc025.trabalho.persistence.CompradorPersistence;
import dcc025.trabalho.persistence.Persistence;
import dcc025.trabalho.persistence.VendedorPersistence;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaComprador extends Tela{
    
    private TelaLogin menu;
    
    private Comprador usuario;
    
    private JList<Vendedor> jlistVendedores;

    protected TelaComprador(TelaLogin login, Comprador comp) {
        usuario = comp;
        menu = login;
        super.botoes = new ArrayList();
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
        JPanel painel = configuraPainelMain("Comprador");
        
        labels.add(new JLabel("Nome: "+usuario.getNome()));
        labels.add(new JLabel("Email: "+usuario.getEmail()));
        labels.add(new JLabel("Saldo: "+df.format(usuario.getSaldo())));
        
        //Botão Adicionar Saldo
        botoes.add(new JButton("Aumentar Saldo"));
        //Configuração
        botoes.get(0).addActionListener((ActionEvent e) -> {
            adicionarSaldo();
        });
        
        //Botão Carrinho de Compras
        botoes.add(new JButton("Carrinho de Compras"));
        //Configuração
        botoes.get(1).addActionListener((ActionEvent e) -> {
            abrirCarrinho();
        });
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaLista("Vendedores Disponíveis"));
        painelAux.add(desenhaBotoes(botoes));
        painel.add(painelAux, BorderLayout.CENTER);
        
        //Botao de Acesso a Loja do Vendedor
        botoes.add(new JButton("Acessar Loja"));
        try{
            botoes.get(2).addActionListener((ActionEvent e) -> {
                abrirLoja();
            });
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Selecione uma loja");
        }
        
        JPanel bpainel = new JPanel();
        
        //Botão Sair
        botoes.add(new JButton("Sair"));
        //Configuração
        botoes.get(3).addActionListener((ActionEvent e) -> {
//            fechar();
            //Salvando dados
            salvar();
            
            fechar();
            menu.abrir();
        });
        
        //Adicionando o botão no bpainel
        bpainel.add(botoes.get(3), BorderLayout.PAGE_END);
        bpainel.add(botoes.get(2), BorderLayout.SOUTH);
        
        painel.add(bpainel, BorderLayout.SOUTH);

        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    @Override
    protected JPanel desenhaLista(String string){

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder(string));
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA/3));
        painel.setLayout(new BorderLayout());

        DefaultListModel<Vendedor> model = new DefaultListModel<>();

        jlistVendedores = new JList<>(model);

        painel.add(new JScrollPane(jlistVendedores), BorderLayout.CENTER);

        Persistence<Vendedor> persistence = new VendedorPersistence();
        carregaVendedores(persistence.findAll());
        return painel;
    }
    
    public void adicionarSaldo(){
        TelaAdicionaSaldo addSaldo = new TelaAdicionaSaldo(this, usuario);
        addSaldo.desenha();
    }

    public void carrega(){
        //Salvando dados
        salvar();
        
        //Atualizando labels
        labels.get(0).setText("Nome: "+usuario.getNome());
        labels.get(1).setText("Email: "+usuario.getEmail());
        labels.get(2).setText("Saldo: "+df.format(usuario.getSaldo()));
    }
    
    protected void abrir(){
        tela.setVisible(true);
    }
    
    public void fechar(){
        //salvar informações no banco
        tela.dispose();
    }
    
    public void salvar(){
        //Salvando dados
        CompradorPersistence persistence = new CompradorPersistence();
        java.util.List<Comprador> comprador =  persistence.findAll();
        int index = 0;

        for(Comprador aux: compradores){
                    if(aux.getNome().equals(info[0]) && aux.getEmail().equals(info[1]) && aux.getSenha().equals(info[2])){
                        comprador = aux;
                    }
                }
        
        comprador.remove(index);
        
        comprador.add(this.usuario);
        persistence.save(comprador);
    }
    
    public void abrirCarrinho(){
        TelaCarrinho carrinho = new TelaCarrinho(usuario, this);
        carrinho.desenha();
        tela.setVisible(false);
    }
    
    public void carregaVendedores(java.util.List<Vendedor> vendedores){
        DefaultListModel<Vendedor> model = (DefaultListModel<Vendedor>)jlistVendedores.getModel();
        
        for (Vendedor v: vendedores) {
            model.addElement(v);
        }
    }
    
    public void abrirLoja(){
        try{
            Vendedor vendedor = jlistVendedores.getSelectedValue();
            vendedorNull(vendedor);
            TelaLojaVendedor telaLoja = new TelaLojaVendedor(this, vendedor, this.usuario);
            telaLoja.desenha();
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Selecione uma loja");
        }
    }
    
    public void vendedorNull(Vendedor vendedor) throws NullPointerException{
        if(vendedor == null)
            throw new NullPointerException();
    }
    
}
