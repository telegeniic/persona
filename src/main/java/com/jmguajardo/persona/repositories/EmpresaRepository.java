package com.jmguajardo.persona.repositories;

import com.jmguajardo.persona.models.entities.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    
}
