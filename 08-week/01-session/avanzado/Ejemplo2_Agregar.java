package avanzado;

/**
 * LISTA ENLAZADA - Ejemplo 2: Agregar elementos
 * 
 * Operaciones basicas:
 *   - Agregar al INICIO (mas facil)
 *   - Agregar al FINAL (hay que recorrer)
 */
public class Ejemplo2_Agregar {

    public static void main(String[] args) {
        
        ListaSimple lista = new ListaSimple();
        
        System.out.println("=== AGREGAR AL FINAL ===");
        lista.agregarFinal(10);
        lista.mostrar();  // [10]
        
        lista.agregarFinal(20);
        lista.mostrar();  // [10] -> [20]
        
        lista.agregarFinal(30);
        lista.mostrar();  // [10] -> [20] -> [30]
        
        System.out.println("\n=== AGREGAR AL INICIO ===");
        lista.agregarInicio(5);
        lista.mostrar();  // [5] -> [10] -> [20] -> [30]
        
        lista.agregarInicio(1);
        lista.mostrar();  // [1] -> [5] -> [10] -> [20] -> [30]
    }
}

/**
 * Lista Enlazada Simple
 */
class ListaSimple {
    
    NodoSimple cabeza;  // Primer nodo de la lista
    
    // Constructor - lista vacia
    ListaSimple() {
        this.cabeza = null;
    }
    
    // Agregar al INICIO - O(1) constante
    void agregarInicio(int dato) {
        NodoSimple nuevo = new NodoSimple(dato);
        nuevo.siguiente = cabeza;  // El nuevo apunta al antiguo primero
        cabeza = nuevo;            // El nuevo es ahora la cabeza
    }
    
    // Agregar al FINAL - O(n) lineal
    void agregarFinal(int dato) {
        NodoSimple nuevo = new NodoSimple(dato);
        
        // Si la lista esta vacia
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }
        
        // Buscar el ultimo nodo
        NodoSimple actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        
        // Conectar el nuevo al final
        actual.siguiente = nuevo;
    }
    
    // Mostrar la lista
    void mostrar() {
        if (cabeza == null) {
            System.out.println("Lista vacia");
            return;
        }
        
        NodoSimple actual = cabeza;
        System.out.print("Lista: ");
        while (actual != null) {
            System.out.print("[" + actual.dato + "]");
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println(" -> null");
    }
}

class NodoSimple {
    int dato;
    NodoSimple siguiente;
    
    NodoSimple(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
