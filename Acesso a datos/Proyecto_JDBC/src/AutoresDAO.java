package org.example;

import java.sql.*;
import java.util.ArrayList;

public class AutoresDAO {
    Statement consulta;
    ConexionBD conexionBD = new ConexionBD();

    Connection con = null;
    PreparedStatement ps = null;

    //Prepared Statement
    String insertAuthor = "INSERT INTO autor (nombreAutor) VALUES (?);";
    String updateAuthor = "UPDATE autor SET nombreAutor = ? WHERE idAutor = ?;";
    String deleteAuthor = "DELETE FROM autor WHERE idAutor = ?;";

    // Función insertar autor
    public int insertAuthor(Autor autor) {
        try(Connection conn = conexionBD.getConnection();
            PreparedStatement ps = conn.prepareStatement(insertAuthor)) {

            ps.setString(1, autor.getNombreAutor());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getLocalizedMessage());}

        return 1;
    }

    // Función leer autores
    public ArrayList<Autor> readAuthor() {
        ArrayList<Autor> autores = new ArrayList<>();
        String sql = "SELECT * FROM autor";

        try (Connection conn = conexionBD.getConnection();
             Statement consulta = conn.createStatement();
             ResultSet rs = consulta.executeQuery(sql)) {

            while (rs.next()) {
                autores.add(new Autor(rs.getInt("idAutor"), rs.getString("nombreAutor")));
            }

        } catch (SQLException ex) {
            System.err.println("Error al leer los autores: " + ex.getLocalizedMessage());}

        return autores;
    }

    // Función modificar autores
    public int updateAuthor(Autor autor) {
        try( Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(updateAuthor);) {

            ps.setString(1, autor.getNombreAutor());
            ps.setInt(2, autor.getIdAutor());

            ps.executeUpdate();

        } catch(SQLException e) {
            System.err.println("Error: " + e.getLocalizedMessage());}

        return 1;
    }

    // Función eliminar autor
    public int deleteAuthor(Autor autor) {
        try( Connection conn = conexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(deleteAuthor);) {

            ps.setInt(1, autor.getIdAutor());

            ps.executeUpdate();

        } catch(SQLException e) {
            System.err.println("Error: " + e.getLocalizedMessage());}

        return 1;
    }
}