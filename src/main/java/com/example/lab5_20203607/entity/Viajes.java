package com.example.lab5_20203607.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "viajes")
public class Viajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idViajes")
    private Integer idViajes;

    @Column(name = "punto_recojo")
    private String punto_recojo;

    @Column(name = "cant_personas")
    private String cant_personas;

    @Column(name = "cant_perros")
    private String cant_perros;

    @ManyToOne
    @JoinColumn(name = "persona_idpersona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "lugares_idlugares")
    private Lugares lugares;
}
