package Vista;
import java.util.Scanner;
import Controlador.GestionLenguaje;
import Modelo.LenguajeProgramacion;


public class SistemaRegistro {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GestionLenguaje gestion = new GestionLenguaje();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int opcion;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Agregar Lenguaje de Programacion");
            System.out.println("2. Buscar Lenguaje de Programacion");
            System.out.println("3. Eliminar Lenguaje de Programacion");
            System.out.println("4. Mostrar Todos los Lenguajes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarLenguaje();
                    break;
                case 2:
                    buscarLenguaje();
                    break;
                case 3:
                    eliminarLenguaje();
                    break;
                case 4:
                    mostrarLenguajes();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 5);
    }

    private static void agregarLenguaje() {
        System.out.print("Anio de Creacion: ");
        int anioCreacion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Caracteristica Principal: ");
        String caracteristicaPrincipal = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Utilizacion: ");
        String utilizacion = scanner.nextLine();

        gestion.agregarLenguaje(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
    }

    private static void buscarLenguaje() {
        System.out.print("Nombre del Lenguaje: ");
        String nombre = scanner.nextLine();

        LenguajeProgramacion lenguaje = gestion.buscarLenguaje(nombre);
        if (lenguaje != null) {
            System.out.println("Lenguaje encontrado: " + lenguaje);
        } else {
            System.out.println("Lenguaje no encontrado");
        }
    }

    private static void eliminarLenguaje() {
        System.out.print("Nombre del Lenguaje a Eliminar: ");
        String nombre = scanner.nextLine();

        boolean resultado = gestion.eliminarLenguaje(nombre);
        if (resultado) {
            System.out.println("Lenguaje eliminado correctamente");
        } else {
            System.out.println("Lenguaje no encontrado");
        }
    }

    private static void mostrarLenguajes() {
        gestion.imprimirLenguajes();
        
}
}