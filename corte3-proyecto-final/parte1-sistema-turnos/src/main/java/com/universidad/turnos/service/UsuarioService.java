package com.universidad.turnos.service;

import com.universidad.turnos.model.Usuario;
import com.universidad.turnos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de Usuario.
 * Contiene la lógica de negocio para gestionar usuarios del sistema.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Lista todos los usuarios registrados.
     * Complejidad: O(n)
     */
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    /**
     * Busca un usuario por su ID.
     * Complejidad: O(1) promedio (índice primario).
     */
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    /**
     * Registra un nuevo usuario.
     * Valida que el correo no esté duplicado.
     * Complejidad: O(1) promedio.
     *
     * @throws IllegalArgumentException si el correo ya está registrado.
     */
    public Usuario registrar(Usuario usuario) {
        if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            throw new IllegalArgumentException(
                "Ya existe un usuario con el correo: " + usuario.getCorreo()
            );
        }
        return usuarioRepository.save(usuario);
    }

    /**
     * Actualiza los datos de un usuario existente.
     * Complejidad: O(1) promedio.
     *
     * @throws IllegalArgumentException si el usuario no existe.
     */
    public Usuario actualizar(Long id, Usuario datosActualizados) {
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + id));

        usuario.setNombre(datosActualizados.getNombre());
        usuario.setTelefono(datosActualizados.getTelefono());

        // El correo solo se actualiza si no está en uso por otro usuario
        if (!usuario.getCorreo().equals(datosActualizados.getCorreo())) {
            if (usuarioRepository.existsByCorreo(datosActualizados.getCorreo())) {
                throw new IllegalArgumentException("El correo ya está en uso.");
            }
            usuario.setCorreo(datosActualizados.getCorreo());
        }

        return usuarioRepository.save(usuario);
    }

    /**
     * Elimina un usuario por ID.
     * Complejidad: O(1) promedio.
     *
     * @throws IllegalArgumentException si el usuario no existe.
     */
    public void eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuario no encontrado con ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}
