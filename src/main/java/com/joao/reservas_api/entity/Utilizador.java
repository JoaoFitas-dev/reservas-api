package com.joao.reservas_api.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="utilizadores")
public class Utilizador {
    @OneToMany(mappedBy="user")
    private List<Reserva> reservations = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    public Utilizador() {}

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setNome(String nome) { this.nome = nome;}
    public String getNome() {return nome;}
}
