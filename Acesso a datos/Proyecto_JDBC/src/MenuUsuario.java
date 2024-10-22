import java.util.Scanner;

public class MenuUsuario {
    private GestionUsuario gestionUsuario;
    private Scanner sc;

    public MenuUsuario() {
        gestionUsuario = new GestionUsuario();
        sc = new Scanner(System.in);
    }

    public void mostrarMenuUsuario() {
        int opcion = 0;

        do {
            System.out.println("\n--- Menú de Gestión de Usuarios ---");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Leer Usuario");
            System.out.println("3. Actualizar Usuario");
            System.out.println("4. Eliminar Usuario");
            System.out.println("5. Mostrar Todos los Usuarios");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearUsuario();
                    break;
                case 2:
                    leerUsuario();
                    break;
                case 3:
                    actualizarUsuario();
                    break;
                case 4:
                    eliminarUsuario();
                    break;
                case 5:
                    mostrarTodosLosUsuarios();
                    break;
                case 6:
                    System.out.println("Saliendo del menú de usuarios...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 6);
    }

    //Metodo crear Usuario
    private void crearUsuario() {
        System.out.print("Ingrese el nombre del nuevo usuario: ");
        String nombre = sc.nextLine();
        Usuario nuevoUsuario = new Usuario(0, nombre);
        if (gestionUsuario.insertUsuario(nuevoUsuario) == 1) {
            System.out.println("Usuario creado exitosamente.");
        } else {
            System.out.println("Error al crear el usuario.");
        }
    }

    // Metodo leer Usuario
    private void leerUsuario() {
        System.out.print("Ingrese el ID del usuario a buscar: ");
        int idUsuario = sc.nextInt();
        sc.nextLine(); // Limpia la entrada
        Usuario usuario = gestionUsuario.obtenerUsuarioId(idUsuario);
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario.getNombre());
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // Metodo actualizar Usuario
    private void actualizarUsuario() {
        System.out.print("Ingrese el ID del usuario a actualizar: ");
        int idUsuario = sc.nextInt();
        sc.nextLine(); // Limpia la entrada
        Usuario usuario = gestionUsuario.obtenerUsuarioId(idUsuario);

        if (usuario != null) {
            System.out.print("Ingrese el nuevo nombre del usuario: ");
            String nuevoNombre = sc.nextLine();
            usuario.setNombre(nuevoNombre);
            if (gestionUsuario.updateUsuarios(usuario) == 1) {
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("Error al actualizar el usuario.");
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // Metodo eliminar Usuario
    private void eliminarUsuario() {
        System.out.print("Ingrese el ID del usuario a eliminar: ");
        int idUsuario = sc.nextInt();
        sc.nextLine(); // Limpia la entrada
        Usuario usuario = gestionUsuario.obtenerUsuarioId(idUsuario);

        if (usuario != null && gestionUsuario.deleteUsuario(usuario) == 1) {
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            System.out.println("Error al eliminar el usuario.");
        }
    }

    // Metodo mostrar
    private void mostrarTodosLosUsuarios() {
        System.out.println("\nLista de Usuarios:");
        for (Usuario usuario : gestionUsuario.LeerUsuario()) {
            System.out.println("ID: " + usuario.getIdUsario() + ", Nombre: " + usuario.getNombre());
        }
    }
}
