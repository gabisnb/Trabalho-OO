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
    
}
