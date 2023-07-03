package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.*;
import dcc025.trabalho.model.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class TelaCarrinho extends Tela{
    
    private Comprador usuario;
    
    private TelaComprador telaComp;
    
    private JList<Produto> jlistProdutos;

    protected TelaCarrinho(Comprador comp, TelaComprador tela) {
        usuario = comp;
        telaComp = tela;
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
        try{
            carregaCarrinhoBanco(usuario.getProdutos());
        }
        catch(NullPointerException e){System.out.println("Carrinho vazio!");}
        
        tela.pack();
    }
    
    private void desenhaMenu(){
        JPanel painel = configuraPainelMain("Carrinho de Compras");
        
        labels.add(new JLabel("Nome: " + usuario.getNome()));
        labels.add(new JLabel("Email: " + usuario.getEmail()));
        labels.add(new JLabel("Saldo: " + df.format(usuario.getSaldo())));
        labels.add(new JLabel("Valor Total: " + df.format(usuario.getCarrinho().getTotalPagar())));
                
        //Botão Comprar
        botoes.add(new JButton("Comprar"));
        botoes.get(0).addActionListener((java.awt.event.ActionEvent e) -> {
            abrirPagamento();
        });
        
        //Botão Voltar
        botoes.add(new JButton("Remover do Carrinho"));
        botoes.get(1).addActionListener((java.awt.event.ActionEvent e) -> {
            try{
                usuario.removeProdutoCarrinho(jlistProdutos.getSelectedValue().getProduct_id(), 1);
            }
            catch(NullPointerException e1){
                JOptionPane.showMessageDialog(null, "Selecione o produto que deseja remover!");
            }
            carregaCarrinhoBanco(usuario.getProdutos());
            telaComp.salvar();
        });
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaLista("Produtos no Carrinho"));
        painelAux.add(desenhaBotoes(botoes));
        painel.add(painelAux, BorderLayout.CENTER);

        //Botão Voltar
        botoes.add(new JButton("Voltar"));
        botoes.get(2).addActionListener((java.awt.event.ActionEvent e) -> {
            tela.dispose();
            telaComp.abrir();
        });
        
        JPanel bpainel = new JPanel();
        bpainel.add(botoes.get(2));
        painel.add(bpainel, BorderLayout.PAGE_END);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    @Override
    protected JPanel desenhaLista(String string){

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder(string));
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA/3));
        painel.setLayout(new BorderLayout());

        DefaultListModel<Produto> model = new DefaultListModel<>();

        jlistProdutos = new JList<>(model);

        painel.add(new JScrollPane(jlistProdutos), BorderLayout.CENTER);
        return painel;
    }
    
    protected void abrirPagamento(){
        if(this.usuario.getCarrinho().isEmpty()){
            JOptionPane.showMessageDialog(null, "Carrinho vazio!");
            return;
        }
        TelaPagamento telaPaga = new TelaPagamento(usuario, this);
        telaPaga.desenha();
        tela.setVisible(false);
    }
    
    public void carregaCarrinhoBanco(java.util.List<Produto> carrinho){
        DefaultListModel<Produto> model = (DefaultListModel<Produto>)jlistProdutos.getModel();
        model.clear();
        for (Produto c: carrinho) {
            model.addElement(c);
        }
        labels.get(3).setText("Valor Total: " + df.format(usuario.getCarrinho().getTotalPagar()));
    }
    
    protected void abrir(){
        tela.setVisible(true);
        carregaCarrinhoBanco(usuario.getProdutos());
        telaComp.salvar();
    }
    
    public void recarregaSaldo(){
        labels.get(2).setText("Saldo: " + df.format(usuario.getSaldo()));
        telaComp.carrega();
    }
}
