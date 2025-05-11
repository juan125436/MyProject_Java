package Club;

public class Futbolista extends Persona {
    private int dorsal;
    private String posicion;
    private Boolean lesion;
    public Futbolista(int dorsal, String posicion, String nombre, String apellido, int edad,boolean lesion){
        super(nombre, apellido, edad);
        this.dorsal=dorsal;
        this.posicion=posicion;
        this.lesion=lesion;
    }
    public int getDorsal(){
        return dorsal;
    }

    public String getPosicion(){
        return posicion;
    }
    public void setLesion(boolean lesion){
        this.lesion=lesion;
    }
    public Boolean getLesion(){
        return lesion;
    }
}
