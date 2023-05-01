package dcc025.trabalho;

import java.util.*;
import dcc025.trabalho.ListaQuantidadeCor.Cor;

/**
 *
 * @author joaov
 */
public class Eletrodomestico extends Produto{
    public static enum TipoEletrodomestico{
        GELADEIRA, FOGAO, COMPUTADOR, TV, MAQUINA_DE_LAVAR
    }

    public Eletrodomestico(double preco, int quantidade, Cor cor) {
        super(preco, quantidade, cor);
    }
    
}
