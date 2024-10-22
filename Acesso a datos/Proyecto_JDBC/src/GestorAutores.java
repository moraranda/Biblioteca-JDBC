import java.util.List;

public class GestorAutores {
    private List<Autor> listaAutores;
    private AutoresDAO autoresDAO;

    public GestorAutores() {
        inicializarListaAutores();}

    // Inicializamos la memoria
    private void inicializarListaAutores() {
        this.autoresDAO = new AutoresDAO();
        this.listaAutores = autoresDAO.readAuthor();}

    // Obtenemos los autores
    public Autor obtenerAutor(int idAutor) {

        for(Autor autor : this.listaAutores) {

            if(autor.getIdAutor() == idAutor) {
                return autor;}
        }
        return null;
    }

    public List<Autor> obtenerAutores() {
        return this.listaAutores;}

    // Añadimos los autores a la memoria
    public int insertarAutores(Autor autor) {
        int x = autoresDAO.insertAuthor(autor);

        if(x == 1) {
            this.listaAutores.add(autor);
            return 1;}

        return -1;
    }

    // Actualizamos un autor en la memoria
    public int actualizarAutores(Autor autor) {
        int x = autoresDAO.updateAuthor(autor);

        if(x == 1) {
            int index = this.listaAutores.indexOf(autor);
            this.listaAutores.set(index,autor);
            return 1;}

        return -1;
    }

    // Eliminamos un autor de la memoria
    public int eliminarAutores(Autor autor) {
        int x = autoresDAO.deleteAuthor(autor);

        if(x == 1) {
            this.listaAutores.remove(autor);
            return 1;}

        return -1;
    }
}