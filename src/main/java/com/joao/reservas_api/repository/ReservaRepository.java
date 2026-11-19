package com.joao.reservas_api.repository;

import com.joao.reservas_api.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
