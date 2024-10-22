package org.example;

import java.util.List;

public class GestorLibros {
    private List<Libro> listaLibros;
    private LibrosDAO librosDAO;

    public GestorLibros() {
        inicializarListaLibros();}

    // Inicializamos la memoria
    private void inicializarListaLibros() {
        this.librosDAO = new LibrosDAO();
        this.listaLibros = librosDAO.readBook();}

    // Obtenemos los libros
    public Libro obtenerLibro(String tituloLibro) {

        for(Libro libro : this.listaLibros) {

            if(libro.getTituloLibro() == tituloLibro) {
                return libro;
            }
        }
        return null;
    }

    public List<Libro> obtenerLibros() {
        return this.listaLibros;}

    // Añadimos los libros a la memoria
    public int insertarLibros(Libro libro) {
        int x = librosDAO.insertBook(libro);

        if(x == 1) {
            this.listaLibros.add(libro);
            return 1;}

        return -1;
    }

    // Actualizamos un libro en la memoria
    public int actualizarLibros(Libro libro) {
        int x = librosDAO.updateBook(libro);

        if(x == 1) {
            int index = this.listaLibros.indexOf(libro);
            this.listaLibros.set(index, libro);
            return 1;}

        return -1;
    }

    // Eliminamos un libro de la memoria
    public int eliminarLibro(Libro libro) {
        int x = librosDAO.deleteBook(libro);

        if(x == 1) {
            this.listaLibros.remove(libro);
            return 1;}

        return -1;
    }
}