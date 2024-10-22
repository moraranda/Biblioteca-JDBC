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
            System.out.println("--- Menu Autores/Libros ---\n1.- Insertar relación.\n2.- Leer relaciones.\n3.- Modificar autor.");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> {System.out.print("Escribe el ID del autor: ");
                    int idAutor = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer

                    System.out.print("Escribe el ID del libro: ");
                    int idLibro = sc.nextInt();
                    sc.nextLine();

                    Autor autor = new Autor(idAutor, "");
                    Libro libro = new Libro(idLibro, "");

                    int resultado = gestorAutoresLibros.insertarAutorLibro(autor, libro);
                    if (resultado == 1) {
                        System.out.println("Relación insertada correctamente entre autor y libro.");
                    } else {
                        System.out.println("Error al insertar la relación.");
                    }
                }

                case 2 -> {private void leerRelaciones() {
                    List<AutorLibro> relaciones = gestorAutoresLibros.obtenerAutoresLibros();
                    if (relaciones.isEmpty()) {
                        System.out.println("No hay relaciones de autores y libros registradas.");
                    } else {
                        System.out.println("--- Relaciones de Autores y Libros ---");
                        for (AutorLibro autorLibro : relaciones) {
                            System.out.println("Autor ID: " + autorLibro.getIdAutor() + ", Libro ID: " + autorLibro.getIdLibro());
                        }
                    }
                }
                }

                case 3 -> System.out.println("Volviendo al menú principal..");

                default -> System.out.println("Opcion invalida.");
            }
        }  while (op != 3);
    }
}