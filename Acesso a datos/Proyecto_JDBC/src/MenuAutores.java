package org.example;

import java.util.List;
import java.util.Scanner;

public class MenuAutores {
    private GestorAutores gestorAutores;
    private Scanner sc;

    public MenuAutores() {
        gestorAutores = new GestorAutores();
        sc = new Scanner(System.in);}

    public void showMenuAuthor() {
        int op = 0;

        do {
            System.out.println("--- Menu Autores ---\n1.- Insertar autor.\n2.- Leer autor.\n3.- Modificar autor.\n4.- Eliminar autor.\n5.- Mostrar todos los autores.\n6.- Volver al menú principal.");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.println("Escribe el nombre del autor: ");
                    String nombreAutor = sc.nextLine();

                    Autor nuevoAutor = new Autor(nombreAutor);
                    if(gestorAutores.insertarAutores(nuevoAutor) == 1) {
                        System.out.println("Autor insertado correctamente.");

                    } else {
                        System.out.println("Error al insertar el autor.");
                    }
                }

                case 2 -> {
                    System.out.println("Escribe el nombre del autor: ");
                    int idAutor = sc.nextInt();
                    sc.nextLine();

                    Autor autor = gestorAutores.obtenerAutor(idAutor);
                    if(autor != null) {
                        System.out.println("Autor encontrado.");
                        System.out.println("Autor " + autor.getIdAutor() + " [ Nombre del autor: " + autor.getNombreAutor() + " ]");

                    } else {
                        System.out.println("Autor no encontrado.");
                    }
                }

                case 3 -> {
                    List<Autor> autoresListados = gestorAutores.obtenerAutores();
                    if(autoresListados.isEmpty()) {
                        System.out.println("No hay autores en la base de datos.");

                    } else {
                        for(Autor autor : autoresListados) {
                            System.out.println(autor);}}

                    System.out.println("Escribe el ID del autor que quieres modificar: ");
                    int idAutorModificar = sc.nextInt();
                    sc.nextLine();

                    Autor aMod = null;
                    for(Autor autor : autoresListados) {
                        if(autor.getIdAutor() == idAutorModificar) {
                            aMod = autor;
                            break;}}

                    if(aMod != null) {
                        System.out.println("Escribe el nuevo nombre (ACTUAL: " + aMod.getNombreAutor() + "):");
                        String nombreAutor = sc.nextLine();
                        Autor autorActualizado = new Autor(nombreAutor);

                        if(gestorAutores.actualizarAutores(autorActualizado) == 1) {
                            System.out.println("Autor insertado correctamente.");

                        } else {
                            System.out.println("Error al modificar el autor.");
                        }

                    } else {
                        System.out.println("No se ha encontrado ningun autor con el ID " + idAutorModificar + ".");
                    }
                }

                case 4 -> {
                    List<Autor> autoresListados = gestorAutores.obtenerAutores();
                    if(autoresListados.isEmpty()) {
                        System.out.println("No hay autores en la base de datos.");

                    } else {
                        for(Autor autor : autoresListados) {
                            System.out.println(autor);}}

                    System.out.println("Escribe el ID del autor que quieres eliminar: ");
                    int idAutorEliminar = sc.nextInt();
                    sc.nextLine();

                    Autor autor = gestorAutores.obtenerAutor(idAutorEliminar);
                    if(autor != null && gestorAutores.eliminarAutores(autor) == 1) {
                        System.out.println("Autor eliminado correctamente.");

                    } else {
                        System.out.println("Error al eliminar el autor.");
                    }
                }

                case 5 -> {
                    System.out.println("A U T O R E S");
                    for(Autor autor : gestorAutores.obtenerAutores()) {
                        System.out.println("Autor " + autor.getIdAutor() + " [ Nombre: " + autor.getNombreAutor() + " ]");

                    }
                }

                case 6 -> System.out.println("Volviendo al menú principal..");

                default -> System.out.println("Opcion invalida.");
            }
        }  while (op != 6);
    }
}