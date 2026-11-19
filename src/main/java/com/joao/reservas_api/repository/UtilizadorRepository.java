package com.joao.reservas_api.repository;

import com.joao.reservas_api.entity.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilizadorRepository extends JpaRepository<Utilizador, Long> {
}
