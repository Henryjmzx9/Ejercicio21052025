public class Barco {
  private Tripulante[][] tripulantes;
    private int filas;
    private int columnas;
    private int ocupados;

    public Barco(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.tripulantes = new Tripulante[filas][columnas];
        this.ocupados = 0;
    }

    public boolean agregarTripulante(Tripulante t) {
        if (ocupados >= filas * columnas) {
            System.out.println("El barco ya está lleno.");
            return false;
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tripulantes[i][j] == null) {
                    tripulantes[i][j] = t;
                    ocupados++;
                    System.out.println("Tripulante agregado en posición: [" + i + "][" + j + "]");
                    return true;
                }
            }
        }
        return false;
    }

    public void buscarPorRol(String rol) {
        boolean encontrado = false;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Tripulante t = tripulantes[i][j];
                if (t != null && t.getRol().equalsIgnoreCase(rol)) {
                    System.out.println("Tripulante: " + t.getNombre() + " en posición [" + i + "][" + j + "]");
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún tripulante con el rol: " + rol);
        }
    }

    public void mostrarTripulantes() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tripulantes[i][j] != null) {
                    System.out.println("Posición [" + i + "][" + j + "] - Nombre: " 
                        + tripulantes[i][j].getNombre() + " | Rol: " + tripulantes[i][j].getRol());
                }
            }
        }
    }

    public boolean estaLleno() {
        return ocupados >= filas * columnas;
    }
}
