package dcc025.trabalho;

import java.util.*;
import dcc025.trabalho.ListaQuantidadeCor.Cor;

/**
 *
 * @author joaov
 */
public class Roupa extends Produto {
    public static enum TipoRoupa{
        SAPATO, CALCA, BLUSA, CONJUNTO, ACESSORIOS
    }
    private TipoRoupa tipo;
    
    //Gabriela: não sei como associar quantidade por tamanho com quantidade por cor
    private enum TamanhoRoupa{
        XP, PP, P, M, G, GG, XG, UNICO
    }
    private TamanhoRoupa [] tamanho;
    private HashMap<String, Integer> quantidadeTamanho;

    public Roupa(double preco, int quantidade, TipoRoupa tipo, Cor cor) {
        super(preco, quantidade, cor);
        
        if(tipo==null)
            tipo = TipoRoupa.CONJUNTO;
        this.tipo = tipo;
    }
}
