package dcc025.trabalho.model;

import java.util.*;

public class ListaQuantidadeCor {
    public static enum Cor{
        ROSA, VERMELHO, LARANJA, AMARELO, VERDE_CLARO, VERDE, CIANO, AZUL_CLARO, AZUL,
        ROXO, MAJENTA, PRETO, CINZA, BRANCO
    }
    protected Map<Cor,Integer> quantidade;
    
    public ListaQuantidadeCor(){
        this.quantidade = new HashMap<>();
        for(Cor aux : Cor.values())
            quantidade.put(aux, 0);
    }
    
    public int getQuantidade(Cor cor){
        for(Cor aux : Cor.values())
            if(cor==aux)
                return this.quantidade.get(cor);
        return 0;
    }
    
    public void setQuantidade(int quantidade, Cor cor){
        this.quantidade.put(cor, quantidade);
    }
    
    public void listaCoresQuantidade(){
        for(Map.Entry<Cor,Integer> aux : quantidade.entrySet())
        {
            if(aux.getValue()!=0)
                System.out.println(aux.getKey() + ": " + aux.getValue() + " em estoque");
        }
    }
}
