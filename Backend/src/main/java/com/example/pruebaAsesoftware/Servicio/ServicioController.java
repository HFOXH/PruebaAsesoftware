package com.example.pruebaAsesoftware.Servicio;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/servicios")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ServicioController {

    private final ServicioService servicioService;

    @GetMapping
    public List<ServicioDTO> obtenerTodosLosServicios() {
        return servicioService.obtenerTodosDTO();
    }
}