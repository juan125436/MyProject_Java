package programa;

import javax.management.MBeanException;

public class MenuExcepcion extends Exception{
    public MenuExcepcion(String mensaje){
        super(mensaje);
    }
    public static void errorCurso(char curso) throws MenuExcepcion{
        if(curso!='A' && curso!='B' && curso!='C' && curso!='D' ){
            throw new MenuExcepcion("Error, Curso INEXISTENTE");
        }
    }
    public static void errorOpcion(String opcion) throws MenuExcepcion{
        if(!opcion.equals("ver") && !opcion.equals("insertar") && !opcion.equals("salir")){
            throw new MenuExcepcion("Error, opcion invalida");
        }
    }
}
