package Sistema;
import java.util.*;
public class Main {
    static Scanner datos = new Scanner(System.in);
    static CuentaBancaria BCI;
    static ArrayList<Cliente> juan = new ArrayList<>();
    static boolean nuevoUsuario=true;
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
    public static void main(String[] args) {
        String opcion="";
        crearCuenta();
        System.out.println("Transferencia \nRetirar");
        System.out.println("Escriba su opcion: ");
        opcion=datos.nextLine().toLowerCase();
        if(opcion.equals("transferencia")){
            transferencia();
        }
    }
    public static void crearCuenta(){
        System.out.println("Bienvenido/a al Banco BCI");
        int nCuenta=1;
        while(nuevoUsuario){
            String nombre="",apellidos="",clave="";
            System.out.println("Ha continuacion va a crear una Cuenta Bancaria");
            try {
                System.out.print("Digite su PRIMER nombre: ");
                nombre=datos.nextLine();
                checarNombre(nombre);
                System.out.print("Digite sus apellidos: ");
                apellidos = datos.nextLine().replaceAll("\\s+", "");
                checarNombre(apellidos);
            } catch (CrearCuentaException e){
                System.out.println(e.getMessage());
                break;
            }
            try{
                System.out.print("Digite clave: ");
                clave = datos.nextLine();
                checarContraseña(clave);
            } catch(CrearCuentaException e){
                System.out.println(e.getMessage());
                break;
            } 
            BCI = new CuentaBancaria(nombre, apellidos, nCuenta, 10000, clave);
            juan.add(BCI);
            nuevoUsuario=false;
        }
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
    
    public static void transferencia(){
        while(true){
            int transferencia=0;
            System.out.println("Tu saldo es "+BCI.getSaldo());
            System.out.println("Ha continuacion va a hacer una transferencia");
            try {
                System.out.println("Digite monto a depositar");
                transferencia = datos.nextInt();
                checarTransferencia(BCI.getSaldo(), transferencia);
            } catch (FondosInsuficienteException e){
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println("=================================");
            System.out.println("SE HA REALIZADO SU TRANSFERENCIA");
            System.out.println("=================================");
            BCI.setSaldo(BCI.getSaldo()-transferencia);
            return;
        }
    }
}
