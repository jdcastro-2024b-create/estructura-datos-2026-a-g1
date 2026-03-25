public class ListaEnlazada {

    // Clase Nodo (cada nodo tiene un dato y una referencia)
    static class Nodo {
        String dato;
        Nodo siguiente;

        public Nodo(String dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public static void main(String[] args) {

        // Crear nodos (nombres de estudiantes)
        Nodo n1 = new Nodo("Juan");
        Nodo n2 = new Nodo("Maria");
        Nodo n3 = new Nodo("Carlos");
        Nodo n4 = new Nodo("Laura");

        // Enlazar nodos
        n1.siguiente = n2;
        n2.siguiente = n3;
        n3.siguiente = n4;

        // Definir la cabeza de la lista
        Nodo cabeza = n1;

        // Recorrer la lista
        Nodo actual = cabeza;

        System.out.println("Lista de estudiantes:");

        while (actual != null) {
            System.out.println("- " + actual.dato);
            actual = actual.siguiente;
        }

        // Contar nodos
        int contador = 0;
        Nodo temp = cabeza;

        while (temp != null) {
            contador++;
            temp = temp.siguiente;
        }

        System.out.println("Total de estudiantes: " + contador);
    }
}
