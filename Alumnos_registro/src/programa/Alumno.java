package programa;

import java.util.ArrayList;
import java.util.Scanner;
public class Alumno {
    static Scanner datos = new Scanner(System.in);
    static int indice=0;
    static ArrayList<Alumno> alumnos = new ArrayList<>();
    private String nombre;
    private int edad;
    public Alumno(String nombre,int edad){
        this.nombre=nombre;
        this.edad=edad;
    }

    public String getNombre(){
        return nombre;
    }
    public int getEdad(){
        return edad;
    }

    public static Alumno crearAlumno(){
        String nombre="";
        int edad=0;
        try {
            System.out.print("Digite nombre del estudiante: ");
            nombre=datos.nextLine();
            AlumnoExcepcion.verificarNombre(nombre);
            System.out.print("Digite edad del estudiante DE PRIMER AÑO: ");
            edad=datos.nextInt();
            AlumnoExcepcion.verificarEdad(edad);
        } catch (AlumnoExcepcion e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        Alumno alumno = new Alumno(nombre, edad);
        alumnos.add(alumno);
        indice++;
        return alumno;
    }
}
