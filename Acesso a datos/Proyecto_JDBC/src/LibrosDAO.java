package org.example;

import java.sql.*;
import java.util.ArrayList;

public class LibrosDAO {
    Statement consulta;
    ConexionBD conexionBD = new ConexionBD();

    Connection con = null;
    PreparedStatement ps = null;

    // Prepared Statements
    String insertBook = "INSERT INTO libro (tituloLibro, isbn) VALUES (?, ?);";
    String updateBook = "UPDATE libro SET tituloLibro = ?, isbn = ? WHERE idLibro = ?;";
    String deleteBook = "DELETE FROM libro WHERE idLibro = ?;";

    // Función insertar libro
    public int insertBook(Libro libro){
        try( Connection conn = conexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertBook);) {

            ps.setString(1, libro.getTituloLibro());
            ps.setString(2, libro.getIsbn());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getLocalizedMessage());}

        return 1;
    }

    // Función leer libros
    public ArrayList<Libro> readBook() {
        ArrayList<Libro> libros = new ArrayList<>();
        ResultSet rs = null;

        try {
            consulta = conexionBD.getConnection().createStatement();
            String cadena = "SELECT * FROM libro;";
            rs = consulta.executeQuery(cadena);

            while (rs.next()) {
                libros.add(new Libro(rs.getInt("idLibro"), rs.getString("tituloLibro"), rs.getString("isbn")));
            }

        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getLocalizedMessage());}

        return libros;
    }

    // Función modificar libros
    public int updateBook(Libro libro) {
        try( Connection conn = conexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(updateBook);) {

            ps.setString(1, libro.getTituloLibro());
            ps.setString(2, libro.getIsbn());
            ps.setInt(3, libro.getIdLibro());

            ps.executeUpdate();

        } catch(SQLException e) {
            System.err.println("Error: " + e.getLocalizedMessage());}

        return 1;
    }

    // Función eliminar libro
    public int deleteBook(Libro libro) {
        try( Connection conn = conexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(deleteBook);) {

            ps.setInt(1, libro.getIdLibro());

            ps.executeUpdate();

        } catch(SQLException e) {
            System.err.println("Error: " + e.getLocalizedMessage());}

        return 1;
    }
}