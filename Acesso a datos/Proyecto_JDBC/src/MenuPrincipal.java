import java.util.Scanner;

public class MenuPrincipal {
    // Menus
    MenuAutores menuAutores = new MenuAutores();
    MenuLibros menuLibros = new MenuLibros();
    MenuUsuario menuUsuario = new MenuUsuario();
    MenuPrestamo menuPrestamo = new MenuPrestamo();
    MenuAutoresLibros menuAutoresLibros = new MenuAutoresLibros();

    Scanner sc = new Scanner(System.in);
    public MenuPrincipal() {
        mostrarMenu();}

    private void mostrarMenu() {
        int menu;

        do {
            System.out.println("---- Gestor de Autores/Libros/Usuarios/Prestamos ----\n1. Autores\n2. Libros\n3. Usuarios.\n4. Prestamos.\n5. Relaciones Autores y Libros.\n6. Cerrar programa");
            menu = sc.nextInt();

            switch (menu) {
                case 1 -> {
                    menuAutores.showMenuAuthor();
                }

                case 2 -> {
                    menuLibros.showMenuLibros();
                }

                case 3 -> {
                    menuPrestamo.mostrarMenuPrestamo();
                }

                case 4 -> {
                    menuUsuario.mostrarMenuUsuario();
                }

                case 5 -> {
                    menuAutoresLibros.showMenuAuthorBook();
                }

                case 6 -> System.out.println("Cerrando programa..");

                default -> System.out.println("Opcion no valida.");
            }
        } while(menu!= 6);
    }
}