package com.joao.reservas_api.service;

import com.joao.reservas_api.entity.Reserva;
import com.joao.reservas_api.repository.ReservaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReservaService {
    private final ReservaRepository repository;

    public ReservaService(ReservaRepository repository){
        this.repository= repository;
    }

    public Reserva obter(Long id){
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não encontrada"));
    }
}
