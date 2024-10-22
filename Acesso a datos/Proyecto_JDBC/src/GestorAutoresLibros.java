import java.util.List;

public class GestorAutoresLibros {
    private List<AutorLibro> listaAutoresLibros;
    private AutoresLibrosDAO autoresLibrosDAO;

    public GestorAutoresLibros() {
        inicializarListaAutoresLibros();}

    // Inicializamos la memoria
    private void inicializarListaAutoresLibros() {
        this.autoresLibrosDAO = new AutoresLibrosDAO();
        this.listaAutoresLibros = autoresLibrosDAO.readAllAuthorBookRelations();}

    public List<AutorLibro> obtenerAutoresLibros() {
        return this.listaAutoresLibros;}

    public int insertarAutorLibro(Autor autor, Libro libro) {
        AutorLibro autorLibro = new AutorLibro(autor.getIdAutor(), libro.getIdLibro());
        int x = autoresLibrosDAO.insertAuthorBookRelation(autorLibro);

        if(x == 1) {
            this.listaAutoresLibros.add(autorLibro);
            return 1;}

        return -1;
    }
}