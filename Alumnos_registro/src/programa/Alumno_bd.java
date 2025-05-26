package programa;
import java.sql.*;
public class Alumno_bd {
    static String url = "jdbc:mysql://192.168.100.95:3306/colegio?useSSL=false&serverTimezone=UTC";
    static String usu="root";
    static String pass="";
    public static void verificarmenu(){
        switch(Main.opcion){
            case "ver": mostrarCurso();
             break;
            case "insertar": Alumno nuevo = Alumno.crearAlumno();
                             try{
                                AlumnoExcepcion.comprobarAlumnoCreado(nuevo);
                                insertarAlumno();
                             } catch (AlumnoExcepcion e){
                                System.out.println(e.getMessage());
                             }
             break;
        }
    }
    public static void insertarAlumno(){
        try{
            Connection conexion = DriverManager.getConnection(url, usu, pass);
            String tabla = "primero"+Main.curso;
            String sql_consulta="INSERT INTO "+tabla+" (nombre_"+Main.curso+",edad_"+Main.curso+") VALUES(?,?)";
            PreparedStatement sentencia=conexion.prepareStatement(sql_consulta);

            Alumno alumno = Alumno.alumnos.get(Alumno.alumnos.size()-1);
            sentencia.setString(1, alumno.getNombre());
            sentencia.setInt(2, alumno.getEdad());
            sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
        } catch (SQLException e){
            System.out.println("Error");
            e.printStackTrace();
            System.exit(0);
        }
    }
    public static void mostrarCurso(){
        
        try {
            Connection conexion = DriverManager.getConnection(url, usu, pass);
            String tabla="primero"+Main.curso;
            String sql_consulta= "select * from "+tabla;
            PreparedStatement sentencia = conexion.prepareStatement(sql_consulta);
            ResultSet resultado = sentencia.executeQuery();
            System.out.println("==========================");
            System.out.println("PRIMER AÑO "+Main.curso);
            System.out.println("==========================");
            while(resultado.next()){
                int id = resultado.getInt("id_"+Main.curso);
                String nombre = resultado.getString("nombre_"+Main.curso);
                int edad = resultado.getInt("edad_"+Main.curso);
                System.out.println("id:" +id+" nombre: "+nombre+" edad: "+edad);
            }
            conexion.close();
            sentencia.close();
            resultado.close();
        } catch (SQLException e){
            System.out.println("Error");
            e.printStackTrace();
            System.exit(0);
        }
    }
}
