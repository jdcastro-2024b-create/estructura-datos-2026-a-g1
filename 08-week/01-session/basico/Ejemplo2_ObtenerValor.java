package basico;

import java.util.HashMap;

/**
 * EJEMPLO 2: Obtener valores con get()
 * 
 * get(clave) -> retorna el valor asociado a esa clave
 */
public class Ejemplo2_ObtenerValor {

    public static void main(String[] args) {
        
        HashMap<String, Integer> edades = new HashMap<>();
        
        // Agregar datos
        edades.put("Juan", 25);
        edades.put("Maria", 30);
        edades.put("Pedro", 22);
        
        // Obtener un valor usando la clave
        int edadJuan = edades.get("Juan");
        System.out.println("Edad de Juan: " + edadJuan);
        
        int edadMaria = edades.get("Maria");
        System.out.println("Edad de Maria: " + edadMaria);
        
        // Si la clave no existe, retorna null
        Integer edadLuis = edades.get("Luis");
        System.out.println("Edad de Luis: " + edadLuis);
    }
}

/*
 * SALIDA:
 * Edad de Juan: 25
 * Edad de Maria: 30
 * Edad de Luis: null
 */
