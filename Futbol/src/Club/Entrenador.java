package Club;

public class Entrenador extends Persona{
    private String estrategia;
    public Entrenador(String estrategia, String nombre, String apellido, int edad){
        super(nombre,apellido,edad);
        this.estrategia=estrategia;
    }
    public String getEstrategia(){
        return estrategia;
    }
}
