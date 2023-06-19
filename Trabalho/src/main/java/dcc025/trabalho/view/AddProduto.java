package dcc025.trabalho.view;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

import dcc025.trabalho.Usuario.Vendedor;
import dcc025.trabalho.model.*;
import dcc025.trabalho.model.ListaQuantidadeCor.Cor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

public class AddProduto extends Tela{
    
    private SubTipoProduto subtipo; 
    private TiposProdutos tipo;
    private Map<Cor, Integer> qCor = new HashMap<>();
    private double preco = 0;
    private int quantidadeTotal = 0;
    private static int productId = 1;
    
    private Vendedor vendedor;
    private TelaVendedor telaAnterior;
    
    private JComboBox<Cor> cbCor;
    private JComboBox<TiposProdutos> cbTipo;
    private JComboBox<SubTipoProduto> cbSubTipo;
    private ArrayList<JTextField> tf;
    
    public AddProduto(TelaVendedor telaVendedor, Vendedor vend){
        super.botoes = new ArrayList();
        super.labels = new ArrayList();
        tf = new ArrayList<>();
        telaAnterior = telaVendedor;
        vendedor = vend;
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
        JPanel painel = ConfiguraPainelMain("Adicionar Produto");
        
        labels.add(new JLabel("Tipo: "));
        labels.add(new JLabel("SubTipo: "));
        labels.add(new JLabel("Cor: "));
        labels.add(new JLabel("Preco: "));
        labels.add(new JLabel("Quantidade: "));
        
        botoes.add(new JButton("Adicionar"));
        botoes.add(new JButton("Sair"));
        botoes.get(1).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                telaAnterior.abrir();
                tela.dispose();
            }
        });
        
        cbTipo = new JComboBox();
        cbSubTipo = new JComboBox();
        
        cbTipo.addItem(TiposProdutos.ELETRODOMESTICO);
        cbTipo.addItem(TiposProdutos.MATERIAL_ESCRITORIO);
        cbTipo.addItem(TiposProdutos.MOVEL);
        cbTipo.addItem(TiposProdutos.ROUPAS);
        cbTipo.addItem(TiposProdutos.N_A);
        
        JPanel panel = new JPanel();
        panel.add(cbTipo);
        panel.add(cbSubTipo);
        panel.add(desenhaCB());
        panel.add(desenhaTF(2, 20, tf));
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(panel);
        painel.add(painelAux, BorderLayout.CENTER);

        JPanel bpainel = new JPanel();
        
        //Botões Adicionar e Sair
        bpainel.add(desenhaBotoes(botoes));
        painel.add(bpainel, BorderLayout.PAGE_END);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    private JPanel desenhaCB(){
        JPanel painelCB = new JPanel();
        painelCB.setLayout(new GridLayout(0,1, 5, 4));
        
        cbCor = new JComboBox<>();
        cbCor.addItem(Cor.AMARELO);
        cbCor.addItem(Cor.AZUL);
        cbCor.addItem(Cor.AZUL_CLARO);
        cbCor.addItem(Cor.BRANCO);
        cbCor.addItem(Cor.CIANO);
        cbCor.addItem(Cor.CINZA);
        cbCor.addItem(Cor.LARANJA);
        cbCor.addItem(Cor.MAJENTA);
        cbCor.addItem(Cor.PRETO);
        cbCor.addItem(Cor.ROSA);
        cbCor.addItem(Cor.ROXO);
        cbCor.addItem(Cor.VERDE);
        cbCor.addItem(Cor.VERDE_CLARO);
        cbCor.addItem(Cor.VERMELHO);
        
        painelCB.add(cbCor);
        
        return painelCB;
    }

    public AddProduto(Vendedor vendedor){
        this.vendedor = vendedor;
        this.productId++;
    }

    private void setPreco(double preco){this.preco = preco;}
    
    private void addCor(Cor cor, int quantidade){ qCor.put(cor, quantidade);}

    
    private void getQuantidadeTotal()
    {
        for(Cor aux : Cor.values()){
            quantidadeTotal += qCor.get(aux);
        }
    }
    
    private void adicionaProduto(){
        Produto produto = new Produto(preco, quantidadeTotal, qCor, tipo, subtipo, this.vendedor.getId() + "x" + Integer.toString(this.productId));
        this.vendedor.adicionarProduto(produto);
    }

/////////////////////// - Sets para Tipo de Produto /////////////////////////////////////////////////
    private void setTipoRoupa(){tipo = TiposProdutos.ROUPAS;}
    private void setTipoMovel(){tipo = TiposProdutos.MOVEL;}
    private void setTipoEletrodomestico(){tipo = TiposProdutos.ELETRODOMESTICO;}
    private void setTipoEscritorio(){tipo = TiposProdutos.MATERIAL_ESCRITORIO;}
    /////////////////////// - Sets para Roupa //////////////////////////////////////////////////////
    private void setTipoRoupaSapato(){subtipo = SubTipoProduto.SAPATO;}
    private void setTipoRoupaCalca(){subtipo = SubTipoProduto.CALCA;}
    private void setTipoRoupaBlusa(){subtipo = SubTipoProduto.BLUSA;}
    private void setTipoRoupaConjunto(){subtipo = SubTipoProduto.CONJUNTO;}
    private void setTipoRoupaAcessorio(){subtipo = SubTipoProduto.ACESSORIOS;}
/////////////////////// - Sets para Móvel /////////////////////////////////////////////////////////
    private void setTipoMovelArmario(){subtipo = SubTipoProduto.ARMARIO ;}
    private void setTipoMovelAssento(){subtipo = SubTipoProduto.ASSENTO ;}
    private void setTipoMovelCama(){subtipo = SubTipoProduto.CAMA ;}
    private void setTipoMovelEstante(){subtipo = SubTipoProduto.ESTANTE ;}
    private void setTipoMovelLuminaria(){subtipo = SubTipoProduto.LUMINARIA ;}
    private void setTipoMovelMesa(){subtipo = SubTipoProduto.MESA ;}
    private void setTipoMovelQuadro(){subtipo = SubTipoProduto.QUADRO ;}
/////////////////// - Sets para Eletrodoméstico ///////////////////////////////////////////////////
    private void setTipoEletrodomesticoComputador(){subtipo = SubTipoProduto.COMPUTADOR ;}
    private void setTipoEletrodomesticoFogao(){subtipo = SubTipoProduto.FOGAO ;}
    private void setTipoEletrodomesticoGeladeira(){subtipo = SubTipoProduto.GELADEIRA ;}
    private void setTipoEletrodomesticoMaquina(){subtipo = SubTipoProduto.MAQUINA_DE_LAVAR ;}
    private void setTipoEletrodomesticoTV(){subtipo = SubTipoProduto.TV ;}
//////////////// - Sets para Material de Escritorio ///////////////////////////////////////////////
    private void setTipoEscritorioBorracha(){subtipo = SubTipoProduto.BORRACHA ;}
    private void setTipoEscritorioCaneta(){subtipo = SubTipoProduto.CANETA ;}
    private void setTipoEscritorioClipes(){subtipo = SubTipoProduto.CLIPES ;}
    private void setTipoEscritorioLapis(){subtipo = SubTipoProduto.LAPIS ;}
    private void setTipoEscritorioPapel(){subtipo = SubTipoProduto.PAPEL ;}


}