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
    
    private JTextField tfPreco;
    private JSlider jsQuantidadeCor;
    private JComboBox<Cor> cbCor;
    
    public AddProduto(){
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
        JPanel painel = ConfiguraPainelMain("Adicionar Produto");
        
        labels.add(new JLabel("Preco: "));
        labels.add(new JLabel("Tipo: "));
        labels.add(new JLabel("SubTipo: "));
        
        //Botão Adicionar
        botoes.add(new JButton("Adicionar"));
        
        JComboBox<TiposProdutos> cbTipo = new JComboBox();
        JComboBox<SubTipoProduto> cbSubTipo = new JComboBox();
        
        cbTipo.addItem(TiposProdutos.ELETRODOMESTICO);
        cbTipo.addItem(TiposProdutos.MATERIAL_ESCRITORIO);
        cbTipo.addItem(TiposProdutos.MOVEL);
        cbTipo.addItem(TiposProdutos.ROUPAS);
        cbTipo.addItem(TiposProdutos.N_A);
        
        JPanel panel = desenhaTF();
        panel.add(cbTipo);
        panel.add(cbSubTipo);
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(panel);
//        painelAux.add(desenhaRadio());
        painelAux.add(desenhaBotoes(botoes));
        painel.add(painelAux, BorderLayout.CENTER);

        JPanel bpainel = new JPanel();
        
        //Botão Sair
        bpainel.add(new JButton("Sair"));
        painel.add(bpainel, BorderLayout.PAGE_END);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    private JPanel desenhaTF(){
        JPanel painelTF = new JPanel();
        painelTF.setLayout(new GridLayout(0,1, 5, 4));
        
        tfPreco = new JTextField(20);
        
        painelTF.add(tfPreco);

        return painelTF;
    }
    
//    private JPanel desenhaRadio(){
//
//        JPanel painel = new JPanel();
//        painel.setBorder(BorderFactory.createTitledBorder("Cor"));
//        painel.setPreferredSize(new Dimension(LARGURA, ALTURA/3));
//        painel.setLayout(new BorderLayout());
//
//        bgCor = new ButtonGroup();
//        
//        JRadioButton amarelo = new JRadioButton("Amarelo");
//        JRadioButton azul = new JRadioButton("Azul");
//        JRadioButton branco = new JRadioButton("Branco");
//        JRadioButton cinza = new JRadioButton("Cinza");
//        JRadioButton laranja = new JRadioButton("Laranja");
//        JRadioButton preto = new JRadioButton("Preto");
//        JRadioButton rosa = new JRadioButton("Rosa");
//        JRadioButton verde = new JRadioButton("Verde");
//        JRadioButton vermelho = new JRadioButton("Vermelho");
//        
//        
//        bgCor.add(amarelo);
//        bgCor.add(azul);
//        bgCor.add(branco);
//        bgCor.add(cinza);
//        bgCor.add(laranja);
//        bgCor.add(preto);
//        bgCor.add(rosa);
//        bgCor.add(verde);
//        bgCor.add(vermelho);
//        
//        painel.add(amarelo).setBounds(30, 30, 60, 50);
//        painel.add(azul);
//        painel.add(branco);
//        painel.add(cinza);
//        painel.add(laranja);
//        painel.add(preto);
//        painel.add(rosa);
//        painel.add(verde);
//        painel.add(vermelho);
//        
////        amarelo.setBounds(120, 30, 120, 50);
////        azul.setBounds(120, 60, 120, 80);
////        azulClaro.setBounds(120, 30, 120, 50);
////        tela.add(amarelo);
////        tela.add(azul);
////        tela.add(azulClaro);
////        tela.add(branco);
////        tela.add(ciano);
////        tela.add(cinza);
////        tela.add(laranja);
////        tela.add(majenta);
////        tela.add(preto);
////        tela.add(rosa);
////        tela.add(roxo);
////        tela.add(verde);
////        tela.add(verdeClaro);
////        tela.add(vermelho);
//        
////        for(int i = 0; i < 14; i++)
////            painel.add(bgCor, BorderLayout.EAST);
//
//        return painel;
//    }
//    
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