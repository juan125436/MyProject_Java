package Club;

public class Doctor extends Persona{
    private String titulo;
    private int añosExp;
    public Doctor(String titulo, int añosExp, String nombre, String apellido, int edad){
        super(nombre, apellido, edad);
        this.titulo=titulo;
        this.añosExp=añosExp;
    }
    public String getTitulo(){
        return titulo;
    }

    public int getAñosExp(){
        return añosExp;
    }
}
