package Programa;

public class PasswordInvalidaException extends Exception{
    public PasswordInvalidaException(String mensaje){
        super(mensaje);
    }
}
