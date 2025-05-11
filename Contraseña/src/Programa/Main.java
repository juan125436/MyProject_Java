package Programa;

import java.util.*;

/*
 * Este programa podra verificar si la contraseña es correcta
 * Tratamiento de excepciones
 */
public class Main {
    public static void validacionClave(String claveRegistrada, String claveEntrada) throws PasswordInvalidaException {
        if(!claveEntrada.equals(claveRegistrada)){
            throw new PasswordInvalidaException("Clave incorrecta");
        }
    }
    public static void validarRequisitos(String clave) throws PasswordInvalidaException{
        if(clave.length()<8){
            throw new PasswordInvalidaException("La clave es muy corta, intentelo denuevo....");
        }
        boolean mayus=false,minus=false,digit=false,especial=false;
        for(int i=0;i<clave.length();i++){
                char caracter = clave.charAt(i);
                if(Character.isUpperCase(caracter)){
                    mayus=true;
                }
                if(Character.isLowerCase(caracter)){
                    minus=true;
                }
                if(Character.isDigit(caracter)){
                    digit=true;
                }
                if(!Character.isLetterOrDigit(caracter)){
                    especial=true;
                }
            }
        if(!(mayus && minus && digit && especial)){
            throw new PasswordInvalidaException("La clave no cumple con los requisitos");
        }
    }
    public static void main(String[] args){
        Scanner datos = new Scanner(System.in);
        HashMap<String,String> usuarios = new HashMap<>();
        String usuario="juan",clave;
        boolean registrado=false;
        while(true) {
            if(!registrado) {
                System.out.println("Creacion de contraseña de "+usuario);

                try{
                    System.out.print("Ingrese contraseña: ");
                    clave=datos.nextLine();
                    validarRequisitos(clave);
                    usuarios.put(usuario, clave);
                    registrado=true;
                } catch (PasswordInvalidaException e){
                    System.out.println(e.getMessage());
                    break;
                } finally {
                    datos.close();
                }
            }
            
            if(registrado){
                System.out.println("Bienvenido/a");
                try{
                    System.out.print("Ingrese clave: ");
                    clave=datos.nextLine();
                    validacionClave(usuarios.get(usuario),clave);
                    System.out.println("Clave correcta bienvenido");
                    return;
                } catch(PasswordInvalidaException e){
                    System.out.println(e.getMessage());
                    break;
                } finally {
                    datos.close();
                }
            }
        }
    }
}
