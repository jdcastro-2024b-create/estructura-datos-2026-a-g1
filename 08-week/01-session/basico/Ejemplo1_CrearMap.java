package basico;

import java.util.HashMap;

/**
 * EJEMPLO 1: Crear un Map y agregar elementos
 * 
 * Map = Estructura que guarda pares CLAVE -> VALOR
 */
public class Ejemplo1_CrearMap {

    public static void main(String[] args) {
        
        // Crear un HashMap vacio
        // HashMap<TipoClave, TipoValor>
        HashMap<String, Integer> edades = new HashMap<>();
        
        // Agregar elementos con put(clave, valor)
        edades.put("Juan", 25);
        edades.put("Maria", 30);
        edades.put("Pedro", 22);
        edades.put("Juan", 26); // Si la clave ya existe, se reemplaza el valor
        // edades.put("Maria", 31); // Reemplaza el valor de Maria
        edades.put("Diego", 22); // Reemplaza el valor de Pedro (aunque sea el mismo)
        edades.put("Diego", 12);
        
        // Imprimir el Map completo
        System.out.println("Map de edades: " + edades);
        
        // Agregar otro elemento
        edades.put("Ana", 28);
        System.out.println("Despues de agregar Ana: " + edades);
    }
}

/*
 * SALIDA:
 * Map de edades: {Juan=25, Maria=30, Pedro=22}
 * Despues de agregar Ana: {Juan=25, Maria=30, Pedro=22, Ana=28}
 */
