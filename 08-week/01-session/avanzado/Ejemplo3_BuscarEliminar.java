package avanzado;

/**
 * LISTA ENLAZADA - Ejemplo 3: Buscar y Eliminar
 */
public class Ejemplo3_BuscarEliminar {

    public static void main(String[] args) {
        
        Lista lista = new Lista();
        
        // Agregar elementos
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.agregar(40);
        lista.agregar(50);
        
        System.out.println("Lista inicial:");
        lista.mostrar();
        
        // ========================================
        // BUSCAR
        // ========================================
        System.out.println("\n=== BUSCAR ===");
        System.out.println("Buscar 30: " + lista.buscar(30));  // true
        System.out.println("Buscar 99: " + lista.buscar(99));  // false
        
        // ========================================
        // ELIMINAR
        // ========================================
        System.out.println("\n=== ELIMINAR ===");
        
        lista.eliminar(30);
        System.out.println("Despues de eliminar 30:");
        lista.mostrar();
        
        lista.eliminar(10);  // Eliminar el primero
        System.out.println("Despues de eliminar 10:");
        lista.mostrar();
        
        lista.eliminar(50);  // Eliminar el ultimo
        System.out.println("Despues de eliminar 50:");
        lista.mostrar();
    }
}

class Lista {
    
    Nodo2 cabeza;
    
    void agregar(int dato) {
        Nodo2 nuevo = new Nodo2(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo2 actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }
    
    // BUSCAR un elemento - retorna true si existe
    boolean buscar(int dato) {
        Nodo2 actual = cabeza;
        while (actual != null) {
            if (actual.dato == dato) {
                return true;  // Encontrado!
            }
            actual = actual.siguiente;
        }
        return false;  // No existe
    }
    
    // ELIMINAR un elemento
    void eliminar(int dato) {
        if (cabeza == null) return;
        
        // Caso especial: eliminar la cabeza
        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente;
            return;
        }
        
        // Buscar el nodo anterior al que queremos eliminar
        Nodo2 actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato == dato) {
                // Saltar el nodo a eliminar
                actual.siguiente = actual.siguiente.siguiente;
                return;
            }
            actual = actual.siguiente;
        }
    }
    
    void mostrar() {
        Nodo2 actual = cabeza;
        System.out.print("Lista: ");
        while (actual != null) {
            System.out.print("[" + actual.dato + "]");
            if (actual.siguiente != null) System.out.print(" -> ");
            actual = actual.siguiente;
        }
        System.out.println(" -> null");
    }
}

class Nodo2 {
    int dato;
    Nodo2 siguiente;
    
    Nodo2(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
