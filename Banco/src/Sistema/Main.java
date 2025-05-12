package Sistema;
import java.util.*;
public class Main {
    static Scanner datos = new Scanner(System.in);
    static CuentaBancaria BCI;
    static HashMap<Integer , Cliente> Cuentas_Banco_BCI = new HashMap<>();
    static boolean nuevoUsuario;

    
    public static void main(String[] args) {
        String opcion="";
       while(true){
            try {
                System.out.print("Bienvenido al banco BCI\nIniciar Sesion\nRegistrarse\nEscriba: ");
                opcion=datos.nextLine().toLowerCase();
                ErrorException.errorINICIO(opcion);
            } catch (ErrorException e){
                System.out.println(e.getMessage());return;
            }
            registrarORiniciar(opcion);
            if(nuevoUsuario) {
                crearCuenta();
            } else {
                iniciarSesion();
                menu();
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
    public static void crearCuenta(){
        System.out.println("Bienvenido/a al Banco BCI");
        int nCuenta=1;
        int id_Cuenta=1;
        while(nuevoUsuario){
            String nombre="",apellidos="",clave="";
            System.out.println("Ha continuacion va a crear una Cuenta Bancaria");
            try {
                System.out.print("Digite su PRIMER nombre: ");
                nombre=datos.nextLine();
                CrearCuentaException.checarNombre(nombre);
                System.out.print("Digite sus apellidos: ");
                apellidos = datos.nextLine().replaceAll("\\s+", "");
                CrearCuentaException.checarNombre(apellidos);
            } catch (CrearCuentaException e){
                System.out.println(e.getMessage());
                break;
            }
            try{
                System.out.print("Digite clave: ");
                clave = datos.nextLine();
                CrearCuentaException.checarContraseña(clave);
            } catch(CrearCuentaException e){
                System.out.println(e.getMessage());
                return;
            } 
            BCI = new CuentaBancaria(nombre, apellidos, nCuenta, 10000, clave);
            System.out.println("=======================================================================");
            System.out.println("SE HA CREADO UNA CUENTA, PARA INICIAR SESION DEBERA USAR SIEMPRE SU ID"
            +"\nSU NUMERO DE ID ES "+id_Cuenta);
            System.out.println("=======================================================================");
            Cuentas_Banco_BCI.put(id_Cuenta,BCI);
            id_Cuenta++;
            nCuenta++;
            nuevoUsuario=false;
        }
    }   
    public static void iniciarSesion(){
        System.out.println("INICIANDO SESION");
        int id=0;
        String clave="";
        try {
            System.out.print("DIGITE SU ID DE INICIO DE SESION: ");
            id=datos.nextInt();
            IniciarSesionException.errorID(Cuentas_Banco_BCI, id);
            datos.nextLine();
            System.out.print("DIGITE CLAVE: ");
            clave=datos.nextLine();
            IniciarSesionException.errorClave(id, clave, Cuentas_Banco_BCI);
        } catch(IniciarSesionException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("============================");
        System.out.println("BIENVENIDO/A A SU CUENTA BCI");
        System.out.println("============================");
    }
    public static void menu(){
        System.out.println("HA CONTINUACION PUEDE HACER 2 ACCIONES\nRETIRAR\nDEPOSITAR");
        String opcion="";
        while(true){
            try{
                System.out.println("ELIJA: ");
                opcion=datos.nextLine().toLowerCase();
                 ErrorException.errorMenu(opcion);
                } catch (ErrorException e){
                    System.out.println(e.getMessage());
                }
                if(opcion.equals("retirar")){
                } else if(opcion.equals("depositar")){
                    transferencia();
                }
                System.out.println("Otro movimiento? s/n");
                opcion=datos.nextLine();
                while(!opcion.equals("s") && !opcion.equals("n")){
                    System.out.println("DIGITE BIEN: ");
                    opcion=datos.nextLine();
                }
                if(opcion.equals("s")){
                    continue;
                } else if (opcion.equals("n")) {
                    return;
                }
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
                FondosInsuficienteException.checarTransferencia(BCI.getSaldo(), transferencia);
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
