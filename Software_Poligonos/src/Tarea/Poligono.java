package Tarea;

public abstract class Poligono {
    protected int nLados;
    public Poligono(int nLados){
        this.nLados=nLados;
    }

    public int getnLados(){
        return nLados;
    }
    @Override
    public String toString(){
        return "Poligono{"+"Nlados="+nLados+"}";
    }
    public abstract double area();
}
