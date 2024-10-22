package org.example;

public class Autor {
    // Variables
    private int idAutor;
    private String nombreAutor;

    // Getter and Setter
    public int getIdAutor() {
        return idAutor;}

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;}

    public String getNombreAutor() {
        return nombreAutor;}

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;}

    // Constructor
    public Autor(int idAutor, String nombreAutor) {
        this.idAutor = idAutor;
        this.nombreAutor = nombreAutor;}

    public Autor(String nombreAutor) {
        this.nombreAutor = nombreAutor;}

    public Autor() {}

    @Override
    public String toString() {
        return "Autor " + idAutor + " [ Nombre del Autor: " + nombreAutor + " ]";
    }
}