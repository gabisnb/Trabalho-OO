package dcc025.trabalho;

import dcc025.trabalho.ListaQuantidadeCor.Cor;

/**
 *
 * @author joaov
 */
public class MaterialEscritorio extends Produto{
    public static enum TipoMaterialEscritorio{
        CANETA, LAPIS, BORRACHA, PAPEL, CLIPES
    }

    public MaterialEscritorio(double preco, int quantidade, Cor cor) {
        super(preco, quantidade, cor);
    }
    
}
