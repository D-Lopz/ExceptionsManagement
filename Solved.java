import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solved {
    public static void main(String[] args) {

        // Intentamos trabajar con un archivo que puede no existir
        try {
            File archivo = new File("archivo_no_existente.txt");

            // Revisamos si el archivo realmente está ahí
            if (archivo.exists()) {
                FileReader lector = new FileReader(archivo);

            } else {
                System.out.println("Ups, the file you´re trying to in isn't available.");
            }

        } catch (IOException e) {
            // Capturamos cualquier problema al manejar el archivo (por ejemplo, si no se puede abrir o que simplemente no exista)
            System.out.println("File error occurred: " + e);
        }

        // Ahora vamos a manejar una posible división por cero de forma segura
        try {
            int divisor = 2; // Cambiamos el cero por otro número para evitar el caos

            int resultado = 10 / divisor;
            System.out.println("All good, Result: " + resultado);

        } catch (ArithmeticException e) {
            // Esto atraparía un error si intentáramos dividir por cero (aunque aquí no pasa)
            System.out.println("Math error: " + e);

        }

        // Simulamos una carga de memoria pero controlada para evitar un OutOfMemoryError

        List<int[]> lista = new ArrayList<>();

        for (int i = 0; i < 5; i++) { // Solo creamos 5 arrays grandes
            lista.add(new int[1000000]); // Cada array tiene 1000000 de posiciones

        }

        // Llamamos a un método recursivo adaptado
        stopResource(0);

    }

    // Método recursivo con tope para evitar StackOverflowError
    public static void stopResource(int contador) {

        if (contador >= 1000) return; // Condición para detener la recursión antes del desastre
        stopResource(contador + 1);

    }
}
