package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.Vendedor;
import dcc025.trabalho.model.*;
import dcc025.trabalho.persistence.Persistence;
import dcc025.trabalho.persistence.ProdutoPersistence;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.*;

public class TelaVendedor extends Tela{
    
    private Vendedor usuario;
    
    private TelaLogin menu;
    
    private JList<Produto> jlistProdutos;

    protected TelaVendedor(TelaLogin login, Vendedor vend) {
        usuario = vend;
        menu = login;
        super.botoes = new ArrayList();
        super.labels = new ArrayList();
        
        DefaultListModel<Produto> model = new DefaultListModel<>();
        jlistProdutos = new JList<>(model);
    }
    
    public void desenha(){
        tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(LARGURA, ALTURA);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        
        desenhaMenu();
        
        carregaProdutosBanco(Vendedor.getProdutosByVendedorID(usuario.getId()));
        tela.pack();
    }
    
    private void desenhaMenu(){
        JPanel painel = configuraPainelMain("Vendedor");
        
        labels.add(new JLabel("Nome: " + usuario.getNome()));
        labels.add(new JLabel("Email: " + usuario.getEmail()));
        
        botoes.add(new JButton("Adicionar Produto"));
        botoes.get(0).addActionListener((java.awt.event.ActionEvent e) -> {
            abrirAddProduto();
        });
        
        botoes.add(new JButton("Remover Produto"));
        botoes.get(1).addActionListener((java.awt.event.ActionEvent e) -> {
            removeProduto(jlistProdutos.getSelectedValue());
        });
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaLista("Produtos"));
        painelAux.add(desenhaBotoes(botoes));
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
        
        //Botão Sair
        botoes.add(new JButton("Sair"));
        botoes.get(2).addActionListener((java.awt.event.ActionEvent e) -> {
            fechar();
            menu.abrir();
        });
        
        bpainel.add(botoes.get(2));
        
        painel.add(bpainel, BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    @Override
    protected JPanel desenhaLista(String string){

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder(string));
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA/3));
        painel.setLayout(new BorderLayout());

        painel.add(new JScrollPane(jlistProdutos), BorderLayout.CENTER);

        return painel;
    }
    
    public void carregaProdutosBanco(java.util.List<Produto> produtos){
        DefaultListModel<Produto> model = (DefaultListModel<Produto>)jlistProdutos.getModel();
        model.clear();
        for (Produto c: produtos) {
            model.addElement(c);
        }
    }

    public void addProduto(Produto produto){

        Persistence<Produto> persistence = new ProdutoPersistence();
        java.util.List<Produto> allProducts = persistence.findAll();

        allProducts.add(produto);

        persistence.save(allProducts);
        carregaProdutosBanco(Vendedor.getProdutosByVendedorID(usuario.getId()));
    }
    
    public void removeProduto(Produto produto){
        ProdutoPersistence persistence = new ProdutoPersistence();
        java.util.List<Produto> allProducts = persistence.findAll();
        
        int index = 0;
        
        for(Produto product : allProducts)
            if(produto.compare(product))
                index = allProducts.indexOf(product);
        
        allProducts.remove(index);

        persistence.save(allProducts);
        carregaProdutosBanco(Vendedor.getProdutosByVendedorID(usuario.getId()));
    }
    
    public void abrirAddProduto(){
        AddProduto telaAddProd = new AddProduto(this, usuario.getId());
        telaAddProd.desenha();
        tela.setVisible(false);
    }
    
    public void abrir(){
        tela.setVisible(true);
    }
    
    public void fechar(){
        tela.dispose();
    }
}
