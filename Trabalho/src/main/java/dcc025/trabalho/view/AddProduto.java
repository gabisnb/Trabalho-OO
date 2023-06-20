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
import java.awt.event.ItemEvent;

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
    
    @Override
    protected JPanel ConfiguraPainelMain(String nome){
        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA-(ALTURA/3)));
        painel.setBorder(BorderFactory.createTitledBorder(nome));
        painel.setLayout(new BorderLayout());
        return painel;
    }
    
    public void desenha(){
        tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setSize(LARGURA, ALTURA-(ALTURA/3));
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        
        desenhaMenu();
        
        tela.pack();
    }
    
    private void desenhaMenu(){
        JPanel painel = ConfiguraPainelMain("Adicionar Produto");
        
        //Cria labels
        labels.add(new JLabel("Tipo: "));
        labels.add(new JLabel("SubTipo: "));
        labels.add(new JLabel("Cor: "));
        labels.add(new JLabel("Preco: "));
        labels.add(new JLabel("Quantidade: "));
        
        //Cria botões
        botoes.add(new JButton("Adicionar"));
        botoes.add(new JButton("Sair"));
        
        //Configuração dos botões
        //Adicionar
        botoes.get(0).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int selected = cbTipo.getSelectedIndex();
                switch(selected){
                    case 0:
                        carregaCbEletrodomestico();
                        break;
                    case 1:
                        setTipoEscritorio();
                        break;
                    case 2:
                        setTipoMovel();
                        break;
                    case 3:
                        setTipoRoupa();
                        break;
                }
                
                selected = cbSubTipo.getSelectedIndex();
                switch(selected){
                    //socorro
                }
                
                String input = tf.get(0).getText();
                preco = Double.parseDouble(input);
                
                input = tf.get(1).getText();
                quantidadeTotal = Integer.parseInt(input);
            }
        });
        //Sair
        botoes.get(1).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                telaAnterior.abrir();
                tela.dispose();
            }
        });
        
        //Cria painel que conterá labels
        JPanel jpLabels = new JPanel();
        jpLabels.setLayout(new GridLayout(5,1, 5, 4));
        for(int i=0; i<5; i++)
            jpLabels.add(labels.get(i));
        
        //Cria painel que conterá combo box e text field
        JPanel jpCBTF = new JPanel();
        jpCBTF.setLayout(new GridLayout(5,1, 0, 5));
        //Adiciona combo box
        jpCBTF.add(desenhaCBTipo());
        jpCBTF.add(desenhaCBSubTipo());
        jpCBTF.add(desenhaCBCor());
        //Adiciona text field
        desenhaTF(2, 20, tf);
        jpCBTF.add(tf.get(0));
        jpCBTF.add(tf.get(1));
        
        //Cria painel que conterá labels, combo box e text field
        JPanel painelAux = new JPanel();
        painelAux.setLayout(new GridLayout(1,2, 5, 2));
        painelAux.add(jpLabels);
        painelAux.add(jpCBTF);
        //Adiciona painel na janela
        painel.add(painelAux, BorderLayout.CENTER);

        //Cria painel que conterá os botões
        JPanel bpainel = new JPanel();
        bpainel.add(desenhaBotoes(botoes));
        
        
        //Adiciona o painel na janela
        painel.add(bpainel, BorderLayout.PAGE_END);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    private JComboBox desenhaCBCor(){
        cbCor = new JComboBox<>();
        
        //Adiciona itens
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
        
        return cbCor;
    }
    
    private JComboBox desenhaCBTipo(){
        cbTipo = new JComboBox();
        
        //Adiciona itens
        cbTipo.addItem(TiposProdutos.ELETRODOMESTICO);
        cbTipo.addItem(TiposProdutos.MATERIAL_ESCRITORIO);
        cbTipo.addItem(TiposProdutos.MOVEL);
        cbTipo.addItem(TiposProdutos.ROUPAS);
        cbTipo.addItem(TiposProdutos.N_A);
        
        //Adiciona eventListener para mudar os itens de cbSubTipo
        cbTipo.addItemListener(new java.awt.event.ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                int selected = cbTipo.getSelectedIndex();
                switch(selected){
                    case 0:
                        carregaCbEletrodomestico();
                        break;
                    case 1:
                        carregaCbEscritorio();
                        break;
                    case 2:
                        carregaCbMovel();
                        break;
                    case 3:
                        carregaCbRoupa();
                        break;
                }
            }
        });
        
        return cbTipo;
    }
    
    private JComboBox desenhaCBSubTipo(){
        cbSubTipo = new JComboBox();
        
        //Adiciona itens default
        carregaCbEletrodomestico();
        
        return cbSubTipo;
    }
    
    private void carregaCbEletrodomestico(){
        cbSubTipo.removeAllItems();
        
        //Adiciona novos itens
        cbSubTipo.addItem(SubTipoProduto.N_A);
        cbSubTipo.addItem(SubTipoProduto.GELADEIRA);
        cbSubTipo.addItem(SubTipoProduto.FOGAO);
        cbSubTipo.addItem(SubTipoProduto.COMPUTADOR);
        cbSubTipo.addItem(SubTipoProduto.TV);
        cbSubTipo.addItem(SubTipoProduto.MAQUINA_DE_LAVAR);
    }
    
    private void carregaCbEscritorio(){
        cbSubTipo.removeAllItems();
        
        //Adiciona novos itens
        cbSubTipo.addItem(SubTipoProduto.N_A);
        cbSubTipo.addItem(SubTipoProduto.CANETA);
        cbSubTipo.addItem(SubTipoProduto.LAPIS);
        cbSubTipo.addItem(SubTipoProduto.BORRACHA);
        cbSubTipo.addItem(SubTipoProduto.PAPEL);
        cbSubTipo.addItem(SubTipoProduto.CLIPES);
    }

    private void carregaCbMovel(){
        cbSubTipo.removeAllItems();
        
        //Adiciona novos itens
        cbSubTipo.addItem(SubTipoProduto.N_A);
        cbSubTipo.addItem(SubTipoProduto.ASSENTO);
        cbSubTipo.addItem(SubTipoProduto.MESA);
        cbSubTipo.addItem(SubTipoProduto.ESTANTE);
        cbSubTipo.addItem(SubTipoProduto.QUADRO);
        cbSubTipo.addItem(SubTipoProduto.LUMINARIA);
        cbSubTipo.addItem(SubTipoProduto.ARMARIO);
        cbSubTipo.addItem(SubTipoProduto.CAMA);
    }
    
    private void carregaCbRoupa(){
        cbSubTipo.removeAllItems();
        
        //Adiciona novos itens
        cbSubTipo.addItem(SubTipoProduto.N_A);
        cbSubTipo.addItem(SubTipoProduto.SAPATO);
        cbSubTipo.addItem(SubTipoProduto.CALCA);
        cbSubTipo.addItem(SubTipoProduto.BLUSA);
        cbSubTipo.addItem(SubTipoProduto.CONJUNTO);
        cbSubTipo.addItem(SubTipoProduto.ACESSORIOS);
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
        try{
            productId++;
            Produto produto = new Produto(preco, quantidadeTotal, qCor, tipo, subtipo, this.vendedor.getId() + "x" + Integer.toString(this.productId));
            this.vendedor.adicionarProduto(produto);
            telaAnterior.addProduto(produto);
        }
        catch(Exception e){
            
        }
        finally{
            this.tela.dispose();
            telaAnterior.abrir();
        }
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