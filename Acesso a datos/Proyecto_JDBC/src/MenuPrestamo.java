public class MenuPrestamo {
    private GestionPrestamo gestionPrestamo;
    private Scanner sc;

    public MenuPrestamo() {
        gestionPrestamo = new GestionPrestamo();
        sc = new Scanner(System.in);
    }

    public void mostrarMenuPrestamo() {
        int opcion = 0;

        do {
            System.out.println("\n--- Menú de Gestión de Préstamos ---");
            System.out.println("1. Crear Préstamo");
            System.out.println("2. Leer Préstamo");
            System.out.println("3. Eliminar Préstamo");
            System.out.println("4. Mostrar Todos los Préstamos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearPrestamo();
                    break;
                case 2:
                    leerPrestamo();
                    break;
                case 3:
                    eliminarPrestamo();
                    break;
                case 4:
                    mostrarTodosLosPrestamos();
                    break;
                case 5:
                    System.out.println("Saliendo del menú de préstamos...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);
    }

    // Metodo crear Prestamo
    private void crearPrestamo() {
        System.out.print("Ingrese el ID del usuario: ");
        int idUsuario = sc.nextInt();
        System.out.print("Ingrese el ID del libro: ");
        int idLibro = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
        String fechaInicio = sc.nextLine();
        System.out.print("Ingrese la fecha de fin (YYYY-MM-DD): ");
        String fechaFin = sc.nextLine();

        Prestamo nuevoPrestamo = new Prestamo(0, fechaInicio, fechaFin, idUsuario, idLibro);
        if (gestionPrestamo.insertPrestamo(nuevoPrestamo) == 1) {
            System.out.println("Préstamo creado exitosamente.");
        } else {
            System.out.println("Error al crear el préstamo.");
        }
    }

    // Metodo leer Prestamo
    private void leerPrestamo() {
        System.out.print("Ingrese el ID del préstamo a buscar: ");
        int idPrestamo = sc.nextInt();
        sc.nextLine();

        Prestamo prestamo = gestionPrestamo.leerPrestamosId(idPrestamo);
        if (prestamo != null) {
            System.out.println("Préstamo encontrado:");
            System.out.println("Usuario ID: " + prestamo.getUsuario().getIdUsario());
            System.out.println("Libro ID: " + prestamo.getLibro().getIdLibro());
            System.out.println("Fecha de inicio: " + prestamo.getFechaInicio());
            System.out.println("Fecha de fin: " + prestamo.getFechaFin());
        } else {
            System.out.println("Préstamo no encontrado.");
        }
    }

    // Metodo eliminar Prestamo
    private void eliminarPrestamo() {
        System.out.print("Ingrese el ID del préstamo a eliminar: ");
        int idPrestamo = sc.nextInt();
        sc.nextLine(); // Limpia la entrada

        Prestamo prestamo = gestionPrestamo.leerPrestamosId(idPrestamo);
        if (prestamo != null && gestionPrestamo.deletePrestamo(prestamo) == 1) {
            System.out.println("Préstamo eliminado exitosamente.");
        } else {
            System.out.println("Error al eliminar el préstamo.");
        }
    }

    // Método para mostrar todos los préstamos
    private void mostrarTodosLosPrestamos() {
        System.out.println("\nLista de Préstamos:");
        for (Prestamo prestamo : gestionPrestamo.leerPrestamos()) {
            System.out.println("ID: " + prestamo.getIdPrestamo() +
                    ", Usuario ID: " + prestamo.getUsuario().getIdUsario() +
                    ", Libro ID: " + prestamo.getLibro().getIdLibro() +
                    ", Fecha de Inicio: " + prestamo.getFechaInicio() +
                    ", Fecha de Fin: " + prestamo.getFechaFin());
        }
    }
}
