import java.util.HashMap;
import java.util.Scanner;

/**
 * TABLA HASH (HashMap) - Diccionario de Palabras
 * 
 * Una tabla hash almacena datos usando una CLAVE unica
 * para acceder rapidamente al VALOR.
 * 
 * Ejemplo: Diccionario
 *   Clave  -> Valor
 *   "hola" -> "saludo en espanol"
 *   "bye"  -> "despedida en ingles"
 */
public class TablaHashEjemplo {

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.print("\n".repeat(50));
        }
    }

    public static void pausa(Scanner sc) {
        System.out.print("\nEnter para continuar...");
        sc.nextLine();
    }

    public static void main(String[] args) {
        
        // CREAR TABLA HASH
        // HashMap<TipoClave, TipoValor>
        HashMap<String, String> diccionario = new HashMap<>();
        
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            cls();
            System.out.println("=== DICCIONARIO (Tabla Hash) ===");
            System.out.println("1. Agregar palabra");
            System.out.println("2. Buscar significado");
            System.out.println("3. Modificar significado");
            System.out.println("4. Eliminar palabra");
            System.out.println("5. Ver todo el diccionario");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            cls();
            
            switch (opcion) {
                
                case 1: // AGREGAR - put(clave, valor)
                    System.out.println("--- AGREGAR PALABRA ---");
                    System.out.print("Palabra: ");
                    String palabra = sc.nextLine();
                    System.out.print("Significado: ");
                    String significado = sc.nextLine();
                    
                    // put() agrega o reemplaza si ya existe
                    diccionario.put(palabra, significado);
                    System.out.println("Agregado!");
                    pausa(sc);
                    break;
                    
                case 2: // BUSCAR - get(clave)
                    System.out.println("--- BUSCAR PALABRA ---");
                    System.out.print("Palabra a buscar: ");
                    String buscar = sc.nextLine();
                    
                    // get() retorna el valor o null si no existe
                    String resultado = diccionario.get(buscar);
                    
                    if (resultado != null) {
                        System.out.println("Significado: " + resultado);
                    } else {
                        System.out.println("No existe en el diccionario");
                    }
                    pausa(sc);
                    break;
                    
                case 3: // MODIFICAR - put() con clave existente
                    System.out.println("--- MODIFICAR PALABRA ---");
                    System.out.print("Palabra a modificar: ");
                    String modificar = sc.nextLine();
                    
                    // containsKey() verifica si existe la clave
                    if (diccionario.containsKey(modificar)) {
                        System.out.println("Significado actual: " + diccionario.get(modificar));
                        System.out.print("Nuevo significado: ");
                        String nuevo = sc.nextLine();
                        diccionario.put(modificar, nuevo);
                        System.out.println("Modificado!");
                    } else {
                        System.out.println("No existe esa palabra");
                    }
                    pausa(sc);
                    break;
                    
                case 4: // ELIMINAR - remove(clave)
                    System.out.println("--- ELIMINAR PALABRA ---");
                    System.out.print("Palabra a eliminar: ");
                    String eliminar = sc.nextLine();
                    
                    // remove() elimina y retorna el valor eliminado
                    String eliminado = diccionario.remove(eliminar);
                    
                    if (eliminado != null) {
                        System.out.println("Eliminado: " + eliminar + " -> " + eliminado);
                    } else {
                        System.out.println("No existe esa palabra");
                    }
                    pausa(sc);
                    break;
                    
                case 5: // VER TODO - size(), keySet(), entrySet()
                    System.out.println("--- DICCIONARIO COMPLETO ---");
                    
                    // isEmpty() verifica si esta vacio
                    if (diccionario.isEmpty()) {
                        System.out.println("El diccionario esta vacio");
                    } else {
                        // size() retorna cantidad de elementos
                        System.out.println("Total palabras: " + diccionario.size());
                        System.out.println();
                        
                        // Recorrer con keySet() (solo claves)
                        for (String clave : diccionario.keySet()) {
                            System.out.println(clave + " -> " + diccionario.get(clave));
                        }
                    }
                    pausa(sc);
                    break;
                    
                case 6:
                    System.out.println("Adios!");
                    break;
                    
                default:
                    System.out.println("Opcion invalida");
                    pausa(sc);
            }
            
        } while (opcion != 6);
        
        sc.close();
    }
}

/*
 * RESUMEN DE METODOS DE TABLA HASH (HashMap):
 * 
 * put(clave, valor)    -> Agregar o actualizar
 * get(clave)           -> Obtener valor (null si no existe)
 * remove(clave)        -> Eliminar y retorna valor
 * containsKey(clave)   -> Existe la clave? (true/false)
 * containsValue(valor) -> Existe el valor? (true/false)
 * size()               -> Cantidad de elementos
 * isEmpty()            -> Esta vacio? (true/false)
 * clear()              -> Eliminar todo
 * keySet()             -> Conjunto de claves (para recorrer)
 * values()             -> Coleccion de valores
 * entrySet()           -> Conjunto de pares clave-valor
 */
