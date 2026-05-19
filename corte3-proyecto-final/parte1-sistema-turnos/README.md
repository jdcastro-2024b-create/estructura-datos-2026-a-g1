# Sistema de Turnos Universitario

Proyecto de Estructura de Datos - Corte 3, Parte 1.

## Descripcion

Aplicacion funcional para gestionar turnos de atencion universitaria. El problema se resuelve con una cola FIFO: el primer usuario que solicita turno es el primero en ser llamado.

## Stack

- Java 17
- Spring Boot 3.2
- Spring Data JPA
- MySQL 8
- HTML, CSS y Axios
- JUnit 5 + H2 para pruebas

## Estructura de datos principal

| Operacion | Endpoint | Estructura | Complejidad |
| --- | --- | --- | --- |
| Encolar turno | `POST /turnos/encolar/{usuarioId}` | Cola / Queue | O(1) |
| Ver frente | `GET /turnos/frente` | Peek | O(1) conceptual |
| Llamar siguiente | `PUT /turnos/siguiente` | Dequeue | O(1) conceptual |
| Recorrer pendientes | `GET /turnos/pendientes` | Recorrido FIFO | O(n) |
| Cancelar turno | `PUT /turnos/{id}/cancelar` | Busqueda en cola | O(n) |

## Ejecucion

1. Crear la base de datos:

```sql
SOURCE database.sql;
```

2. Ajustar credenciales en `src/main/resources/application.properties`.

3. Ejecutar el backend:

```bash
mvn spring-boot:run
```

4. Abrir el frontend:

- `frontend/index.html`
- `frontend/usuarios.html`
- `frontend/turnos.html`
- `frontend/cola.html`

## Pruebas

```bash
mvn test
```

Las pruebas validan que la cola respete FIFO, que no se dupliquen turnos activos, que solo se completen turnos en atencion y que la cancelacion actualice el estado.

## Endpoints

### Usuarios

- `GET /usuarios`
- `GET /usuarios/{id}`
- `POST /usuarios`
- `PUT /usuarios/{id}`
- `DELETE /usuarios/{id}`

### Turnos

- `GET /turnos`
- `GET /turnos/pendientes`
- `GET /turnos/frente`
- `GET /turnos/estadisticas`
- `POST /turnos/encolar/{usuarioId}`
- `PUT /turnos/siguiente`
- `PUT /turnos/{id}/completar`
- `PUT /turnos/{id}/cancelar`

## Evidencias funcionales sugeridas

1. Registrar dos usuarios.
2. Solicitar un turno para cada usuario.
3. Verificar que el primer turno aparece al frente.
4. Llamar al siguiente turno.
5. Completar la atencion.
6. Cancelar un turno pendiente.
7. Mostrar el dashboard `cola.html` con estadisticas actualizadas.
