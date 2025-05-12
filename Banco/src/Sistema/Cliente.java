package Sistema;

public class Cliente {
	private String nombre;
	private String apellidos;
	public Cliente(String nombre, String apellidos){
		this.nombre=nombre;
		this.apellidos=apellidos;
	}

	public String getNombre(){
		return nombre;
	}
	public String getApellidos(){
		return apellidos;
	}
}
