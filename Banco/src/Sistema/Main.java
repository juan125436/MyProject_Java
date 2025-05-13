package Sistema;
import java.util.*;
public class Main {
    static Scanner datos = new Scanner(System.in);

    static boolean nuevoUsuario;
    public static void main(String[] args) {
        String opcion="";
       while(true){
            try {
                System.out.print("Bienvenido al banco BCI\nIniciar Sesion\nRegistrarse\nEscriba: ");
                opcion=datos.nextLine().toLowerCase();
                ErrorException.errorINICIO(opcion);
            } catch (ErrorException e){
                System.out.println(e.getMessage());
                return;
            }
            registrarORiniciar(opcion);
            if(nuevoUsuario) {
                CuentaBancaria.crearCuenta();
            } else {
                CuentaBancaria.iniciarSesion();
                CuentaBancaria.menu();
                return;
            }
       }
    }
    public static void registrarORiniciar(String opcion){
        if(opcion.equals("iniciar sesion")){
            nuevoUsuario=false;
        } else if(opcion.equals("registrarse")){
            nuevoUsuario=true;
        }
    }
      
    
     public static void transferencia(){
        while(true){
            int transferencia=0;
            System.out.println("Tu saldo es "+CuentaBancaria.BCI.getSaldo());
            System.out.println("Ha continuacion va a hacer un DEPOSITO");
            try {
                System.out.println("Digite monto a depositar");
                transferencia = datos.nextInt();
                FondosInsuficienteException.checarTransferencia(CuentaBancaria.BCI.getSaldo(), transferencia);
            } catch (FondosInsuficienteException e){
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println("=================================");
            System.out.println("SE HA REALIZADO SU DEPOSITO");
            System.out.println("=================================");
            CuentaBancaria.BCI.setSaldo(CuentaBancaria.BCI.getSaldo()+transferencia);
            return;
        }
    }
    public static void retirar(){
        int cifra=0;
        while(true){
            System.out.println("Hola soy tu cajero MACH\n*MAXIMO 100000 y minimo 1000*");
            try {
                System.out.print("DIGITE CIFRA:");
                cifra=datos.nextInt();
                ErrorException.errorCifra(cifra);
            } catch(ErrorException e){
                System.out.println(e.getMessage());
                continue;
            }
            CuentaBancaria.BCI.setSaldo(CuentaBancaria.BCI.getSaldo()-cifra);
            System.out.println("======================================");
            System.out.println("PERFECTO, HIZO SU RETIRO CON EXITO :3");
            System.out.println("======================================");
        }
    }
}
