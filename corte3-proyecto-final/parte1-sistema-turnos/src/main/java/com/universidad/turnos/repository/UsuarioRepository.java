package com.universidad.turnos.repository;

import com.universidad.turnos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repositorio de Usuario.
 * 
 * Extiende JpaRepository que internamente usa una TABLA HASH
 * para búsquedas por ID con complejidad O(1) promedio.
 * 
 * Complejidad de operaciones JPA:
 *  - findById:    O(1) promedio (índice de tabla hash en DB)
 *  - findAll:     O(n) — recorre todos los registros
 *  - save:        O(1) amortizado
 *  - deleteById:  O(1) promedio
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Busca usuario por correo electrónico.
     * Complejidad: O(1) promedio con índice en la columna.
     */
    Optional<Usuario> findByCorreo(String correo);

    /**
     * Verifica si existe un usuario con ese correo.
     * Complejidad: O(1) promedio.
     */
    boolean existsByCorreo(String correo);
}
