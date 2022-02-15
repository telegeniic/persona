package com.jmguajardo.persona.services;

import java.util.List;

import com.jmguajardo.persona.exceptions.DouplicateRegisterException;
import com.jmguajardo.persona.exceptions.EmptyPersonaListException;
import com.jmguajardo.persona.exceptions.PersonaNotFoundException;
import com.jmguajardo.persona.models.entities.Empresa;
import com.jmguajardo.persona.models.entities.Persona;
import com.jmguajardo.persona.models.requests.CreatePersona;
import com.jmguajardo.persona.repositories.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    
    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    EmpresaService empresaService;

    public Persona createPersona(CreatePersona cPersona){
        Persona persona = new Persona(cPersona);
        Empresa empresa = empresaService.searchEmpresa(cPersona.getEmpresa(), cPersona.getDireccionEmpresa());
        persona.setEmpresa(empresa);
        try {
            persona = personaRepository.save(persona);
        } catch (DataIntegrityViolationException e) {
            throw new DouplicateRegisterException();
        }
        return persona;
    }

    public List<Persona> getAllPersona(){
        List<Persona> personas = personaRepository.findAll();
        if(personas.isEmpty()) throw new EmptyPersonaListException(); 
        return personas;
    }

    public Persona getPersonaByNombre(String nombre){
        return personaRepository.findByNombre(nombre)
        .orElseThrow(() -> new PersonaNotFoundException());
    }


}
