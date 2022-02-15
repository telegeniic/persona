package com.jmguajardo.persona.repositories;

import java.util.Optional;

import com.jmguajardo.persona.models.entities.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
    Optional<Persona> findByNombre(String nombre);
}
