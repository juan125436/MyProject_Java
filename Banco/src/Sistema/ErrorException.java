package Sistema;

public class ErrorException extends Exception{
    public ErrorException(String mensaje){
        super(mensaje);
    }
    public static void errorINICIO(String opcion) throws ErrorException{
        if(!opcion.equals("iniciar sesion") && !opcion.equals("registrarse")){
            throw new ErrorException("ERROR");
        }
    }
    public static void errorMenu(String opcion) throws ErrorException{ 
        if(!opcion.equals("retirar") && !opcion.equals("depositar")){
            throw new ErrorException("ERROR");
        }
    }
}
