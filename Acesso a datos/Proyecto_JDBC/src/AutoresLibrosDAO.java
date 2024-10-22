import java.sql.*;
import java.util.ArrayList;

public class AutoresLibrosDAO {
    Statement consulta;
    ConexionBD conexionBD = new ConexionBD();

    Connection con = null;
    PreparedStatement ps = null;

    // Prepared Statement
    String insertAuthorBook = "INSERT INTO libro_autor(idLibro, idAutor) VALUES (?, ?);";

    // Función leer autores-libros
    public ArrayList<AutorLibro> readAllAuthorBookRelations() {
        ArrayList<AutorLibro> autorLibros = new ArrayList<>();
        ResultSet rs = null;

        try {
            consulta = conexionBD.getConnection().createStatement();
            String cadena = "SELECT * FROM libro_autor;";
            rs = consulta.executeQuery(cadena);

            while (rs.next()) {
                autorLibros.add(new AutorLibro(rs.getInt("idAutor"), rs.getInt("idLibro")));
            }

        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getLocalizedMessage());}

        return autorLibros;

    }

    // Función insertar nueva relación
    public int insertAuthorBookRelation(AutorLibro autorLibro) {
        try (Connection conn = conexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertAuthorBook)) {

            ps.setInt(1, autorLibro.getIdAutor());
            ps.setInt(2, autorLibro.getIdLibro());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getLocalizedMessage());}

        return 1;
    }
}