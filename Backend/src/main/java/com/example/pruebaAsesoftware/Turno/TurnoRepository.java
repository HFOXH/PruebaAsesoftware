package com.example.pruebaAsesoftware.Turno;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TurnoRepository extends JpaRepository<Turno, UUID> {

    List<Turno> findByServicioIdAndFechaBetween(UUID servicioId, LocalDate fechaInicio, LocalDate fechaFin);
}