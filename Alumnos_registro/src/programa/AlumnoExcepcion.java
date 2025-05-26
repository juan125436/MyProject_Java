package programa;

import java.util.ArrayList;

public class AlumnoExcepcion extends Exception {
    public AlumnoExcepcion(String mensaje){
        super(mensaje);
    }

    public static void verificarEdad(int edad)throws AlumnoExcepcion{
        if(edad<14 || edad>18){
            throw new AlumnoExcepcion("EDAD NO PERMITIDA"); 
        }
    }
    public static void verificarNombre(String nombre) throws AlumnoExcepcion{
        boolean numero=false,simbolo=false;
        for(int i=0;i<nombre.length();i++){
            char caracter = nombre.charAt(i);
            if(Character.isDigit(caracter)){
                numero=true;
                break;
            }
            if(!Character.isLetterOrDigit(caracter)){
                simbolo=true;
                break;
            }
        }
        if(numero){
            throw new AlumnoExcepcion("ERROR, EL NOMBRE TIENE AL MENOS UN NUMERO");
        }
        if(simbolo){
            throw new AlumnoExcepcion("ERROR, EL NOMBRE TIENE AL MENOS UN SIMBOLO");
        }
    }
    public static void comprobarAlumnoCreado(Alumno alumno) throws AlumnoExcepcion{
        if(alumno==null){
            throw new AlumnoExcepcion("NO HAY NINGUN ALUMNO CREADO");
        }
    }

}
