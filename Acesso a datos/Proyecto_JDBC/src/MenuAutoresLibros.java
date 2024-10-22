import java.util.List;
import java.util.Scanner;

public class MenuAutoresLibros {
    private GestorAutoresLibros gestorAutoresLibros;
    private Scanner sc;

    public MenuAutoresLibros() {
        gestorAutoresLibros = new GestorAutoresLibros();
        sc = new Scanner(System.in);}

    public void showMenuAuthorBook() {
        int op = 0;

        do {
            System.out.println("--- Menu Relaciones Autor/Libro ---\n1.- Insertar relacion.\n2.- Leer relaciones.\n3.- Volver al menú principal.");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Escribe el ID del autor: ");
                    int idAutor = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Escribe el ID del libro: ");
                    int idLibro = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer

                    Autor autor = new Autor(idAutor);
                    Libro libro = new Libro(idLibro);

                    int resultado = gestorAutoresLibros.insertarAutorLibro(autor, libro);
                    if (resultado == 1) {
                        System.out.println("Relación insertada correctamente entre autor y libro.");
                    } else {
                        System.out.println("Error al insertar la relación.");
                    }
                }

                case 2 -> {
                    System.out.print("Escribe el ID del autor: ");
                    int idAutor = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Escribe el ID del libro: ");
                    int idLibro = sc.nextInt();
                    sc.nextLine();

                    Autor autor = new Autor(idAutor);
                    Libro libro = new Libro(idLibro);

                    int resultado = gestorAutoresLibros.insertarAutorLibro(autor, libro);
                    if (resultado == 1) {
                        System.out.println("Relación insertada correctamente entre autor y libro.");
                    } else {
                        System.out.println("Error al insertar la relación.");
                    }
                }

                case 3 -> System.out.println("Saliendo del menú...");

                default -> System.out.println("Opción inválida. Por favor, selecciona otra opción.");
            }
        } while (op != 3);
    }
}