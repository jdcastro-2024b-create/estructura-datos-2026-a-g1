package com.universidad.turnos.controller;

import com.universidad.turnos.model.Usuario;
import com.universidad.turnos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * Controlador REST para la gestión de Usuarios.
 *
 * Endpoints disponibles:
 *  GET    /usuarios          → listar todos los usuarios
 *  GET    /usuarios/{id}     → buscar usuario por ID
 *  POST   /usuarios          → registrar nuevo usuario
 *  PUT    /usuarios/{id}     → actualizar usuario
 *  DELETE /usuarios/{id}     → eliminar usuario
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")  // Permite peticiones desde el frontend HTML
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * GET /usuarios
     * Retorna la lista completa de usuarios registrados.
     */
    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    /**
     * GET /usuarios/{id}
     * Busca un usuario por su ID. Retorna 404 si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
            .<ResponseEntity<?>>map(ResponseEntity::ok)
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Usuario no encontrado con ID: " + id)));
    }

    /**
     * POST /usuarios
     * Registra un nuevo usuario.
     * Body: { "nombre": "...", "correo": "...", "telefono": "..." }
     */
    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {
        try {
            Usuario creado = usuarioService.registrar(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("error", e.getMessage()));
        }
    }

    /**
     * PUT /usuarios/{id}
     * Actualiza los datos de un usuario existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            Usuario actualizado = usuarioService.actualizar(id, usuario);
            return ResponseEntity.ok(actualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", e.getMessage()));
        }
    }

    /**
     * DELETE /usuarios/{id}
     * Elimina un usuario por ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            usuarioService.eliminar(id);
            return ResponseEntity.ok(Map.of("mensaje", "Usuario eliminado correctamente."));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", e.getMessage()));
        }
    }
}
