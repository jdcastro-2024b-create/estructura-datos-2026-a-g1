package com.universidad.turnos.controller;

import com.universidad.turnos.model.Turno;
import com.universidad.turnos.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * Controlador REST para la gestión de Turnos (Cola - Queue).
 *
 * Endpoints disponibles:
 *  GET    /turnos                        → listar todos los turnos
 *  GET    /turnos/pendientes             → listar cola PENDIENTE (FIFO)
 *  GET    /turnos/frente                 → ver el frente de la cola (peek)
 *  GET    /turnos/estadisticas           → estadísticas de la cola
 *  GET    /turnos/{id}                   → buscar turno por ID
 *  POST   /turnos/encolar/{usuarioId}    → agregar turno a la cola (enqueue)
 *  PUT    /turnos/siguiente              → llamar siguiente turno (dequeue)
 *  PUT    /turnos/{id}/completar         → marcar turno como atendido
 *  PUT    /turnos/{id}/cancelar          → cancelar turno de la cola
 */
@RestController
@RequestMapping("/turnos")
@CrossOrigin(origins = "*")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    /**
     * GET /turnos
     * Lista todos los turnos sin importar su estado.
     */
    @GetMapping
    public ResponseEntity<List<Turno>> listarTodos() {
        return ResponseEntity.ok(turnoService.listarTodos());
    }

    /**
     * GET /turnos/pendientes
     * Lista los turnos PENDIENTES en orden FIFO (primero creado, primero atendido).
     * Equivalente a recorrer la cola sin modificarla.
     */
    @GetMapping("/pendientes")
    public ResponseEntity<List<Turno>> listarPendientes() {
        return ResponseEntity.ok(turnoService.listarPendientes());
    }

    /**
     * GET /turnos/frente
     * Retorna el turno al frente de la cola sin removerlo (peek).
     * Retorna 204 No Content si la cola está vacía.
     */
    @GetMapping("/frente")
    public ResponseEntity<?> verFrente() {
        return turnoService.verFrente()
            .<ResponseEntity<?>>map(ResponseEntity::ok)
            .orElse(ResponseEntity.noContent().build());
    }

    /**
     * GET /turnos/estadisticas
     * Retorna estadísticas sobre el estado de la cola.
     */
    @GetMapping("/estadisticas")
    public ResponseEntity<Map<String, Long>> estadisticas() {
        return ResponseEntity.ok(turnoService.estadisticasCola());
    }

    /**
     * GET /turnos/{id}
     * Busca un turno por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return turnoService.buscarPorId(id)
            .<ResponseEntity<?>>map(ResponseEntity::ok)
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Turno no encontrado con ID: " + id)));
    }

    /**
     * POST /turnos/encolar/{usuarioId}
     * ENQUEUE: Agrega un nuevo turno al final de la cola.
     * Equivalente a: cola.add(turno) o cola.offer(turno)
     */
    @PostMapping("/encolar/{usuarioId}")
    public ResponseEntity<?> encolar(@PathVariable Long usuarioId) {
        try {
            Turno turno = turnoService.encolar(usuarioId);
            return ResponseEntity.status(HttpStatus.CREATED).body(turno);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", e.getMessage()));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("error", e.getMessage()));
        }
    }

    /**
     * PUT /turnos/siguiente
     * DEQUEUE: Llama al siguiente turno de la cola (lo pasa a EN_ATENCION).
     * Equivalente a: cola.poll()
     */
    @PutMapping("/siguiente")
    public ResponseEntity<?> llamarSiguiente() {
        try {
            Turno turno = turnoService.llamarSiguiente();
            return ResponseEntity.ok(turno);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("error", e.getMessage()));
        }
    }

    /**
     * PUT /turnos/{id}/completar
     * Marca un turno EN_ATENCION como ATENDIDO (completado).
     */
    @PutMapping("/{id}/completar")
    public ResponseEntity<?> completar(@PathVariable Long id) {
        try {
            Turno turno = turnoService.completarAtencion(id);
            return ResponseEntity.ok(turno);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", e.getMessage()));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("error", e.getMessage()));
        }
    }

    /**
     * PUT /turnos/{id}/cancelar
     * Cancela un turno PENDIENTE (lo saca de la cola antes de ser atendido).
     */
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<?> cancelar(@PathVariable Long id) {
        try {
            Turno turno = turnoService.cancelar(id);
            return ResponseEntity.ok(turno);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", e.getMessage()));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("error", e.getMessage()));
        }
    }
}
