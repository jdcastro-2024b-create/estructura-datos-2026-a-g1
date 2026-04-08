package basico;

import java.util.HashMap;

/**
 * EJEMPLO 7: Metodos utiles - size(), isEmpty(), clear()
 */
public class Ejemplo7_MetodosUtiles {

    public static void main(String[] args) {
        
        HashMap<String, String> colores = new HashMap<>();
        
        // isEmpty() - verifica si esta vacio
        System.out.println("Esta vacio? " + colores.isEmpty());
        
        // Agregar elementos
        colores.put("rojo", "#FF0000");
        colores.put("verde", "#00FF00");
        colores.put("azul", "#0000FF");
        
        System.out.println("Esta vacio? " + colores.isEmpty());
        
        // size() - obtener cantidad de elementos
        System.out.println("Cantidad de colores: " + colores.size());
        
        System.out.println("Map: " + colores);
        
        // clear() - borrar todo
        colores.clear();
        System.out.println("\nDespues de clear():");
        System.out.println("Map: " + colores);
        System.out.println("Esta vacio? " + colores.isEmpty());
        System.out.println("Cantidad: " + colores.size());
    }
}

/*
 * SALIDA:
 * Esta vacio? true
 * Esta vacio? false
 * Cantidad de colores: 3
 * Map: {rojo=#FF0000, verde=#00FF00, azul=#0000FF}
 * 
 * Despues de clear():
 * Map: {}
 * Esta vacio? true
 * Cantidad: 0
 */
