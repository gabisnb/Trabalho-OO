package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.Comprador;
import dcc025.trabalho.Usuario.Vendedor;
import dcc025.trabalho.exceptions.ProductLimitException;
import dcc025.trabalho.model.Produto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TelaLojaVendedor extends Tela{
    private Vendedor vendedor;
    private Comprador comprador;
    
    private TelaComprador telaAnterior;
    
    private JList<Produto> jlistProdutos;
    
    public TelaLojaVendedor(TelaComprador telaAnterior, Vendedor vend, Comprador compr) {
        vendedor = vend;
        comprador = compr;
        this.telaAnterior = telaAnterior;
        super.botoes = new ArrayList();
        super.labels = new ArrayList();
    }
    
    public void desenha(){
        tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setSize(LARGURA, ALTURA*2/3);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        
        desenhaMenu();
        carregaProdutos(Vendedor.getProdutosByVendedorID(vendedor.getId()));
        
        tela.pack();
    }
    
    @Override
    protected JPanel configuraPainelMain(String nome){
        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA*2/3));
        painel.setBorder(BorderFactory.createTitledBorder(nome));
        painel.setLayout(new BorderLayout());
        return painel;
    }
    
    private void desenhaMenu(){
        JPanel painel = configuraPainelMain("Loja");
        
        labels.add(new JLabel("Nome: " + vendedor.getNome()));
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaLista("Produtos"));
        painelAux.add(desenhaBotoes(botoes));
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
        
        //Botao Adicionar no Carrinho
        botoes.add(new JButton("Adicionar Produto ao carrinho"));
        botoes.get(0).addActionListener((java.awt.event.ActionEvent e) -> {
            try {
                checkProductMax(jlistProdutos.getSelectedValue());
                adicionarProduto();
            }
            catch (ProductLimitException ex){
                JOptionPane.showMessageDialog(null, "Máximo de Inserção de Produto");
            }
            catch (NullPointerException ex){
                adicionarProduto();
            }
        });


        //Botão Sair
        botoes.add(new JButton("Sair"));
        botoes.get(1).addActionListener((java.awt.event.ActionEvent e) -> {
            this.tela.dispose();
        });
        
        for(JButton botao : botoes)
            bpainel.add(botao);
        
        painel.add(bpainel, BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    @Override
    protected JPanel desenhaLista(String string){

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder(string));
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA/2));
        painel.setLayout(new BorderLayout());

        DefaultListModel<Produto> model = new DefaultListModel<>();

        jlistProdutos = new JList<>(model);

        painel.add(new JScrollPane(jlistProdutos), BorderLayout.CENTER);

        return painel;
    }
    
    public void carregaProdutos(java.util.List<Produto> produtos){
        DefaultListModel<Produto> model = (DefaultListModel<Produto>)jlistProdutos.getModel();
        model.clear();
        for (Produto c: produtos) {
            model.addElement(c);
        }
    }
    
    public java.util.List<Produto> listaProdutos(){
        DefaultListModel<Produto> model = (DefaultListModel<Produto>)jlistProdutos.getModel();
        java.util.List<Produto> produtos = new ArrayList<>();

        for (int i = 0; i < model.size(); i++) {
            produtos.add(model.get(i));
        }

        return produtos;
    }


    public void checkProductMax(Produto produto) throws ProductLimitException {
        if(produto.getQuantidade() <= comprador.getCarrinho().quantidadeEmCarrinho(produto.getProduct_id()))
            throw new ProductLimitException();
    }
    
    public void adicionarProduto(){
        this.comprador.adicionarProdutoCarrinho(jlistProdutos.getSelectedValue().getProduct_id(), 1);
        this.telaAnterior.salvar();
        JOptionPane.showMessageDialog(null, "Uma unidade do produto adicionado ao carrinho!");
    }
}
