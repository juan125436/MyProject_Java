package Tarea;

public class Triangulo extends Poligono {
    private double lado1;
    private double lado2;
    private double lado3;
    public Triangulo(double lado1, double lado2, double lado3, int nLados){
        super(3);
        this.lado1=lado1;
        this.lado2=lado2;
        this.lado3=lado3;
    }
    public double getLado1(){
        return lado1;
    } 
    public double getLado2(){
        return lado2;
    }
    public double getLado3(){
        return lado3;
    }
    @Override
    public String toString(){
        return "Triangulo{\n"+super.toString()+"\nlado1="+lado1+"\nlado2="+lado2+"\nlado3="+lado3+"\n}";
    }
    @Override
    public double area(){
        double area=0,semiP;
        semiP=(lado1+lado2+lado3)/2;
        area=Math.sqrt(semiP*(semiP-lado1)*(semiP-lado2)*(semiP-lado3));
        return area;
    }
}