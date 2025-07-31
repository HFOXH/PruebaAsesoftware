package com.example.pruebaAsesoftware.Servicio;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;
import java.util.UUID;


@Data
@AllArgsConstructor
public class ServicioDTO {
    private UUID id;
    private String nombre;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private Integer duracionMinutos;
    private String nombreComercio;
}