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
    public static void errorCifra(int cifra) throws ErrorException{
        CuentaBancaria.BCI=(CuentaBancaria) CuentaBancaria.Cuentas_Banco_BCI.get(CuentaBancaria.id_estatico);
        if((cifra>100000 && cifra<1000) || (cifra>CuentaBancaria.BCI.getSaldo())) {
            throw new ErrorException("EL CAJERO ENCONTRO UN ERROR DE CIFRA O SUELDO INFERIOR..");
        }
    }
    public static void verificadorSaldo(CuentaBancaria BCI) throws ErrorException{
        CuentaBancaria.BCI=(CuentaBancaria) CuentaBancaria.Cuentas_Banco_BCI.get(CuentaBancaria.id_estatico);
        if(CuentaBancaria.BCI.getSaldo()<1000){
            throw new ErrorException("NO PUEDES ACCEDER A ESTA OPCION\nSALDO INSUFICIENTE");
        }
    }
}
