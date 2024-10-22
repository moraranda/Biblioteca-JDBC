public class Libro {

    // Variables
    private int idLibro;
    private String tituloLibro;
    private String isbn;

    // Getter and Setter
    public int getIdLibro() {
        return idLibro;}

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;}

    public String getTituloLibro() {
        return tituloLibro;}

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;}

    public String getIsbn() {
        return isbn;}

    public void setIsbn(String isbn) {
        this.isbn = isbn;}

    // Constructor
    public Libro(int idLibro, String tituloLibro, String isbn) {
        this.idLibro = idLibro;
        this.tituloLibro = tituloLibro;
        this.isbn = isbn;}

    public Libro(String tituloLibro, String isbn) {
        this.tituloLibro = tituloLibro;
        this.isbn = isbn;}

    public Libro() {}

    @Override
    public String toString() {
        return "Libro " + idLibro + " [ Título del libro: " + tituloLibro + ", ISBN: " + isbn + "]";
    }
}