package com.joao.reservas_api.service;

import com.joao.reservas_api.entity.Utilizador;
import com.joao.reservas_api.repository.UtilizadorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UtilizadorService {
    private final UtilizadorRepository repository;

    public UtilizadorService(UtilizadorRepository repository) {
        this.repository = repository;
    }

    public Utilizador obter(Long id){
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilizador não encontrado"));
    }

    public Utilizador criar(Utilizador u) {return repository.save(u); }

    @Transactional
    public Utilizador atualizar(Long id, Utilizador novo){
        Utilizador u= obter(id);
        u.setNome(novo.getNome());
        return u;
    }

    public void apagar(Long id) {
        repository.delete(obter(id));
    }
    public List<Utilizador> listar() {
        return repository.findAll();
    }

}
