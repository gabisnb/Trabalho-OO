package dcc025.trabalho.exceptions;

public class EmailNotFoundException extends Exception {
    public EmailNotFoundException(){
        super("ERRO: Email NAO encontrado");
    }
}
