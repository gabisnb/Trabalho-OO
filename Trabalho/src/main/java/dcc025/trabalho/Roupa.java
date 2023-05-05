package dcc025.trabalho;

import java.util.*;
import dcc025.trabalho.ListaQuantidadeCor.Cor;

/**
 *
 * @author joaov
 */
public class Roupa extends Produto{
    
    private TipoRoupa tipo;

    public Roupa(double preco, int quantidade, Cor cor, TipoRoupa tipo) {
        super(preco, quantidade, cor);
        
        this.tipo = TipoRoupa.N_A;
        for(TipoRoupa aux : TipoRoupa.values())
            if(aux.equals(tipo))
                this.tipo = tipo;
        this.tipo = tipo;
        
    }
    public TipoRoupa getTipo(){
       return tipo; 
    }
    @Override
    public void exibirCatalogo()
    {
        System.out.println("Tipo de Roupa: " + this.tipo);
        System.out.println("Preco do Produto: " + getPreco());
        System.out.println("Quantidade em Estoque: " + getQuantidade());
        System.out.println("Cores disponiveis: ");
        quantidadeCor.listaCoresQuantidade();
    }
     @Override
    public void exibirResumoProduto()
    {
        System.out.println("Roupa: " + this.tipo + "Preco: " + getPreco());
    }
}
