package basico;

import java.util.HashMap;
import java.util.Scanner;

/**
 * EJEMPLO 8: Entrada de datos por consola
 */
public class Ejemplo8_ConScanner {

    public static void main(String[] args) {
        
        HashMap<String, Integer> edades = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        
        // Pedir 3 personas
        for (int i = 1; i <= 3; i++) {
            System.out.println("--- Persona " + i + " ---");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            sc.nextLine(); // limpiar buffer
            
            edades.put(nombre, edad);
            System.out.println();
        }
        
        // Mostrar resultados
        System.out.println("=== PERSONAS REGISTRADAS ===");
        for (String nombre : edades.keySet()) {
            System.out.println(nombre + " tiene " + edades.get(nombre) + " anios");
        }
        
        sc.close();
    }
}
