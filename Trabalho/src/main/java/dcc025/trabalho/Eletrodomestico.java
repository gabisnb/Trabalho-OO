package dcc025.trabalho;

import java.util.*;
import dcc025.trabalho.ListaQuantidadeCor.Cor;

/**
 *
 * @author joaov
 */
public class Eletrodomestico extends Produto{
    
    private TipoEletrodomestico tipo;
    
    public Eletrodomestico(double preco, int quantidade, Cor cor, TipoEletrodomestico tipo) {
        super(preco, quantidade, cor);
        this.tipo = TipoEletrodomestico.N_A;
        for(TipoEletrodomestico aux : TipoEletrodomestico.values())
            if(aux.equals(tipo))
                this.tipo = tipo;
    }
    
}
