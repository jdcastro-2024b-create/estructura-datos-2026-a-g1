package basico;

import java.util.HashMap;

/**
 * EJEMPLO 5: Recorrer un Map
 * 
 * keySet() -> obtiene todas las claves
 */
public class Ejemplo5_Recorrer {

    public static void main(String[] args) {
        
        HashMap<String, String> capitales = new HashMap<>();
        
        capitales.put("Colombia", "Bogota");
        capitales.put("Peru", "Lima");
        capitales.put("Chile", "Santiago");
        capitales.put("Ecuador", "Quito");
        
        // Recorrer usando las claves
        System.out.println("--- Lista de Capitales ---");
        
        for (String pais : capitales.keySet()) {
            String capital = capitales.get(pais);
            System.out.println(pais + " -> " + capital);
        }
        
        // Obtener tamanio
        System.out.println("\nTotal paises: " + capitales.size());
    }
}

/*
 * SALIDA:
 * --- Lista de Capitales ---
 * Colombia -> Bogota
 * Peru -> Lima
 * Chile -> Santiago
 * Ecuador -> Quito
 * 
 * Total paises: 4
 */
