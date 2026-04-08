package basico;

import java.util.HashMap;

/**
 * EJEMPLO 6: Actualizar valores
 * 
 * put() con clave existente -> reemplaza el valor
 */
public class Ejemplo6_Actualizar {

    public static void main(String[] args) {
        
        HashMap<String, Integer> notas = new HashMap<>();
        
        // Agregar notas iniciales
        notas.put("Matematicas", 3);
        notas.put("Historia", 4);
        notas.put("Ingles", 3);
        
        System.out.println("Notas iniciales: " + notas);
        
        // Actualizar una nota (usar put con clave existente)
        notas.put("Matematicas", 5);
        System.out.println("Despues de mejorar Matematicas: " + notas);
        
        // Otro ejemplo
        int notaActual = notas.get("Ingles");
        notas.put("Ingles", notaActual + 1);
        System.out.println("Despues de subir Ingles en 1: " + notas);
    }
}

/*
 * SALIDA:
 * Notas iniciales: {Matematicas=3, Historia=4, Ingles=3}
 * Despues de mejorar Matematicas: {Matematicas=5, Historia=4, Ingles=3}
 * Despues de subir Ingles en 1: {Matematicas=5, Historia=4, Ingles=4}
 */
