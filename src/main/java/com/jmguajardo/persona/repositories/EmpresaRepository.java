package com.jmguajardo.persona.repositories;

import java.util.Optional;

import com.jmguajardo.persona.models.entities.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    Optional<Empresa> findByEmpresaAndDireccion(String empresa, String direccion);
}
