import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Barco barco = new Barco(2, 3); // 2 filas y 3 columnas
        System.out.println("Bienvenido al simulador de barco.");
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar tripulante");
            System.out.println("2. Buscar tripulante por rol");
            System.out.println("3. Mostrar todos los tripulantes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    if (barco.estaLleno()) {
                        System.out.println("El barco está lleno, no se pueden agregar más tripulantes.");
                        break;
                    }
                    System.out.print("Ingrese el nombre del tripulante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el rol del tripulante: ");
                    String rol = scanner.nextLine();
                    Tripulante t = new Tripulante(nombre, rol);
                    barco.agregarTripulante(t);
                    break;

                case 2:
                    System.out.print("Ingrese el rol que desea buscar: ");
                    String rolBuscado = scanner.nextLine();
                    barco.buscarPorRol(rolBuscado);
                    break;

                case 3:
                    barco.mostrarTripulantes();
                    break;

                case 4:
                    System.out.println("¡Saliendo del simulador!");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);

        scanner.close();
    }

}
