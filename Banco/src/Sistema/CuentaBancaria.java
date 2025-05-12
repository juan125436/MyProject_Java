package Sistema;

public class CuentaBancaria extends Cliente{
    private int nCuenta;
    private int saldo;
    private String clave;
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

    
}
