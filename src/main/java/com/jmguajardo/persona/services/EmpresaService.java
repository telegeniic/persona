package com.jmguajardo.persona.services;

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

    public Empresa searchEmpresa(String empresa, String direccion){
        CreateEmpresa cEmpresa = new CreateEmpresa(empresa, direccion);
        return empresaRepository.findByEmpresaAndDireccion(empresa, direccion)
        .orElse(empresaRepository.save(new Empresa(cEmpresa)));
    }
}
