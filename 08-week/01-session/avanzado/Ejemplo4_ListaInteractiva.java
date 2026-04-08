package avanzado;

import java.util.Scanner;

/**
 * LISTA ENLAZADA - Ejemplo 4: Ejercicio Interactivo
 * 
 * Menu para practicar todas las operaciones
 */
public class Ejemplo4_ListaInteractiva {

    public static void main(String[] args) {
        
        ListaEnlazada lista = new ListaEnlazada();
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n=== LISTA ENLAZADA ===");
            System.out.println("1. Agregar al final");
            System.out.println("2. Agregar al inicio");
            System.out.println("3. Buscar elemento");
            System.out.println("4. Eliminar elemento");
            System.out.println("5. Mostrar lista");
            System.out.println("6. Contar elementos");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.print("Valor a agregar: ");
                    lista.agregarFinal(sc.nextInt());
                    System.out.println("Agregado al final!");
                    break;
                    
                case 2:
                    System.out.print("Valor a agregar: ");
                    lista.agregarInicio(sc.nextInt());
                    System.out.println("Agregado al inicio!");
                    break;
                    
                case 3:
                    System.out.print("Valor a buscar: ");
                    boolean existe = lista.buscar(sc.nextInt());
                    System.out.println(existe ? "SI existe" : "NO existe");
                    break;
                    
                case 4:
                    System.out.print("Valor a eliminar: ");
                    lista.eliminar(sc.nextInt());
                    System.out.println("Eliminado!");
                    break;
                    
                case 5:
                    lista.mostrar();
                    break;
                    
                case 6:
                    System.out.println("Total: " + lista.contar() + " elementos");
                    break;
                    
                case 7:
                    System.out.println("Adios!");
                    break;
                    
                default:
                    System.out.println("Opcion invalida");
            }
            
        } while (opcion != 7);
        
        sc.close();
    }
}

class ListaEnlazada {
    
    Nodo3 cabeza;
    
    void agregarFinal(int dato) {
        Nodo3 nuevo = new Nodo3(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo3 actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }
    
    void agregarInicio(int dato) {
        Nodo3 nuevo = new Nodo3(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }
    
    boolean buscar(int dato) {
        Nodo3 actual = cabeza;
        while (actual != null) {
            if (actual.dato == dato) return true;
            actual = actual.siguiente;
        }
        return false;
    }
    
    void eliminar(int dato) {
        if (cabeza == null) return;
        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente;
            return;
        }
        Nodo3 actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato == dato) {
                actual.siguiente = actual.siguiente.siguiente;
                return;
            }
            actual = actual.siguiente;
        }
    }
    
    int contar() {
        int contador = 0;
        Nodo3 actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }
    
    void mostrar() {
        if (cabeza == null) {
            System.out.println("Lista vacia");
            return;
        }
        Nodo3 actual = cabeza;
        System.out.print("Lista: ");
        while (actual != null) {
            System.out.print("[" + actual.dato + "]");
            if (actual.siguiente != null) System.out.print(" -> ");
            actual = actual.siguiente;
        }
        System.out.println(" -> null");
    }
}

class Nodo3 {
    int dato;
    Nodo3 siguiente;
    
    Nodo3(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
