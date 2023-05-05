package dcc025.trabalho;

import java.util.*;
import dcc025.trabalho.ListaQuantidadeCor.Cor;

/**
 *
 * @author joaov
 */
public class Movel extends Produto{
    
    private TipoMovel tipo;
    
    public Movel(double preco, int quantidade, Cor cor, TipoMovel tipo) {
        super(preco, quantidade, cor);
        this.tipo = TipoMovel.N_A;
        for(TipoMovel aux : TipoMovel.values())
            if(aux.equals(tipo))
                this.tipo = tipo;
        }
    
    @Override
    public void exibirCatalogo()
    {
        System.out.println("Tipo de Movel: " + this.tipo);
        System.out.println("Preco do Produto: " + getPreco());
        System.out.println("Quantidade em Estoque: " + getQuantidade());
        System.out.println("Cores disponiveis: ");
        quantidadeCor.listaCoresQuantidade();
    }
    
    @Override
    public void exibirResumoProduto()
    {
        System.out.println("Movel: " + this.tipo + "Preco: " + getPreco());
    }
    
}
