import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Ejemplo básico de Map en Java
 * Muestra las diferentes operaciones disponibles
 */
public class OcjectMap {
    
    public static void main(String[] args) {
        
        System.out.println("========================================");
        System.out.println("   EJEMPLO DE MAP EN JAVA");
        System.out.println("========================================\n");
        
        // =============================================
        // 1. CREAR UN MAP
        // =============================================
        System.out.println("1. CREAR UN MAP");
        System.out.println("-----------------------------------------");
        
        // HashMap - No mantiene orden
        Map<String, Integer> edades = new HashMap<>();
        System.out.println("HashMap creado: " + edades);
        
        // =============================================
        // 2. AGREGAR ELEMENTOS - put()
        // =============================================
        System.out.println("\n2. AGREGAR ELEMENTOS - put()");
        System.out.println("-----------------------------------------");
        
        edades.put("Juan", 25);
        edades.put("María", 30);
        edades.put("Pedro", 22);
        edades.put("Ana", 28);
        edades.put("Carlos", 35);
        
        System.out.println("Elementos agregados:");
        System.out.println("Map actual: " + edades);
        
        // =============================================
        // 3. OBTENER UN VALOR - get()
        // =============================================
        System.out.println("\n3. OBTENER UN VALOR - get()");
        System.out.println("-----------------------------------------");
        
        int edadJuan = edades.get("Juan");
        System.out.println("Edad de Juan: " + edadJuan);
        
        Integer edadDesconocido = edades.get("Roberto");
        System.out.println("Edad de Roberto (no existe): " + edadDesconocido);
        
        // =============================================
        // 4. VERIFICAR SI EXISTE - containsKey() / containsValue()
        // =============================================
        System.out.println("\n4. VERIFICAR SI EXISTE - containsKey() / containsValue()");
        System.out.println("-----------------------------------------");
        
        boolean existeJuan = edades.containsKey("Juan");
        System.out.println("¿Existe la clave 'Juan'? " + existeJuan);
        
        boolean existeLuis = edades.containsKey("Luis");
        System.out.println("¿Existe la clave 'Luis'? " + existeLuis);
        
        boolean existeEdad30 = edades.containsValue(30);
        System.out.println("¿Existe el valor 30? " + existeEdad30);
        
        // =============================================
        // 5. TAMAÑO DEL MAP - size()
        // =============================================
        System.out.println("\n5. TAMAÑO DEL MAP - size()");
        System.out.println("-----------------------------------------");
        
        int tamanio = edades.size();
        System.out.println("Cantidad de elementos: " + tamanio);
        
        // =============================================
        // 6. ACTUALIZAR UN VALOR - put() con clave existente
        // =============================================
        System.out.println("\n6. ACTUALIZAR UN VALOR - put() con clave existente");
        System.out.println("-----------------------------------------");
        
        System.out.println("Edad actual de Juan: " + edades.get("Juan"));
        edades.put("Juan", 26); // Actualiza el valor
        System.out.println("Nueva edad de Juan: " + edades.get("Juan"));
        
        // =============================================
        // 7. ELIMINAR UN ELEMENTO - remove()
        // =============================================
        System.out.println("\n7. ELIMINAR UN ELEMENTO - remove()");
        System.out.println("-----------------------------------------");
        
        System.out.println("Map antes de eliminar: " + edades);
        Integer edadEliminada = edades.remove("Pedro");
        System.out.println("Edad eliminada de Pedro: " + edadEliminada);
        System.out.println("Map después de eliminar: " + edades);
        
        // =============================================
        // 8. RECORRER UN MAP
        // =============================================
        System.out.println("\n8. RECORRER UN MAP");
        System.out.println("-----------------------------------------");
        
        // Forma 1: Usando entrySet()
        System.out.println("\nUsando entrySet():");
        for (Map.Entry<String, Integer> entrada : edades.entrySet()) {
            System.out.println("  " + entrada.getKey() + " -> " + entrada.getValue());
        }
        
        // Forma 2: Usando keySet()
        System.out.println("\nUsando keySet():");
        for (String nombre : edades.keySet()) {
            System.out.println("  " + nombre + " -> " + edades.get(nombre));
        }
        
        // Forma 3: Usando values()
        System.out.println("\nUsando values() (solo valores):");
        for (Integer edad : edades.values()) {
            System.out.println("  Edad: " + edad);
        }
        
        // Forma 4: Usando forEach con lambda
        System.out.println("\nUsando forEach con lambda:");
        edades.forEach((nombre, edad) -> 
            System.out.println("  " + nombre + " tiene " + edad + " años")
        );
        
        // =============================================
        // 9. OTRAS OPERACIONES ÚTILES
        // =============================================
        System.out.println("\n9. OTRAS OPERACIONES ÚTILES");
        System.out.println("-----------------------------------------");
        
        // isEmpty() - verificar si está vacío
        System.out.println("¿Está vacío? " + edades.isEmpty());
        
        // getOrDefault() - obtener con valor por defecto
        int edadLuis = edades.getOrDefault("Luis", 0);
        System.out.println("Edad de Luis (con default 0): " + edadLuis);
        
        // putIfAbsent() - agregar solo si no existe
        edades.putIfAbsent("María", 99); // No cambia porque María ya existe
        edades.putIfAbsent("Luis", 40);  // Agrega porque Luis no existe
        System.out.println("Map después de putIfAbsent: " + edades);
        
        // replace() - reemplazar valor
        edades.replace("Luis", 41);
        System.out.println("Edad de Luis después de replace: " + edades.get("Luis"));
        
        // =============================================
        // 10. TIPOS DE MAP
        // =============================================
        System.out.println("\n10. TIPOS DE MAP");
        System.out.println("-----------------------------------------");
        
        // HashMap - No mantiene orden de inserción
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("C", "Tercero");
        hashMap.put("A", "Primero");
        hashMap.put("B", "Segundo");
        System.out.println("HashMap (sin orden): " + hashMap);
        
        // LinkedHashMap - Mantiene orden de inserción
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("C", "Tercero");
        linkedHashMap.put("A", "Primero");
        linkedHashMap.put("B", "Segundo");
        System.out.println("LinkedHashMap (orden inserción): " + linkedHashMap);
        
        // TreeMap - Ordena por clave
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("C", "Tercero");
        treeMap.put("A", "Primero");
        treeMap.put("B", "Segundo");
        System.out.println("TreeMap (orden alfabético): " + treeMap);
        
        // =============================================
        // 11. LIMPIAR EL MAP - clear()
        // =============================================
        System.out.println("\n11. LIMPIAR EL MAP - clear()");
        System.out.println("-----------------------------------------");
        
        System.out.println("Map antes de limpiar: " + edades);
        edades.clear();
        System.out.println("Map después de limpiar: " + edades);
        System.out.println("¿Está vacío ahora? " + edades.isEmpty());
        
        System.out.println("\n========================================");
        System.out.println("   FIN DEL EJEMPLO");
        System.out.println("========================================");
    }
}
