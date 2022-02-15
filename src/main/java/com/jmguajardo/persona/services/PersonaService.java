package com.jmguajardo.persona.services;

import java.util.List;

import com.jmguajardo.persona.models.entities.Persona;
import com.jmguajardo.persona.models.requests.CreatePersona;
import com.jmguajardo.persona.repositories.EmpresaRepository;
import com.jmguajardo.persona.repositories.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    
    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    public Persona createPersona(CreatePersona cPersona){
        return personaRepository.save(new Persona(cPersona));
    }

    public List<Persona> getAllPersona(){
        return personaRepository.findAll();
    }

    
}
