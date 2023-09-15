package com.example.lab5_20203607.repository;

import com.example.lab5_20203607.entity.Mascotas;
import com.example.lab5_20203607.entity.Viajes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MascotasRepository extends JpaRepository<Mascotas, Integer> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE mascotas SET nombre_mascota = ?2, Vacunado = ?3, Desparasitado = ?4 WHERE idMascotas = ?1")
    void saveeditar(int idMascotas, String nombre, String vacunado, String desparasitado);

}
