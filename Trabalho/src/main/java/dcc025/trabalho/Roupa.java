package dcc025.trabalho;

import java.util.*;

/**
 *
 * @author joaov
 */
public class Roupa extends Produto {
    private String tipo;
    private String cor;
    private HashMap<String, Integer> quantidadeCor;
    private String tamanho;
    private HashMap<String, Integer> quantidadeTamanho;

    public Roupa(double preco, int quantidade) {
        super(preco, quantidade);
    }
}
