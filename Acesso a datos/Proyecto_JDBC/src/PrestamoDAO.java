import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {
    //Insertar Prestamo
    public  void insertPrestamo(Prestamo prestamo){
        String sql = "INSERT INTO Prestamo (fechaInicio, fechaFinal, idUsuario, idLibro) VALUES(?,?,?,?)";
        try(Connection con= ConexionBD.getConnection();
        PreparedStatement pst = con.prepareStatement(sql)){
            pst.setDate(1, new java.sql.Date(prestamo.getFechaInicio().getTime()));
            pst.setDate(2, new java.sql.Date(prestamo.getFechaFin().getTime()));
            pst.setInt(3,prestamo.getUsuario().getIdUsario());
            pst.setInt(4,prestamo.getLibro().getIdLibro());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Leer Prestamos
    public List<Prestamo> leerPrestamo(){
        List<Prestamo> prestamos = new ArrayList<Prestamo>();
        String sql = "SELECT * FROM Prestamo";
        try(Connection con= ConexionBD.getConnection();
        PreparedStatement ps= con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Prestamo prestamo= new Prestamo();
                prestamo.setIdPrestamo(rs.getInt("idPrestamo"));
                prestamo.setFechaInicio(rs.getDate("fechaInicio"));
                prestamo.setFechaFin(rs.getDate("fechaFin"));
                prestamo.getUsuario().setIdUsario(rs.getInt("idUsuario"));
                prestamo.getLibro().setIdLibro(rs.getInt("idLibro"));
                prestamos.add(prestamo);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return prestamos;
    }
}
