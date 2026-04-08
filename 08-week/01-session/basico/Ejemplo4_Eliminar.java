package basico;

import java.util.HashMap;

/**
 * EJEMPLO 4: Eliminar elementos con remove()
 * 
 * remove(clave) -> elimina el par clave-valor
 */
public class Ejemplo4_Eliminar {

    public static void main(String[] args) {
        
        HashMap<String, Double> precios = new HashMap<>();
        
        // Agregar productos
        precios.put("Manzana", 2500.0);
        precios.put("Banana", 1800.0);
        precios.put("Naranja", 3000.0);
        
        System.out.println("Precios: " + precios);
        
        // Eliminar un elemento
        precios.remove("Banana");
        System.out.println("Despues de eliminar Banana: " + precios);
        
        // remove() retorna el valor eliminado
        Double precioEliminado = precios.remove("Manzana");
        System.out.println("Precio eliminado: " + precioEliminado);
        System.out.println("Map final: " + precios);
    }
}

/*
 * SALIDA:
 * Precios: {Banana=1800.0, Manzana=2500.0, Naranja=3000.0}
 * Despues de eliminar Banana: {Manzana=2500.0, Naranja=3000.0}
 * Precio eliminado: 2500.0
 * Map final: {Naranja=3000.0}
 */
