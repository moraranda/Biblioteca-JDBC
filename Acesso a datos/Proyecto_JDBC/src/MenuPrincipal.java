package org.example;

import java.util.Scanner;

public class MenuPrincipal {
    MenuAutores menuAutores = new MenuAutores();
    MenuLibros menuLibros = new MenuLibros();

    Scanner sc = new Scanner(System.in);
    public MenuPrincipal() {
        mostrarMenu();}

    private void mostrarMenu() {
        int menu;

        do {
            System.out.println("---- Gestor de Autores/Libros/Usuarios/Prestamos ----\n1. Autores\n2. Libros\n3. Usuarios.\n4. Prestamos\n5. Cerrar programa");
            menu = sc.nextInt();

            switch (menu) {
                case 1 -> {
                    menuAutores.showMenuAuthor();
                }

                case 2 -> {
                    menuLibros.showMenuLibros();
                }

                case 3 -> {
                    System.out.println("aa");
                }

                case 4 -> {
                    System.out.println("bb");
                }

                case 5 -> System.out.println("Cerrando programa..");

                default -> System.out.println("Opcion no valida.");
            }
        } while(menu!= 5);
    }
}