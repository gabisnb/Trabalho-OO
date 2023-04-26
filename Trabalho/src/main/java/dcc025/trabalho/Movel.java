package dcc025.trabalho;

import java.util.*;

/**
 *
 * @author joaov
 */
public class Movel extends Produto{
    private String cor;
    private HashMap<String, Integer> quantidadeCor;

    public Movel(double preco, int quantidade) {
        super(preco, quantidade);
    }
    
}
