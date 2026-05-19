package com.universidad.turnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Sistema de Turnos.
 * 
 * Este sistema implementa una Cola (Queue) como estructura de datos principal
 * para gestionar el orden de atención de usuarios en la universidad.
 * 
 * Estructura de datos utilizada: COLA (Queue) - FIFO (First In, First Out)
 * - Los turnos se asignan en orden de llegada.
 * - El primer turno en entrar es el primero en ser atendido.
 * - Complejidad de encolar: O(1)
 * - Complejidad de desencolar: O(1)
 * - Complejidad de búsqueda: O(n)
 */
@SpringBootApplication
public class SistemaTurnosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaTurnosApplication.class, args);
        System.out.println("===========================================");
        System.out.println("  Sistema de Turnos - Estructura de Datos  ");
        System.out.println("  Estructura: Cola (Queue) - FIFO           ");
        System.out.println("  Puerto: http://localhost:8080              ");
        System.out.println("===========================================");
    }
}
