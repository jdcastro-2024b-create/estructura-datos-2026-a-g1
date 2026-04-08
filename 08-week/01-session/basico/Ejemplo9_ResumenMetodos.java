package basico;

import java.util.HashMap;

/**
 * RESUMEN: Todos los metodos de HashMap
 */
public class Ejemplo9_ResumenMetodos {

    public static void main(String[] args) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // ========================================
        // AGREGAR / ACTUALIZAR
        // ========================================
        map.put("A", 1);        // Agregar
        map.put("B", 2);
        map.put("A", 10);       // Actualizar (clave existente)
        
        // ========================================
        // OBTENER
        // ========================================
        int valor = map.get("A");           // Obtener valor
        int valorODefault = map.getOrDefault("X", 0);  // Valor o default
        
        // ========================================
        // VERIFICAR
        // ========================================
        boolean existeClave = map.containsKey("A");    // Existe clave?
        boolean existeValor = map.containsValue(10);   // Existe valor?
        boolean vacio = map.isEmpty();                  // Esta vacio?
        int cantidad = map.size();                      // Cantidad
        
        // ========================================
        // ELIMINAR
        // ========================================
        map.remove("B");        // Eliminar por clave
        // map.clear();         // Eliminar todo
        
        // ========================================
        // RECORRER
        // ========================================
        for (String clave : map.keySet()) {
            System.out.println(clave + " = " + map.get(clave));
        }
        
        // ========================================
        System.out.println("\nMap final: " + map);
    }
}
