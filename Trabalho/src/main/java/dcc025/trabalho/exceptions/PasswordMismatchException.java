package dcc025.trabalho.exceptions;

public class PasswordMismatchException extends Exception {
    public PasswordMismatchException(){
        super("ERRO: Senha Incorreta");
    }
}
