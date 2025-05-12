package Sistema;

public class CrearCuentaException extends Exception{
    public CrearCuentaException(String mensaje){
        super(mensaje);
    }
    public static void checarNombre(String nombreORapellido) throws CrearCuentaException{
        boolean digito=false,especial=false;
        for(int i=0;i<nombreORapellido.length();i++){
            char caracter=nombreORapellido.charAt(i);
            if(Character.isDigit(caracter)){
                digito=true;
            }
            if(!Character.isLetterOrDigit(caracter)){
                especial=true;
            }
        }
        if(especial || digito){
            throw new CrearCuentaException("EL NOMBRE O APELLIDOS TIENE DIGITOS O CARACTERES ESPECIALES...");
        }
    }
    public static void checarContraseña(String clave) throws CrearCuentaException{
        boolean letra=false,especial=false;
        if(clave.length()!=4){
            throw new CrearCuentaException("La clave NO TIENE 4 DIGITOS");
        }
        for(int i=0;i<clave.length();i++){
            char caracter = clave.charAt(i);
            if(Character.isLetter(caracter)){
                letra=true;
            }
            if(!Character.isLetterOrDigit(caracter)){
                especial=true;
            }
        }
        if(letra || especial){
            throw new CrearCuentaException("La clave tiene letras o caracteres especiales....");
        }
    }
}

