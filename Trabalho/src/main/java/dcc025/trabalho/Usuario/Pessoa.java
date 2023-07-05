package dcc025.trabalho.Usuario;

public abstract class Pessoa {
    private String nome;
    private String email;
    private String senha;
    private double saldo;

    public Pessoa(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
