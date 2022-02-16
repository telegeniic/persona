package com.jmguajardo.persona.services;

import java.util.Optional;

import com.jmguajardo.persona.models.entities.Empresa;
import com.jmguajardo.persona.models.requests.CreateEmpresa;
import com.jmguajardo.persona.repositories.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    
    @Autowired
    EmpresaRepository empresaRepository;

    public Empresa createEmpresa(CreateEmpresa cEmpresa){
        return empresaRepository.save(new Empresa(cEmpresa));
    }

    public Optional<Empresa> searchEmpresa(String empresa){
        return empresaRepository.findByEmpresa(empresa);
    }
}
