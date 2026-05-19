-- =============================================
-- SCRIPT DE BASE DE DATOS - Sistema de Turnos
-- Proyecto: Estructura de Datos (Cola - Queue)
-- =============================================

-- Crear y seleccionar la base de datos
CREATE DATABASE IF NOT EXISTS sistema_turnos
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE sistema_turnos;

-- =============================================
-- TABLA: usuarios
-- Nodos que solicitan turnos en la cola
-- =============================================
CREATE TABLE IF NOT EXISTS usuarios (
    id       BIGINT       PRIMARY KEY AUTO_INCREMENT,
    nombre   VARCHAR(100) NOT NULL,
    correo   VARCHAR(100) NOT NULL UNIQUE,
    telefono VARCHAR(20)
);

-- =============================================
-- TABLA: turnos
-- Elementos de la Cola (Queue) — FIFO
--
-- Estados del ciclo de vida:
--   PENDIENTE   → en la cola esperando
--   EN_ATENCION → al frente, siendo atendido
--   ATENDIDO    → completado y salió de la cola
--   CANCELADO   → removido antes de ser atendido
-- =============================================
CREATE TABLE IF NOT EXISTS turnos (
    id             BIGINT       PRIMARY KEY AUTO_INCREMENT,
    codigo         VARCHAR(20)  NOT NULL UNIQUE,
    estado         VARCHAR(20)  NOT NULL DEFAULT 'PENDIENTE',
    usuario_id     BIGINT       NOT NULL,
    fecha_creacion DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_atencion DATETIME,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    INDEX idx_estado (estado),
    INDEX idx_fecha_creacion (fecha_creacion)
);

-- =============================================
-- DATOS DE PRUEBA
-- =============================================

-- Insertar usuarios de ejemplo
INSERT INTO usuarios (nombre, correo, telefono) VALUES
    ('Carlos Gómez',    'carlos.gomez@universidad.edu.co',    '3001234567'),
    ('María Rodríguez', 'maria.rodriguez@universidad.edu.co', '3019876543'),
    ('Andrés Torres',   'andres.torres@universidad.edu.co',   '3151234567'),
    ('Laura Sánchez',   'laura.sanchez@universidad.edu.co',   '3179876543'),
    ('Felipe Vargas',   'felipe.vargas@universidad.edu.co',   '3201234567');

-- Insertar turnos de prueba (simulando la cola)
INSERT INTO turnos (codigo, estado, usuario_id, fecha_creacion) VALUES
    ('T-001', 'ATENDIDO',   1, NOW() - INTERVAL 2 HOUR),
    ('T-002', 'ATENDIDO',   2, NOW() - INTERVAL 1 HOUR),
    ('T-003', 'EN_ATENCION',3, NOW() - INTERVAL 30 MINUTE),
    ('T-004', 'PENDIENTE',  4, NOW() - INTERVAL 15 MINUTE),
    ('T-005', 'PENDIENTE',  5, NOW() - INTERVAL 5 MINUTE);

-- =============================================
-- VERIFICACIÓN
-- =============================================
SELECT 'Usuarios registrados:' AS info, COUNT(*) AS total FROM usuarios;
SELECT 'Turnos en cola (PENDIENTES):' AS info, COUNT(*) AS total FROM turnos WHERE estado = 'PENDIENTE';
SELECT 'Turno al frente (FIFO):' AS info, codigo AS turno FROM turnos WHERE estado = 'PENDIENTE' ORDER BY fecha_creacion ASC LIMIT 1;
