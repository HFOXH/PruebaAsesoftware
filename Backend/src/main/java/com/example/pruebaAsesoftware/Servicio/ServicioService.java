package com.example.pruebaAsesoftware.Servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioService {

    private final ServicioRepository servicioRepository;

    public List<ServicioDTO> obtenerTodosDTO() {
        return servicioRepository.findAll().stream().map(servicio ->
            new ServicioDTO(
                servicio.getId(),
                servicio.getNombre(),
                servicio.getHoraApertura(),
                servicio.getHoraCierre(),
                servicio.getDuracionMinutos(),
                servicio.getComercio().getNombre()
            )
        ).toList();
    }
}
