package dcc025.trabalho;

import java.util.*;

/**
 *
 * @author joaov
 */
public class Eletrodomestico extends Produto{
    private String cor;
    private HashMap<String, Integer> quantidadeCor;

    public Eletrodomestico(double preco, int quantidade) {
        super(preco, quantidade);
    }
    
}
