package com.example.pruebaAsesoftware.Turno;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/turnos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TurnoController {

    private final TurnoService turnoService;

    @PostMapping("/generar")
    public List<TurnoDTO> generarTurnos(
            @RequestParam UUID servicioId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        return turnoService.generarTurnos(servicioId, fechaInicio, fechaFin).stream()
                .map(t -> new TurnoDTO(
                        t.getServicio().getComercio().getNombre(),
                        t.getServicio().getNombre(),
                        t.getFecha(),
                        t.getHoraInicio(),
                        t.getHoraFin()))
                .toList();
    }

    @GetMapping
    public List<Turno> obtenerTurnos(
            @RequestParam UUID servicioId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        return turnoService.obtenerTurnos(servicioId, fechaInicio, fechaFin);
    }

    @GetMapping("/all")
    public List<TurnoDTO> obtenerTodosTurnos() {
        return turnoService.obtenerTodosTurnos();
    }
}