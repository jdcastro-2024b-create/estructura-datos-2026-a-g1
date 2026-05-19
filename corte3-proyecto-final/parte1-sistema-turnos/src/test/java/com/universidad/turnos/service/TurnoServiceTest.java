package com.universidad.turnos.service;

import com.universidad.turnos.model.Turno;
import com.universidad.turnos.model.Usuario;
import com.universidad.turnos.repository.TurnoRepository;
import com.universidad.turnos.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TurnoRepository turnoRepository;

    @Test
    void encolaYAtiendeRespetandoFifo() {
        Usuario primero = usuarioRepository.save(new Usuario(null, "Ana Perez", "ana@uni.edu.co", "3001111111"));
        Usuario segundo = usuarioRepository.save(new Usuario(null, "Luis Rojas", "luis@uni.edu.co", "3002222222"));

        Turno turno1 = turnoService.encolar(primero.getId());
        Turno turno2 = turnoService.encolar(segundo.getId());

        assertThat(turnoService.verFrente()).contains(turno1);
        assertThat(turnoService.listarPendientes()).extracting(Turno::getCodigo)
            .containsExactly(turno1.getCodigo(), turno2.getCodigo());

        Turno llamado = turnoService.llamarSiguiente();
        assertThat(llamado.getCodigo()).isEqualTo(turno1.getCodigo());
        assertThat(llamado.getEstado()).isEqualTo("EN_ATENCION");
        assertThat(turnoService.verFrente()).contains(turno2);
    }

    @Test
    void evitaDuplicarTurnosActivosParaElMismoUsuario() {
        Usuario usuario = usuarioRepository.save(new Usuario(null, "Marta Ruiz", "marta@uni.edu.co", "3003333333"));
        turnoService.encolar(usuario.getId());

        assertThatThrownBy(() -> turnoService.encolar(usuario.getId()))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("turno activo");
    }

    @Test
    void completarSoloPermiteTurnoEnAtencion() {
        Usuario usuario = usuarioRepository.save(new Usuario(null, "Pedro Silva", "pedro@uni.edu.co", "3004444444"));
        Turno turno = turnoService.encolar(usuario.getId());

        assertThatThrownBy(() -> turnoService.completarAtencion(turno.getId()))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("EN_ATENCION");

        Turno llamado = turnoService.llamarSiguiente();
        Turno completado = turnoService.completarAtencion(llamado.getId());
        assertThat(completado.getEstado()).isEqualTo("ATENDIDO");
    }

    @Test
    void cancelarActualizaElEstadoDelTurnoPendiente() {
        Usuario usuario = usuarioRepository.save(new Usuario(null, "Sofia Cano", "sofia@uni.edu.co", "3005555555"));
        Turno turno = turnoService.encolar(usuario.getId());

        Turno cancelado = turnoService.cancelar(turno.getId());

        assertThat(cancelado.getEstado()).isEqualTo("CANCELADO");
        assertThat(turnoRepository.countByEstado("PENDIENTE")).isZero();
    }
}
