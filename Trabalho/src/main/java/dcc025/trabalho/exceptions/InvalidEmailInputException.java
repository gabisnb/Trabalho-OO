package dcc025.trabalho.exceptions;

public class InvalidEmailInputException extends Exception {
    public InvalidEmailInputException(){
        super("ERRO: Email invalido inserido");
    }
}
