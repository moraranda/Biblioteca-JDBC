package org.example;

public class AutorLibro {
    // Variables
    private int idAutor;
    private int idLibro;

    // Getter and Setter
    public int getIdAutor() {
        return idAutor;}

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;}

    public int getIdLibro() {
        return idLibro;}

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;}

    // Constructor
    public AutorLibro(int idAutor, int idLibro) {
        this.idAutor = idAutor;
        this.idLibro = idLibro;}
}