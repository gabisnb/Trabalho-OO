package dcc025.trabalho;

import java.util.*;
import dcc025.trabalho.ListaQuantidadeCor.Cor;

public class Eletrodomestico extends Produto{
    
    private TipoEletrodomestico tipo;
    
    public Eletrodomestico(double preco, int quantidade, Cor cor, TipoEletrodomestico tipo) {
        super(preco, quantidade, cor);
        this.tipo = TipoEletrodomestico.N_A;
        for(TipoEletrodomestico aux : TipoEletrodomestico.values())
            if(aux.equals(tipo))
                this.tipo = tipo;
    }
    
    @Override
    public void exibirCatalogo()
    {
        System.out.println("\n\nTipo de Eletrodomestico: " + this.tipo);
        System.out.println("Preco do Produto: " + getPreco());
        System.out.println("Quantidade em Estoque: " + getQuantidade());
        System.out.println("Cores disponiveis: ");
        quantidadeCor.listaCoresQuantidade();
    }
    
    @Override
    public void exibirResumoProduto()
    {
        System.out.println("\n\nEletrodomestico: " + this.tipo + "\nPreco: " + getPreco());
    } 
}
