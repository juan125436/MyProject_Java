package BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {
    public static void main(String[] args) {
        /*
        AGREGAR VALUES A UNA TABLA X
        */
        String url_BD = "jdbc:mysql://localhost:3306/Prueba_Colegio";

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

            int filasAfectadas=sentencia.executeUpdate();
            sentencia.close();
        } catch (SQLException e){
            System.out.println("ERROR");
        }
    }
    public static void prueba(){
        // URL de conexión a la base de datos
        // Formato: jdbc:mysql://<host>:<puerto>/<nombre_base_de_datos>
        String url_BD = "jdbc:mysql://localhost:3306/Prueba_Colegio";

        //Usuario y contraseña(XAMPP NO TIENE CONTRASEÑA)
        String user="root";
        String password="";
        
        try {
            Connection conexion = DriverManager.getConnection(url_BD, user, password);
            System.out.println("Se conecto a la base de datos");
            
            //SENTENCIA
            String sql ="SELECT * FROM Alumno";

            //STATEMENT QUE NOS SIRVE PARA EJECUTAR LA SENTENCIA SQL
            Statement consulta = conexion.createStatement();

            //EJECUTAR CONSULTA
            ResultSet resultado = consulta.executeQuery(sql);

            //ESTE WHILE ES PARA RECORRER FILA X FILA
            while(resultado.next()){
                //CREAMOS VARIABLES QUE TENDRAN EL VALOR DE 1 REGISTRO POR COLUMNA
                int id=resultado.getInt("id");
                String nombres=resultado.getString("nombres");
                String apellidos=resultado.getString("apellidos");

                //SE IMPRIME
                System.out.println("ID: "+id+" Nombres: "+nombres+" Apellidos: "+apellidos);
            }
        } catch (SQLException e){
            System.out.println("Error");
        }
    }
}
