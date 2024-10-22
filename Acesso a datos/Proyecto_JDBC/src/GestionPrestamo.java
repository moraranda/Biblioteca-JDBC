import java.util.List;

public class GestionPrestamo {
    private List<Prestamo>  listaPrestamos;
    private  PrestamoDAO prestamoDAO;

    public GestionPrestamo() {
        inicializarLista();
    }

    //Inicializar la lista con la base de datos
    private void inicializarLista() {
        this.prestamoDAO = new PrestamoDAO();
        this.listaPrestamos= prestamoDAO.leerPrestamo();
    }

    //Mostrar todos los prestamos
    public List<Prestamo> leerPrestamos() {
        return this.listaPrestamos;
    }

    //Obtiene Prestamso por id
    public Prestamo leerPrestamosId(int id) {
        for(Prestamo prestamo: this.listaPrestamos) {
            if(prestamo.getIdPrestamo() == id) {
                return prestamo;
            }
        }
        return null;
    }

    //Inserta Prestamos
    public int insertPrestamo(Prestamo prestamo) {
        int r= prestamoDAO.insertPrestamo(prestamo);
        if(r==1){
            this.listaPrestamos.add(prestamo);
            return 1;
        }
        return -1;
    }

    //Actualiza Prestamos
    public int updatePrestamo(Prestamo prestamo) {
        int r= prestamoDAO.updatePrestamo(prestamo);
        if(r==1){
            int indice= this.listaPrestamos.indexOf(prestamo);
            return 1;
        }
        return -1;
    }

    //Borra Prestamos
    public int deletePrestamo(Prestamo prestamo) {
        int r= prestamoDAO.deletePrestamo(prestamo);
        if(r==1){
            this.listaPrestamos.remove(prestamo);
            return 1;
        }
        return -1;
    }
}
