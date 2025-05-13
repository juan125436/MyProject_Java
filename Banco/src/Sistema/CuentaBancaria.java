package Sistema;
import java.util.*;
public class CuentaBancaria extends Cliente{
    static Scanner datos = new Scanner(System.in);
    private int nCuenta;
    private int saldo;
    private String clave;
    static int id_estatico=0;
    static CuentaBancaria BCI;
    static HashMap<Integer , Cliente> Cuentas_Banco_BCI = new HashMap<>();
    static boolean nuevoUsuario;
    public CuentaBancaria(String nombre, String apellidos,int nCuenta, int saldo,String clave){
        super(nombre, apellidos);
        this.nCuenta=nCuenta;
        this.saldo=saldo;
        this.clave=clave;
    }
    public int nCuenta(){
        return nCuenta;
    }
    public int getSaldo(){
        return saldo;
    }
    public String getClave(){
        return clave;
    }
    public void setSaldo(int saldo){
        this.saldo=saldo;
    }
    public static void iniciarSesion(){
        System.out.println("INICIANDO SESION");
        int id=0;
        String clave="";
        try {
            System.out.print("DIGITE SU ID DE INICIO DE SESION: ");
            id=datos.nextInt();
            IniciarSesionException.errorID(Cuentas_Banco_BCI, id);
            id_estatico=id;
            datos.nextLine();
            System.out.print("DIGITE CLAVE: ");
            clave=datos.nextLine();
            IniciarSesionException.errorClave(id, clave, Cuentas_Banco_BCI);
        } catch(IniciarSesionException e) {
            System.out.println(e.getMessage());
            return;
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
                    return;
                }
                if(opcion.equals("retirar")){
                    try {
                        BCI=(CuentaBancaria) Cuentas_Banco_BCI.get(id_estatico);
                        ErrorException.verificadorSaldo(BCI);
                    } catch (ErrorException e){
                        System.exit(0);
                    }
                    Main.retirar();
                } else if(opcion.equals("depositar")){
                    BCI = (CuentaBancaria) Cuentas_Banco_BCI.get(id_estatico);
                    Main.transferencia();
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
                return;
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
            nCuenta++;
            nuevoUsuario=false;
            id_Cuenta++;
            System.out.println("=======================================================================");
            System.out.println("SE HA CREADO UNA CUENTA, PARA INICIAR SESION DEBERA USAR SIEMPRE SU ID"
            +"\nSU NUMERO DE ID ES "+id_Cuenta);
            System.out.println("=======================================================================");
            Cuentas_Banco_BCI.put(id_Cuenta,BCI);
            
        }
    } 
}
