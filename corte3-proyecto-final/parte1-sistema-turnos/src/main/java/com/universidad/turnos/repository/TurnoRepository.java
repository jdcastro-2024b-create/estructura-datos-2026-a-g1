package com.universidad.turnos.repository;

import com.universidad.turnos.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de Turno.
 *
 * Las consultas respetan el comportamiento FIFO de la cola: el primer turno
 * pendiente por fecha de creacion es el primero que debe ser atendido.
 */
@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {

    /**
     * Lista todos los turnos de un estado ordenados por llegada.
     * Equivale a recorrer la cola sin modificarla.
     */
    List<Turno> findByEstadoOrderByFechaCreacionAsc(String estado);

    /**
     * Obtiene el frente de la cola sin removerlo.
     */
    Optional<Turno> findFirstByEstadoOrderByFechaCreacionAsc(String estado);

    /**
     * Lista los turnos historicos de un usuario.
     */
    List<Turno> findByUsuarioIdOrderByFechaCreacionDesc(Long usuarioId);

    /**
     * Cuenta turnos por estado para el panel de estadisticas.
     */
    long countByEstado(String estado);

    /**
     * Evita que un usuario tenga dos turnos activos al mismo tiempo.
     */
    @Query("SELECT COUNT(t) > 0 FROM Turno t WHERE t.usuario.id = :usuarioId AND t.estado IN ('PENDIENTE', 'EN_ATENCION')")
    boolean existsTurnoActivoByUsuarioId(Long usuarioId);

    /**
     * Obtiene el ultimo turno registrado para generar el siguiente codigo.
     */
    Optional<Turno> findTopByOrderByIdDesc();
}
