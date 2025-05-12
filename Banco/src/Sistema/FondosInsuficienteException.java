package Sistema;

public class FondosInsuficienteException extends Exception{
    public FondosInsuficienteException(String mensaje){
        super(mensaje);
    }
    public static void checarFondos(int fondos) throws FondosInsuficienteException{
        if(fondos<=0){
            throw new FondosInsuficienteException("NO TIENE SALDO");
        }
    }
    public static void checarTransferencia(int fondos, int transferencia) throws FondosInsuficienteException{
        if(transferencia>fondos){
            throw new FondosInsuficienteException("NO PUEDE HACER TRANSFERENCIA POR FONDOS INSUFICIENTE");
        }
    }
}
