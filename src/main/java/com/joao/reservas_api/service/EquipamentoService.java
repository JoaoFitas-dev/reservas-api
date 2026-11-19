package com.joao.reservas_api.service;

import com.joao.reservas_api.entity.Equipamento;
import com.joao.reservas_api.repository.EquipamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EquipamentoService {
    private final EquipamentoRepository repository;

    public EquipamentoService(EquipamentoRepository repository){
        this.repository= repository;
    }

    public List<Equipamento> Listar() {
        return repository.findAll();
    }

    public Equipamento obter(Long id){
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipamento não econtrado"));
    }

    public Equipamento criar(Equipamento e){
        return repository.save(e);
    }

    @Transactional
    public Equipamento atualizar(Long id, Equipamento novo) {
        Equipamento e = obter(id);
        e.setNome(novo.getNome());
        e.setDescricao(novo.getDescricao());
        e.setAtivo(novo.isAtivo());
        return e; // o Hibernate faz o UPDATE sozinho no fim da transação
    }
}
