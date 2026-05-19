package com.universidad.turnos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

/**
 * Entidad Turno - representa un elemento dentro de la Cola de atención.
 *
 * ESTRUCTURA DE DATOS: COLA (Queue) — FIFO
 * ----------------------------------------
 * Cada Turno es un elemento de la cola con:
 *  - codigo: identificador único del turno (ej. T-001)
 *  - estado: PENDIENTE → EN_ATENCION → ATENDIDO (ciclo de vida del nodo en la cola)
 *  - fechaCreacion: marca de tiempo para garantizar el orden FIFO
 *  - usuario: referencia al nodo (usuario) propietario del turno
 *
 * Complejidad:
 *  - Encolar (crear turno):     O(1)
 *  - Desencolar (atender):      O(1)
 *  - Buscar por código:         O(n)
 *  - Listar por estado FIFO:    O(n log n) al ordenar por fechaCreacion
 */
@Entity
@Table(name = "turnos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", nullable = false, unique = true, length = 20)
    private String codigo;

    /**
     * Estado del turno en la Cola:
     * PENDIENTE    → turno en cola esperando ser llamado
     * EN_ATENCION  → turno al frente de la cola (siendo procesado)
     * ATENDIDO     → turno completado y removido de la cola
     * CANCELADO    → turno eliminado antes de ser atendido
     */
    @Column(name = "estado", nullable = false, length = 20)
    private String estado = "PENDIENTE";

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    /**
     * Marca de tiempo usada para mantener el orden FIFO de la cola.
     * El turno con menor fechaCreacion es el que está al frente.
     */
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Column(name = "fecha_atencion")
    private LocalDateTime fechaAtencion;
}
