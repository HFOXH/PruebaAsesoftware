package com.example.pruebaAsesoftware.Turno;

import com.example.pruebaAsesoftware.Comercio.Comercio;
import com.example.pruebaAsesoftware.Servicio.Servicio;
import com.example.pruebaAsesoftware.Servicio.ServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TurnoService {

    private final TurnoRepository turnoRepository;
    private final ServicioRepository servicioRepository;

    public List<Turno> generarTurnos(UUID servicioId, LocalDate fechaInicio, LocalDate fechaFin) {
        Servicio servicio = servicioRepository.findById(servicioId)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        List<Turno> turnosGenerados = new ArrayList<>();

        LocalTime horaApertura = servicio.getHoraApertura();
        LocalTime horaCierre = servicio.getHoraCierre();
        int duracion = servicio.getDuracionMinutos();

        Comercio comercio = servicio.getComercio();

        for (LocalDate fecha = fechaInicio; !fecha.isAfter(fechaFin); fecha = fecha.plusDays(1)) {
            LocalTime horaActual = horaApertura;

            while (horaActual.plusMinutes(duracion).isBefore(horaCierre.plusSeconds(1))) {
                LocalTime horaFin = horaActual.plusMinutes(duracion);

                Turno turno = Turno.builder()
                        .fecha(fecha)
                        .horaInicio(horaActual)
                        .horaFin(horaFin)
                        .servicio(servicio)
                        .comercio(comercio)
                        .build();

                turnosGenerados.add(turno);

                horaActual = horaFin;
            }
        }

        return turnoRepository.saveAll(turnosGenerados);
    }

    public List<Turno> obtenerTurnos(UUID servicioId, LocalDate fechaInicio, LocalDate fechaFin) {
        return turnoRepository.findByServicioIdAndFechaBetween(servicioId, fechaInicio, fechaFin);
    }
}