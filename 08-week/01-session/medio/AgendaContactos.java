import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Agenda de Contactos - Ejemplo de Map en Java
 * 
 * Map: Almacena pares clave-valor
 *   - Clave: Nombre (String)
 *   - Valor: Telefono (String)
 */
public class AgendaContactos {

    // Limpiar consola Windows
    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.print("\n".repeat(50));
        }
    }

    // Pausar hasta Enter
    public static void pausa(Scanner sc) {
        System.out.print("\nEnter para continuar...");
        sc.nextLine();
    }

    public static void main(String[] args) {
        
        // Crear el Map
        Map<String, String> agenda = new HashMap<>();
        
        // Scanner para entrada de datos
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            cls();
            
            // Menu
            System.out.println("=== AGENDA DE CONTACTOS ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Ver todos");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            cls();
            
            switch (opcion) {
                
                case 1: // AGREGAR - put()
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = sc.nextLine();
                    
                    agenda.put(nombre, telefono);
                    System.out.println("Contacto agregado!");
                    pausa(sc);
                    break;
                    
                case 2: // BUSCAR - get()
                    System.out.print("Nombre a buscar: ");
                    String buscar = sc.nextLine();
                    
                    if (agenda.containsKey(buscar)) {
                        System.out.println("Telefono: " + agenda.get(buscar));
                    } else {
                        System.out.println("No encontrado");
                    }
                    pausa(sc);
                    break;
                    
                case 3: // ELIMINAR - remove()
                    System.out.print("Nombre a eliminar: ");
                    String eliminar = sc.nextLine();
                    
                    if (agenda.containsKey(eliminar)) {
                        agenda.remove(eliminar);
                        System.out.println("Eliminado!");
                    } else {
                        System.out.println("No encontrado");
                    }
                    pausa(sc);
                    break;
                    
                case 4: // VER TODOS - entrySet()
                    if (agenda.isEmpty()) {
                        System.out.println("Agenda vacia");
                    } else {
                        System.out.println("--- Contactos ---");
                        for (Map.Entry<String, String> c : agenda.entrySet()) {
                            System.out.println(c.getKey() + " : " + c.getValue());
                        }
                    }
                    pausa(sc);
                    break;
                    
                case 5:
                    System.out.println("Adios!");
                    break;
                    
                default:
                    System.out.println("Opcion invalida");
                    pausa(sc);
            }
            
        } while (opcion != 5);
        
        sc.close();
    }
}
