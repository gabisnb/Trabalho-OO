package dcc025.trabalho;

import java.util.*;
import dcc025.trabalho.ListaQuantidadeCor.Cor;

/**
 *
 * @author joaov
 */
public class Movel extends Produto{
    public static enum TipoMovel{
        ASSENTO, MESA, ESTANTE, QUADRO, LUMINARIA, ARMARIO, CAMA
    }
    
    public Movel(double preco, int quantidade, Cor cor) {
        super(preco, quantidade, cor);
    }
    
}
