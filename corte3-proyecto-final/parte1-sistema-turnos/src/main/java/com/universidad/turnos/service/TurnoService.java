package com.universidad.turnos.service;

import com.universidad.turnos.model.Turno;
import com.universidad.turnos.model.Usuario;
import com.universidad.turnos.repository.TurnoRepository;
import com.universidad.turnos.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;

/**
 * Servicio de turnos. Implementa una cola FIFO para simular la atencion
 * de solicitudes en una dependencia universitaria.
 */
@Service
public class TurnoService {

    private final TurnoRepository turnoRepository;
    private final UsuarioRepository usuarioRepository;

    public TurnoService(TurnoRepository turnoRepository, UsuarioRepository usuarioRepository) {
        this.turnoRepository = turnoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Enqueue: agrega un turno al final de la cola.
     * Complejidad esperada: O(1) para la insercion.
     */
    public Turno encolar(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + usuarioId));

        if (turnoRepository.existsTurnoActivoByUsuarioId(usuarioId)) {
            throw new IllegalStateException("El usuario ya tiene un turno activo en la cola.");
        }

        Turno turno = new Turno();
        turno.setCodigo(generarCodigo());
        turno.setEstado("PENDIENTE");
        turno.setUsuario(usuario);
        turno.setFechaCreacion(LocalDateTime.now());

        return turnoRepository.save(turno);
    }

    /**
     * Dequeue: toma el turno al frente de la cola y lo pasa a atencion.
     */
    public Turno llamarSiguiente() {
        Turno siguiente = turnoRepository.findFirstByEstadoOrderByFechaCreacionAsc("PENDIENTE")
            .orElseThrow(() -> new IllegalStateException("La cola esta vacia. No hay turnos pendientes."));

        siguiente.setEstado("EN_ATENCION");
        siguiente.setFechaAtencion(LocalDateTime.now());
        return turnoRepository.save(siguiente);
    }

    /**
     * Finaliza el procesamiento de un turno desencolado.
     */
    public Turno completarAtencion(Long turnoId) {
        Turno turno = turnoRepository.findById(turnoId)
            .orElseThrow(() -> new IllegalArgumentException("Turno no encontrado: " + turnoId));

        if (!"EN_ATENCION".equals(turno.getEstado())) {
            throw new IllegalStateException("El turno no esta EN_ATENCION. Estado actual: " + turno.getEstado());
        }

        turno.setEstado("ATENDIDO");
        return turnoRepository.save(turno);
    }

    /**
     * Cancela un turno antes de ser atendido.
     */
    public Turno cancelar(Long turnoId) {
        Turno turno = turnoRepository.findById(turnoId)
            .orElseThrow(() -> new IllegalArgumentException("Turno no encontrado: " + turnoId));

        if ("ATENDIDO".equals(turno.getEstado())) {
            throw new IllegalStateException("No se puede cancelar un turno ya atendido.");
        }

        turno.setEstado("CANCELADO");
        return turnoRepository.save(turno);
    }

    /**
     * Peek: consulta el frente de la cola sin modificarlo.
     */
    public Optional<Turno> verFrente() {
        return turnoRepository.findFirstByEstadoOrderByFechaCreacionAsc("PENDIENTE");
    }

    public List<Turno> listarPendientes() {
        return turnoRepository.findByEstadoOrderByFechaCreacionAsc("PENDIENTE");
    }

    public List<Turno> listarTodos() {
        return turnoRepository.findAll();
    }

    public Optional<Turno> buscarPorId(Long id) {
        return turnoRepository.findById(id);
    }

    public Map<String, Long> estadisticasCola() {
        return Map.of(
            "pendientes", turnoRepository.countByEstado("PENDIENTE"),
            "enAtencion", turnoRepository.countByEstado("EN_ATENCION"),
            "atendidos", turnoRepository.countByEstado("ATENDIDO"),
            "cancelados", turnoRepository.countByEstado("CANCELADO")
        );
    }

    /**
     * Demostracion educativa: carga los pendientes en una LinkedList que
     * implementa la interfaz Queue de Java.
     */
    public List<Turno> simularColaEnMemoria() {
        Queue<Turno> colaEnMemoria = new LinkedList<>();
        List<Turno> pendientes = turnoRepository.findByEstadoOrderByFechaCreacionAsc("PENDIENTE");
        colaEnMemoria.addAll(pendientes);
        return List.copyOf(colaEnMemoria);
    }

    private String generarCodigo() {
        long siguiente = turnoRepository.findTopByOrderByIdDesc()
            .map(t -> t.getId() + 1)
            .orElse(1L);
        return String.format("T-%03d", siguiente);
    }
}
