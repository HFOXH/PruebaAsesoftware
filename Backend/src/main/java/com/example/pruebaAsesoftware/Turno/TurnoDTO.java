package com.example.pruebaAsesoftware.Turno;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class TurnoDTO {
    private String comercio;
    private String servicio;
    private String fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public TurnoDTO(String comercio, String servicio, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        this.comercio = comercio;
        this.servicio = servicio;
        this.fecha = fecha.toString();
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

}