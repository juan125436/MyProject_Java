package BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Main {
    public static void insercion() {
        String url = "jdbc:mysql://192.168.100.95:3306/prueba_java?useSSL=false&serverTimezone=UTC";
        String usu="root";
        String pass="";
        Scanner datos = new Scanner(System.in);
        String nombre;
        int id=0;
        try {
            Connection conexion = DriverManager.getConnection(url, usu, pass);
            for(int i=0;i<10;i++){
                String sql_consulta="insert into usuarios(id,nombre) values(?,?)"; 
                PreparedStatement sentencia = conexion.prepareStatement(sql_consulta);
                id++;
                System.out.print("Ingrese nombre: ");
                nombre=datos.nextLine();
                sentencia.setInt(1, id);
                sentencia.setString(2, nombre);
                sentencia.executeUpdate();
            }
            conexion.close();
        } catch(SQLException e){
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
    public static void valores() {
        /*
        AGREGAR VALUES A UNA TABLA X
        */
        String url_BD = "jdbc:mysql://localhost:3306/prueba_java";

        String user="root";
        String password="";
        
        try{
            Connection conexion = DriverManager.getConnection(url_BD, user, password);
            String sql_consulta="INSERT INTO Alumno(id,nombres,apellidos) VALUES(?,?,?)";
            PreparedStatement sentencia=conexion.prepareStatement(sql_consulta);

            //CARGAR VALORES
            sentencia.setInt(1, 2);
            sentencia.setString(2, "Jeremy Isaias");
            sentencia.setString(3, "Arias Saavedra");

            sentencia.executeUpdate();
            sentencia.close();
        } catch (SQLException e){
            System.out.println("ERROR");
        }
    }
    public static void main(String[]args){
        // URL de conexión a la base de datos
        // Formato: jdbc:mysql://<host>:<puerto>/<nombre_base_de_datos>
        String url = "jdbc:mysql://192.168.100.95:3306/prueba_java?useSSL=false&serverTimezone=UTC";

        //Usuario y contraseña(XAMPP NO TIENE CONTRASEÑA)
        String user="root";
        String password="";
        
        try {
            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Se conecto a la base de datos");
            
            //SENTENCIA
            String sql ="SELECT * FROM usuarios";

            //STATEMENT QUE NOS SIRVE PARA EJECUTAR LA SENTENCIA SQL
            Statement consulta = conexion.createStatement();

            //EJECUTAR CONSULTA
            ResultSet resultado = consulta.executeQuery(sql);

            //ESTE WHILE ES PARA RECORRER FILA X FILA
            while(resultado.next()){
                //CREAMOS VARIABLES QUE TENDRAN EL VALOR DE 1 REGISTRO POR COLUMNA
                int id=resultado.getInt("id");
                String nombres=resultado.getString("nombre");

                //SE IMPRIME
                System.out.println("ID: "+id+" Nombres: "+nombres);
            }
        } catch (SQLException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
