import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    //Insertar Usuario
    public void inserirUsuario(Usuario usuario){
        String SQL = "INSERT INTO Usuario (nombre) VALUES (?)";
        try(Connection con= ConexionBD.getConnection();
            PreparedStatement ps= con.prepareStatement(SQL)){
            ps.setString(1, usuario.getNombre());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Leer Usuario
    public List<Usuario> obtenerUsuarios(){
        String SQL = "SELECT * FROM Usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try(Connection con= ConexionBD.getConnection();
        PreparedStatement ps= con.prepareStatement(SQL)){
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Usuario usuario= new Usuario();
                usuario.setIdUsario(rs.getInt("idUsario"));
                usuario.setNombre(rs.getString("nombre"));
                usuarios.add(usuario);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return usuarios;
    }

    //Actualizar Usuario
    public void actualizarUsuario(Usuario usuario){
        String SQL="UPDATE Usuario SET nombre=? WHERE idUsario=?";
        try(Connection con= ConexionBD.getConnection();
        PreparedStatement ps= con.prepareStatement(SQL)){
            ps.setString(1, usuario.getNombre());
            ps.setInt(2, usuario.getIdUsario());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Borrar Usuario
    public void deleteUsuario(Usuario usuario){
        String SQL = "DELETE FROM Usuario WHERE idUsario = ?";
        try(Connection con= ConexionBD.getConnection();
        PreparedStatement ps= con.prepareStatement(SQL)){
            ps.setInt(1, usuario.getIdUsario());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
