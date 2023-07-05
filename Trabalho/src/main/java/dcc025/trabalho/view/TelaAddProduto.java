package dcc025.trabalho.view;

import dcc025.trabalho.controller.AdicionarProduto;
import dcc025.trabalho.exceptions.InvalidProductException;
import dcc025.trabalho.exceptions.NegativePriceException;
import dcc025.trabalho.exceptions.NegativeQuantityException;
import dcc025.trabalho.model.*;
import dcc025.trabalho.model.Cor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.util.*;
import javax.swing.*;

public class TelaAddProduto extends Tela{
    
    private SubTipoProduto subtipo = SubTipoProduto.N_A; 
    private TiposProdutos tipo = TiposProdutos.ELETRODOMESTICO;
    private Cor qCor = Cor.AMARELO;
    private double preco = 0;
    private int quantidade = 0;
    private static int productId = 1;

    private Produto novoProduto;
    private final String vender_id;
    private final TelaVendedor telaAnterior;
    
    private JComboBox<Cor> cbCor;
    private JComboBox<TiposProdutos> cbTipo;
    private JComboBox<SubTipoProduto> cbSubTipo;
    private ArrayList<JTextField> tf;

    
    public TelaAddProduto(TelaVendedor telaVendedor, String vender_id){
        super.botoes = new ArrayList();
        super.labels = new ArrayList();
        tf = new ArrayList<>();
        telaAnterior = telaVendedor;
        this.vender_id = vender_id;
        productId++;
    }
    
    @Override
    protected JPanel configuraPainelMain(String nome){
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
        JPanel painel = configuraPainelMain("Adicionar Produto");
        
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
        botoes.get(0).addActionListener(new AdicionarProduto(this));
        //Sair
        botoes.get(1).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                fechar();
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
        
        //Adiciona eventListener
        cbCor.addItemListener(new java.awt.event.ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                int selected = cbTipo.getSelectedIndex();
                switch(selected){
                    case 0:
                        qCor = Cor.AMARELO;
                        break;
                    case 1:
                        qCor = Cor.AZUL;
                        break;
                    case 2:
                        qCor = Cor.AZUL_CLARO;
                        break;
                    case 3:
                        qCor = Cor.BRANCO;
                        break;
                    case 4:
                        qCor = Cor.CIANO;
                        break;
                    case 5:
                        qCor = Cor.CINZA;
                        break;
                    case 6:
                        qCor = Cor.LARANJA;
                        break;
                    case 7:
                        qCor = Cor.MAJENTA;
                        break;
                    case 8:
                        qCor = Cor.PRETO;
                        break;
                    case 9:
                        qCor = Cor.ROSA;
                        break;
                    case 10:
                        qCor = Cor.ROXO;
                        break;
                    case 11:
                        qCor = Cor.VERDE;
                        break;
                    case 12:
                        qCor = Cor.VERDE_CLARO;
                        break;
                    case 13:
                        qCor = Cor.VERMELHO;
                        break;
                }
            }
        });
        
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
                        setTipoEletrodomestico();
                        carregaCbEletrodomestico();
                        break;
                    case 1:
                        setTipoEscritorio();
                        carregaCbEscritorio();
                        break;
                    case 2:
                        setTipoMovel();
                        carregaCbMovel();
                        break;
                    case 3:
                        setTipoRoupa();
                        carregaCbRoupa();
                        break;
                    default:
                        tipo = TiposProdutos.N_A;
                        carregaCbNA();
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
    
    public void carregaCbNA(){
        cbSubTipo.removeAllItems();
        
        //Adiciona novos itens
        cbSubTipo.addItem(SubTipoProduto.N_A);
    }

    private void setPreco(double preco){this.preco = preco;}
    
    public Produto getProduto() throws InvalidProductException {
        int selected = cbSubTipo.getSelectedIndex();
        switch(tipo){
            case ELETRODOMESTICO -> {
                switch(selected){
                    case 0 -> subtipo = SubTipoProduto.N_A;
                    case 1 -> setTipoEletrodomesticoGeladeira();
                    case 2 -> setTipoEletrodomesticoFogao();
                    case 3 -> setTipoEletrodomesticoComputador();
                    case 4 -> setTipoEletrodomesticoTV();
                    case 5 -> setTipoEletrodomesticoMaquina();
                }
            }

                
            case MOVEL -> {
                switch(selected){
                    case 0 -> subtipo = SubTipoProduto.N_A;
                    case 1 -> setTipoMovelAssento();
                    case 2 -> setTipoMovelMesa();
                    case 3 -> setTipoMovelEstante();
                    case 4 -> setTipoMovelQuadro();
                    case 5 -> setTipoMovelLuminaria();
                    case 6 -> setTipoMovelArmario();
                    case 7 -> setTipoMovelCama();
                }
            }

            
            case MATERIAL_ESCRITORIO -> {
                switch(selected){
                    case 0 -> subtipo = SubTipoProduto.N_A;
                    case 1 -> setTipoEscritorioCaneta();
                    case 2 -> setTipoEscritorioLapis();
                    case 3 -> setTipoEscritorioBorracha();
                    case 4 -> setTipoEscritorioPapel();
                    case 5 -> setTipoEscritorioClipes();
                }
            }

                
            case ROUPAS -> {
                switch(selected){
                    case 0 -> subtipo = SubTipoProduto.N_A;
                    case 1 -> setTipoRoupaSapato();
                    case 2 -> setTipoRoupaCalca();
                    case 3 -> setTipoRoupaBlusa();
                    case 4 -> setTipoRoupaConjunto();
                    case 5 -> setTipoRoupaAcessorio();
                }
            }

        }
        try {
            String input = tf.get(0).getText();
            preco = Double.parseDouble(input);
            input = tf.get(1).getText();
            quantidade = Integer.parseInt(input);
            return new Produto(preco, quantidade, qCor, tipo, subtipo, vender_id);
       }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Insira valores válidos");
            throw new InvalidProductException();
       } catch (NegativePriceException e) {
            JOptionPane.showMessageDialog(null, "Preço não pode ser 0 ou negativo");
            throw new InvalidProductException();
        } catch (NegativeQuantityException e) {
            JOptionPane.showMessageDialog(null, "Quantidade não pode ser 0 ou negativo");
            throw new InvalidProductException();
        }
    }

    public void adicionarProduto() throws InvalidProductException {
        if(getProduto() != null)
        this.telaAnterior.addProduto(getProduto());

        else throw new InvalidProductException();
    }
    
    public void fechar(){
        tela.dispose();
        telaAnterior.abrir();
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