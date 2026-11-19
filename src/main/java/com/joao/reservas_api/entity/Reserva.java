package com.joao.reservas_api.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="reservas")
public class Reserva {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Equipamento equipment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Utilizador user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime inicio;

    @Column(nullable = false)
    private LocalDateTime fim;

    public Reserva () {}

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setInicio(LocalDateTime inicio) {this.inicio = inicio;}
    public LocalDateTime getInicio() {return inicio;}

    public void setFim(LocalDateTime fim) {this.fim=fim;}
    public LocalDateTime getFim() {return fim;}

    public void setEquipment(Equipamento equipment) {
        this.equipment = equipment;
    }
    public Equipamento getEquipment() {
        return equipment;
    }

    public void setUser (Utilizador user) {
        this.user = user;
    }
    public Utilizador getUser(){
        return user;
    }
}
