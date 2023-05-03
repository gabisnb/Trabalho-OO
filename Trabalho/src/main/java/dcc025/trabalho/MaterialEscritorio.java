package dcc025.trabalho;

import dcc025.trabalho.ListaQuantidadeCor.Cor;

/**
 *
 * @author joaov
 */
public class MaterialEscritorio extends Produto{
    private TipoMatEscritorio tipo;

    public MaterialEscritorio(double preco, int quantidade, Cor cor, TipoMatEscritorio tipo) {
        super(preco, quantidade, cor);
        this.tipo = TipoMatEscritorio.N_A;
        for(TipoMatEscritorio aux : TipoMatEscritorio.values())
            if(aux.equals(tipo))
                this.tipo = tipo;
    }
    
}
