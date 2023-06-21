package dcc025.trabalho.controller;

import dcc025.trabalho.model.ListaQuantidadeCor;
import dcc025.trabalho.model.Produto;
import dcc025.trabalho.view.AddProduto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dcc025.trabalho.view.TelaVendedor;
import java.util.HashMap;
import java.util.Map;

public class AdicionarProduto implements ActionListener{
    
    private final TelaVendedor telaVend;
    private final AddProduto telaAdd;
    
    public AdicionarProduto(TelaVendedor telaVend, AddProduto telaAdd){
        this.telaVend = telaVend;
        this.telaAdd = telaAdd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        telaVend.addProduto(telaAdd.getProduto());
        telaAdd.fechar();
    }
    
//    private void adicionaProduto(){
//        try{
//            productId++;
//            Map<ListaQuantidadeCor.Cor, Integer> cor = new HashMap<>();
//            cor.put(qCor, quantidade);
//            Produto produto = new Produto(preco, quantidade, cor, tipo, subtipo, this.vendedor.getId() + "x" + Integer.toString(this.productId));
//            this.vendedor.adicionarProduto(produto);
//            telaAnterior.addProduto(produto);
//        }
//        catch(Exception e){
//            
//        }
//        finally{
//            this.tela.dispose();
//            telaAnterior.abrir();
//        }
//    }
       
}
