package programa;
import java.sql.*;
import java.util.Scanner;

public class Main {
    static String opcion="";
    static char curso=0;
    static Scanner datos = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
        elegirCurso();
        Alumno_bd.verificarmenu();
    }
    public static void menu(){
        System.out.println("Hola, este programa te permitira agregar alumnos a un curso de primer nivel");
        System.out.println("Ver || Insertar || Salir \n");
        try {
            System.out.print("Elige: ");
            opcion=datos.nextLine().toLowerCase();
            MenuExcepcion.errorOpcion(opcion);
        } catch (MenuExcepcion e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    public static void elegirCurso(){
        System.out.println("Ha continuacion debe elegir letra del curso\n"
        +"A B C D");
        try {
            System.out.println("Elige: ");
            curso=datos.next().trim().toUpperCase().charAt(0);
            MenuExcepcion.errorCurso(curso);
        } catch(MenuExcepcion e){
            System.out.print(e.getMessage());
            System.exit(0);
        }
    }
}
