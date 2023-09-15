package com.example.lab5_20203607.repository;

import com.example.lab5_20203607.entity.Persona;
import com.example.lab5_20203607.entity.Viajes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
