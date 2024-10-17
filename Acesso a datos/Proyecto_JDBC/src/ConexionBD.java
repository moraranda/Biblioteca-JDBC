import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca-jdbc";
    private static final String USER = "root";
    private static final String PW = "";

    //Conexion a la BD
    public static Connection getConnection(){
        Connection con=null;
        try{
            con = DriverManager.getConnection(URL,USER,PW);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
    System
}
