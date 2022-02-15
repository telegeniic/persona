package com.jmguajardo.persona.repositories;

import com.jmguajardo.persona.models.entities.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
}
