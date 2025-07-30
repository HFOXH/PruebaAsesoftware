package com.example.pruebaAsesoftware.Comercio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComercioRepository extends JpaRepository<Comercio, UUID> {
}