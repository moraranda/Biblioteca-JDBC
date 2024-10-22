import java.util.List;

public class GestionUsuario {
    private List<Usuario> listausuarios;
    private UsuarioDAO usuarioDAO;

    public GestionUsuario() {
        inicializarLista();
    }

    //Inicializar lista y base de datos
    private void inicializarLista() {
        this.usuarioDAO = new UsuarioDAO();
        this.listausuarios= usuarioDAO.obtenerUsuarios();
    }

    //Obtiene lso Usuarios por id
    public Usuario obtenerUsuarioId(int id){
        for(Usuario usuario: this.listausuarios){
            if(usuario.getIdUsario() == id){
                return usuario;
            }
        }
        return null;
    }

    //Obtener todos los usuarios
    public List<Usuario> LeerUsuario(){
        return this.listausuarios;
    }

    //Añade Usuarios
    public  int insertUsuario(Usuario usuario){
        int r= usuarioDAO.insertUsuario(usuario);
        if(r==1){
            this.listausuarios.add(usuario);
            return 1;
        }
        return  -1;
    }

    //Actualiza Usuarios
    public int updateUsuarios(Usuario usuario){
        int r= usuarioDAO.actualizarUsuario(usuario);
        if(r==1){
            int indice= this.listausuarios.indexOf(usuario);
            this.listausuarios.set(indice,usuario);
            return 1;
        }
        return  -1;
    }

    //Elimina Usuarios
    public int deleteUsuario(Usuario usuario){
        int r= usuarioDAO.deleteUsuario(usuario);
        if(r==1){
            this.listausuarios.remove(usuario);
            return 1;
        }
        return  -1;
    }
}
