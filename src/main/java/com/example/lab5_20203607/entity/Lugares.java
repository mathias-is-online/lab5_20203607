package com.example.lab5_20203607.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "lugares")
public class Lugares {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLugares")
    private Integer idLugares;


    @Column(name = "nombre_lugar")
    private String nombre_lugar;

    @Column(name = "descrip_lugar")
    private String descrip_lugar;

    @Column(name = "fecha_lugar")
    private Date fecha_lugar;
}
