package avanzado;

/**
 * LISTA ENLAZADA - Ejemplo 1: El Nodo
 * 
 * Una lista enlazada esta formada por NODOS.
 * Cada nodo tiene:
 *   1. Un DATO (el valor que guardamos)
 *   2. Una REFERENCIA al siguiente nodo
 * 
 * Imagina una cadena:
 *   [Dato|->] -> [Dato|->] -> [Dato|->] -> null
 */
public class Ejemplo1_Nodo {

    public static void main(String[] args) {
        
        // Crear nodos individuales
        Nodo nodo1 = new Nodo(10);
        Nodo nodo2 = new Nodo(20);
        Nodo nodo3 = new Nodo(30);
        
        System.out.println("Nodos creados (sin conectar):");
        System.out.println("Nodo1 dato: " + nodo1.dato);
        System.out.println("Nodo2 dato: " + nodo2.dato);
        System.out.println("Nodo3 dato: " + nodo3.dato);
        
        // Conectar los nodos (formar la cadena)
        nodo1.siguiente = nodo2;  // nodo1 apunta a nodo2
        nodo2.siguiente = nodo3;  // nodo2 apunta a nodo3
        // nodo3.siguiente ya es null (fin de la lista)
        
        System.out.println("\nNodos conectados:");
        System.out.println("[" + nodo1.dato + "] -> [" + nodo2.dato + "] -> [" + nodo3.dato + "] -> null");
        
        // Recorrer la cadena desde el primer nodo
        System.out.println("\nRecorriendo desde nodo1:");
        Nodo actual = nodo1;
        while (actual != null) {
            System.out.println("Visitando: " + actual.dato);
            actual = actual.siguiente;  // Avanzar al siguiente
        }
    }
}

/**
 * Clase Nodo - El bloque basico de una lista enlazada
 */
class Nodo {
    int dato;           // El valor que guarda el nodo
    Nodo siguiente;     // Referencia al siguiente nodo (o null si es el ultimo)
    
    // Constructor
    Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

/*
 * SALIDA:
 * Nodos creados (sin conectar):
 * Nodo1 dato: 10
 * Nodo2 dato: 20
 * Nodo3 dato: 30
 * 
 * Nodos conectados:
 * [10] -> [20] -> [30] -> null
 * 
 * Recorriendo desde nodo1:
 * Visitando: 10
 * Visitando: 20
 * Visitando: 30
 */
