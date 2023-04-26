package dcc025.trabalho;

/**
 *
 * @author joaov
 */
public abstract class Pessoa {
    private String nome;
    private String login;
    private String senha;
    private static int N_CONTAS;

    public Pessoa(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public static int getN_CONTAS() {
        return N_CONTAS;
    }
    
}
