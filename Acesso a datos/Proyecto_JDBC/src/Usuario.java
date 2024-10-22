public class Usuario {
    private String nombre;
    private int idUsario;

    //Contructor
    public Usuario(int idUsario, String nombre) {
        this.nombre = nombre;
        this.idUsario = idUsario;
    }

    public Usuario() {

    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdUsario() {
        return idUsario;
    }

    public void setIdUsario(int idUsario) {
        this.idUsario = idUsario;
    }

    //ToString
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", idUsario=" + idUsario +
                '}';
    }
}
