package org.example;

import java.util.List;
import java.util.Scanner;

public class MenuLibros {
    private GestorLibros gestorLibros;
    private Scanner sc;

    public MenuLibros() {
        gestorLibros = new GestorLibros();
        sc = new Scanner(System.in);}

    public void showMenuLibros() {
        int op = 0;

        do {
            System.out.println("--- Menu Libros ---\n1.- Insertar libro.\n2.- Leer libro.\n3.- Modificar libro.\n4.- Eliminar libro.\n5.- Mostrar todos los libros.\n6.- Volver al menú principal.");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.println("Escribe el título del libro:");
                    String tituloLibro = sc.nextLine();

                    System.out.println("Escribe el ISBN del libro:");
                    String isbnLibro = sc.nextLine();

                    Libro nuevoLibro = new Libro(tituloLibro, isbnLibro);
                    if(gestorLibros.eliminarLibro(nuevoLibro) == 1) {
                        System.out.println("Libro insertado correctamente.");

                    } else {
                        System.out.println("Error al insertar el libro.");
                    }
                }

                case 2 -> {
                    System.out.println("Escribe el nombre del libro:");
                    String tituloLibro = sc.nextLine();
                    sc.nextLine();

                    Libro libro = gestorLibros.obtenerLibro(tituloLibro);
                    if(libro != null) {
                        System.out.println("Libro encontrado.");
                        System.out.println("Libro " + libro.getIdLibro() + " [ Título del libro: " + libro.getTituloLibro() + ", ISBN: " + libro.getIsbn() + " ]");

                    } else {
                        System.out.println("Error al obtener el libro.");
                    }
                }

                case 3 -> {
                    List<Libro> librosListados = gestorLibros.obtenerLibros();
                    if(librosListados.isEmpty()) {
                        System.out.println("No hay libros en la base de datos.");

                    } else {
                        for(Libro libro : librosListados) {
                            System.out.println(libro);}}

                    System.out.println("Escribe el ID del libro que quieras modificar:");
                    int idLibroModificar = sc.nextInt();
                    sc.nextLine();

                    Libro lMod = null;
                    for(Libro libro : librosListados) {
                        if(libro.getIdLibro() == idLibroModificar) {
                            lMod = libro;
                            break;}}

                    if(lMod != null) {
                        System.out.println("Escribe el nuevo título (ACTUAL: " + lMod.getTituloLibro() + "):");
                        String tituloLibro = sc.nextLine();

                        System.out.println("Escribe el nuevo ISBN (ACTUAL: " + lMod.getIsbn() + "):");
                        String isbnLibro = sc.nextLine();
                        Libro libroActualizado = new Libro(tituloLibro, isbnLibro);

                        if(gestorLibros.actualizarLibros(libroActualizado) == 1) {
                            System.out.println("Libro actualizado correctamente.");

                        } else {
                            System.out.println("Error al modificar el libro.");
                        }

                    } else {
                        System.out.println("No se ha encontrado ningún libro con el ID " + idLibroModificar + ".");
                    }
                }

                case 4 -> {
                    List<Libro> librosListados = gestorLibros.obtenerLibros();
                    if(librosListados.isEmpty()) {
                        System.out.println("No hay libros en la base de datos.");

                    } else {
                        for(Libro libro : librosListados) {
                            System.out.println(libro);}}

                    System.out.println("Escribe el título del libro que quieras eliminar: ");
                    String tituloLibroEliminar = sc.nextLine();
                    sc.nextLine();

                    Libro libro = gestorLibros.obtenerLibro(tituloLibroEliminar);
                    if(libro != null && gestorLibros.eliminarLibro(libro) == 1) {
                        System.out.println("Libro eliminado correctamente.");

                    } else {
                        System.out.println("Error al eliminar el libro.");
                    }
                }

                case 5 -> {
                    System.out.println("L I B R O S");
                    for(Libro libro : gestorLibros.obtenerLibros()) {
                        System.out.println("Libro " + libro.getIdLibro() + " [ Título del libro: " + libro.getTituloLibro() + ", ISBN: " + libro.getIsbn() + " ]");
                    }
                }

                case 6 -> System.out.println("Volviendo al menú principal..");

                default -> System.out.println("Opción invalida.");
            }
        } while(op != 6);
    }
}