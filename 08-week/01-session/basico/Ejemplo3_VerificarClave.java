package basico;

import java.util.HashMap;

/**
 * EJEMPLO 3: Verificar si existe una clave
 * 
 * containsKey(clave) -> true si existe, false si no
 */
public class Ejemplo3_VerificarClave {

    public static void main(String[] args) {
        
        HashMap<String, String> paises = new HashMap<>();
        
        // Agregar datos
        paises.put("CO", "Colombia");
        paises.put("MX", "Mexico");
        paises.put("AR", "Argentina");
        
        // Verificar si existe una clave
        boolean existeCO = paises.containsKey("CO");
        System.out.println("Existe CO? " + existeCO);
        
        boolean existeBR = paises.containsKey("BR");
        System.out.println("Existe BR? " + existeBR);
        
        // Uso practico con if
        if (paises.containsKey("MX")) {
            System.out.println("MX es: " + paises.get("MX"));
        }
        
        if (paises.containsKey("PE")) {
            System.out.println("PE es: " + paises.get("PE"));
        } else {
            System.out.println("PE no existe en el mapa");
        }
    }
}

/*
 * SALIDA:
 * Existe CO? true
 * Existe BR? false
 * MX es: Mexico
 * PE no existe en el mapa
 */
