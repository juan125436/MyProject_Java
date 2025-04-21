package Tarea;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static ArrayList<Poligono> poligonos = new ArrayList<>();
    static Scanner datos = new Scanner(System.in);
    public static void main(String[]args){
        rellenarPoligonos();
        mostrar();
    }

    public static void rellenarPoligonos (){
        int opcion;
        String opcionS;
        while (true){
            System.out.println("Que poligono desea: \n1.Triangulo \n2.Rectangulo \nElige:");
            opcion=datos.nextInt();
            while (opcion!=1 && opcion!=2){
                System.out.println("Que poligono desea: \n1.Triangulo \n2.Rectangulo\nElige:");
                opcion=datos.nextInt();
            }
            if (opcion==1){
                Triangulo();
            } else if (opcion==2){
                Rectangulo();
            }
            datos.nextLine();
            System.out.println("Desea introducir otro poligono? s/n");
            opcionS=datos.nextLine().toLowerCase();
            while(!opcionS.equals("s") && !opcionS.equals("n")){
                System.out.println("Desea introducir otro poligono? s/n");
                opcionS=datos.nextLine();
            }
            if (opcionS.equals("s")){
                continue;
            } else if (opcionS.equals("n")){
                return;
            }
        }
    }

    public static void Triangulo(){
        double lado1,lado2,lado3;
        System.out.println("Digite lado1: ");
        lado1=datos.nextDouble();
        System.out.println("Digite lado2: ");
        lado2=datos.nextDouble();
        System.out.println("Digite lado3: ");
        lado3=datos.nextDouble();
        Triangulo triangulo = new Triangulo(lado1, lado2, lado3, 3);
        poligonos.add(triangulo);
    }
    public static void Rectangulo(){
        double lado1,lado2;
        System.out.println("Digite lado1: ");
        lado1=datos.nextDouble();
        System.out.println("Digite lado2: ");
        lado2=datos.nextDouble();
        Rectangulo rectangulo = new Rectangulo(lado1, lado2, 2);
        poligonos.add(rectangulo);
    }

    public static void mostrar(){
        for (Poligono poligono : poligonos) {
            System.out.println("Datos: "+poligono.toString());
            System.out.println("Area: "+poligono.area());
        }
    }
}
