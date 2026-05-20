# Taller Practico - Unidad 3

## Arbol binario simple y recorridos

**Materia:** Estructura de Datos  
**Tema:** Arbol binario simple y recorridos  
**Estudiante:** Juan Diego Castro
---

## Objetivo

Aplicar los conceptos basicos de arbol binario simple y recorridos para representar informacion jerarquica.

---

## Contexto

Una empresa organiza su estructura interna de la siguiente forma:

- Un Director.
- Dos departamentos.
- Dos empleados por cada departamento.

Esta estructura se puede representar con un arbol binario de 7 nodos, donde el Director es la raiz, los departamentos son los hijos del Director y los empleados son las hojas del arbol.

---

# Parte 1 - Diseno del arbol

## 1. Dibujo del arbol binario

```text
                         Director
                       /          \
          Departamento A          Departamento B
            /        \              /        \
   Empleado A1    Empleado A2  Empleado B1  Empleado B2
```

## 2. Identificacion de los nodos

### Raiz

La raiz del arbol es:

- Director

La raiz es el nodo principal del arbol, porque de el se desprende toda la estructura.

### Nodos internos

Los nodos internos son:

- Director
- Departamento A
- Departamento B

Estos nodos son internos porque tienen al menos un hijo dentro del arbol.

### Hojas

Las hojas del arbol son:

- Empleado A1
- Empleado A2
- Empleado B1
- Empleado B2

Estos nodos son hojas porque no tienen hijos.

## 3. Altura del arbol

La altura del arbol es **2**, si se cuenta por cantidad de aristas desde la raiz hasta la hoja mas lejana.

Representacion por niveles:

```text
Nivel 0: Director
Nivel 1: Departamento A, Departamento B
Nivel 2: Empleado A1, Empleado A2, Empleado B1, Empleado B2
```

Por lo tanto:

- Altura del arbol: **2**
- Cantidad de niveles: **3**
- Cantidad total de nodos: **7**

---

# Parte 2 - Recorridos

## 1. Recorrido Preorden

El recorrido preorden sigue el orden:

```text
Raiz -> Izquierda -> Derecha
```

Aplicando este recorrido al arbol:

```text
Director Departamento A Empleado A1 Empleado A2 Departamento B Empleado B1 Empleado B2
```

## 2. Recorrido Postorden

El recorrido postorden sigue el orden:

```text
Izquierda -> Derecha -> Raiz
```

Aplicando este recorrido al arbol:

```text
Empleado A1 Empleado A2 Departamento A Empleado B1 Empleado B2 Departamento B Director
```

## 3. Diferencia entre Preorden y Postorden

En el recorrido preorden, primero se visita la raiz y luego se recorren el subarbol izquierdo y el subarbol derecho.  
En el recorrido postorden, primero se recorren los hijos o subarboles y al final se visita la raiz.  
Por esta razon, en preorden el primer nodo visitado es el Director, mientras que en postorden el Director aparece al final.

---

# Parte 3 - Mini implementacion en Java

## Codigo Java

```java
class Node {
    String value;
    Node left, right;

    Node(String value) {
        this.value = value;
    }
}

public class Main {

    static void preOrder(Node n) {
        if (n == null) return;

        System.out.print(n.value + " ");
        preOrder(n.left);
        preOrder(n.right);
    }

    public static void main(String[] args) {
        // Construccion manual del arbol
        Node root = new Node("Director");

        root.left = new Node("Departamento A");
        root.right = new Node("Departamento B");

        root.left.left = new Node("Empleado A1");
        root.left.right = new Node("Empleado A2");

        root.right.left = new Node("Empleado B1");
        root.right.right = new Node("Empleado B2");

        System.out.println("Recorrido Preorden:");
        preOrder(root);
    }
}
```

## Salida esperada del programa

```text
Recorrido Preorden:
Director Departamento A Empleado A1 Empleado A2 Departamento B Empleado B1 Empleado B2
```

---

# Conclusiones

El arbol binario permite representar de forma clara una estructura jerarquica, como la organizacion interna de una empresa. En este caso, el Director representa la raiz, los departamentos funcionan como nodos internos y los empleados representan las hojas. Los recorridos preorden y postorden permiten visitar los nodos del arbol en diferentes ordenes, dependiendo de si se desea procesar primero la raiz o dejarla para el final.

