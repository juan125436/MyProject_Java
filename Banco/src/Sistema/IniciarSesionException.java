package Sistema;

import java.util.HashMap;

public class IniciarSesionException extends Exception{
    public IniciarSesionException(String mensaje){
        super("ERROR DE INICIO DE SESION");
    }

    public static void errorID(HashMap<Integer,Cliente> cuenta,int id_entrada) throws IniciarSesionException{
        if(!cuenta.containsKey(id_entrada)) {
            throw new IniciarSesionException("ERROR:ID NO ENCONTRADA...");
        } else {

        }
    }
    public static void errorClave(int id, String clave, HashMap<Integer, Cliente> contraseñas) throws IniciarSesionException {
    Cliente cliente = contraseñas.get(id);  // obtener por ID

    if (cliente instanceof CuentaBancaria) {
        CuentaBancaria cuenta = (CuentaBancaria) cliente;

        if (!clave.equals(cuenta.getClave())) {
            throw new IniciarSesionException("CLAVE INCORRECTA");
        }

    } 
 }
}
